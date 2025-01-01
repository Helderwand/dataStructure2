import java.util.LinkedList;

public class Post {
    protected final int postId;
    protected int accountID;
    protected String content;
    protected LinkedList<Account> likes = new LinkedList<>();
    protected LinkedList<Account> comments = new LinkedList<>();

    /**
     * THE CONSTRUCTORS
     */
    protected Post(int postId, String content, int accountID) {
        this.postId = postId;
        this.content = content;
        this.accountID = accountID;
    }

    protected Post(int postId, String content) {
        this.postId = postId;
        this.content = content;
    }

    private Post(int postId, int accountID) {
        this.accountID = accountID;
        this.postId = postId;
    }

    protected Post(int postId) {
        this.postId = postId;
    }

    /**
     * Our method saves object in like linked list.
     */
    public void addLike(Account obj){
        System.out.println("..............LIKING " + obj.username + "'S POST..............");
        likes.add(obj);
    }

    /**
     * Our method removes object from like linked list.
     */
    public void disLike(Account obj){
        System.out.println("..............DISLIKING " + obj.username + "'S POST..............");
        likes.remove(obj);
    }

    /**
     * Our method saves object in comments linked list and we will save the comment in the content section.
     */
    public void addComment(Account obj, String chat){
        System.out.println("..............ADDING COMMENT " + obj.username + "'S POST..............");
        obj.Content = chat;
        comments.add(obj);
    }

    /**
     * Our method removes object from comments linked list.
     */
    public void deleteComment(Account obj, String chat){
        System.out.println("..............DELETING COMMENT " + obj.username + "'S POST..............");
        obj.Content = null;
        comments.remove(obj);
    }

    /**
     * Our method saves object in likes linked list.
     * We count the total likes and print the names of the objects in the printing process.
     */
    public void viewLikes(){
        int count = likes.size();
        StringBuilder names = new StringBuilder();
        for (Account account : likes) {
            names.append(account.username).append("\t");
        }
        if(count == 0){
            System.out.println("PostID: " + postId + "\tThere is no likes.");
        }
        else{
            System.out.println("PostID: " + postId + "\tliked by\t" + count + " person \tAccount usernames;\t" + names);
        }
    }

    /**
     * We count the total comments and print the names of the objects in the printing process.
     */
    public void viewComments(){
        int count = comments.size();
        if(count == 0){
            System.out.println("PostID: " + postId + "\tThere is no comments.");
        }
        else {
            System.out.println("PostID: " + postId + "\thave comment by\t" + count + " person :");
            for (Account account : comments) {
                System.out.println("PostID: " + postId + "\thave comment by\t" + account.username + ":\t" + account.Content);
            }
        }
    }
}