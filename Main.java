import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

class Main{
    public static void main(String args[]){
        JFrame frameStart = new JFrame("Project 1");
        frameStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameStart.setSize(500,250);
        
        FlowLayout fl = new FlowLayout();
        JPanel panel = new JPanel();
        panel.setLayout(fl);
        
        // buttons
        JButton btnAddClient = new JButton("Add Client");
        JButton btnAddProduct = new JButton("Add Product");
        JButton btnAddWishlist = new JButton("Add to Wishlist");
        
        frameStart.getContentPane().add(panel);
        panel.add(btnAddClient);
        panel.add(btnAddProduct);
        panel.add(btnAddWishlist);
        
        // ActionListener for the buttons
        btnAddClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                panel.setVisible(false);
                createNewClient(frameStart, panel);
            }
        });
        btnAddProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                panel.setVisible(false);
                createNewProduct(frameStart, panel);
            }
        });
        btnAddWishlist.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                    
            }
        });
        
        frameStart.setVisible(true);
    }
    
    public static void createNewClient(JFrame frame, JPanel panelStart) {
        JPanel newPanel = new JPanel();
        
        frame.getContentPane().add(newPanel);
        
        JLabel firstNameLabel = new JLabel("First Name");
        JTextField firstNameText = new JTextField(20);
        
        JLabel lastNameLabel = new JLabel("Last Name");
        JTextField lastNameText = new JTextField(20);
        
        JButton createClient = new JButton("Create Client");
        createClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // need to check if the first and last name text fields are empty
                // items need to be added to an array or list
            
                //frame.getContentPane().remove(newPanel);
                newPanel.setVisible(false);
                panelStart.setVisible(true);
            }
        });
        
        newPanel.add(firstNameLabel);
        newPanel.add(firstNameText);
        newPanel.add(lastNameLabel);
        newPanel.add(lastNameText);
        newPanel.add(createClient);
        
        newPanel.setVisible(true);
    }
    
    
    
    public static void createNewProduct(JFrame frame, JPanel panelStart) {
        JPanel newPanel = new JPanel();
        
        frame.getContentPane().add(newPanel);
        
        JLabel productNameLabel = new JLabel("Product Name");
        JTextField productNameText = new JTextField(100);
        
        JLabel productIdLabel = new JLabel("Product ID");
        JTextField productIdText = new JTextField(20);
        
        JButton createProduct = new JButton("Create Product");
        createProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // need to check if the text fields are empty
                // items need to be added to an array or list
            
                newPanel.setVisible(false);
                panelStart.setVisible(true);
            }
        });
        
        newPanel.add(productNameLabel);
        newPanel.add(productNameText);
        newPanel.add(productIdLabel);
        newPanel.add(productIdText);
        newPanel.add(createProduct);
        
        newPanel.setVisible(true);
    }
}