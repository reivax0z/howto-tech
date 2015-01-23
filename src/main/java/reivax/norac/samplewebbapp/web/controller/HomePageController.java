package reivax.norac.samplewebbapp.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import reivax.norac.samplewebbapp.model.DbModel;
import reivax.norac.samplewebbapp.model.DbModelBuilder;
import reivax.norac.samplewebbapp.service.Utils;
import reivax.norac.samplewebbapp.web.Templates;

import java.util.Collections;

/**
 * Created by xavier caron on 22/01/2015.
 */
@Controller
public class HomePageController implements HomePageControllerInterface {

    String welcomeMessage;

    @Override
    public ModelAndView displayHomePage() {
        DbModel dbContent = DbModelBuilder.getInstance().build();
        Collections.sort(dbContent.getListOfAdvice(), Utils.getHowToModelComparator());

        ModelAndView toReturn = new ModelAndView(Templates.HOMEPAGE_TEMPLATE);
        toReturn.addObject("allAdvice", dbContent.getListOfAdvice());
        toReturn.addObject("welcomeMessage", welcomeMessage);
        return toReturn;
    }

    @Value("${static-welcome-message}")
    public void setWelcomeMessage(String welcomeMessage){
        this.welcomeMessage = welcomeMessage;
    }
}
