public class Comment extends Interaction{
    protected boolean Hascomment;
    protected String content  ;
    private Comment(int interacionIDs,Post postIDs, Account accountIDs,String contents) {
        this.accountID = accountIDs;
        this.postID = postIDs;
        this.interacionID = interacionIDs;
        this.Hascomment = true;
        this.content = contents ;

    }
    /**
     *THIS IS CONSTRUCTURE
     */
    Comment(Post postIDs) {
        this.postID = postIDs;
        this.Hascomment = true;
    }
}
