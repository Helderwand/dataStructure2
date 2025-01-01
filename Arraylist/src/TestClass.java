public class TestClass {
    public static void main(String[ ] args){
        Account gizemsungu = new Account(1,"gızemsungu","13.01.1993","Istanbul");
        Account sibelgulmez = new Account(2,"sibelgulmez","26.12.1994","Bursa");
        Account gokhankaya = new Account(4,"gokhankaya","9.03.1995","Kocaeli");

        sibelgulmez.login();
        Post post1 = new Post(1134);
        sibelgulmez.addPost(post1);
        Post post2 = new Post ( 1234);
        sibelgulmez.addPost(post2);
        sibelgulmez.follow(gizemsungu);
        sibelgulmez.follow(gokhankaya);
        sibelgulmez.logout();
        gokhankaya.login();
        gokhankaya.viewProfile(sibelgulmez);
        gokhankaya.viewPosts(sibelgulmez);
        Like like1 = new Like (post2);
        post2.addLike(gokhankaya);
        Comment comment1 = new Comment (post2);
        post2.addComment(sibelgulmez,"THIS IS A COMMENT");
        gokhankaya.follow(sibelgulmez);
        gokhankaya.follow(gizemsungu);
        Message message1 = new Message(45,sibelgulmez,gokhankaya,"THIS IS A MESSAGE");
        gokhankaya.sendToInbox(45,message1,"THIS IS A MESSAGE");
        sibelgulmez.sendToOutbox(45,message1,"THIS IS A MESSAGE");
        gokhankaya.logout();
        gizemsungu.login();
        gizemsungu.viewOutbox();
        gizemsungu.viewInbox();
        gizemsungu.viewProfile(sibelgulmez);
        gizemsungu.viewPosts(sibelgulmez);
        gizemsungu.viewInteractions(sibelgulmez);
        post2.addLike(gizemsungu);
        gizemsungu.viewInteractions(sibelgulmez);
    }
}
