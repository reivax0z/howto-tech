package reivax.norac.samplewebbapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import reivax.norac.samplewebbapp.model.DbModel;
import reivax.norac.samplewebbapp.model.HowToModel;
import reivax.norac.samplewebbapp.model.DbModelBuilder;
import reivax.norac.samplewebbapp.repository.HowToModelRepository;
import reivax.norac.samplewebbapp.service.Utils;
import reivax.norac.samplewebbapp.web.Templates;

import java.util.Collections;

/**
 * Created by xavier caron on 22/01/2015.
 */
@Controller
public class AdviceController implements AdviceControllerInterface {

    @Autowired
    private HowToModelRepository repository;

    @Override
    public ModelAndView displayAdvice(@RequestParam(value = "id", required = true) String id) {

        HowToModel advice = repository.findOne(Integer.parseInt(id));
/*        DbModel dbContent = DbModelBuilder.getInstance().build();
        HowToModel advice = Utils.getAdviceFromList(dbContent.getListOfAdvice(), Integer.parseInt(id));*/
        Collections.sort(advice.getSteps(), Utils.getStepModelComparator());

        ModelAndView toReturn = new ModelAndView(Templates.ADVICE_TEMPLATE);
        toReturn.addObject("advice", advice);
        return toReturn;
    }
}
