package by.javaweb.flightcontrol.creation;

//import org.apache.log4j.Logger;

import by.javaweb.flightcontrol.utils.FileWorker;
import by.javaweb.flightcontrol.utils.XMLRWorker;
import java.util.List;


// Emulates work with properly built database
public class AircraftDefaultParametersReader 
{
    private static final String XMLR_DATABASE_FILEPATH = "D:\\Users\\Александр\\Desktop\\aircrafts_default_params.xmlr";
    //private static final Logger LOGGER;

    
    static
    {
        //LOGGER = Logger.getLogger("AircraftsDatabaseWorker");
    }
    
    private AircraftDefaultParametersReader()
    {
        // not allowed
    }
    
    // Used to prepare aircrafts xmlr file parts
    // Storage<String> holds String xmlr pieces, 1 for each aircraft
    private static List<String> getElements()
    {
        
        String source = FileWorker.readFile(XMLR_DATABASE_FILEPATH);
        List<String> elements = XMLRWorker.collectItems(source, "aircraft");
        
        return elements;
    }

    // Used to init aircraft fields with values taken from default params database
    // Returns piece of xmlr file with data for chosen model
    private static String getElementContent(String searchValue, String ... searchPath)
    {
        List<String> elements = getElements();
        
        String content = XMLRWorker.search(elements, searchValue, searchPath);

        return content;
    }
    
    // Used to read proper field value (using 1 or more Strings to set field)
    // for chosen by model aircraft
    public static String getValue(String model, String ... chainPath)
    {
        String elementContent = getElementContent(model, "model");
        String value = XMLRWorker.getContent(elementContent, chainPath);
        
        if(value.length() == 0)
        {
            StringBuilder message = new StringBuilder();
            message.append("Failed to get data for model ").append(model);
            message.append(", property ");
            for(int i = 0; i < chainPath.length; i++)
            {
                message.append(chainPath[i]).append(" ");
            }
            
            //LOGGER.warn(message.toString());
        }
        return value;
    }
}
