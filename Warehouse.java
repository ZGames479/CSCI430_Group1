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
        Client client = new Client(name, address, id);
        if (clientList.insertClient(client)){
            return client;
        }
        return null;
    }
    
    public Client getClients() {
        clientList.getClient();
    }
    
    public Product addProduct(String name, String address, String id) {
        Client product = new Client(name, address, id);
        if (productList.insertProduct(product)){
            return product;
        }
        return null;
    }
    
    public Product getProducts() {
        productList.getProduct();
    }
}