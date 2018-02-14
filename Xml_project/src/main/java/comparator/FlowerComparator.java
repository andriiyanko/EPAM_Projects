package comparator;

import model.Flower;

import java.util.Comparator;

public class FlowerComparator implements Comparator<Flower>{

    @Override
    public int compare(Flower o1, Flower o2) {
        return Double.compare(o1.getGrowing_tip().getTemperature(), o2.getGrowing_tip().getTemperature());
    }
}
