package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class InventoryDatabaseDriver {
    public InventoryDatabaseDriver() {}

    public static void addInventory(Inventory inventory) {
        String sql = "INSERT INTO inventory(id, amount, description, name, barcode) VALUES ((select nextval('inventory_sequence')), "
           + inventory.getAmount() + ", '" + inventory.getDescription() + "', '" + inventory.getName() +
           "', " + inventory.getBarcode() + ")";
        try {
            Connection connection = DriverManager.getConnection(Database.getUrl());
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Inventory getInventoryFromId(int idIn) {
        String sql = "SELECT * FROM inventory WHERE id = " + idIn + ";";
        try {
            Connection connection = DriverManager.getConnection(Database.getUrl());
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            statement.close();
            ArrayList<Inventory> inventoryArray = new ArrayList<Inventory>();
            while (rs.next()) {
                int id = rs.getInt("id");
                int amount = rs.getInt("amount");
                String description = rs.getString("description");
                String name = rs.getString("name");
                int barcode = rs.getInt("barcode");
                inventoryArray.add(new Inventory(id, description, amount, name, barcode));
            }
            if (inventoryArray.size() == 1) {
                return inventoryArray.get(0);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Inventory getInventoryFromName(String nameIn) {
        String sql = "SELECT * FROM inventory WHERE name = '" + nameIn + "';";
        try {
            Connection connection = DriverManager.getConnection(Database.getUrl());
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ArrayList<Inventory> inventoryArray = new ArrayList<Inventory>();
            while (rs.next()) {
                int id = rs.getInt("id");
                int amount = rs.getInt("amount");
                String description = rs.getString("description");
                String name = rs.getString("name");
                int barcode = rs.getInt("barcode");
                inventoryArray.add(new Inventory(id, description, amount, name, barcode));
            }
            if (inventoryArray.size() == 1) {
                return inventoryArray.get(0);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<String> getNames() {
        String sql = "SELECT name FROM inventory;";
        try {
            Connection connection = DriverManager.getConnection(Database.getUrl());
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ArrayList<String> inventoryNames = new ArrayList<String>();
            while (rs.next()) {
                String name = rs.getString("name");
                inventoryNames.add(name);
            }
            return inventoryNames;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean updateAmount(int amountIn, int idIn) {
        String sql = "UPDATE inventory SET amount = " + amountIn + " WHERE id = " +  idIn + ";";
        try {
            Connection connection = DriverManager.getConnection(Database.getUrl());
            Statement statement = connection.createStatement();
            int test = statement.executeUpdate(sql);
            if (test != 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateDescription(String descriptionIn, int idIn) {
        String sql = "UPDATE inventory SET description = '" + descriptionIn + "' WHERE id = " + idIn + ";";
        try {
            Connection connection = DriverManager.getConnection(Database.getUrl());
            Statement statement = connection.createStatement();
            int test = statement.executeUpdate(sql);
            if (test != 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateName(String name, int idIn) {
        String sql = "UPDATE inventory SET name = '" + name + "' WHERE id = " + idIn + ";";
        try {
            Connection connection = DriverManager.getConnection(Database.getUrl());
            Statement statement = connection.createStatement();
            int test = statement.executeUpdate(sql);
            if (test != 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateBarcode(int barcode, int id) {
        String sql = "UPDATE inventory SET barcode = " + barcode + " WHERE id = " + id + ";";
        try {
            Connection connection = DriverManager.getConnection(Database.getUrl());
            Statement statement = connection.createStatement();
            int test = statement.executeUpdate(sql);
            if (test != 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void removeRow(int id) {
        String sql = "DELETE FROM inventory WHERE id = " + id + ";";
        try {
            Connection connection = DriverManager.getConnection(Database.getUrl());
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
