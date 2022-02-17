import java.util.*;
import java.lang.*;
import java.io.*;
public class Wishlist implements Serializable {
    private List wishlist = new LinkedList();   
    public Wishlist() {
    }

    public boolean insertWishlist(Product product) {
        wishlist.add(product);
        return true;
    }

    public Iterator getWishlist() {
        return wishlist.iterator();
    }

    /**
    private void writeObject(java.io.ObjectOutputStream output) {
        try {
            output.defaultWriteObject();
            output.writeObject(productList);
        } catch(IOException ioe) {
            System.out.println(ioe);
        }
    }

    private void readObject(java.io.ObjectInputStream input) {
        try {
            if (wishlist != null) {
                return;
            } else {
                input.defaultReadObject();
                if (wishlist == null) {
                    wishlist = input.readObject();
                } else {
                    input.readObject();
                }
            }
        } catch(IOException ioe) {
            System.out.println("in ClientList readObject \n" + ioe);
        } catch(ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }**/
    public String toString() {
        return wishlist.toString();
    }
}