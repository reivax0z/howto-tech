package reivax.norac.samplewebbapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xavier caron on 22/01/2015.
 */
public class HowToBuilder {

    private String title;
    private String intro;
    private int id;
    private List<StepModel> steps = new ArrayList<StepModel>();

    private HowToBuilder(){}

    public static HowToBuilder anHowTo(){ return new HowToBuilder(); }

    public HowToBuilder withTitle(String title){
        this.title = title;
        return this;
    }
    public HowToBuilder withIntro(String intro){
        this.intro = intro;
        return this;
    }
    public HowToBuilder withId(int id){
        this.id = id;
        return this;
    }
    public HowToBuilder withSteps(List<StepModel> steps){
        this.steps = steps;
        return this;
    }
    public HowToBuilder withStep(StepModel step){
        this.steps.add(step);
        return this;
    }

    public HowToModel build(){
        HowToModel how = new HowToModel();
        how.setIntro(this.intro);
        how.setId(this.id);
        how.setSteps(this.steps);
        how.setTitle(this.title);
        return how;
    }
}
