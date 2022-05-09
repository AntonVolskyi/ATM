package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BankDBReader extends ConnectionToBankDB {

    public ArrayList<String> getCardNumbers() {
        String query = "SELECT clients.card_number FROM clients";
        ArrayList<String> result = new ArrayList<>();

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result.add(resultSet.getString("card_number"));
            }
        } catch (SQLException e) {
            System.err.println("Connection to DB failed!");
            System.err.println(e.getMessage());
        }
        return result;
    }

    public boolean isCorrectPassword(String cardNumber, String password) {
        String query = "SELECT clients.pin FROM clients WHERE clients.card_number = \'" + cardNumber + "\'";
        boolean result = false;

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getString("pin").equals(password)) {
                    result = true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Connection to DB failed!");
            System.err.println(e.getMessage());
        }
        return result;
    }

    public String getCardBalance(String cardNumber) {
        String query = "SELECT card_balance.balance FROM card_balance WHERE card_balance.card_number = \'" + cardNumber + "\'";
        String result = "0";

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result = resultSet.getString("balance");
            }
        } catch (SQLException e) {
            System.err.println("Connection to DB failed!");
            System.err.println(e.getMessage());
        }
        return result;
    }

    public String getCardSaveBalance(String cardNumber) {
        String query = "SELECT card_balance.saving_balance FROM card_balance WHERE card_balance.card_number = \'" + cardNumber + "\'";
        String result = "0";

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result = resultSet.getString("saving_balance");
            }
        } catch (SQLException e) {
            System.err.println("Connection to DB failed!");
            System.err.println(e.getMessage());
        }
        return result;
    }

    public boolean isCardExist(String cardNumber) {
        boolean result = false;
        String query = "SELECT COUNT(*) FROM clients WHERE card_number = \'" + cardNumber + "\'";

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int count = resultSet.getInt("count");
                result = count > 0;
            }
        } catch (SQLException e) {
            System.err.println("Connection to DB failed!");
            System.err.println(e.getMessage());
        }
        return result;
    }
}
