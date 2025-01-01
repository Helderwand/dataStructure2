
public class Message extends Interaction {
    protected int messageID;
    protected Account senderID;
    protected Account receiverID;

    public String content ;

    /**
     *THIS IS CONSTRUCTURE
     */
    protected Message(int messageIDs,Account senderIDs, Account receiverIDs ,String contents ) {
        this.messageID = messageIDs;
        this.content = contents;
        this.senderID = senderIDs;
        this.receiverID = receiverIDs;

    }

}