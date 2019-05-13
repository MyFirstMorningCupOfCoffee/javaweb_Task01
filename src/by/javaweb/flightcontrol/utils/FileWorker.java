package by.javaweb.flightcontrol.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWorker 
{
    public static List<String> readLines(String filePath)
    {
        List<String> result = new ArrayList<>();
        
        try
        {
            result = Files.readAllLines(Paths.get(filePath));
        }
        catch(IOException ex)
        {
            // log
            // throw RuntimeError?
        }
        
        return result;
    }
    
    public static String readFile(String filePath)
    {
        BufferedReader br = null;
        FileReader fr = null;
        StringBuilder sb = new StringBuilder();

        try 
        {
            fr = new FileReader(filePath);
            br = new BufferedReader(fr);
            String buffer;

            while ((buffer = br.readLine()) != null) 
            {
                sb.append(buffer).append("\n");
            }
        } 
        catch (IOException e) 
        {
            // ignore
        } 
        finally 
        {
            try 
            {
                if (br != null)
                {
                    br.close();
                }
                if (fr != null)
                {
                    fr.close();
                }
            } 
            catch (IOException ex) 
            {
                // ignore
            }
        }
        return sb.toString();
    }
}
