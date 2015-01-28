package reivax.norac.samplewebbapp.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import reivax.norac.samplewebbapp.web.ApplicationUrls;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by xavier caron on 28/01/2015.
 */
@RequestMapping(ApplicationUrls.SEARCH)
public interface SearchControllerInterface {

    @RequestMapping(method = POST)
    ModelAndView displaySearchResultPage(@RequestParam(value = "text", required = true) String text);
}
