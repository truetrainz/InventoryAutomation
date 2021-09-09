package Main;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class InventoryInDatabaseDriver {
    public InventoryInDatabaseDriver() {}

    public void addInventoryIn(InventoryIn inventoryIn) {
        String sql = "INSERT INTO inventory_in(id, barcode, amount, name) VALUES (nextval(inventory_in_sequence), "
            + inventoryIn.getBarcode() + ", " + inventoryIn.getAmount() + ", '" + inventoryIn.getName() + "')";
        try {
            Connection connection = DriverManager.getConnection(Database.getUrl());
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public InventoryIn getInventoryIn(int idIn) {
        String sql = "SELECT * FROM inventory_in WHERE id = " + idIn + ";";
        try {
            Connection connection = DriverManager.getConnection(Database.getUrl());
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ArrayList<InventoryIn> list = new ArrayList<InventoryIn>();
            while (rs.next()) {
                int id = rs.getInt("id");
                int barcode = rs.getInt("barcode");
                int amount = rs.getInt("amount");
                String name = rs.getString("name");
                list.add(new InventoryIn(id, barcode, amount, name));
            }
            if (list.size() != 0) {
                return list.get(0);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public InventoryIn getInventoryIn(int barcodeIn, boolean check) {
        String sql = "SELECT * FROM inventory_in WHERE barcode = " + barcodeIn + ";";
        try {
            Connection connection = DriverManager.getConnection(Database.getUrl());
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ArrayList<InventoryIn> list = new ArrayList<InventoryIn>();
            while (rs.next()) {
                int id = rs.getInt("id");
                int barcode = rs.getInt("barcode");
                int amount = rs.getInt("amount");
                String name = rs.getString("name");
                list.add(new InventoryIn(id, barcode, amount, name));
            }
            if (list.size() != 0) {
                return list.get(0);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public InventoryIn getInventoryIn(String nameIn) {
        String sql = "SELECT * FROM inventory_in WHERE name = '" + nameIn + "';";
        try {
            Connection connection = DriverManager.getConnection(Database.getUrl());
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ArrayList<InventoryIn> list = new ArrayList<InventoryIn>();
            while (rs.next()) {
                int id = rs.getInt("id");
                int barcode = rs.getInt("barcode");
                int amount = rs.getInt("amount");
                String name = rs.getString("name");
                list.add(new InventoryIn(id, barcode, amount, name));
            }
            if (list.size() != 0) {
                return list.get(0);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateBarcode(int idIn, int barcodeIn) {
        String sql = "UPDATE inventory_in SET barcode = " + barcodeIn + " WHERE id = " + idIn + ";";
        try {
            Connection connection = DriverManager.getConnection(Database.getUrl());
            Statement statement = connection.createStatement();
            int count = statement.executeUpdate(sql);
            if (count != 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAmount (int idIn, int amountIn) {
        String sql = "UPDATE inventory_in SET amount = " + amountIn + " WHERE id = " + idIn + ";";
        try {
            Connection connection = DriverManager.getConnection(Database.getUrl());
            Statement statement = connection.createStatement();
            int count = statement.executeUpdate(sql);
            if (count != 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateName (int idIn, String nameIn) {
        String sql = "UPDATE inventory_in SET name = '" + nameIn + "' WHERE id = " + idIn + ";";
        try {
            Connection connection = DriverManager.getConnection(Database.getUrl());
            Statement statement = connection.createStatement();
            int count = statement.executeUpdate(sql);
            if (count != 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
