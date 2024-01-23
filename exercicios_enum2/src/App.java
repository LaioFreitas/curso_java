import java.text.SimpleDateFormat;

import entites.Comments;
import entites.Post;

public class App {
    public static void main(String[] args) throws Exception {

        SimpleDateFormat smt =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Post p1 = new Post(
            smt.parse("21/06/2018 13:05:45"),
            "treviling to new zealand",
            "i'm going to visit this wonderful coutry!",
            12
        );

        p1.addComment(new Comments("have a nice trip"));
        p1.addComment(new Comments("wow that's awesome!"));
    }
}
