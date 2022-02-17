import java.util.*;
import java.io.*;

public class Warehouse implements Serializable {
    private ClientList clientList;
    private ProductList productList;
    private static Warehouse warehouse;
    
    private Warehouse() {
        clientList = ClientList.instance();
        productList = ProductList.instance();
    }
    
    public static Warehouse instance() {
        if(warehouse == null) {
            return (warehouse = new Warehouse());
        } else
            return warehouse;
    }
    
    public Client addClient(String name, String address, String id) {
        Client client = new Client(name, address, id);
        if (clientList.insertClient(client)){
            return client;
        }
        return null;
    }
    
    public Iterator getClients() {
        return clientList.getClient();
    }
    
    public Product addProduct(String name, String quantity, String id) {
        Product product = new Product(name, quantity, id);
        if (productList.insertProduct(product)){
            return product;
        }
        return null;
    }
    
    public Iterator getProducts() {
        return productList.getProduct();
    }
}