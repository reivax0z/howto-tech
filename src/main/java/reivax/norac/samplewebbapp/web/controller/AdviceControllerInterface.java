package reivax.norac.samplewebbapp.web.controller;

/**
 * Created by xavier caron on 22/01/2015.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import reivax.norac.samplewebbapp.web.ApplicationUrls;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RequestMapping(ApplicationUrls.ADVICE)
public interface AdviceControllerInterface {

        @RequestMapping(method = GET)
        ModelAndView displayAdvice(@RequestParam(value = "id", required = true) String id);
}
