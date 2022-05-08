package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BankDBWrighter extends ConnectionToBankDB {

    public void ChangeBalance(String cardNumber, int takenMoney) {
        String query = "UPDATE card_balance SET balance = balance - " + takenMoney
                + " WHERE card_balance.card_number = \'" + cardNumber + "\'";

        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println("Connection to DB failed!");
            System.err.println(e.getMessage());
        }
    }
}
