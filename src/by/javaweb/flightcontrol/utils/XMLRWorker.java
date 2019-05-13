package by.javaweb.flightcontrol.utils;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class XMLRWorker 
{
    // Used to compare given value with the value found by given parameters
    // Returns true if values are equal and false if not
    public static boolean fits(String source, String value, String ... propertyChain)
    {
        String factValue = getContent(source, propertyChain);
        
        return factValue.equals(value);
    }
    
    // Used to search inside given elements collection, trying to find piece that
    // suits requested parameters. Returns "" if search fails
    public static String search(List<String> elements, String value, String ... propertyChain)
    {
        for(int i = 0; i < elements.size(); i++)
        {
            if(fits(elements.get(i), value, propertyChain))
            {
                return elements.get(i);
            }
        }
        
        return "";
    }
    
    
    // Return value of a field set by propertyChain Strings from source String
    public static String getContent(String source, String ... propertyChain)
    {
        String buffer = source;
        
        for(String property : propertyChain)
        {
            String pattern = "<" + property + ">(.+?)</" + property + ">";
            //System.out.println(pattern);
            Pattern pat = Pattern.compile(pattern, Pattern.DOTALL);
            Matcher mat = pat.matcher(buffer);
            if(mat.find())
            {
                buffer = mat.group(1);
            }
            else
            {
                buffer = "";
            }
        }
        
        return buffer;
    }
    
    // Used to split xmlr file into parts each one of which is laid between 
    // itemContainer tags
    public static List<String> collectItems(String source, String itemContainer)
    {
        List<String> responce = new ArrayList<>();
        
        //System.out.println("src: " + source);
        String pattern = "<" + itemContainer + ">(.+?)</" + itemContainer + ">";
        //System.out.println("pattern: " + pattern);
        Pattern pat = Pattern.compile(pattern, Pattern.DOTALL);
        Matcher mat = pat.matcher(source);
        
        while(mat.find())
        {
            responce.add(mat.group(1));
        }
        
        return responce;
    }
}
