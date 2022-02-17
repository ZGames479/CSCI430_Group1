import java.util.*;
import java.io.*;

public class Warehouse implements Serializable {
    private ClientList clientList;
    private ProductList productList;
    
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
    
    // addClient
    // getClients
    // addProduct
    // getProducts
}