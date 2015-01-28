package reivax.norac.samplewebbapp.web.controller;

import org.jsoup.nodes.Document;
import org.mockito.InjectMocks;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.ModelAndView;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reivax.norac.samplewebbapp.model.HowToBuilder;
import reivax.norac.samplewebbapp.model.HowToModel;
import reivax.norac.samplewebbapp.model.StepBuilder;
import reivax.norac.samplewebbapp.web.Templates;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by xavier caron on 23/01/2015.
 */
@ContextConfiguration(locations = "/spring/applicationContext.xml")
public class HomePageControllerTest extends RendererHelper {

    private static final String ALL_ADVICE = "allAdvice";
    private static final String MESSAGE = "welcomeMessage";

    private static final String EXPECTED_MESSAGE = "test message";

    @InjectMocks
    HomePageController controller;

    @BeforeClass
    public void setUp() throws Exception {
        initMocks(this);
        controller.setWelcomeMessage(EXPECTED_MESSAGE);
    }

    @Test
    public void rightPageIsDisplayed(){/*
        ModelAndView mv = controller.displayHomePage();
        assertThat(mv.getViewName(), is(Templates.HOMEPAGE_TEMPLATE));*/
    }

    @Test
    public void someAdviceIsDisplayed(){/*
        ModelAndView mv = controller.displayHomePage();
        List<HowToModel> allAdvice = (List<HowToModel>) mv.getModel().get(ALL_ADVICE);
        assertThat(allAdvice, is(notNullValue()));*/
    }

    @Test
    public void welcomeMessageIsDisplayed(){/*
        ModelAndView mv = controller.displayHomePage();
        String message = (String) mv.getModel().get(MESSAGE);
        assertThat(message, is(notNullValue()));*/
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
        Document doc = displayHTMLView(Arrays.asList(new HowToModel[]{advice}), EXPECTED_MESSAGE);

        // then
        assertThat(doc.select("h2").text(), is(not("")));
        assertThat(EXPECTED_MESSAGE.equals(doc.select(".jumbotron p").text()), is(true));
    }

    private Document displayHTMLView(List<HowToModel> allAdvice, String message) {
        ModelAndView modelAndView = new ModelAndView(Templates.HOMEPAGE_TEMPLATE);
        modelAndView.addObject(ALL_ADVICE, allAdvice);
        modelAndView.addObject(MESSAGE, message);
        return renderAsDocument(modelAndView);
    }
}
