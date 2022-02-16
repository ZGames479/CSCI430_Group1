import java.util.*;
import java.lang.*;
import java.io.*;
public class ClientList implements Serializable {
    private static final long serialVersionUID = 1L;
    private List clients = new LinkedList();
    private static ClientList clientList;
    private ClientList() {
    }
    public static ClientList instance() {
        if (clientList == null) {
            return (clientList = new ClientList());
        } else {
            return clientList;
        }
    }

    public boolean insertClient(Client client) {
        clients.add(client);
        return true;
    }

    public Iterator getClient() {
        return clients.iterator();
    }

    private void writeObject(java.io.ObjectOutputStream output) {
        try {
            output.defaultWriteObject();
            output.writeObject(clientList);
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
                if (clientList == null) {
                    clientList = (ClientList) input.readObject();
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
        return clients.toString();
    }
}