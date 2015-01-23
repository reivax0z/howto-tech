package reivax.norac.samplewebbapp.web.renderer;

import org.antlr.stringtemplate.NoIndentWriter;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Map;

/**
 * Created by xavier caron on 21/01/2015.
 */
public class StringTemplateFactory {

    private final StringTemplateGroup stGroup;

    private static final String LAYOUT_TEMPLATE = "layout";

    public static final String BODY_TEMPLATE_MODEL_NAME = "bodytemplate";

    public StringTemplateFactory(String groupName, Resource rootDirectory) throws IOException {
        this(new StringTemplateGroup(groupName, rootDirectory.getFile().getPath()));
    }

    public StringTemplateFactory(StringTemplateGroup stGroup) {
        this.stGroup = stGroup;
        stGroup.setStringTemplateWriter(NoIndentWriter.class);
    }

    public StringTemplate createStringTemplate(String templateName, Map<String, Object> model) {
        populateTemplateModel(templateName, model);
        return stGroup.getInstanceOf(LAYOUT_TEMPLATE, model);
    }

    private void populateTemplateModel(String templateName, Map<String, Object> model) {
        model.put(BODY_TEMPLATE_MODEL_NAME, templateName);
    }
}
