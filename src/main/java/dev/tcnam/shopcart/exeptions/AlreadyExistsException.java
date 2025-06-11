package dev.tcnam.shopcart.exeptions;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String message){
        super(message);
    }
}
