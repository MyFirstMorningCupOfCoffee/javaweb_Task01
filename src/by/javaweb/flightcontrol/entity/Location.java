package by.javaweb.flightcontrol.entity;

public class Location 
{
    private double latitude;
    private double longitude;

    public Location()
    {
        
    }

    public Location(double latitude, double longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    }
    
    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        result.append("ltt: ").append(getLatitude()).append(" ");
        result.append("lgt: ").append(getLongitude());
        
        return result.toString();
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object) return true;
        if (!(object instanceof Location)) return false;
        if (!super.equals(object)) return false;

        Location location = (Location) object;

        if (Double.compare(location.latitude, latitude) != 0) return false;
        if (Double.compare(location.longitude, longitude) != 0) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
