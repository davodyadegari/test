package dao;

import model.Account;
import model.Card;

import java.sql.SQLException;
import java.util.List;

public interface Dao {
    public Card getCard(String cardNumber) throws SQLException;
    public List<Account> getAccountList() throws SQLException;


    }