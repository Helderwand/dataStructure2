public class Message {
    protected int messageID;
    protected Account senderID;
    protected Account receiverID;

    public String content ;
    private Account sender;
    private Account receiver;

    /**
     *THIS IS CONSTRUCTURE
     */
    protected Message(int messageIDs,Account senderIDs, Account receiverIDs ,String contents ) {
        this.messageID = messageIDs;
        this.content = contents;
        this.senderID = senderIDs;
        this.receiverID = receiverIDs;

    }

    public Account getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public Account getReceiver() {
        return receiver;
    }
}
