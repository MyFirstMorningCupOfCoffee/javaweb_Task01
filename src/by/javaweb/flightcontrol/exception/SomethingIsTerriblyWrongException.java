package by.javaweb.flightcontrol.exception;

public class SomethingIsTerriblyWrongException extends RuntimeException
{

    public SomethingIsTerriblyWrongException()
    {
    }

    public SomethingIsTerriblyWrongException(String msg)
    {
        super(msg);
    }
}
