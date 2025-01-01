import java.util.ArrayList;

public class Account {
    protected int accountID;
    protected String username;
    protected String birthdate;
    protected String location;

    protected String Content ; //bu sonra
    private boolean IsItOpen;


    /**
     *THESE ARE CONSTRUCTURE
     */
    private Post[] posts = new Post[100];

    private Message[] Inbox = new Message[100];
    private Message[] Outbox = new Message[100];
    private Account[] following = new Account[100];
    private Account[] followers = new Account[100];

    private History[] histories = new History[100];
    Account(int accountIDs, String usernames, String birthdays, String locations) {
        this.accountID = accountIDs;
        this.username = usernames;
        this.birthdate = birthdays;
        this.location = locations;
        this.IsItOpen = false;
        System.out.println("An account with username " + this.username + " has been created.");
    }

    /**
     *  GET METHODS FOR INFORMATIONS
     */
    public String getUsername(Account obj) {
        return obj.username;
    }
    public int getAccountID(Account obj) {  return obj.accountID; }
    public String getBirthdate(Account obj) {
        return obj.birthdate;
    }
    public String getLocation(Account obj) {
        return obj.location;
    }

    /**
     *  We get the information with the get methods.
     *  We add the following information obtained with Stringbuilder to each other.
     */
    public void getFollowingInfo(Account obj){
        int i = 0 ,count = 0 ;
        StringBuilder names = new StringBuilder();
        for (;i<100;i++){
            if(obj.following[i] != null){
                count++;
                //builder yardımı ile stringleri birbirine ekliyoruz
                names = names.append(obj.following[i].username+"\t");
            }
        }
        System.out.println(obj.username+"\tfollowing\t"+count+"\taccounts;"+names);

        //history
        StringBuilder sb = new StringBuilder();
        sb.append(this.username);
        sb.append("get following info\t");
        String result = sb.toString();
        History NewHistory = new History(result);
        for(i=0;i<100;i++){
            if(histories[i]== null){
                histories[i] = NewHistory;
                break;
            }
        }

    }
    /**
     *  We get the information with the get methods.
     *  We add the follower information obtained with Stringbuilder to each other.
     */
    public void getFollowerInfo(Account obj){
        int i = 0 ,count = 0 ;
        StringBuilder names = new StringBuilder();
        for (;i<100;i++){
            if(obj.followers[i] != null){
                count++;
                names = names.append(obj.followers[i].username+"\t");
            }
        }
        System.out.println(obj.username+"\tfollowed by\t"+count+"\taccounts;\t"+names);
        //history
        StringBuilder sb = new StringBuilder();
        sb.append(this.username);
        sb.append("get follower info\t");
        String result = sb.toString();
        History NewHistory = new History(result);
        for(i=0;i<100;i++){
            if(histories[i]== null){
                histories[i] = NewHistory;
                break;
            }
        }
    }

    /**
     * IT ıs a PRINT METHOD USING WITH THE OTHER METHODS
     */
    public void viewProfile(Account obj){
        System.out.println(".............."+getUsername(obj)+"PROFILE..............");
        System.out.println("ACCOUNT ID : "+getAccountID(obj));
        System.out.println("USER NAME : "+getUsername(obj));
        System.out.println("BIRTH DATE : "+getBirthdate(obj));
        System.out.println("LOCATION : "+getLocation(obj));
        getFollowingInfo(obj);
        getFollowerInfo(obj);
        //history
        StringBuilder sb = new StringBuilder();
        sb.append(this.username);
        sb.append("\tview profile of :\t");
        sb.append(obj.username);
        String result = sb.toString();
        History NewHistory = new History(result);
        for(int i=0;i<100;i++){
            if(histories[i]== null){
                histories[i] = NewHistory;
                break;
            }
        }
    }

    /**
     *  IT ıs a PRINT METHOD USING WITH THE OTHER METHODS
     */
    public void viewProfile(){
        System.out.println(".............."+getUsername(this)+"PROFILE..............");
        System.out.println("ACCOUNT ID : "+getAccountID(this));
        System.out.println("USER NAME : "+getUsername(this));
        System.out.println("BIRTH DATE : "+getBirthdate(this));
        System.out.println("LOCATION : "+getLocation(this));
        getFollowingInfo(this);
        getFollowerInfo(this);

        //history
        StringBuilder sb = new StringBuilder();
        sb.append(this.username);
        sb.append("\tview own profile\t");
        String result = sb.toString();
        History NewHistory = new History(result);
        for(int i=0;i<100;i++){
            if(histories[i]== null){
                histories[i] = NewHistory;
                break;
            }
        }
    }

    /**
     * IT TURNS IS IT OPEN TO TRUE
     */
    public void login(){
        System.out.println("....LOGGED IN "+this.username);
        this.IsItOpen = true;

        //history
        StringBuilder sb = new StringBuilder();
        sb.append(this.username);
        sb.append("\tlogged in\t");
        String result = sb.toString();
        History NewHistory = new History(result);
        for(int i=0;i<100;i++){
            if(histories[i]== null){
                histories[i] = NewHistory;
                break;
            }
        }
    }

    /**
     *  IT TURNS IS IT OPEN TO FALSE
     */
    public void logout(){
        if(this.IsItOpen==true) {
            System.out.println("....LOGGED OUT " + this.username);
            this.IsItOpen = false;
            //history
            StringBuilder sb = new StringBuilder();
            sb.append(this.username);
            sb.append("\tlogged out\t");
            String result = sb.toString();
            History NewHistory = new History(result);
            for(int i=0;i<100;i++){
                if(histories[i]== null){
                    histories[i] = NewHistory;
                    break;
                }
            }

        }
        else{
            System.out.println("....IT IS NOT LOGGED IN BEFORE " );
            //history
            StringBuilder sb = new StringBuilder();
            sb.append(this.username);
            sb.append("\ttried logged out fail.\t");
            String result = sb.toString();
            History NewHistory = new History(result);
            for(int i=0;i<100;i++){
                if(histories[i]== null){
                    histories[i] = NewHistory;
                    break;
                }
            }
        }
    }

    /**
     * We check that there is an account logged in. We are throwing the object into an empty part of the array.
     */
    public void addPost(Post obj){
        if(this.IsItOpen == false){
            System.out.println("You did not logged in.");
        }
        else{
            int i = 0 ;
            for(;i<100;i++){
                if(this.posts[i]== null){
                    this.posts[i]= obj;
                    obj.accountID = this.accountID;
                    System.out.println("....ADDING THE POST ..... ");
                    //history
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.username);
                    sb.append("\tadd post \t");
                    sb.append(obj.postId);
                    String result = sb.toString();
                    History NewHistory = new History(result);
                    for(int j=0;j<100;j++){
                        if(histories[j]== null){
                            histories[j] = NewHistory;
                            break;
                        }
                    }
                    break;
                }
            }
        }

    }

    public void deletePost(Post obj){
        if(this.IsItOpen == false){
            System.out.println("You did not logged in.");
        }
        else {
            int i = 0;
            for (; i < 100; i++) {
                if (this.posts[i] == obj) {
                    this.posts[i] = null;
                    System.out.println("....DELETING THE POST ..... ");
                    //history
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.username);
                    sb.append("\tdelete  post \t");
                    sb.append(obj.postId);
                    String result = sb.toString();
                    History NewHistory = new History(result);
                    for(int j=0;j<100;j++){
                        if(histories[j]== null){
                            histories[j] = NewHistory;
                            break;
                        }
                    }
                    break;
                }
            }
        }

    }

    /**
     *  When followed, the following user is recorded as the followed followers.
     */
    public void follow(Account obj){//We add our object to the end of our arraylist.
        if(this.IsItOpen == false){
            System.out.println("You did not logged in.");
        }
        else{
            int i = 0 ;
            for(;i<100;i++){
                if(this.following[i]== null){
                    this.following[i]= obj;
                    System.out.println("....ADD FOLLOWING "+obj.username);StringBuilder sb = new StringBuilder();
                    sb.append(this.username);
                    sb.append("\tfollows \t");
                    sb.append(obj.username);
                    String result = sb.toString();
                    History NewHistory = new History(result);
                    for(int j=0;j<100;j++){
                        if(histories[j]== null){
                            histories[j] = NewHistory;
                            break;
                        }
                    }
                    break;
                }
            }
            for(i = 0;i<100;i++){
                if(obj.followers[i]== null){
                    System.out.println("....ADD FOLLOWER "+this.username);
                    obj.followers[i] = this;
                    break;
                }
            }
        }
        //history

    }

    public void unfollow(Account obj){//We add our object to the end of our arraylist.
        if(this.IsItOpen == false){
            System.out.println("You did not logged in.");
        }
        else{
            int i = 0 ;
            for(;i<100;i++){
                if(this.following[i]== obj){
                    this.following[i]= null;
                    //history
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.username);
                    sb.append("\tunfollows \t");
                    sb.append(obj.username);
                    String result = sb.toString();
                    History NewHistory = new History(result);
                    for(int j=0;j<100;j++){
                        if(histories[j]== null){
                            histories[j] = NewHistory;
                            break;
                        }
                    }
                    break;
                }
            }
            for(i = 0;i<100;i++){
                if(obj.followers[i]== this){
                    obj.followers[i] = null;
                    break;
                }
            }
        }

    }

    /**
     *It shows the posts made by the users together with the comments about the post. If there is no about section, it indicates this.
     */
    public void viewPosts(){
        if(this.IsItOpen == false){
            System.out.println("You did not logged in.");
        }
        else{
            int i = 0 ;
            for(;i<100;i++){
                if(this.posts[i]!= null){
                    if(this.posts[i].Content==null){
                        System.out.println(this.posts[i].postId+"\t"+this.username+": There is no contents");

                    }
                    else{
                        System.out.println(this.posts[i].postId+"\t"+this.username+":"+this.posts[i].Content);

                    }

                }
            }
        }
    }

    public void viewPosts(Account obj){
        if(this.IsItOpen == false){
            System.out.println("You did not logged in.");
        }
        else{
            int i = 0 ;
            int j = 0 ;
            for(;i<100;i++){
                if(obj.posts[i]!= null) {
                    System.out.println(obj.posts[i].postId + "\t" + obj.username + ":" + obj.posts[i].Content);
                    j++;
                }
                if(i==99 && obj.posts[i]== null&& j==0){
                    System.out.println("There is no post have shared by "+obj.username);
                }
            }
        }
    }

    /**
     *  It provides information about interactions using the viewlike and viewcomments methods. If there is no interaction, it indicates this.
     */
    public void viewInteractions(){
        int j = 0 ;
        int i = 0 ;
        System.out.println(this.username+" Interactions....");
        for(;i<100;i++){
            if(this.posts[i]!= null) {
                this.posts[i].viewLikes();
                this.posts[i].viewComments();
                j++;
            }
            if(i==99 && this.posts[i]== null&& j==0){
                System.out.println("There is no interactions have shared by "+this.username);
            }
        }
    }
    public void viewInteractions(Account obj){
        int j = 0 ;
        int i = 0 ;
        System.out.println(obj.username+" Interactions....");
        for(;i<100;i++){
            if(obj.posts[i]!= null) {
                obj.posts[i].viewLikes();
                obj.posts[i].viewComments();
                j++;
            }
            if(i==99 && obj.posts[i]== null&& j==0){
                System.out.println("There is no interactions have shared by "+obj.username);
            }
        }
    }

    /**
     *  I am using two methods as sent and received.
     *  I complete the incoming messages to the sender and the sender of the outgoing messages by throwing objects into the arrays.
     */
    public void sendToInbox(int messageIDs,Message senderIDs,String contents ){
        /*
        if(this.IsItOpen == false){
            System.out.println("You did not logged in.");
        }*/
        //else{
        int i = 0 ;
        for(;i<100;i++){
            if(this.Inbox[i]== null){
                System.out.println("....SENDED MESSAGE BY "+this.username);
                this.Inbox[i] = senderIDs ;
                this.Inbox[i].content=contents;
                //history
                StringBuilder sb = new StringBuilder();
                sb.append("Send message by ");
                sb.append(this.username);
                String result = sb.toString();
                History NewHistory = new History(result);
                for(int j=0;j<100;j++){
                    if(histories[j]== null){
                        histories[j] = NewHistory;
                        break;
                    }
                }
                break;
                }
            }
        //}

    }
    public void sendToOutbox(int messageIDs,Message receiverIDs ,String contents ){

        int i = 0 ;
        for(;i<100;i++){
            if(this.Outbox[i]== null){
                System.out.println("....SENDED MESSAGE to "+this.username);
                this.Outbox[i] = receiverIDs ;
                this.Outbox[i].content=contents;
                StringBuilder sb = new StringBuilder();
                sb.append("Send message to ");
                sb.append(this.username);
                String result = sb.toString();
                History NewHistory = new History(result);
                for(int j=0;j<100;j++){
                    if(histories[j]== null){
                        histories[j] = NewHistory;
                        break;
                    }
                }
                break;
            }
        }

    }

    /**
     *The user is informed with the help of the objects kept in the arrays by the login person. This information is given if the boxes are empty.
     */
    public void viewInbox(){
        if(this.IsItOpen == false){
            System.out.println("You did not logged in.");
        }
        else{
            int j = 0 ;
            int i = 0 ;
            System.out.println(this.username+" inbox Messages....");
            for(;i<100;i++){
                if(this.Inbox[i]!= null) {
                    j++;
                }
                if(i==99 && this.Inbox[i]== null&& j==0){
                    System.out.println("Inbox is empty for\t"+this.username);
                }
            }
            if(j!=0){
                System.out.println("There is "+j+"Messages for\t"+this.username);
            }
            for(i=0;i<100;i++){
                if(this.Inbox[i]!= null) {
                    System.out.println("One Messages from\t"+this.username+":\t"+this.Inbox[i].content);
                    j++;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.username);
            sb.append(" Viewed Inbox ");
            String result = sb.toString();
            History NewHistory = new History(result);
            for(int k=0;k<100;k++){
                if(histories[k]== null){
                    histories[k] = NewHistory;
                    break;
                }
            }
        }


    }

    public void viewOutbox(){
        if(this.IsItOpen == false){
            System.out.println("You did not logged in.");
        }
        else{
            int j = 0 ;
            int i = 0 ;
            System.out.println(this.username+" outbox Messages....");
            for(;i<100;i++){
                if(this.Outbox[i]!= null) {
                    j++;
                }
                if(i==99 && this.Outbox[i]== null&& j==0){
                    System.out.println("outbox is empty for\t"+this.username);
                }
            }
            if(j!=0){
                System.out.println("There is "+j+"Messages to\t"+this.username);
            }
            for(i=0;i<100;i++){
                if(this.Outbox[i]!= null) {
                    System.out.println("One Messages to\t"+this.username+":\t"+this.Outbox[i].content);
                    j++;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.username);
            sb.append(" Viewed Inbox ");
            String result = sb.toString();
            History NewHistory = new History(result);
            for(int k=0;k<100;k++){
                if(histories[k]== null){
                    histories[k] = NewHistory;
                    break;
                }
            }
        }
    }

    public void viewHistory() {
        if (!this.IsItOpen) {
            System.out.println("You did not log in.");
        } else {
            for (int i = 0; i < this.histories.length; i++) {

                if(this.histories[i]!=null){
                    History history = this.histories[i];
                    System.out.println(this.username + ": " + (history != null && history.Content != null ? history.Content : null));
                }
            }
        }
    }
}
