import java.util.LinkedList;

public class Account {
    protected int accountID;
    protected String username;
    protected String birthdate;
    protected String location;

    protected String Content; //bu sonra
    private boolean IsItOpen;

    /**
     * THESE ARE CONSTRUCTORS
     */
    private LinkedList<Post> posts = new LinkedList<>();
    private LinkedList<Message> Inbox = new LinkedList<>();
    private LinkedList<Message> Outbox = new LinkedList<>();
    private LinkedList<Account> following = new LinkedList<>();
    private LinkedList<Account> followers = new LinkedList<>();
    private LinkedList<History> histories = new LinkedList<>();

    Account(int accountIDs, String usernames, String birthdays, String locations) {
        this.accountID = accountIDs;
        this.username = usernames;
        this.birthdate = birthdays;
        this.location = locations;
        this.IsItOpen = false;
        System.out.println("An account with username " + this.username + " has been created.");
        StringBuilder sb = new StringBuilder();
        sb.append(this.username);
        sb.append("\t Account created \t");
        String result = sb.toString();
        History NewHistory = new History(result);
    }

    public String getUsername() {
        return username;
    }

    public int getAccountID() {
        return accountID;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getLocation() {
        return location;
    }

    public void getFollowingInfo() {
        int count = 0;
        StringBuilder names = new StringBuilder();
        for (Account account : following) {
            count++;
            names.append(account.username).append("\t");
        }
        System.out.println(username + "\tfollowing\t" + count + "\taccounts;" + names);

    }

    public void getFollowerInfo() {
        int count = 0;
        StringBuilder names = new StringBuilder();
        for (Account account : followers) {
            count++;
            names.append(account.username).append("\t");
        }
        System.out.println(username + "\tfollowed by\t" + count + "\taccounts;\t" + names);

    }

    public void viewProfile() {
        System.out.println(".............." + getUsername() + " PROFILE..............");
        System.out.println("ACCOUNT ID : " + getAccountID());
        System.out.println("USER NAME : " + getUsername());
        System.out.println("BIRTH DATE : " + getBirthdate());
        System.out.println("LOCATION : " + getLocation());
        getFollowingInfo();
        getFollowerInfo();


        StringBuilder sb = new StringBuilder();
        sb.append(this.username);
        sb.append("viewed own profile\t");
        String result = sb.toString();

        History NewHistory = new History(result);
        histories.add(NewHistory);
    }

    public void viewProfile(Account obj) {
        System.out.println(".............." + getUsername() + " PROFILE..............");
        System.out.println("ACCOUNT ID : " + getAccountID());
        System.out.println("USER NAME : " + getUsername());
        System.out.println("BIRTH DATE : " + getBirthdate());
        System.out.println("LOCATION : " + getLocation());
        obj.getFollowingInfo();
        obj.getFollowerInfo();

        StringBuilder sb = new StringBuilder();
        sb.append(this.username);
        sb.append("viewed\t");
        sb.append(obj.username);
        sb.append("Profile\t");
        String result = sb.toString();

        History NewHistory = new History(result);
        histories.add(NewHistory);
    }

    public void login() {
        System.out.println("....LOGGED IN " + this.username);
        this.IsItOpen = true;
        StringBuilder sb = new StringBuilder();
        sb.append(this.username);
        sb.append("\tLogged in:\t");
        String result = sb.toString();

        History NewHistory = new History(result);
        histories.add(NewHistory);
    }

    public void logout() {
        if (this.IsItOpen == true) {
            System.out.println("....LOGGED OUT " + this.username);
            this.IsItOpen = false;
            StringBuilder sb = new StringBuilder();
            sb.append(this.username);
            sb.append("\tlogged out:\t");
            String result = sb.toString();
            History NewHistory = new History(result);
            histories.add(NewHistory);

        } else {
            System.out.println("....IT IS NOT LOGGED IN BEFORE ");
            StringBuilder sb = new StringBuilder();
            sb.append(this.username);
            sb.append("\tCouldn't logged out:\t");
            String result = sb.toString();

            History NewHistory = new History(result);
            histories.add(NewHistory);
        }
    }

    public void addPost(Post obj) {
        if (this.IsItOpen == false) {
            System.out.println("You did not logged in.");
        } else {
            posts.add(obj);
            obj.accountID = this.accountID;
            System.out.println("....ADDING THE POST ..... ");
            StringBuilder sb = new StringBuilder();
            sb.append(this.username);
            sb.append("add post \tpostID:\t");
            sb.append(obj.postId);
            String result = sb.toString();

            History NewHistory = new History(result);
            histories.add(NewHistory);
        }
    }

    public void deletePost(Post obj) {
        if (this.IsItOpen == false) {
            System.out.println("You did not logged in.");
        } else {
            if (posts.remove(obj)) {
                System.out.println("....DELETING THE POST ..... ");

                StringBuilder sb = new StringBuilder();
                sb.append(this.username);
                sb.append("delete post \tpostID:\t");
                sb.append(obj.postId);
                String result = sb.toString();

                History NewHistory = new History(result);

                histories.add(NewHistory);
            } else {
                System.out.println("Post not found.");
            }
        }
    }

    public void follow(Account obj) {
        if (this.IsItOpen == false) {
            System.out.println("You did not logged in.");
        } else {
            following.add(obj);
            obj.followers.add(this);
            System.out.println("....NOW FOLLOWING " + obj.username + ".....");
            StringBuilder sb = new StringBuilder();
            sb.append(this.username);
            sb.append("followed ");
            sb.append(obj.username);
            String result = sb.toString();

            History NewHistory = new History(result);
            histories.add(NewHistory);
        }
    }

    public void unfollow(Account obj) {
        if (!IsItOpen) {
            System.out.println("You did not log in.");
            return;
        }
        if (followers.remove(obj)) {
            obj.following.remove(this);
            StringBuilder sb = new StringBuilder();
            sb.append(this.username);
            sb.append(" unfollowed ");
            sb.append(obj.username);
            String result = sb.toString();
            History NewHistory = new History(result);
            histories.add(NewHistory);
        } else {
            System.out.println("You are not following " + obj.username + ".");
        }
    }

    public void viewHistory() {
        if (!IsItOpen) {
            System.out.println("You did not log in.");
            return;
        }
        System.out.println(this.username + " history....");
        int j = histories.size();
        if (j == 0) {
            System.out.println("There is no history for\t" + this.username);
            return;
        }
        System.out.println("There is " + j + " history entries for\t" + this.username);
        for (int i = 0; i < j; i++) {
            System.out.println(histories.get(i).Content);
        }
    }

    public void viewPosts() {
        if (!IsItOpen) {
            System.out.println("You did not log in.");
            return;
        }
        System.out.println(this.username + " posts....");
        int j = posts.size();
        if (j == 0) {
            System.out.println("There is no posts for\t" + this.username);
            return;
        }
        System.out.println("There is " + j + " posts for\t" + this.username);
        for (int i = 0; i < j; i++) {
            System.out.println(posts.get(i).postId + "\t" + this.username + ": " + (posts.get(i).content!= null ? posts.get(i).content : "There is no contents"));
        }
    }

    public void viewPosts(Account obj) {
        if (!IsItOpen) {
            System.out.println("You did not log in.");
            return;
        }
        System.out.println(obj.username + " posts....");
        int j = obj.posts.size();
        if (j == 0) {
            System.out.println("There is no posts have been shared by " + obj.username);
            return;
        }
        System.out.println("There is " + j + " posts have been shared by " + obj.username);
        for (int i = 0; i < j; i++) {
            System.out.println(obj.posts.get(i).postId + "\t" + obj.username + ": " + (obj.posts.get(i).content != null ? obj.posts.get(i).content : "There is no contents"));
        }
    }

    public void viewInteractions(Account obj) {
        int j = 0;
        System.out.println(obj.username + " Interactions....");
        for (Post p : posts) {
            p.viewLikes();
            p.viewComments();
            j++;
        }
        if (j == 0) {
            System.out.println("There are no interactions shared by " + obj.username);
        }
    }

    public void sendToInbox(int messageID, Message message, String contents) {
        Inbox.add(message);
        System.out.println("....SENT MESSAGE BY " + this.username);

        String result = this.username + " sent message by " + this.username;
        History NewHistory = new History(result);
        histories.add(NewHistory);
    }

    public void sendToOutbox(int messageID, Message message, String contents) {
        Outbox.add(message);
        System.out.println("....SENT MESSAGE TO " + this.username);

        String result = "Sent message to " + this.username;
        History NewHistory = new History(result);
        histories.add(NewHistory);
    }

    public void viewInbox() {
        if (!IsItOpen) {
            System.out.println("You did not log in.");
            return;
        }
        System.out.println(this.username + " inbox Messages....");
        int j = Inbox.size();
        if (j == 0) {
            System.out.println("Inbox is empty for\t" + this.username);
            return;
        }
        System.out.println("There are " + j + " messages for\t" + this.username);
        for (Message message : Inbox) {
            System.out.println("One message from\t" + message.senderID.username + ":\t" + message.content);
        }

        String result = this.username + " viewed Inbox ";
        History NewHistory = new History(result);
        histories.add(NewHistory);
    }

    public void viewOutbox() {
        if (!IsItOpen) {
            System.out.println("You did not log in.");
            return;
        }
        System.out.println(this.username + " outbox Messages....");
        int j = Outbox.size();
        if (j == 0) {
            System.out.println("Outbox is empty for\t" + this.username);
            return;
        }
        System.out.println("There are " + j + " messages to\t" + this.username);
        for (Message message : Outbox) {
            System.out.println("One message to\t" + message.receiverID.username + ":\t" + message.content);
        }

        String result = this.username + " viewed outbox ";
        History NewHistory = new History(result);
        histories.add(NewHistory);
    }
}