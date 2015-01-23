package reivax.norac.samplewebbapp.web.controller;

import reivax.norac.samplewebbapp.web.ApplicationUrls;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by xavier caron on 21/01/2015.
 */
@RequestMapping(ApplicationUrls.HOME)
public interface HomePageControllerInterface {

    @RequestMapping(method = GET)
    ModelAndView displayHomePage();
}
