package by.javaweb.flightcontrol.entity.aircraft;

public abstract class Plane extends HeavierThanAirAircraft
{
    private int runwayLength;

    public Plane()
    {
    }

    public Plane(Plane copyMe)
    {
        super(copyMe);
        this.runwayLength = copyMe.runwayLength;
    }

    public int getRunwayLength()
    {
        return runwayLength;
    }

    public void setRunwayLength(int minimalRunwayLengthInMeters)
    {
        this.runwayLength = minimalRunwayLengthInMeters;
    }
    
}
