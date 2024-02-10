public abstract class Asset {
    private String name;
    private String  SerialNumber;

    public Asset(String name, String SerialNumber) {
        this.name = name;
        this.SerialNumber = SerialNumber;
    }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public void setSerialNumber(String SerialNumber) { this.SerialNumber = SerialNumber; }
    public  String getSerialNumber() { return SerialNumber; }

    public static void main(String [] args){

    }

}
