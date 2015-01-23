package reivax.norac.samplewebbapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xavier caron on 22/01/2015.
 */
public class DbModel {

    List<HowToModel> listOfAdvice = new ArrayList<HowToModel>();

    public List<HowToModel> getListOfAdvice(){
        return this.listOfAdvice;
    }
    public void addAdvice(HowToModel advice){ this.listOfAdvice.add(advice); }
}
