package by.javaweb.flightcontrol.entity.aircraft;


public class Helicopter extends HeavierThanAirAircraft
{
    private int seats;

    public Helicopter()
    {
    }

    public Helicopter(Helicopter copyMe)
    {
        super(copyMe);
        this.seats = copyMe.seats;
    }

    public int getSeats()
    {
        return seats;
    }

    public void setSeats(int seats)
    {
        this.seats = seats;
    }
    
    @Override
    public boolean equals(Object object) 
    {
        if (this == object) return true;
        if (!(object instanceof Helicopter)) return false;
        if (!super.equals(object)) return false;

        Helicopter that = (Helicopter) object;

        if (seats != that.seats) return false;

        return true;
    }

    @Override
    public int hashCode() 
    {
        int result = super.hashCode();
        result = 31 * result + seats;
        return result;
    }
    
}
