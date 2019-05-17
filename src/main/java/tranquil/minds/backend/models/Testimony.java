package tranquil.minds.backend.models;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name="testimonies")
public class Testimony {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", columnDefinition = "serial")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private String date;

    @Column(name = "content")
    private String content;

    public Testimony(String title, String date, String content) {
        this.title = title;
        this.date = date;
        this.content = content;
    }

    public Testimony(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

