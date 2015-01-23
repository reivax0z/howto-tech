package reivax.norac.samplewebbapp.web.controller;

import org.jsoup.nodes.Document;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reivax.norac.samplewebbapp.model.HowToBuilder;
import reivax.norac.samplewebbapp.model.HowToModel;
import reivax.norac.samplewebbapp.model.StepBuilder;
import reivax.norac.samplewebbapp.web.Templates;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.jsoup.Jsoup.parse;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by xavier caron on 23/01/2015.
 */
public class AdviceControllerTest extends RendererHelper {

    private static final String ADVICE = "advice";

    @InjectMocks
    AdviceController controller;

    @BeforeMethod
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void rightPageIsDisplayed(){
        ModelAndView mv = controller.displayAdvice("1");
        assertThat(mv.getViewName(), is(Templates.ADVICE_TEMPLATE));
    }

    @Test
    public void someAdviceIsDisplayed(){
        ModelAndView mv = controller.displayAdvice("1");
        HowToModel advice = (HowToModel) mv.getModel().get(ADVICE);
        assertThat(advice, is(notNullValue()));
    }

    @Test
    public void theHTMLContentIsValid() {
        // given
        HowToModel advice = HowToBuilder.anHowTo()
                .withStep(StepBuilder.aStep()
                    .withId(1)
                    .withContent("content")
                    .withIntro("intro")
                    .build())
                .build();

        // when
        Document doc = displayHTMLView(advice);

        // then
        assertThat(doc.select("#step1"), is(notNullValue()));
    }

    private Document displayHTMLView(HowToModel advice) {
        ModelAndView modelAndView = new ModelAndView(Templates.ADVICE_TEMPLATE);
        modelAndView.addObject(ADVICE, advice);
        return renderAsDocument(modelAndView);
    }
}
