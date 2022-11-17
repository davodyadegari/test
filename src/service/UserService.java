package service;

import Exeptions.AgeException;
import Exeptions.InvalidInputException;
import database.Database;
import model.Account;
import model.User;
import util.MyMethod;

import java.time.LocalDate;
import java.util.Optional;

public class UserService {

    private Database database = Database.getInstance();

    public User createUser(String fName, String lName, String nationalCode, LocalDate bDay) {
        final User[] user = {null};

        if (findAccountByNationalCode(nationalCode).isPresent()){
            throw new InvalidInputException("User already exist.");
        }

        if (bDay.getYear() < 18)
            throw new AgeException();
        user[0] = new User(fName, lName, nationalCode, bDay);
        MyMethod.print(user[0]);
        return user[0];
    }

    public Optional<User> findAccountByNationalCode(String nationalCode) {
        for (Account account : database.getAccountList()) {
            if (account.getUser().getNationalCode().equals(nationalCode))
                return Optional.of(account.getUser());
        }
        return Optional.empty();
    }
}
