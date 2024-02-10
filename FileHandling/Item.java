import java.io.Serializable;
class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    int Id;
    String name;
    int stockQty;
    double costPerUnit;
    
    public Item(int Id, String name, int stockQty, double costPerUnit) {
        this.Id = Id;
        this.name = name;
        this.stockQty = stockQty;
        this.costPerUnit = costPerUnit;
    }


    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public int getStockQty() {
        return stockQty;
    }

    public double getCostPerUnit() {
        return costPerUnit;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    public void setCostPerUnit(double costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public String toString() {
        return "Id: " + Id + "\nName: " + name + "\nStock Quantity: " + stockQty + "\nCost Per Unit: " + costPerUnit;
    }

}
