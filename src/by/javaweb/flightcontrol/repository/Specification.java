package by.javaweb.flightcontrol.repository;

import by.javaweb.flightcontrol.entity.aircraft.Aircraft;

public interface Specification 
{
    boolean specify(Aircraft element);
            
}
