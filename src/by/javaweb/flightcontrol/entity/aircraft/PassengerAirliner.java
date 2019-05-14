package by.javaweb.flightcontrol.entity.aircraft;

public class PassengerAirliner extends Plane
{
    // number of passenger seats in current passenger airliner
    private int seats;

    public PassengerAirliner()
    {
    }

    public PassengerAirliner(PassengerAirliner copyMe)
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
        if (!(object instanceof PassengerAirliner)) return false;
        if (!super.equals(object)) return false;

        PassengerAirliner that = (PassengerAirliner) object;

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
