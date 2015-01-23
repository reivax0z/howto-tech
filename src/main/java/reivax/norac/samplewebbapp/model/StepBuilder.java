package reivax.norac.samplewebbapp.model;

/**
 * Created by xavier caron on 22/01/2015.
 */
public class StepBuilder {

    private String intro;
    private String content;
    private String pictureLink;
    private int id;

    private StepBuilder(){}

    public static StepBuilder aStep(){ return new StepBuilder(); }

    public StepBuilder withIntro(String intro){
        this.intro = intro;
        return this;
    }

    public StepBuilder withContent(String content){
        this.content = content;
        return this;
    }

    public StepBuilder withPictureLink(String pictureLink){
        this.pictureLink = pictureLink;
        return this;
    }

    public StepBuilder withId(int id){
        this.id = id;
        return this;
    }

    public StepModel build(){
        StepModel step = new StepModel();
        step.setContent(this.content);
        step.setId(this.id);
        step.setIntro(this.intro);
        step.setPictureLink(this.pictureLink);
        return step;
    }
}
