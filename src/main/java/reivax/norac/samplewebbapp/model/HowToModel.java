package reivax.norac.samplewebbapp.model;

import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Created by xavier caron on 22/01/2015.
 */
@Entity
@Indexed
@Table(name = "how_to")
public class HowToModel {

    @Column(name = "title")
    @Field(index=Index.YES, analyze= Analyze.YES)
    private String title;

    @Column(name = "intro")
    @Field(index=Index.YES, analyze= Analyze.YES)
    private String intro;

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "howto", cascade = CascadeType.ALL)
    @IndexedEmbedded
    private List<StepModel> steps = new ArrayList<StepModel>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HowToModel that = (HowToModel) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<StepModel> getSteps() {
        return steps;
    }

    public void setSteps(List<StepModel> steps) {
        this.steps = steps;
    }

    public void addStep(StepModel step) {
        this.steps.add(step);
    }
}
