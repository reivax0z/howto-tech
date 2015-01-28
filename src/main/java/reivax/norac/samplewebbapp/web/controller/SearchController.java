package reivax.norac.samplewebbapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import reivax.norac.samplewebbapp.model.HowToModel;
import reivax.norac.samplewebbapp.search.HibernateSearch;
import reivax.norac.samplewebbapp.service.Utils;
import reivax.norac.samplewebbapp.web.Templates;

import java.util.Collections;
import java.util.List;

/**
 * Created by xavier caron on 28/01/2015.
 */
@Controller
public class SearchController implements SearchControllerInterface {

    @Autowired
    private HibernateSearch search;

    @Override
    public ModelAndView displaySearchResultPage(@RequestParam(value = "text", required = true) String text) {
        ModelAndView toReturn = new ModelAndView(Templates.SEARCH_RESULTS_TEMPLATE);

        toReturn.addObject("textSearched", text);

        List<HowToModel> results = search.getSearchResults(text);
        Collections.sort(results, Utils.getHowToModelComparator());
        toReturn.addObject("matchedAdvice", results);

        return toReturn;
    }
}
