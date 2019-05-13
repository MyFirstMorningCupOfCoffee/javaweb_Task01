package by.javaweb.flightcontrol.comparation;

import java.util.Comparator;
import by.javaweb.flightcontrol.entity.aircraft.CargoAirliner;

public class CargoAirlinerComparatorList 
{
    public static class CargoAirlinerGateHeightComparator implements Comparator<CargoAirliner>
    {
        @Override
        public int compare(CargoAirliner o1, CargoAirliner o2)
        {
            Double o1Param = o1.getLoadingGateHeightMeters();
            Double o2Param = o2.getLoadingGateHeightMeters();
            
            return o1Param.compareTo(o2Param);
        }
    }
    
    public static class CargoAirlinerGateWidthComparator implements Comparator<CargoAirliner>
    {
        @Override
        public int compare(CargoAirliner o1, CargoAirliner o2)
        {
            Double o1Param = o1.getLoadingGateWidthMeters();
            Double o2Param = o2.getLoadingGateWidthMeters();
            
            return o1Param.compareTo(o2Param);
        }
    }
}
