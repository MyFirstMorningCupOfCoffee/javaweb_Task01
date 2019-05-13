package by.javaweb.flightcontrol.entity;

//import org.apache.log4j.Logger;

public class Engine 
{
    
    public static enum Type 
    { 
        JET, 
        TURBOPROP, 
        NOT_DEFINED 
    };

    //private static final Logger LOGGER;

    static
    {
        //LOGGER = Logger.getLogger("Engine");
    }
    
    
    private Engine()
    {
        // not allowed
    }
    
    // Parsing type of engine from given source String
    // If something goes wrong, NOT_DEFINED type will be returned
    public static Engine.Type parseType(String source)
    {
        Engine.Type responce = Type.NOT_DEFINED;
        
        try
        {
            responce = Engine.Type.valueOf(source);
        }
        catch(IllegalArgumentException ex)
        {
            //LOGGER.error("Can't parse engine type (" + source + ")", ex);
        }
        
        return responce;
    }

}
