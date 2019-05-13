package by.javaweb.flightcontrol.comparation;

import java.util.Comparator;
import by.javaweb.flightcontrol.entity.aircraft.Helicopter;

public class HelicopterComparatorList 
{
    public static class HelicopterSeatsQuantityComparator implements Comparator<Helicopter>
    {
        @Override
        public int compare(Helicopter o1, Helicopter o2)
        {
            Integer o1Param = o1.getSeats();
            Integer o2Param = o2.getSeats();
            
            return o1Param.compareTo(o2Param);
        }
    }
}
