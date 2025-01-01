public class Post {
    protected final int postId;
    protected int accountID ;

    protected String Content ;

    protected Account[] likes = new Account[100];
    protected Account[] comments = new Account[100];
    /**
     *THESE ARE CONSTRUCTURES
     */
    protected Post(int postIDs, String contents, int accountIDs) {
        this.postId = postIDs;
        this.Content = contents;
        this.accountID = accountIDs;
    }
    protected Post(int postIDs, String contents) {
        this.postId = postIDs;
        this.Content = contents;
    }
    private Post(int postIDs, int accountIDs) {
        this.accountID = accountIDs;
        this.postId = postIDs;

    }
    protected Post(int postIDs) {
        this.postId = postIDs;

    }

    /**
     *Our method saves object in like array.
     */
    public void addLike(Account obj){
        System.out.println("..............LIKING "+obj.username+"'POST..............");
        int i = 0 ;
        for(;i<100;i++){
            if(this.likes[i]== null) {
                this.likes[i] = obj;
                break;
            }
        }
    }

    /**
     *Our method saves object in like array.
     */
    public void disLike(Account obj){
        System.out.println("..............DISLIKING "+obj.username+"'POST..............");
        int i = 0 ;
        for(;i<100;i++){
            if(this.likes[i] == obj){
                this.likes[i]= null;
            }
        }
    }

    /**
     *Our method saves object in array and we will save the comment in the content section.
     */
    public void addComment(Account obj,String chat){
        System.out.println("..............ADDING COMMENT "+obj.username+"'POST..............");
        int i = 0 ;
        for(;i<100;i++){
            if(this.comments[i]==null) {
                this.comments[i] = obj;
                this.comments[i].Content= chat ;
                break;
            }
        }
    }

    /**
     *Our method saves object in array and we will save the comment in the content section.
     */
    public void deleteComment(Account obj,String chat){
        System.out.println("..............DELETE COMMENT "+obj.username+"'POST..............");
        int i = 0 ;
        for(;i<100;i++){
            if(this.comments[i]==obj) {
                this.comments[i]= null;
                this.Content = null ;
                break;
            }
        }
    }

    /**
     *Our method saves object in array and we will save the comment in the content section.
     */
    public void viewLikes(){

        int i = 0 ,count = 0 ;
        StringBuilder names = new StringBuilder();
        for (;i<100;i++){
            if(this.likes[i] != null){
                count++;
                //builder yardımı ile stringleri birbirine ekliyoruz
                names = names.append(this.likes[i].username+"\t");
            }
        }
        if(count==0){
            System.out.println("PostID: "+this.postId+"\tThere is no Likes.");
        }
        else{
            System.out.println("PostID: "+this.postId+"\tliked by\t"+count+" person \tAccount usernames;\t"+names);
        }
    }
    /**
     *We count the total likes and comments with the help of the Count variable.
     *  I used the String Builder to see the likes. We print the names of the objects in the printing process.
     */
    public void viewComments(){

        int i = 0 ,count = 0 ;
        //StringBuilder names = new StringBuilder();
        for (;i<100;i++){
            if(this.comments[i] != null){
                count++;
                //builder yardımı ile stringleri birbirine ekliyoruz
                //names = names.append(this.comments[i].accountID);
            }
        }
        if(count==0){
            System.out.println("PostID: "+this.postId+"\tThere is no comments.");
        }
        else {
            System.out.println("PostID: " +this.postId + "\thave comment by\t" + count + " person :");
            for (i = 0; i < 100; i++) {
                if (this.comments[i] != null) {
                    System.out.println("PostID: " + this.postId + "\thave comment by\t" + this.comments[i].username + ":\t" + this.comments[i].Content);
                }
            }
        }
    }
}