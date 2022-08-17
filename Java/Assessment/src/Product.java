public class Product {

    private int code;
    private String name;
    private String description;
    private String manufacturer;
    private double price;

    public Product(int code, String name, String description, String manufacturer, double price) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public String information(){
        return "Code : "+code+"\nName : "+name+"\nDescription : "+ description +"\nManufacturer : " + manufacturer +"\nPrice : " + price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
