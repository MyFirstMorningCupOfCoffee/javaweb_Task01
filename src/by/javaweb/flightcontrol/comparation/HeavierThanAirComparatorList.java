package by.javaweb.flightcontrol.comparation;

import java.util.Comparator;
import by.javaweb.flightcontrol.entity.aircraft.HeavierThanAirAircraft;

public class HeavierThanAirComparatorList 
{
    public static class EngineTypeComparator implements Comparator<HeavierThanAirAircraft>
    {
        @Override
        public int compare(HeavierThanAirAircraft o1, HeavierThanAirAircraft o2)
        {
            Integer o1Param = o1.getEngineType().ordinal();
            Integer o2Param = o2.getEngineType().ordinal();
            
            return o1Param.compareTo(o2Param);
        }
    }
    
    public static class FuelTypeComparator implements Comparator<HeavierThanAirAircraft>
    {
        @Override
        public int compare(HeavierThanAirAircraft o1, HeavierThanAirAircraft o2)
        {
            Integer o1Param = o1.getFuelType().ordinal();
            Integer o2Param = o2.getFuelType().ordinal();
            
            return o1Param.compareTo(o2Param);
        }
    }
    
    public static class FuelCapacityComparator implements Comparator<HeavierThanAirAircraft>
    {
        @Override
        public int compare(HeavierThanAirAircraft o1, HeavierThanAirAircraft o2)
        {
            Double o1Param = o1.getFuelCapacity();
            Double o2Param = o2.getFuelCapacity();
            
            return o1Param.compareTo(o2Param);
        }
    }
    
    public static class FuelQuantityComparator implements Comparator<HeavierThanAirAircraft>
    {
        @Override
        public int compare(HeavierThanAirAircraft o1, HeavierThanAirAircraft o2)
        {
            Double o1Param = o1.getFuelQuantity();
            Double o2Param = o2.getFuelQuantity();
            
            return o1Param.compareTo(o2Param);
        }
    }
    
    public static class MaxRangeComparator implements Comparator<HeavierThanAirAircraft>
    {
        @Override
        public int compare(HeavierThanAirAircraft o1, HeavierThanAirAircraft o2)
        {
            Integer o1Param = o1.getMaxRange();
            Integer o2Param = o2.getMaxRange();
            
            return o1Param.compareTo(o2Param);
        }
    }
}
