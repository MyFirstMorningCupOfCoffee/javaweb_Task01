package by.javaweb.flightcontrol.repository;

import by.javaweb.flightcontrol.entity.aircraft.Aircraft;
import by.javaweb.flightcontrol.exception.SomethingIsTerriblyWrongException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
//import javax.lang.model.element.Element;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;

// implements Repository pattern
public class Vault implements AircraftRepository
{
    List<Aircraft> storage;
    
    {
        storage = new ArrayList<>();
    }

    @Override
    public boolean add(Aircraft element)
    {
//        for(int i = 0; i < storage.size(); i++)
//        {
//            if(storage.get(i).getNumber().equalsIgnoreCase(element.getNumber()))
//            {
//                return false;
//            }
//        }
        String elemNumber = element.getNumber().toUpperCase();
        Iterator<Aircraft> iterator = storage.iterator();
        while(iterator.hasNext())
        {
            String dtbNumber = iterator.next().getNumber().toUpperCase();
            if(dtbNumber.equals(elemNumber))
            {
                return false;
            }
        }
        
        return storage.add(makeCopy(element));
    }
    
    public boolean[] addAll(Aircraft ... elements)
    {
        boolean[] responce = new boolean[elements.length];
        
        for(int i = 0; i < elements.length; i++)
        {
            responce[i] = add(elements[i]);
        }
        
        return responce;
    }
    
    public boolean[] addAll(Collection<Aircraft> elements)
    {
        boolean[] responce = new boolean[elements.size()];
        Aircraft[] elementsAsArray = elements.toArray(new Aircraft[0]);
        
        for(int i = 0; i < elementsAsArray.length; i++)
        {
            responce[i] = add(elementsAsArray[i]);
        }
        
        return responce;
    }

    @Override
    public boolean delete(Aircraft element)
    {
        return storage.remove(element);
    }
    
    public boolean delete(String number)
    {
        for(int i = 0; i < storage.size(); i++)
        {
            if(storage.get(i).getNumber().equalsIgnoreCase(number))
            {
                storage.remove(i);
                return true;
            }
        }
        
        return false;
    }
    
    public void deleteAll()
    {
        storage.clear();
    }

    @Override
    public Aircraft update(Aircraft element)
    {
        String elemNumber = element.getNumber().toUpperCase();
//        String number = element.getNumber();
//        for(int i = 0; i < storage.size(); i++)
//        {
//            if(storage.get(i).getNumber().equalsIgnoreCase(number))
//            {
//                
//                storage.set(i, makeCopy(element));
//                break;
//            }
//        }
        Iterator<Aircraft> iterator = storage.iterator();
        int counter = 0;
        while(iterator.hasNext())
        {
            String dtbNumber = iterator.next().getNumber().toUpperCase();
            if(elemNumber.equals(dtbNumber))
            {
                storage.set(counter, makeCopy(element));                break;
            }
            counter++;
        }
//        for(int i = 0; i < storage.size(); i++)
//        {
//            if(storage.get(i).getNumber().equalsIgnoreCase(number))
//            {
//                
//                storage.set(i, makeCopy(element));
//                break;
//            }
//        }
        
        return element;
    }
    
    public Aircraft[] updateAll(Aircraft ... elements)
    {
        Aircraft[] responce = new Aircraft[elements.length];
        
        elems: for(int i = 0; i < elements.length; i++)
        {
            for(int j = 0; j < storage.size(); j++)
            {
                if(elements[i].getNumber().equalsIgnoreCase(storage.get(j).getNumber()))
                {
                    responce[i] = storage.set(j, makeCopy(elements[i]));
                    continue elems;
                }
            }
        }
        
        return responce;
    }
    
//    public Aircraft update(String id, Aircraft element)
//    {
//        for(int i = 0; i < storage.size(); i++)
//        {
//            if(storage.get(i).getNumber().equalsIgnoreCase(id))
//            {
//                storage.set(i, element);
//                break;
//            }
//        }
//        
//        return element;
//    }

    
//    public List<Aircraft> query(Predicate<Aircraft> specification)
//    {
//        List<Aircraft> responce = 
//            storage.stream()
//                   .filter(specification)
//                   .collect(Collectors.toList());
//        
//        return responce;
//    }
    
    @Override
    public List<Aircraft> query(Specification specification)
    {
        List<Aircraft> responce = new ArrayList<>();
        
        for(Aircraft item : storage)
        {
            if(specification.specify(item))
            {
                responce.add(item);
            }
        }
        
        return responce;
    }
    
    public List<Aircraft> multipleSpecificationsQuery(Specification ... specifications)
    {
        List<Aircraft> responce = new ArrayList<>();
        
        nextElem: for(Aircraft flyer : storage)
        {
           for(Specification spec : specifications)
           {
               if(!spec.specify(flyer))
               {
                   continue nextElem;
               }
           }
           responce.add(flyer);
        }
        
        return responce;
    }
    
    public int size()
    {
        return storage.size();
    }
    
    public static Aircraft makeCopy(Aircraft element)
    {
        Aircraft responce = null;
        
        try
        {
            Class<?> clazz = Class.forName(element.getClass().getName());
            Constructor<?> constructor = clazz.getConstructor(element.getClass());
            responce = (Aircraft) constructor.newInstance(element);

        }
        catch(ReflectiveOperationException ex)
        {
            // log
            ex.printStackTrace();
            throw new SomethingIsTerriblyWrongException("Error during adding element to database "
                                                            + " which actually cannot happen "
                                                            + " in this implementation.");
        }
        
        return responce;
    }
    
}
