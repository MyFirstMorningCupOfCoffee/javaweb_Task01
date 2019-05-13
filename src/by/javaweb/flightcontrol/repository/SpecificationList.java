package by.javaweb.flightcontrol.repository;

import by.javaweb.flightcontrol.entity.Fuel;
import by.javaweb.flightcontrol.entity.aircraft.*;
import by.javaweb.flightcontrol.exception.SomethingIsTerriblyWrongException;

public class SpecificationList 
{
//    public static Specification planesOnly()
//    {
//        return new PlanesOnly();
//    }
    
//    public static Specification specificTypeOnly_old(Class<? extends Aircraft> typeClass)
//    {
//        return new AircraftTypeSpecification()
//        {
//            @Override
//            public boolean specify(Aircraft element)
//            {
//                return typeClass.isAssignableFrom(element.getClass());
//            }
//        };
//    }
    
    public static Specification specificTypeOnly(AircraftType type)
    {
        Class typeClass;
        
        switch(type)
        {
            case Aircraft:  
            {
                typeClass = Aircraft.class;
                break;
            }
            case HeavierThanAirAircraft:  
            {
                typeClass = HeavierThanAirAircraft.class;
                break;
            }
            case Plane:     
            {
                typeClass = Plane.class;
                break;
            }
            case CargoAirliner:
            {
                typeClass = CargoAirliner.class;
                break;
            }
            case PassengerAirliner:
            {
                typeClass = PassengerAirliner.class;
                break;
            }
            case Helicopter:
            {
                typeClass = CargoAirliner.class;
                break;
            }
            default:
            {
                throw new SomethingIsTerriblyWrongException("Wrong enum parameter");
            }
        }
        
        return new Specification()
        {
            @Override
            public boolean specify(Aircraft element)
            {
                return typeClass.isAssignableFrom(element.getClass());
            }
        };
    }
    
    public static Specification hasFuelLowerThan(double percent)
    {
        return new HasFuelLowerThan(percent);
    }
    
    public static Specification hasFuelLHigherThan(double percent)
    {
        return new HasFuelHigherThan(percent);
    }
    
    public static Specification hasSpecificState(Aircraft.State state)
    {
        return new HasSpecificState(state);
    }
    
    public static Specification usesSpecificFuel(Fuel.Type fuel)
    {
        return new UsesSpecificFuel(fuel);
    }
    
//    public static Specification specificTypeOnly2(Aircraft example)
//    {
//        return new AircraftTypeSpecification()
//        {
//            @Override
//            public boolean specify(Aircraft element)
//            {
//                return element.getClass().isAssignableFrom(example.getClass());
//            }
//        };
//    }
    
//    private static class AircraftTypeSpecification_old implements Specification
//    {
//        @Override
//        public boolean specify(Aircraft element)
//        {
//            return element.getClass().isAssignableFrom(Aircraft.class);
//        }
//    }
    
//    private static class AircraftTypeSpecification implements Specification
//    {
//        @Override
//        public boolean specify(Aircraft element)
//        {
//            return element.getClass().isAssignableFrom(Aircraft.class);
//        }
//    }
//    
//    private static class PlanesOnly implements Specification
//    {
//        @Override
//        public boolean specify(Aircraft element)
//        {
//            return element.getClass().isAssignableFrom(Plane.class);
//        }
//    }
//    
//    private static class HelicoptersOnly implements Specification
//    {
//        @Override
//        public boolean specify(Aircraft element)
//        {
//            return element.getClass() == Helicopter.class;
//        }
//    }
//    
//    private static class CargoPlanesOnly implements Specification
//    {
//        @Override
//        public boolean specify(Aircraft element)
//        {
//            return element.getClass() == CargoAirliner.class;
//        }
//    }
//    
//    private static class PassengerPlanesOnly implements Specification
//    {
//        @Override
//        public boolean specify(Aircraft element)
//        {
//            return element.getClass() == PassengerAirliner.class;
//        }
//    }
    
    
    private static class HasFuelLowerThan implements Specification
    {
        double percent;
        public HasFuelLowerThan(double percent)
        {
            this.percent = percent;
        }
        
        @Override
        public boolean specify(Aircraft element)
        {
            if(element.getClass().isAssignableFrom(HeavierThanAirAircraft.class))
            {
                HeavierThanAirAircraft fuelUser = (HeavierThanAirAircraft) element;
                double actualPercent = 
                        (fuelUser.getFuelQuantity() / fuelUser.getFuelCapacity()) * 100;
                
                return actualPercent < percent;
            }
            
            return false;
        }
    }
    
    private static class HasFuelHigherThan implements Specification
    {
        double percent;
        public HasFuelHigherThan(double percent)
        {
            this.percent = percent;
        }
        
        @Override
        public boolean specify(Aircraft element)
        {
            if(element.getClass().isAssignableFrom(HeavierThanAirAircraft.class))
            {
                HeavierThanAirAircraft fuelUser = (HeavierThanAirAircraft) element;
                double actualPercent = 
                        (fuelUser.getFuelQuantity() / fuelUser.getFuelCapacity()) * 100;
                
                return actualPercent > percent;
            }
            
            return false;
        }
    }
    
    private static class HasSpecificState implements Specification
    {
        Aircraft.State state;
        
        public HasSpecificState(Aircraft.State state)
        {
            this.state = state;
        }
        
        @Override
        public boolean specify(Aircraft element)
        {
            return element.getState() == state;
        }
    }
    
    private static class UsesSpecificFuel implements Specification
    {
        Fuel.Type fuel;
        
        public UsesSpecificFuel(Fuel.Type fuel)
        {
            this.fuel = fuel;
        }
        
        @Override
        public boolean specify(Aircraft element)
        {
            if(HeavierThanAirAircraft.class.isAssignableFrom(element.getClass()))
            {
                HeavierThanAirAircraft fuelUser = (HeavierThanAirAircraft) element;
               
                return fuelUser.getFuelType() == fuel;
            }
            
            return false;
        }
    }
        
}
