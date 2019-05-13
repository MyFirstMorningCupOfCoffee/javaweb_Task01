package by.javaweb.flightcontrol.entity.aircraft;

import by.javaweb.flightcontrol.entity.Airport;

public abstract class Aircraft 
{
    private String model;
    private String name;
    private String number;
    private double baseWeight;
    private double payload;
    private double cargoWeight; 
    
    private State state;
    private Airport destinationPoint;
    private Airport departurePoint;
    
    public enum State
    {
        WAITING_FOR_LANDING_PERMISSION,
        LANDING,
        LANDED,
        HANGARED,
        
        WAITING_FOR_FLY_PERMISSION,
        TAKING_OFF,
        FLYING,
        
        UNKNOWN
    }
    
    {
        state = State.UNKNOWN;
        name = "N/A";
        number = "N/A";
    }

    public Aircraft()
    {
    }

    public Aircraft(Aircraft copyMe)
    {
        this.model = copyMe.model;
        this.name = copyMe.name;
        this.number = copyMe.number;
        this.baseWeight = copyMe.baseWeight;
        this.payload = copyMe.payload;
        this.cargoWeight = copyMe.cargoWeight;
        this.state = copyMe.state;
        this.destinationPoint = copyMe.destinationPoint;
        this.departurePoint = copyMe.departurePoint;
    }

    
    
    
    
    
    public abstract double calcFreeCargoWeight();

    public Airport getDestinationPoint()
    {
        return destinationPoint;
    }

    public void setDestinationPoint(Airport destinationPoint)
    {
        this.destinationPoint = destinationPoint;
    }

    public Airport getDeparturePoint()
    {
        return departurePoint;
    }

    public void setDeparturePoint(Airport departurePoint)
    {
        this.departurePoint = departurePoint;
    }

    public double getCargoWeight()
    {
        return cargoWeight;
    }

    public void setCargoWeight(double cargoWeight)
    {
        this.cargoWeight = cargoWeight;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public double getBaseWeight()
    {
        return baseWeight;
    }

    public void setBaseWeight(double baseWeight)
    {
        this.baseWeight = baseWeight;
    }


    public double getPayload()
    {
        return payload;
    }

    public void setPayload(double payload)
    {
        this.payload = payload;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }
    
    public State getState()
    {
        return state;
    }

    public void setState(State state)
    {
        this.state = state;
    }

}
