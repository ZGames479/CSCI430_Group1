import java.util.*;
import java.lang.*;
import java.io.*;
public class Client implements Serializable  {
 
  private String name;
  private String address;
  private String id;
    
  private List wishlist = new LinkedList();

  public Client(String name, String address, String id) {
    this.name = name;
    this.address = address;
    this.id = id;
  }
  
  public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getId() {
        return this.id;
    }
    
    public Iterator getWishlist() {
        return wishlist.iterator();
    }
    
    public void addToWishlist(Product product) {
        wishlist.add(product);
    }

    public String toString() {
        return "name " + this.name + " address " + this.address + " id " + this.id;
    }
}