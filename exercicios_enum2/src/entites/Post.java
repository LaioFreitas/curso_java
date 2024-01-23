package entites;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entites.Comments;
public class Post {

    private static SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date moment;
    private String title;
    private String content;
    private int likes;
    private List<Comments> comments = new ArrayList<>();

    public Post() {
        
    }

    public Post(Date moment, String title, String content, int likes) {
        this.moment = moment;
        this.title = title;
        this.content = content;
        this.likes = likes; 
    }
    
    public Date getMoment() {
        return moment;
    }

    public void setmoment(Date moment) {
        this.moment = moment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
       this.title = title; 
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void addComment(Comments comment) {
        comments.add(comment);
    }
    
    public void removeComment(Comments comment) {
        comments.remove(comment);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s\n", title));
        sb.append(String.format("%d likes - %s\n", likes, sdt.format(moment)));
        sb.append(content + "\n");
        sb.append("Comments:\n");
        for (Comments comment : comments) {
            sb.append(comment.getText() + "\n");
        }
        return sb.toString();
    }
}
