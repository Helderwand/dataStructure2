public class Like extends Interaction {
    protected boolean IsItliked ;

    protected Like(int interacionIDs,Post postIDs, Account accountIDs) {
        this.accountID = accountIDs;
        this.postID = postIDs;
        this.interacionID = interacionIDs;
        this.IsItliked = true;
    }

    /**
     *THIS IS CONSTRUCTURE
     */
    Like(Post obj) {
        this.postID = obj;
        this.IsItliked = true;
    }
}
