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
    
}
