package by.javaweb.flightcontrol.entity.aircraft;

import by.javaweb.flightcontrol.entity.Engine;
import by.javaweb.flightcontrol.entity.Fuel;

public abstract class HeavierThanAirAircraft extends Aircraft
{
    private double fuelCapacity;
    private double fuelQuantity;
    private double fuelWeight;
    
    private int maxRange;
    
    private Fuel.Type fuel;
    private Engine.Type engine;
    private int enginesQuantity;

    {
        fuel = Fuel.Type.NOT_DEFINED;
        engine = Engine.Type.NOT_DEFINED;
    }

    public HeavierThanAirAircraft()
    {
    }

    public HeavierThanAirAircraft(HeavierThanAirAircraft copyMe)
    {
        super(copyMe);
        this.fuelCapacity = copyMe.fuelCapacity;
        this.fuelQuantity = copyMe.fuelQuantity;
        this.fuelWeight = copyMe.fuelWeight;
        this.maxRange = copyMe.maxRange;
        this.enginesQuantity = copyMe.enginesQuantity;
    }
    
    

    // Refuel aircraft if it has enough empty space for requested fuel quantity
    public boolean refuel(double fuelQuantity)
    {
        if(calcFuelRequired() >= fuelQuantity)
        {
            setFuelQuantity(this.fuelQuantity + fuelQuantity);
            return true;
        }
        
        return false;
    }
    
    // Decreases fuel quantity in aircraft tank if requested value is <= than
    // fuel stored in aircraft tank
    public boolean spendFuel(double fuelQuantity)
    {
        if(this.fuelQuantity >= fuelQuantity)
        {
            setFuelQuantity(this.fuelQuantity - fuelQuantity);
            return true;
        }
        
        return false;
    }
    
    // Calculates empty space in aircraft fuel tank
    public double calcFuelRequired()
    {        
        return getFuelCapacity() - getFuelQuantity();
    }
    
    // calculate how much cargo can be taken aboard
    // negative value means that some cargo needs to be removed from aircraft
    @Override
    public double calcFreeCargoWeight()
    {
        return getPayload() - getCargoWeight() - getFuelWeight();
    }
    
    public Fuel.Type getFuelType()
    {
        return fuel;
    }

    public void setFuelType(Fuel.Type fuel)
    {
        this.fuel = fuel;
    }

    public int getMaxRange()
    {
        return maxRange;
    }

    public void setMaxRange(int maxRange)
    {
        this.maxRange = maxRange;
    }

    public double getFuelCapacity()
    {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity)
    {
        this.fuelCapacity = fuelCapacity;
    }

    public double getFuelQuantity()
    {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity)
    {
        this.fuelQuantity = fuelQuantity;
        this.fuelWeight = Fuel.getFuelWeight(this.fuel, this.fuelQuantity);
    }

    public Engine.Type getEngineType()
    {
        return engine;
    }

    public void setEngineType(Engine.Type engine)
    {
        this.engine = engine;
    }

    public int getEnginesQuantity()
    {
        return enginesQuantity;
    }

    public void setEnginesQuantity(int enginesQuantity)
    {
        this.enginesQuantity = enginesQuantity;
    }

    public double getFuelWeight()
    {
        return fuelWeight;
    }
    
    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        result.append("Number: ").append(getNumber()).append(" | ");
        result.append("Name: ").append(getName()).append(" | ");
        result.append("State: ").append(getState()).append(" | ");
        
        if(getState() == Aircraft.State.FLYING 
                || getState() == Aircraft.State.LANDING
                || getState() == Aircraft.State.TAKING_OFF
                || getState() == Aircraft.State.WAITING_FOR_LANDING_PERMISSION
                || getState() == Aircraft.State.WAITING_FOR_FLY_PERMISSION)
        {
            result.append("Departure: ").append(getDeparturePoint()).append(" | ");
            result.append("Destination: ").append(getDestinationPoint()).append(" | ");
        }
        else
        {
            result.append("Location: ").append(getDestinationPoint()).append(" | ");
        }
        result.append("Fuel: ").append(getFuelQuantity()).append(" / ")
              .append(getFuelCapacity());
        
        return result.toString(); 
    }
    
}
