import java.util.*;
import java.io.*;
public class Product implements Serializable {

    private String name;
    private String quantity;
    private String id;

    public  Product (String  name, String quantity, String id) {
        this.name =  name;
        this.quantity =  quantity;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public String getQuantity() {
        return quantity;
    }
    public String getId() {
        return id;
    }

    public String toString() {
        return " name: " + name + " quantity: " + quantity + " id: " + id;
    }
}