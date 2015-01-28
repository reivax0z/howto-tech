package reivax.norac.samplewebbapp.model;

import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;

/**
 * Created by xavier caron on 22/01/2015.
 */
@Entity
@Indexed
@Table(name = "step")
public class StepModel {

    @ManyToOne
    private HowToModel howto;

    @Column(name = "intro")
    @Field(index= org.hibernate.search.annotations.Index.YES, analyze= Analyze.YES)
    private String intro;

    @Column(name = "content")
    @Field(index= Index.YES, analyze= Analyze.YES)
    private String content;

    @Column(name = "number")
    private Integer number;

    @Column(name = "picture_link")
    private String pictureLink;

    @Id
    @GeneratedValue
    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StepModel stepModel = (StepModel) o;

        if (id != stepModel.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HowToModel getHowto() {
        return howto;
    }

    public void setHowto(HowToModel howto) {
        this.howto = howto;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
