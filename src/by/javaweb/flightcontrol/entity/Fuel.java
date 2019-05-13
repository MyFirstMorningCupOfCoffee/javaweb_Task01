package by.javaweb.flightcontrol.entity;

//import org.apache.log4j.Logger;

public class Fuel 
{
    private Fuel()
    {
        // not allowed
    }
    
    public enum Type 
    { 
        AVIATION_TURBINE_FUEL, 
        AVIATION_SPIRIT, 
        BIOFUEL, 
        LIQUIFIED_NATURAL_GAS, 
        COMPRESSED_NATURAL_GAS,
        NOT_DEFINED
    }
    
    //private static final Logger LOGGER;

    static
    {
        //LOGGER = Logger.getLogger("Engine");
    }
    
    // Used to estimate fuel weigh tanked in aircraft
    public static double getFuelWeight(Type type, double litre)
    {
        double density = 0;
        switch(type)
        {
            case AVIATION_TURBINE_FUEL:
            {
                density = 0.81;
                break;
            }
            case AVIATION_SPIRIT:
            {
                density = 0.72;
                break;
            }
            case BIOFUEL:
            {
                density = 0.92;
                break;
            }
            case LIQUIFIED_NATURAL_GAS:
            {
                density = 0.46;
                break;
            }
            case COMPRESSED_NATURAL_GAS:
            {
                density = 0.18;
                break;
            }      
        }
        
        return litre * density;
    }
    
    // Parsing type of Fuel from given source String
    // If something goes wrong, NOT_DEFINED type will be returned
    public static Fuel.Type parseType(String source)
    {
        Fuel.Type responce = Type.NOT_DEFINED;
        
        try
        {
            responce = Fuel.Type.valueOf(source);
        }
        catch(IllegalArgumentException ex)
        {
            //LOGGER.error("Can't parse fuel type (" + source + ")", ex);
        }
        
        return responce;
    }

}
