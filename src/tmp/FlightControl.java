package tmp;
import by.javaweb.flightcontrol.entity.*;
import by.javaweb.flightcontrol.entity.aircraft.*;
import by.javaweb.flightcontrol.repository.*;
import java.util.List;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;


public class FlightControl 
{

    public static void main(String[] args) 
    {
        CargoAirliner p1 = new CargoAirliner();
        p1.setName("cargo 1");
        p1.setNumber("1");
        p1.setFuelType(Fuel.Type.BIOFUEL);
        PassengerAirliner p2 = new PassengerAirliner();
        p2.setName("passenger 1");
        p2.setNumber("2");
        Helicopter p3 = new Helicopter();
        p3.setName("helicopter 1");
        p3.setNumber("3");
        Helicopter p4 = new Helicopter();
        p4.setName("helicopter 2");
        p4.setNumber("4");
        PassengerAirliner p5 = new PassengerAirliner();
        p5.setName("passenger 2");
        p5.setNumber("5");
        
        Vault vault = new Vault();
        vault.addAll(p1, p2, p3, p4, p5);
        
        //List<Aircraft> result = vault.query(SpecificationList.HasSpecifiedState(Aircraft.State.UNKNOWN));
        //result = vault.query(s -> ((s.getClass() == PassengerAirliner.class) || (s.getName() == "N/A")));
        //List<Aircraft> result = vault.query(SpecificationList.specificTypeOnly2(new Helicopter()));
        
        //List<Aircraft> result = vault.query(SpecificationList.planesOnly());
        //result = vault.query((s) -> true);
        
        //List<Aircraft> result = vault.query(SpecificationList.specificTypeOnly(HeavierThanAirAircraft.class));
        List<Aircraft> result = vault.query(SpecificationList.usesSpecificFuel(Fuel.Type.BIOFUEL));
        
        result = vault.query((s) -> Plane.class.isAssignableFrom(s.getClass()));
        result = vault.query(SpecificationList.specificTypeOnly(AircraftType.Plane));
        
        for(Aircraft ac : result)
        {
            //System.out.println( ((HeavierThanAirAircraft) ac).getFuelType());
            System.out.println(ac);
            //System.out.println(ac.);
        }
        
        System.out.println(new PassengerAirliner(p2));
        

    }

}
