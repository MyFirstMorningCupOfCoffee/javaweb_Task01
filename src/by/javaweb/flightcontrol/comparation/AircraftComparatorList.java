package by.javaweb.flightcontrol.comparation;

import by.javaweb.flightcontrol.entity.Airport;
import java.util.Comparator;
import by.javaweb.flightcontrol.entity.aircraft.Aircraft;

public class AircraftComparatorList
{
    
    public static class NameComparator implements Comparator<Aircraft>
    {
        @Override
        public int compare(Aircraft o1, Aircraft o2)
        {
            return o1.getName().compareToIgnoreCase(o2.getName());
        } 
    }
    
    public static class NumberComparator implements Comparator<Aircraft>
    {
        @Override
        public int compare(Aircraft o1, Aircraft o2)
        {
            return o1.getNumber().compareToIgnoreCase(o2.getNumber());
        }
    }
    
    public static class ModelComparator implements Comparator<Aircraft>
    {
        @Override
        public int compare(Aircraft o1, Aircraft o2)
        {
            return o1.getModel().compareToIgnoreCase(o2.getModel());
        }
    }
    
    public static class BaseWeightComparator implements Comparator<Aircraft>
    {
        @Override
        public int compare(Aircraft o1, Aircraft o2)
        {
            Double o1Param = o1.getBaseWeight();
            Double o2param = o2.getBaseWeight();
            
            return o1Param.compareTo(o2param);
        }
    }
    
    public static class CargoWeightComparator implements Comparator<Aircraft>
    {
        @Override
        public int compare(Aircraft o1, Aircraft o2)
        {
            Double o1Param = o1.getCargoWeight();
            Double o2Param = o2.getCargoWeight();
            
            return o1Param.compareTo(o2Param);
        }
    }
    
    public static class PayloadComparator implements Comparator<Aircraft>
    {
        @Override
        public int compare(Aircraft o1, Aircraft o2)
        {
            Double o1Param = o1.getPayload();
            Double o2Param = o2.getPayload();
            
            return o1Param.compareTo(o2Param);
        }
    }
    
    public static class StateComparator implements Comparator<Aircraft>
    {
        @Override
        public int compare(Aircraft o1, Aircraft o2)
        {
            Integer o1Param = o1.getState().ordinal();
            Integer o2Param = o2.getState().ordinal();
            
            return o1Param.compareTo(o2Param);
        }
    }
    
    public static class DepartureComparator implements Comparator<Aircraft>
    {
        @Override
        public int compare(Aircraft o1, Aircraft o2)
        {
            Airport o1Param = o1.getDeparturePoint();
            Airport o2Param = o2.getDeparturePoint();
            
            return o1Param.compareTo(o2Param);
        }
    }
    
    public static class DestinationComparator implements Comparator<Aircraft>
    {
        @Override
        public int compare(Aircraft o1, Aircraft o2)
        {
            Airport o1Param = o1.getDestinationPoint();
            Airport o2Param = o2.getDestinationPoint();
            
            return o1Param.compareTo(o2Param);
        }
    }
            
    
}
