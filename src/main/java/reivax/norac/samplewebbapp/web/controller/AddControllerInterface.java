package reivax.norac.samplewebbapp.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import reivax.norac.samplewebbapp.web.ApplicationUrls;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by xavier caron on 28/01/2015.
 */
@RequestMapping(ApplicationUrls.ADD)
public interface AddControllerInterface {

    @RequestMapping(method = POST)
    String addAdvice(@RequestParam Map<String,String> allRequestParams);

    @RequestMapping(method = GET)
    ModelAndView displayAddPage();
}
