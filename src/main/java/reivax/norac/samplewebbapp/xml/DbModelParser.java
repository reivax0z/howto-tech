package reivax.norac.samplewebbapp.xml;

import reivax.norac.samplewebbapp.model.DbModel;
import reivax.norac.samplewebbapp.model.HowToModel;
import reivax.norac.samplewebbapp.model.StepModel;

/**
 * Created by xavier caron on 22/01/2015.
 */
public class DbModelParser extends XmlParser<DbModel> {
    @Override
    protected void addRules() {
        digester.addObjectCreate("modeldb", DbModel.class);

        digester.addObjectCreate("modeldb/howtomodel", HowToModel.class);
        digester.addBeanPropertySetter("modeldb/howtomodel/id", "id");
        digester.addBeanPropertySetter("modeldb/howtomodel/title", "title");
        digester.addBeanPropertySetter("modeldb/howtomodel/intro", "intro");

        digester.addObjectCreate("modeldb/howtomodel/stepmodel", StepModel.class);
        digester.addBeanPropertySetter("modeldb/howtomodel/stepmodel/id", "id");
        digester.addBeanPropertySetter("modeldb/howtomodel/stepmodel/intro", "intro");
        digester.addBeanPropertySetter("modeldb/howtomodel/stepmodel/content", "content");
        digester.addBeanPropertySetter("modeldb/howtomodel/stepmodel/pictureLink", "pictureLink");
        digester.addSetNext("modeldb/howtomodel/stepmodel", "addStep");

        digester.addSetNext("modeldb/howtomodel", "addAdvice");
    }
}
