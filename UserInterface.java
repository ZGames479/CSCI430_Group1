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
  private static final int HELP = 15;
    
    private UserInterface() {
        warehouse = new Warehouse();
    }
    
    public static UserInterface instance() {
        if (userInterface == null) {
            return userInterface = new UserInterface();
        } else {
            return userInterface;
        }
    }
    
    // get warehouse, print client, print product, add client, add product
    
    public addClient() {
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
    
    public getClient() {
        Iterator allClients = warehouse.getClients();
        while(allClients.hasNext()){
            Client client = (Client)(allClients.next());
            System.out.println(client.toString());
        }
    }
    
    public addProduct() {
        Scanner scanner;
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
                System.out.println(client);
            }
            
            // ask if we want to add another
            System.out.println("Add another product? (Y/N)");
            String answer = scanner.nextLine();
            if (answer == "N") {
                break;
            }
        } while (true);
    }
    
    public getProduct() {
        Iterator allProducts = warehouse.getProducts();
        while(allProducts.hasNext()){
            Product product = (Product)(allProducts.next());
            System.out.println(product.toString());
        }
    }
    
    public static void main(String[] s) {
        UserInterface.instance().process();
    }
    
    public void process() {
        Scanner scanner;
        help();
        int command = parseInt(scanner.nextLine());
        while (command != EXIT) {
      switch (command) {
        case ADD_CLIENT:          addMember();
                                  break;
        case ADD_PRODUCT:         addBooks();
                                  break;
        case SHOW_CLIENTS:        issueBooks();
                                  break;
        case SHOW_PRODUCTS:       returnBooks();
                                  break;	
        case HELP:                help();
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
        System.out.println(HELP + " for help");
    }
}