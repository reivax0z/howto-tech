package reivax.norac.samplewebbapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import reivax.norac.samplewebbapp.model.HowToBuilder;
import reivax.norac.samplewebbapp.model.HowToModel;
import reivax.norac.samplewebbapp.model.StepBuilder;
import reivax.norac.samplewebbapp.model.StepModel;
import reivax.norac.samplewebbapp.repository.HowToModelRepository;
import reivax.norac.samplewebbapp.web.ApplicationUrls;
import reivax.norac.samplewebbapp.web.Templates;

import java.util.List;
import java.util.Map;

/**
 * Created by xavier caron on 28/01/2015.
 */
@Controller
public class AddController implements AddControllerInterface {

    @Autowired
    private HowToModelRepository repository;

    @Override
    public String addAdvice(@RequestParam Map<String,String> allRequestParams) {

        HowToBuilder adviceBuilder = HowToBuilder.anHowTo()
                .withIntro(allRequestParams.get("intro"))
                .withTitle(allRequestParams.get("title"));


        for(int i=0; i<10; i++){
            if(allRequestParams.get("step_"+i+"_intro") != null) {
                adviceBuilder.withStep(StepBuilder.aStep()
                        .withIntro(allRequestParams.get("step_"+i+"_intro"))
                        .withContent(allRequestParams.get("step_"+i+"_content"))
                        .withNumber(Integer.valueOf(allRequestParams.get("step_"+i+"_number")))
                        .withPictureLink(allRequestParams.get("step_"+i+"_link"))
                        .build());
            }
        }

        repository.save(adviceBuilder.build());

        return "redirect:" + ApplicationUrls.HOME;
    }

    @Override
    public ModelAndView displayAddPage() {

        ModelAndView toReturn = new ModelAndView(Templates.ADD_ADVICE_TEMPLATE);
        return toReturn;
    }
}
