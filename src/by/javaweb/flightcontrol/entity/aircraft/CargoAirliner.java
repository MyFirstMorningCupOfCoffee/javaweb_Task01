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
    
    @Override
    public boolean equals(Object object) 
    {
        if (this == object) return true;
        if (!(object instanceof CargoAirliner)) return false;
        if (!super.equals(object)) return false;

        CargoAirliner that = (CargoAirliner) object;

        if (Double.compare(that.loadingGateHeightMeters, loadingGateHeightMeters) != 0) return false;
        if (Double.compare(that.loadingGateWidthMeters, loadingGateWidthMeters) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() 
    {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(loadingGateHeightMeters);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(loadingGateWidthMeters);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
