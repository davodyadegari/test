package Exeptions;

import util.MyMethod;

import java.sql.SQLException;

public class ExceptionHandler {
    public static void handleException(Exception exception){
        if (exception instanceof SQLException) {
            SQLException sqlException = (SQLException) exception;

//you can search the error code by googling Dunning mysql error code
            MyMethod.print("Error code:" + sqlException.getErrorCode());

            MyMethod.print("SQL state:" + sqlException.getSQLState());
        }
        MyMethod.print("Exception message:" + exception.getMessage());
        MyMethod.print("Stacktrace:");
        exception.printStackTrace();
        }
    }
