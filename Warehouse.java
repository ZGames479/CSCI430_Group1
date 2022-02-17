import java.util.*;
import java.io.*;

public class Warehouse implements Serializable {
    private ClientList clientList;
    private ProductList productList;
    private Warehouse warehouse;
    
    private Warehouse() {
        clientList = ClientList.instance();
        productList = ProductList.instance();
    }
    
    public static Warehouse instance() {
        if(warehouse == null) {
            return (warehouse = new Warehouse())
        } else
            return warehouse;
    }
    
    public Client addClient(String name, String address, String id) {
        
    }
    
    public Client getClients() {
        
    }
    
    public Product addProduct(String name, String address, String id) {
        
    }
    
    public Product getProducts() {
        
    }
}