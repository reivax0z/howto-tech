package reivax.norac.samplewebbapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xavier caron on 22/01/2015.
 */
public class HowToModel {

    private String title;
    private String intro;
    private int id;
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
