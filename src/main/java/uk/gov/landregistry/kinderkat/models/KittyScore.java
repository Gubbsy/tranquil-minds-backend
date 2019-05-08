package uk.gov.landregistry.kinderkat.models;

import javax.persistence.*;

@Entity
public class KittyScore {

    @Column(name = "img_id")
    @Id
    private String imgId;

    @Column(name = "score")
    private long score;


    public KittyScore() {

    }

    public KittyScore(String imgId, long score) {
        this.imgId = imgId;
        this.score = score;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Kitty{" +
                ", imgId='" + imgId + '\'' +
                ", score=" + score +
                '}';
    }
}
