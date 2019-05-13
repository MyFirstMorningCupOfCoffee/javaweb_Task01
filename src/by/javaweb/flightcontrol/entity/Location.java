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

    /**
     * @return the latitude
     */
    public double getLatitude()
    {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public double getLongitude()
    {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
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
    
}
