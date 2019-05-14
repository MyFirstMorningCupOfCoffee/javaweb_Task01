package by.javaweb.flightcontrol.entity;

public class Airport implements Comparable<Airport>
{
    private String name;
    private String id;
    private Location location;
    
    private int runwayLength;
    
    public Airport()
    {
        
    }
    
    public Airport(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Location getLocation()
    {
        return location;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    public int getRunwayLength()
    {
        return runwayLength;
    }

    public void setRunwayLength(int runwayLength)
    {
        this.runwayLength = runwayLength;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        result.append("[").append(getName()).append("]");
        result.append(" (").append(getLocation()).append(")");
        
        return result.toString();
    }

    @Override
    public int compareTo(Airport o)
    {
        String name1 = this.getId();
        String name2 = o.getId();
        
        return name1.compareToIgnoreCase(name2);
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object) return true;
        if (!(object instanceof Airport)) return false;
        if (!super.equals(object)) return false;

        Airport airport = (Airport) object;

        if (runwayLength != airport.runwayLength) return false;
        if (name != null ? !name.equals(airport.name) : airport.name != null) return false;
        if (id != null ? !id.equals(airport.id) : airport.id != null) return false;
        if (location != null ? !location.equals(airport.location) : airport.location != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + runwayLength;
        return result;
    }
}

