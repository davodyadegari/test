package service;

import Exeptions.AgeException;
import Exeptions.InvalidInputException;
import dao.Connect;
import dao.Dao;
import database.Database;
import model.Account;
import model.User;
import util.MyMethod;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class UserService {

    Dao dao=new Connect();

    public User createUser(String fName, String lName, String nationalCode, LocalDate bDay) throws SQLException {
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

    public Optional<User> findAccountByNationalCode(String nationalCode) throws SQLException {

        for (Account account :dao.getAccountList()) {
            if (account.getUser().getNationalCode().equals(nationalCode))
                return Optional.of(account.getUser());
        }
        return Optional.empty();
    }
}
