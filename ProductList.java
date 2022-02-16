import java.util.*;
import java.lang.*;
import java.io.*;
public class ProductList implements Serializable {
    private static final long serialVersionUID = 1L;
    private List products = new LinkedList();
    private static ProductList productList;
    private ClientList() {
    }
    public static ProductList instance() {
        if (productList == null) {
            return (productList = new ProductList());
        } else {
            return clientList;
        }
    }

    public boolean insertProduct(Product product) {
        products.add(product);
        return true;
    }

    public Iterator getProduct() {
        return product.iterator();
    }

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
            if (clients != null) {
                return;
            } else {
                input.defaultReadObject();
                if (productList == null) {
                    productList = (ProductList) input.readObject();
                } else {
                    input.readObject();
                }
            }
        } catch(IOException ioe) {
            System.out.println("in ClientList readObject \n" + ioe);
        } catch(ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }
    public String toString() {
        return products.toString();
    }
}