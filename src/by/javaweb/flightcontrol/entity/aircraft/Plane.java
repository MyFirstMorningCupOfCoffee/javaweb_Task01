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

    @Override
    public boolean equals(Object object) 
    {
        if (this == object) return true;
        if (!(object instanceof Plane)) return false;
        if (!super.equals(object)) return false;

        Plane plane = (Plane) object;

        return runwayLength == plane.runwayLength;
    }

    @Override
    public int hashCode() 
    {
        int result = super.hashCode();
        result = 31 * result + runwayLength;
        return result;
    }
}
