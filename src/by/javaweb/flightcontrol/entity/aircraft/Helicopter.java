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

    

    /**
     * @return the seats quantity
     */
    public int getSeats()
    {
        return seats;
    }

    /**
     * @param seats the seats quantity to set
     */
    public void setSeats(int seats)
    {
        this.seats = seats;
    }
    
}
