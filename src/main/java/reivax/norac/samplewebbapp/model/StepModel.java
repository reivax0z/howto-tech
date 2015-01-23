package reivax.norac.samplewebbapp.model;

/**
 * Created by xavier caron on 22/01/2015.
 */
public class StepModel {

    private String intro;
    private String content;
    private String pictureLink;
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
}
