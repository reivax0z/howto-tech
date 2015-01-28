package reivax.norac.samplewebbapp.service;

import reivax.norac.samplewebbapp.model.HowToModel;
import reivax.norac.samplewebbapp.model.StepModel;

import java.util.Comparator;
import java.util.List;

/**
 * Created by xavier caron on 22/01/2015.
 */
public class Utils {

    public static HowToModel getAdviceFromList(List<HowToModel> list, int id){
        for(HowToModel advice : list){
            if(advice.getId() == id){
                return advice;
            }
        }
        return null;
    }

    public static Comparator<HowToModel> getHowToModelComparator(){
        return new Comparator<HowToModel>() {
            @Override
            public int compare(HowToModel o1, HowToModel o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        };
    }

    public static Comparator<StepModel> getStepModelComparator(){
        return new Comparator<StepModel>() {
            @Override
            public int compare(StepModel o1, StepModel o2) {
                return Integer.compare(o1.getNumber(), o2.getNumber());
            }
        };
    }
}
