/*
 * ASSIGNMENT 1 GROUP 9 INVENTORY MANAGEMENT SYSTEM
 * SECTION 2
 * DANNY WONG SIEW KING BI20160331
 * CAESAR CHAMBAI BI20160315
 * FERNANDEZ BALIN ANAK SIAM BI20110234
 * MOHD DZUL IKRAM BIN AHMAD BI20110212
 */
package inventory_management_system;

//Import statement
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author User
 */
// Begin the Home_Page class
public class Home_Page extends JFrame{
    
    //Specify the window size
    private final int WINDOW_WIDTH = 1100;
    private final int WINDOW_HEIGHT = 665;
    
    // Begin the Home_Page constructor
    public Home_Page(){
        
        //Set window title,window icon, call the window size to set size and creating exit button
        setTitle("Inventory Management System");
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Documents\\NetBeansProjects\\Learning\\Inventory_Management_System\\Icon\\Top_Left.png");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(icon);
        
        //Create a new panel, add to window and set the panel layout
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(null);
        
        //Create title, set the title font, set the title specific location(x,y,length,height) and add to panel
        JLabel titlelabel = new JLabel("HOME PAGE");
        titlelabel.setFont(new Font("Tahoma", Font.BOLD, 28));
        titlelabel.setBounds(455, 50, 200, 40);
        panel.add(titlelabel);
        
        //Set icon location on file, insert icon into label and set the icon specific location(x, y, length, height) and add label icon to the panel.
        ImageIcon Icon = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Learning\\Inventory_Management_System\\Icon\\Login_Screen.png");
        JLabel Icon1 = new JLabel(Icon);
        Icon1.setBounds(320, 40, 200, 65);
        panel.add(Icon1);
        
        //Create label for product
        JLabel productlabel = new JLabel("PRODUCT");
        productlabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        productlabel.setBounds(45, 220, 200, 40);
        panel.add(productlabel);
        
        //Create product icon and insert into the button
        ImageIcon producticon = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Learning\\Inventory_Management_System\\Icon\\Product.png");
        JButton productbutton = new JButton(producticon);
        productbutton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        productbutton.setBounds(15, 250, 150, 150);
        
        //Action listener if user click the button and entering product window
        productbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == productbutton){
                    try {
                        new Product().setVisible(true);
                    } catch (IOException ex) {
                        Logger.getLogger(Home_Page.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dispose();
                }
            }
        });
        panel.add(productbutton);
        
        //Create label for order
        JLabel orderlabel = new JLabel("ORDER");
        orderlabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        orderlabel.setBounds(508, 220, 200, 40);
        panel.add(orderlabel);
        
        //Create order icon and insert into the button
        ImageIcon ordericon = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Learning\\Inventory_Management_System\\Icon\\Order.png");
        JButton orderbutton = new JButton(ordericon);
        orderbutton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        orderbutton.setBounds(465, 250, 150, 150);
        
        //Action listener if user click the button and entering order window
        orderbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == orderbutton){
                    new Order().setVisible(true);
                    dispose();
                }
            }
        });
        panel.add(orderbutton);
        
        //Create logout icon and insert into the button
        ImageIcon logouticon = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Learning\\Inventory_Management_System\\Icon\\Log_Out.png");
        JButton logoutbutton = new JButton(logouticon);
        logoutbutton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        logoutbutton.setBounds(10, 580, 35, 35);
        
        //Action listener if user click the button and entering login(Inventory_Management_System) window
        logoutbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == logoutbutton){
                    new Inventory_Management_System().setVisible(true);
                    dispose();
                }
            }
        });
        panel.add(logoutbutton);
        
        //Create label for user
        JLabel userlabel = new JLabel("USER");
        userlabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        userlabel.setBounds(970, 220, 200, 40);
        panel.add(userlabel);
        
        //Create user icon and insert into the button
        ImageIcon usericon = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Learning\\Inventory_Management_System\\Icon\\User.png");
        JButton userbutton = new JButton(usericon);
        userbutton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        userbutton.setBounds(915, 250, 150, 150);
        
        //Action listener if user click the button and entering user window
        userbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == userbutton){
                    try {
                        new User().setVisible(true);
                    } catch (IOException ex) {
                        Logger.getLogger(Home_Page.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dispose();
                }
            }
        });
        panel.add(userbutton);
    }
    
    /**
     * @param args the command line arguments
     */
    //Driver class main class
    public static void main(String[] args) {
        new Inventory_Management_System().setVisible(true);
    }
}