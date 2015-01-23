package reivax.norac.samplewebbapp.web.controller;

import org.antlr.stringtemplate.StringTemplate;
import org.jsoup.nodes.Document;
import org.mockito.Mock;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;
import org.testng.annotations.BeforeMethod;
import reivax.norac.samplewebbapp.web.renderer.StringTemplateFactory;

import java.io.IOException;
import java.util.Map;

import static org.jsoup.Jsoup.parse;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by xavier caron on 23/01/2015.
 */
public class RendererHelper {

    @Mock
    protected RequestContext requestContext;

    @BeforeMethod
    public void setUp() throws Exception {
        initMocks(this);
        when(requestContext.getContextPath()).thenReturn("/");
    }

    protected Document renderAsDocument(ModelAndView modelAndView) {
        String renderedPage = renderAsString(modelAndView);
        return parse(renderedPage);
    }

    private String renderAsString(ModelAndView modelAndView) {
        if (!modelAndView.getModel().containsKey("rc")) {
            modelAndView.addObject("rc", requestContext);
        }
        StringTemplate template = createTemplate(modelAndView.getViewName(), modelAndView.getModel());
        return template.toString();
    }

    private StringTemplate createTemplate(String templateName, Map<String, Object> model) {
        try {
            StringTemplateFactory factory = new StringTemplateFactory(
                    "test",
                    new FileSystemResourceLoader().getResource("src/main/webapp/WEB-INF/templates"));
            return factory.createStringTemplate(templateName, model);
        } catch (IOException e) {
            throw new RuntimeException("Could not create StringTemplate " + templateName, e);
        }
    }
}
