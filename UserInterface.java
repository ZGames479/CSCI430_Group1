import java.util.*;
import java.text.*;
import java.io.*;

public class UserInterface {
  private static UserInterface userInterface;
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private static Warehouse warehouse;
  private static final int EXIT = 0;
  private static final int ADD_MEMBER = 1;
  private static final int ADD_BOOKS = 2;
  private static final int ISSUE_BOOKS = 3;
  private static final int RETURN_BOOKS = 4;
  private static final int RENEW_BOOKS = 5;
  private static final int REMOVE_BOOKS = 6;
  private static final int PLACE_HOLD = 7;
  private static final int REMOVE_HOLD = 8;
  private static final int PROCESS_HOLD = 9;
  private static final int GET_TRANSACTIONS = 10;
  private static final int SHOW_MEMBERS = 11;
  private static final int SHOW_BOOKS = 12;
  private static final int SAVE = 13;
  private static final int RETRIEVE = 14;
  private static final int HELP = 15;
    
    private UserInterface() {
        warehouse = new Warehouse();
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
}