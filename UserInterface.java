import java.util.*;
import java.text.*;
import java.io.*;

public class UserInterface {
    private static UserInterface userInterface;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Warehouse warehouse;
    private static final int EXIT = 0;
    private static final int ADD_CLIENT = 1;
    private static final int ADD_PRODUCT = 2;
    private static final int SHOW_CLIENTS = 3;
    private static final int SHOW_PRODUCTS = 4;
    private static final int ADD_WISHLIST = 5;
    private static final int SHOW_WISHLIST = 6;
    private static final int HELP = 15;
    
    private UserInterface() {
        warehouse = Warehouse.instance();
    }
    
    public static UserInterface instance() {
        if (userInterface == null) {
            return userInterface = new UserInterface();
        } else {
            return userInterface;
        }
    }
    
    // get warehouse, print client, print product, add client, add product
    
    public void addClient() {
        Scanner scanner = new Scanner(System.in);
        // Ask for name
        System.out.println("Name of new client:");
        String name = scanner.nextLine();
        // Ask for address
        System.out.println("Address of new client:");
        String address = scanner.nextLine();
        // Ask for id
        System.out.println("ID of new client:");
        String id = scanner.nextLine();
        
        Client client;
        client = warehouse.addClient(name, address, id);
        if(client == null) {
            System.out.println("Could not add client");
        }
        System.out.println(client);
    }
    
    public void getClient() {
        Iterator allClients = warehouse.getClients();
        while(allClients.hasNext()){
            Client client = (Client)(allClients.next());
            System.out.println(client.toString());
        }
    }
    
    public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        Product product;
        do {
            // Ask for name
            System.out.println("Name of new product:");
            String name = scanner.nextLine();
            // Ask for quantity
            System.out.println("Quantity of new product:");
            String quantity = scanner.nextLine();
            // Ask for id
            System.out.println("ID of new product:");
            String id = scanner.nextLine();
            
            product = warehouse.addProduct(name, quantity, id);
            if(product == null) {
                System.out.println("Could not add product");
            } else {
                System.out.println(product);
            }
            
            // ask if we want to add another
            System.out.println("Add another product? (Y/N)");
            String answer = scanner.nextLine();
            if (Character.toUpperCase(answer.charAt(0)) == 'N') {
                break;
            }
        } while (true);
    }
    
    public void getProduct() {
        Iterator allProducts = warehouse.getProducts();
        while(allProducts.hasNext()){
            Product product = (Product)(allProducts.next());
            System.out.println(product.toString());
        }
    }
    
    public void addToWishlist() {
        Scanner scanner = new Scanner(System.in);
        Wishlist wishlist;
        Client client = new Client("-1", "-1", "-1");
        Product product = new Product("-1", "-1", "-1");
        
        boolean good = false;
        
        Iterator cList = warehouse.getClients();
        Iterator pList = warehouse.getProducts();
        
        System.out.println("ID of client: ");
        String clientID = scanner.nextLine();
        while(cList.hasNext()) {
            client = (Client) cList.next();
            if(clientID.equals(client.getId())){
                System.out.println("Client found");
                good = true;
                break;
            }
        }
        if(!good) {
            System.out.println("Client not found");
            return;
        }
        
        good = false;
        System.out.println("ID of product: ");
        String productID = scanner.nextLine();
        while(pList.hasNext()) {
            product = (Product) pList.next();
            if(productID.equals(product.getId())){
                System.out.println("Product found");
                good = true;
                break;
            }
        }
        if(!good){
            System.out.println("Product not found");
            return;
        }
        
        System.out.println("Quantity of product: ");
        String productQuantity = scanner.nextLine();
        
        Product tempProduct = new Product(product.getName(), productQuantity, product.getId());
        client.addToWishlist(tempProduct);
    }
    
    public void getWishlist() {
        Scanner scanner = new Scanner(System.in);
        Wishlist wishlist;
        Client client = new Client("-1", "-1", "-1");
        
        Iterator cList = warehouse.getClients();
        boolean good = false;
        System.out.println("ID of client: ");
        String clientID = scanner.nextLine();
        while(cList.hasNext()) {
            client = (Client) cList.next();
            if(clientID.equals(client.getId())){
                System.out.println("Client found");
                good = true;
                break;
            }
        }
        if(!good) {
            System.out.println("Client not found");
            return;
        }
        
        Iterator allWishlist = client.getWishlist();
        while(allWishlist.hasNext()){
            Product product = (Product)(allWishlist.next());
            System.out.println(product.toString());
        }
    }
    
    public static void main(String[] s) {
        UserInterface.instance().process();
    }
    
    public void process() {
        Scanner scanner = new Scanner(System.in);
        help();
        int command = 999;
        while (command != EXIT) {
            System.out.print("Command: ");
            command = Integer.parseInt(scanner.nextLine());
            switch (command) {
                case ADD_CLIENT:    addClient();
                                    break;
                case ADD_PRODUCT:   addProduct();
                                    break;
                case SHOW_CLIENTS:  getClient();
                                    break;
                case SHOW_PRODUCTS: getProduct();
                                    break;	
                case ADD_WISHLIST:  addToWishlist();
                                    break;
                case SHOW_WISHLIST: getWishlist();
                                    break;
                case HELP:          help();
                                    break;
            }
        }
    }
    
    public void help(){
        System.out.println("Enter a number as explained below:");
        System.out.println(EXIT + " to Exit\n");
        System.out.println(ADD_CLIENT + " to add a client");
        System.out.println(ADD_PRODUCT + " to  add products");
        System.out.println(SHOW_CLIENTS + " to  show clients");
        System.out.println(SHOW_PRODUCTS + " to  show products");
        System.out.println(ADD_WISHLIST + " to add a product to the wishlist");
        System.out.println(SHOW_WISHLIST + " to show the wishlist of a client");
        System.out.println(HELP + " for help");
    }
    
    public int getNumber(String prompt) {
    do {
      try {
        Integer num = Integer.valueOf(prompt);
        return num.intValue();
      } catch (NumberFormatException nfe) {
        System.out.println("Please input a number ");
      }
    } while (true);
  }
}