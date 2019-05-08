package uk.gov.landregistry.kinderkat.models;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name="kitties")
public class Kitty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private long id;

    @Column(name = "img_id")
    private String imgId;

    @Column(name = "vote")
    private int vote;

    @Column(name = "kat_name")
    private String katName;


    public Kitty() {

    }

    public Kitty(String imgId, int vote, String katName) {
        this.imgId = imgId;
        this.vote = vote;
        this.katName = katName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public String getKat_name() {
        return katName;
    }

    public void setKat_name(String kat_name) {
        this.katName = kat_name;
    }

    @Override
    public String toString() {
        return "Kitty{" +
                "id=" + id +
                ", imgId='" + imgId + '\'' +
                ", vote=" + vote +
                ", katName='" + katName + '\'' +
                '}';
    }
}
