import java.util.*;
import java.text.*;
import java.io.*;
public class Main {
    public static String getToken(String prompt) {
        do {
            try {
                System.out.println(prompt);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String line = reader.readLine();
                StringTokenizer tokenizer = new StringTokenizer(line,"\n\r\f");
                if (tokenizer.hasMoreTokens()) {
                    return tokenizer.nextToken();
                }
            }
            catch (IOException ioe) {
                System.exit(0);
            }
        } while (true);
    }
    private static boolean yesOrNo(String prompt) {
        String more = getToken(prompt + " (Y|y)[es] or anything else for no");
        if (more.charAt(0) != 'y' && more.charAt(0) != 'Y') {
            return false;
        }
        return true;
    }

    public static void main(String[] s) {
        Client c1 = new Client("Zac", "123 4th Ave", "1");
        Client c2 = new Client("John", "567 8th Ave", "2");
        ClientList clients = ClientList.instance();

        clients.insertClient(c1);
        clients.insertClient(c2);

        System.out.println(clients.toString());
        Iterator productClient = clients.getClient();
        
        Product p1 = new Product("Chicken", "2", "53");
        Product p2 = new Product("Steak", "9", "92");
        
        c1.addToWishlist(p1);
        c2.addToWishlist(p2);
        Iterator c1Wish = c1.getWishlist();
        Iterator c2Wish = c2.getWishlist();
        
        System.out.println(c1.toString() + " Wishlist: " + c1Wish.next());
        System.out.println(c2.toString() + " Wishlist: " + c2Wish.next());
    }
}