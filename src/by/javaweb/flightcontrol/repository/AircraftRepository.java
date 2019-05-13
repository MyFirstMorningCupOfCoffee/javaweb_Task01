package by.javaweb.flightcontrol.repository;

import by.javaweb.flightcontrol.entity.aircraft.Aircraft;

import java.util.List;

public interface AircraftRepository 
{
    public boolean add(Aircraft element);
    public boolean delete(Aircraft element);
    public Aircraft update(Aircraft element);
    public List<Aircraft> query(Specification specification);
}
