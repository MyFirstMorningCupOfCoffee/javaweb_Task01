package by.javaweb.flightcontrol.creation;

import java.util.List;
import by.javaweb.flightcontrol.entity.*;
import by.javaweb.flightcontrol.utils.FileWorker;
import by.javaweb.flightcontrol.utils.PropertyFileReader;
import by.javaweb.flightcontrol.utils.XMLRWorker;
import java.util.ArrayList;



// Emulates work with properly built database
public class AirportsDatabaseWorker 
{
    private static final String XMLR_DATABASE_FILEPATH;
    

//private static final Logger LOGGER;
    
    private AirportsDatabaseWorker()
    {
        // not allowed
    }
    
    private static List<Airport> airports;
   
    static
    {
        //LOGGER = Logger.getLogger("AirportsDatabaseWorker");
        XMLR_DATABASE_FILEPATH = 
            PropertyFileReader.readProperty("XMLR_AIRPORTS_DATABASE_FILEPATH");
        initObjects();
        
    }
    
    // Tries to get proper airport by name from airports list
    // Ruturns null (I know, there should be exception, but we didn't learn em)
    // if search is failed
    public static Airport getAirportByName(String name)
    {
        Airport responce = null;
        
        for(int i = 0; i < airports.size(); i++)
        {
            if(airports.get(i).getName().equals(name))
            {
                responce = airports.get(i);
                break;
            }
        }
        
        //LOGGER.info("Requested Airport object, by name = " + name);
        //LOGGER.info(responce + " gotten as responce");
        
        return responce;
    }
    
    // Tries to get proper airport by id from airports list
    // Ruturns null (I know, there should be exception, but we didn't learn em)
    // if search is failed
    public static Airport getAirportById(String id)
    {
        Airport responce = null;
        
        if(airports == null)
        {
            initObjects();
        }
        
        for(int i = 0; i < airports.size(); i++)
        {
            if(airports.get(i).getId().equals(id))
            {
                responce = airports.get(i);
                break;
            }
        }
        
        //LOGGER.info("Requested Airport object, by id = " + id);
        //LOGGER.info(responce + " gotten as responce");
        
        return responce;
    }
    
    public static List<Airport> getAirportList()
    {
        return airports;
    }
    
    // Used to init airports list from file database
    // Storage<String> holds String xmlr pieces, 1 for each airport
    private static List<String> getElements()
    {
        String source = FileWorker.readFile(XMLR_DATABASE_FILEPATH);
        List<String> elements = XMLRWorker.collectItems(source, "airport");
        
        return elements;
    }

    // Used to init airports list, parsing elements via XMLRWorker 
    private static void initObjects()
    {
        airports = new ArrayList<>();
        
        List<String> elements = getElements();
        
        for(int i = 0; i < elements.size(); i++)
        {
            String element = elements.get(i);
            
            Airport airport = new Airport();
            airport.setName(XMLRWorker.getContent(element, "name"));
            airport.setId(XMLRWorker.getContent(element, "id"));
            
            Location location = new Location();
            location.setLatitude(
                    parseDouble(
                    XMLRWorker.getContent(element, "location", "latitude")));
            location.setLongitude(
                    parseDouble(
                    XMLRWorker.getContent(element, "location", "longitude")));
            airport.setLocation(location);
            
            
            airport.setRunwayLength(
                    parseInt(
                    XMLRWorker.getContent(element, "runway_length")));


            airports.add(airport);
            
            
        }
        
        //LOGGER.info("initializing airports list");
    }
    
    // Updates airports list if requested
    public void readList()
    {
        initObjects();
    }
    
    
    // Parse double value from String source
    // If source is empty ( == "") returns 0
    private static double parseDouble(String source)
    {
        double responce = 0;
        if(source.length() != 0)
        {
            responce = Double.parseDouble(source);
        }
        
        return responce;
    }
    
    // Parse int value from String source
    // If source is empty ( == "") returns 0
    private static int parseInt(String source)
    {
        int responce = 0;
        if(source.length() != 0)
        {
            responce = Integer.parseInt(source);
        }
        
        return responce;
    }
}
