public class TestClass2 {
    public static void main(String[ ] args){
        Account gizemsungu = new Account(1,"gızemsungu","13.01.1993","Istanbul");
        Account sibelgulmez = new Account(2,"sibelgulmez","26.12.1994","Bursa");
        Account gokhankaya = new Account(4,"gokhankaya","9.03.1995","Kocaeli");

        Account user1 = new Account(89,"user1","13.01.1993","Istanbul");
        Account user2 = new Account(545,"user2","26.12.1994","Bursa");
        Account user3 = new Account(21,"user3","9.03.1995","Kocaeli");

        Account user4 = new Account(35,"user4","13.01.1993","Istanbul");
        Account user5 = new Account(64,"user5","26.12.1994","Bursa");
        Account user6 = new Account(5452,"user6","9.03.1995","Kocaeli");

        Account user7 = new Account(589,"user7","13.01.1993","Istanbul");
        Account user8 = new Account(5123,"user8","26.12.1994","Bursa");
        Account user9 = new Account(8,"user9","9.03.1995","Kocaeli");

        sibelgulmez.login();
        Post post1 = new Post(1134);
        sibelgulmez.addPost(post1);
        Post post2 = new Post ( 1234);
        sibelgulmez.addPost(post2);
        sibelgulmez.deletePost(post2);
        sibelgulmez.addPost(post2);
        sibelgulmez.follow(gizemsungu);
        sibelgulmez.unfollow(gizemsungu);
        sibelgulmez.follow(gokhankaya);
        sibelgulmez.logout();
        gokhankaya.login();
        gokhankaya.viewProfile(sibelgulmez);
        gokhankaya.viewPosts(sibelgulmez);
        Like like1 = new Like (post2);
        post2.addLike(gokhankaya);
        post2.disLike(gokhankaya);
        post2.addLike(gokhankaya);
        gokhankaya.viewProfile();
        Comment comment1 = new Comment (post2);
        post2.addComment(sibelgulmez,"THIS IS A COMMENT");
        gokhankaya.follow(sibelgulmez);
        gokhankaya.follow(gizemsungu);
        Message message1 = new Message(45,sibelgulmez,gokhankaya,"THIS IS A MESSAGE");
        gokhankaya.sendToInbox(45,message1,"THIS IS A MESSAGE");
        sibelgulmez.sendToOutbox(45,message1,"THIS IS A MESSAGE");
        gokhankaya.viewOutbox();
        gokhankaya.viewInbox();
        gokhankaya.logout();
        gizemsungu.login();
        gizemsungu.viewOutbox();
        gizemsungu.viewInbox();
        gizemsungu.viewProfile(sibelgulmez);
        gizemsungu.viewPosts(sibelgulmez);
        gizemsungu.viewInteractions(sibelgulmez);
        post2.addLike(gizemsungu);
        gizemsungu.viewInteractions(sibelgulmez);
        gizemsungu.viewHistory();
        gizemsungu.logout();
        gokhankaya.login();
        gokhankaya.viewHistory();
        gokhankaya.logout();
        sibelgulmez.login();
        sibelgulmez.viewHistory();
    }
}
