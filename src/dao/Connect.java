package dao;

import model.Account;
import model.Card;
import model.User;
import model.enums.AccountType;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Connect implements Dao {
    Connection connection;

    {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres"
                    ,"postgrs","2523249");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Card getCard(String cardNumber) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from cards where card_number=?");
        preparedStatement.setString(1,cardNumber);
        ResultSet resultSet=preparedStatement.executeQuery();
        ArrayList<Card>cards=new ArrayList<>();
        while (resultSet.next()){
            Card card=new Card(resultSet.getString("password"),
                    resultSet.getString("cvv2"),resultSet.getDate(
                    "expired_date"),resultSet.getString("cardNumber"));



        }
        return cards.get(1);

    }
    public List<Account> getAccountList() {
        ResultSet resultSet = null;
        List<Account>accounts=new ArrayList<>();
        try {
            resultSet = connection.prepareStatement("select * from accounts a inner join users u on a.user_id=u.id").executeQuery();

            while (resultSet.next()){
                Account account=new Account(new User(resultSet.getString("name"),resultSet.getString("family"),
                        resultSet.getString("national_code"), resultSet.getDate("birthday").toLocalDate() ),
                        resultSet.getString("password"),AccountType.valueOf( resultSet.getString("account_type")));
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        ResultSet resultSet=connection.prepareStatement("select * from accounts").executeQuery();

        return accounts;
    }

    }
