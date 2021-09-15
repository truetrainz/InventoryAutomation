package Main;

public class InventoryIn {

    private int id;
    private int barcode;
    private int amount;
    private String name;

    public InventoryIn(int id, int barcode, int amount, String name) {
        this.id = id;
        this.barcode = barcode;
        this.amount = amount;
        this.name = name;
    }

    public InventoryIn() {}

    public InventoryIn(int barcode, int amount, String name) {
        this.barcode = barcode;
        this.amount = amount;
        this.name = name;
    }

    public InventoryIn(int barcode) {
        this.barcode = barcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
