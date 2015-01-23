package reivax.norac.samplewebbapp.web.renderer;

import org.antlr.stringtemplate.StringTemplate;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by xavier caron on 21/01/2015.
 */
public class StringTemplateView extends InternalResourceView {

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
                                           HttpServletResponse response) throws IOException {
        renderView(response, createStringTemplate(model));
    }

    private StringTemplate createStringTemplate(Map<String, Object> model) {
        StringTemplateFactory factory = getApplicationContext().getBean(StringTemplateFactory.class);
        return factory.createStringTemplate(getBeanName(), model);
    }

    private void renderView(HttpServletResponse response, StringTemplate template) throws IOException {
        response.setContentType(getContentType());
        PrintWriter writer = response.getWriter();
        writer.print(template);
        writer.flush();
        writer.close();
    }
}
