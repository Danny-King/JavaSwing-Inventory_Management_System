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
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 *
 * @author User
 */
//Begin the Inventory_Management_System(Login_Form) class
public class Inventory_Management_System extends JFrame{
    
    //Specify the window size
    private final int WINDOW_WIDTH = 1100;
    private final int WINDOW_HEIGHT = 665;
    
    //Begin the Inventory_Management_System(Login_Form) constructor
    public Inventory_Management_System(){
        
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
        JLabel titlelabel = new JLabel("LOGIN");
        titlelabel.setFont(new Font("Tahoma", Font.BOLD, 28));
        titlelabel.setBounds(515, 50, 200, 40);
        panel.add(titlelabel);
        
        //Set icon location on file, insert icon into label and set the icon specific location(x, y, length, height) and add label icon to the panel.
        ImageIcon Icon = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Learning\\Inventory_Management_System\\Icon\\Login_Screen.png");
        JLabel Icon1 = new JLabel(Icon);
        Icon1.setBounds(370, 40, 200, 65);
        panel.add(Icon1);
        
        //Create label of User ID, set font, set label location and add to panel
        JLabel UserIDlabel = new JLabel("UserID");
        UserIDlabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        UserIDlabel.setBounds(400, 200, 200, 25);
        panel.add(UserIDlabel);
        
        //Create text field for user to insert their User ID, set font, set label location and add to panel
        JTextField UserIDText = new JTextField();
        UserIDText.setFont(new Font("Tahoma", Font.PLAIN, 20));
        UserIDText.setBounds(510, 200, 200, 30);
        panel.add(UserIDText);
        
        //Create label of Password, set font, set label location and add to panel
        JLabel Passwordlabel = new JLabel("Password");
        Passwordlabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        Passwordlabel.setBounds(400, 280, 200, 25);
        panel.add(Passwordlabel);
        
        //Create text field for user to insert their password, set font, set label location and add to panel
        JPasswordField PasswordText = new JPasswordField();
        PasswordText.setFont(new Font("Tahoma", Font.PLAIN, 20));
        PasswordText.setBounds(510, 280, 200, 30);
        panel.add(PasswordText);
        
        //Create login button
        JButton loginbutton = new JButton("Login");
        loginbutton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        loginbutton.setBounds(400, 450, 100, 30);
        
        //Action listener of login button if user click the button it will collect the data from User ID and Password text field and compare with the User ID and Password in the text file.
        loginbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String UserID = UserIDText.getText();
                String Password = PasswordText.getText();
                try{
                    Scanner in = new Scanner(new File("C:\\Users\\User\\Documents\\NetBeansProjects\\Learning\\Inventory_Management_System\\dist\\UserTable.txt"));
                    while(in.hasNextLine())
                    {
                        String s = in.nextLine();  
                        String[] data = s.split(" ");

                        if (UserID.equals(data[0]) && Password.equals(data[1]))
                        {
                            JOptionPane.showMessageDialog(null,"Login Successful", "Success",JOptionPane.INFORMATION_MESSAGE);
                            new Home_Page().setVisible(true);
                            dispose();
                        }
                    }
                    in.close();
                }catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(loginbutton);
        
        //Create clear button to clear text field
        JButton clearbutton = new JButton("Clear");
        clearbutton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        clearbutton.setBounds(610, 450, 100, 30);
        
        //Action Listener if user click the text field (User ID and Password) will become blank
        clearbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == clearbutton){
                    UserIDText.setText("");
                    PasswordText.setText("");
                }
            }
        });
        panel.add(clearbutton);
        
        //Create Register button
        JButton Registerbutton = new JButton("Register");
        Registerbutton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        Registerbutton.setBounds(630, 320, 80, 20);
        
        //Action Listener if user click it, the user will enter registration window to add their name and password
        Registerbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == Registerbutton){
                    if(e.getSource() == Registerbutton){
                        try {
                            new Register().setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(Inventory_Management_System.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    dispose();
                    }
                }
            }
        });
        panel.add(Registerbutton);
    }
    
    /**
     * @param args the command line arguments
     */
    //Driver class main class
    public static void main(String[] args) {
        new Inventory_Management_System().setVisible(true);
    }
}