package by.javaweb.flightcontrol.entity.aircraft;

public class CargoAirliner extends Plane
{
    // These parameters describes size of loading gates of this cargo airliner.
    // Cargo can require really lot of space
    private double loadingGateHeightMeters;
    private double loadingGateWidthMeters;  

    public CargoAirliner()
    {
    }

    public CargoAirliner(CargoAirliner copyMe)
    {
        super(copyMe);
        this.loadingGateHeightMeters = copyMe.loadingGateHeightMeters;
        this.loadingGateWidthMeters = copyMe.loadingGateWidthMeters;
    }

    
    
    public double getLoadingGateHeightMeters()
    {
        return loadingGateHeightMeters;
    }

    public void setLoadingGateHeightMeters(double loadingGateHeightMeters)
    {
        this.loadingGateHeightMeters = loadingGateHeightMeters;
    }

    public double getLoadingGateWidthMeters()
    {
        return loadingGateWidthMeters;
    }

    public void setLoadingGateWidthMeters(double loadingGateWidthMeters)
    {
        this.loadingGateWidthMeters = loadingGateWidthMeters;
    }
}
