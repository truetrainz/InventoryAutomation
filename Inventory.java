package Main;

public class Inventory {

    private int id;
    private String description;
    private int amount;
    private String name;
    private boolean idSet;

    public Inventory(int id, String description, int amount, String name) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.name = name;
        this.idSet = false;
    }

    public Inventory(String description, int amount, String name) {
        this.description = description;
        this.amount = amount;
        this.idSet = false;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public boolean getIdSet() {
        return idSet;
    }

    public void setIdSet(boolean idSet) {
        this.idSet = idSet;
    }
}
