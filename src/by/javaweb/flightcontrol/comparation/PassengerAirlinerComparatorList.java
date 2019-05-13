package by.javaweb.flightcontrol.comparation;

import java.util.Comparator;
import by.javaweb.flightcontrol.entity.aircraft.PassengerAirliner;

public class PassengerAirlinerComparatorList 
{
    public static class PassengerAirlinerSeatsQuantityComparator implements Comparator<PassengerAirliner>
    {
        @Override
        public int compare(PassengerAirliner o1, PassengerAirliner o2)
        {
            Integer o1Param = o1.getSeats();
            Integer o2Param = o2.getSeats();
            
            return o1Param.compareTo(o2Param);
        }
    }
}
