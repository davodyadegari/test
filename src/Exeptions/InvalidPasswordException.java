package Exeptions;

public class InvalidPasswordException extends RuntimeException{
    public static final String Message = "Wrong Password!";
    public InvalidPasswordException() {
        super(Message);
    }
}
