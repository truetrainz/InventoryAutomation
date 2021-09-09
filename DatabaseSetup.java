package Main;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseSetup {

    public DatabaseSetup() {}

    public void createInTable() {
        String sql = "CREATE TABLE IF NOT EXISTS inventory_in (id bigint PRIMARY KEY, barcode int, amount int, name varchar(180))";
        try {
            Connection connection = DriverManager.getConnection(Database.getUrl());
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            System.out.println("DatabaseSetup -> createInTable()");
            e.printStackTrace();
        }
    }

    public void createInventoryTable() {
        String sql = "CREATE TABLE IF NOT EXISTS inventory(id bigint PRIMARY KEY, amount int, description TEXT, name varchar(180))";
        try {
            Connection connection = DriverManager.getConnection(Database.getUrl());
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            System.out.println("DatabaseSetup -> createInventoryTable()");
            e.printStackTrace();
        }
    }

    public void createInTableSequence() {
        String sql = "CREATE SEQUENCE IF NOT EXISTS inventory_in_sequence INCREMENT BY 1 MINVALUE 0 MAXVALUE 9223372036854775806 START 1";
        try {
            Connection connection = DriverManager.getConnection(Database.getUrl());
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            System.out.println("DatabaseSetup -> createInTableSequence()");
            e.printStackTrace();
        }
    }

    public void createInventoryTableSequence() {
        String sql = "CREATE SEQUENCE IF NOT EXISTS inventory_sequence INCREMENT BY 1 MINVALUE 0 MAXVALUE 9223372036854775806 START 1";
        try {
            Connection connection = DriverManager.getConnection(Database.getUrl());
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("DatabaseSetup -> createInventoryTableSequence()");
            e.printStackTrace();
        }
    }
}
