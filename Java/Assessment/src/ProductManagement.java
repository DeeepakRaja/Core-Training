import java.util.ArrayList;
import java.util.List;

public class ProductManagement {
    static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        addProduct(new Product(1, "Football Shoes", "Nike CR7 SuperFly Size 9", "Nike", 5999.00));
        addProduct(new Product(2, "Laptop", "Apple MacBook Pro 14inch", "Apple", 115999.00));
        addProduct(new Product(3, "Helmet", "Vega dot certified size M", "Vega", 1899.00));
        addProduct(new Product(4, "Tablet", "Apple IPad Air", "Apple", 59999.00));
        addProduct(new Product(5, "Mattress", "WakeFit queen size mattress", "WakeFit", 7999.00));
        System.out.println("All Products");
        listProducts();
//        deleteProduct(5);
//        System.out.println("Deleted Products 5");
//        listProducts();
//        updateProduct(new Product(4, "Phone", "Apple IPhone 13 Mini", "Apple", 64999.00));
//        System.out.println("Updated Products 4");
//        listProducts();
        System.out.println("Manufacturer Apple : ");
        findProductByManufacturer("Apple");
        System.out.println("Manufacturer Nike : ");
        findProductByManufacturer("Nike");
    }

    static void addProduct(Product product) {
        products.add(product);
    }

    static void findProductByManufacturer(String manufacturer){
        for (Product p:products){
            if (p.getManufacturer().equalsIgnoreCase(manufacturer)) System.out.println(p.information()+"\n");
        }
    }

    static void updateProduct(Product prodToUpdate) {
        int prodToUpdateIndex = 0;
        for (Product p : products) {
            if (p.getCode() == prodToUpdate.getCode()) break;
            prodToUpdateIndex++;
        }
        if (prodToUpdateIndex <products.size()) products.set(prodToUpdateIndex, prodToUpdate);
    }

    static void deleteProduct(int code) {
        Product prodToRemove = null;
        for (Product p : products) {
            if (p.getCode() == code) {
                prodToRemove = p;break;
            }
        }
        if (prodToRemove != null) products.remove(prodToRemove);
    }

    static void listProducts() {
        for (Product p : products) {
            System.out.println(p.information() + "\n");
        }
    }
}
