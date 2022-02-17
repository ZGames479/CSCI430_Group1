import java.util.*;
import java.lang.*;
import java.io.*;
public class Client implements Serializable  {
 
    private String name;
    private String address;
    private String id;
    private Wishlist wishlist;

    public Client(String name, String address, String id) {
        this.name = name;
        this.address = address;
        this.id = id;
        this.wishlist = new Wishlist();
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
        return wishlist.getWishlist();
    }
    
    public void addToWishlist(Product product) {
        wishlist.insertWishlist(product);
    }

    public String toString() {
        return "name " + this.name + " address " + this.address + " id " + this.id;
    }
}