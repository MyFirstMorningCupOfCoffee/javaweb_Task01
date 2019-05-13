package by.javaweb.flightcontrol.creation;

import by.javaweb.flightcontrol.entity.aircraft.*;
import by.javaweb.flightcontrol.entity.*;


// Step by stem init aircrafts fields with values taken from 
// aircrafts default parameters database
public class AircraftStepByStepCreator 
{
    public static PassengerAirliner createPassengerAirliner(String model)
    {
        PassengerAirliner aircraft = new PassengerAirliner();
        initAircraftPart(model, aircraft);
        initHeavierThanAirAircraftPart(model, aircraft);
        initPlanePart(model, aircraft);
        initPassengerAirlinerPart(model, aircraft);

        return aircraft;
    }
    
    public static CargoAirliner createCargoAirliner(String model)
    {
        CargoAirliner aircraft = new CargoAirliner();
        initAircraftPart(model, aircraft);
        initHeavierThanAirAircraftPart(model, aircraft);
        initPlanePart(model, aircraft);
        initCargoAirlinerPart(model, aircraft);

        return aircraft;
    }
    
    public static Helicopter createHelicopter(String model)
    {
        Helicopter aircraft = new Helicopter();
        initAircraftPart(model, aircraft);
        initHeavierThanAirAircraftPart(model, aircraft);
        initHelicopterPart(model, aircraft);

        return aircraft;
    }
    
    private static void initAircraftPart(String model, Aircraft aircraft)
    {
        aircraft.setModel(model);
        
        String param;
        
        param = AircraftDefaultParametersReader.getValue(model, "baseweight");
        aircraft.setBaseWeight(parseDouble(param));

        param = AircraftDefaultParametersReader.getValue(model, "payload");
        aircraft.setPayload(parseDouble(param));
        
    }
    
    private static void initHeavierThanAirAircraftPart(String model, HeavierThanAirAircraft aircraft)
    {
        String param;
        
        //// start of work on engines init ////
        int enginesQuantity;
        Engine.Type enginesType;
        
        param = AircraftDefaultParametersReader.getValue(model, "engines", "quantity");
        enginesQuantity = parseInt(param);

        param = AircraftDefaultParametersReader.getValue(model, "engines", "type");
        enginesType = Engine.parseType(param);

        aircraft.setEnginesQuantity(enginesQuantity);
        aircraft.setEngineType(enginesType);
        //// end of work on engines init ////
        
        //// start of work on fuel ////
        Fuel.Type fuelType;
        double fuelCapacity;
        
        param = AircraftDefaultParametersReader.getValue(model, "fuel", "type");
        fuelType = Fuel.parseType(param);

        param = AircraftDefaultParametersReader.getValue(model, "fuel", "capacity");
        fuelCapacity = parseDouble(param);


        aircraft.setFuelCapacity(fuelCapacity);
        aircraft.setFuelType(fuelType);
        //// end of work on fuel ////
        
        param = AircraftDefaultParametersReader.getValue(model, "range");
        aircraft.setMaxRange(parseInt(param));
        
    }
    
    private static void initPlanePart(String model, Plane aircraft)
    {
        String param;
        
        param = AircraftDefaultParametersReader.getValue(model, "runway_length");
        aircraft.setRunwayLength(parseInt(param));

    }
    
    private static void initPassengerAirlinerPart(String model, PassengerAirliner aircraft)
    {
        String param;
        
        param = AircraftDefaultParametersReader.getValue(model, "seats");
        aircraft.setSeats(parseInt(param));

    }
    
    private static void initCargoAirlinerPart(String model, CargoAirliner aircraft)
    {
        String param;
        
        param = AircraftDefaultParametersReader.getValue(model, "loading_gates", "width");
        aircraft.setLoadingGateWidthMeters(parseDouble(param) );

        
        param = AircraftDefaultParametersReader.getValue(model, "loading_gates", "heigtht");
        aircraft.setLoadingGateHeightMeters(parseDouble(param));

    }
    
    private static void initHelicopterPart(String model, Helicopter aircraft)
    {
        String param;
        
        param = AircraftDefaultParametersReader.getValue(model, "seats");
        aircraft.setSeats(parseInt(param));
        
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
    
    // Parse boolean value from String source
    // If source is empty ( == "") returns false
    private static boolean parseBoolean(String source)
    {
        boolean responce = false;
        if(source.length() != 0)
        {
            responce = Boolean.parseBoolean(source);
        }
        
        return responce;
    }
    
    
}
