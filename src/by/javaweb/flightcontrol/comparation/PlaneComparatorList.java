package by.javaweb.flightcontrol.comparation;

import java.util.Comparator;
import by.javaweb.flightcontrol.entity.aircraft.Plane;

public class PlaneComparatorList 
{
    public static class RunwayLengthComparator implements Comparator<Plane>
    {
        @Override
        public int compare(Plane o1, Plane o2)
        {
            Integer o1Param = o1.getRunwayLength();
            Integer o2Param = o2.getRunwayLength();
            
            return o1Param.compareTo(o2Param);
        }
    }
}
