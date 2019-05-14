package by.javaweb.flightcontrol.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
        
public class PropertyFileReader 
{
    public static final String PROPERTY_FILE_PATH = "settings.properties";
    
    public static List<String> readAppSettings()
    {
        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(PROPERTY_FILE_PATH))) 
        {
                list = stream.collect(Collectors.toList());
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            System.err.println("Failed to read settings file");
            // LOG exception
            // Runtime exception?
        }

        return list;
    }
    
    public static String readProperty(String property)
    {
        String responce = "";
        
        List<String> props = readAppSettings();
        property = property.toUpperCase();
        
        for(String line : props)
        {
            line = line.toUpperCase();
            if(line.startsWith(property))
            {
                Pattern pat = Pattern.compile("[\\w][ ]{0,}=[ ]{0,}(.+)");
                Matcher mat = pat.matcher(line);
                if(mat.find())
                {
                    responce = mat.group(1);
                    break;
                }
            }
        }
        
        return responce;
    }
}
