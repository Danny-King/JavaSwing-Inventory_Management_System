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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
// Begin the User class
public class User extends JFrame{
    
    //Specify the window size
    private final int WINDOW_WIDTH = 1100;
    private final int WINDOW_HEIGHT = 665;
    
    // Begin the User constructor
    public User() throws IOException{
        
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
        JLabel titlelabel = new JLabel("USER LIST");
        titlelabel.setFont(new Font("Tahoma", Font.BOLD, 28));
        titlelabel.setBounds(440, 50, 250, 40);
        panel.add(titlelabel);
        
        //Set icon location on file, insert icon into label and set the icon specific location(x, y, length, height) and add label icon to the panel.
        ImageIcon Icon = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Learning\\Inventory_Management_System\\Icon\\User(1).png");
        JLabel Icon1 = new JLabel(Icon);
        Icon1.setBounds(305, 40, 200, 65);
        panel.add(Icon1);
        
        //Create array and string for columns and data
        String[] columns = { "User ID", "Password" };
        String[] data = new String[10];
        
        //Create user table
        JTable usertable = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        usertable.setModel(model);
        usertable.setBackground(Color.CYAN.brighter());
        usertable.setForeground(Color.black);
        Font font = new Font("", 1, 18);
        usertable.setFont(font);
        usertable.setRowHeight(30);
        JScrollPane pane = new JScrollPane(usertable);
        pane.setBounds(10, 120, 1070, 350);
        panel.add(pane);
        
        //Create User ID label and user id text field
        JLabel UserIDLabel = new JLabel("User ID/ User Name");
        UserIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        JTextField UserID = new JTextField();
        UserID.setBounds(220, 500, 150, 25);
        UserIDLabel.setBounds(220, 470, 150, 25);
        panel.add(UserIDLabel);
        panel.add(UserID);
        
        //Create Password label and Password text field
        JLabel PasswordLabel = new JLabel("Password");
        PasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        JTextField Password = new JTextField();
        Password.setBounds(750, 500, 150, 25);
        PasswordLabel.setBounds(750, 470, 150, 25);
        panel.add(PasswordLabel);
        panel.add(Password);
        
        //Create add button
        JButton btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnAdd.setBounds(350, 550, 100, 25);
        
        //If the button clicked, the data from text field will collected and inserted into user table
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data[0] = UserID.getText();
                data[1] = Password.getText();
                model.addRow(data);
            }
        });
        panel.add(btnAdd);
        
        //Create edit table
        JButton btnEdit = new JButton("Edit");
        btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnEdit.setBounds(510, 550, 100, 25);
        
        //If the data from table clicked, the data will enter the text field and user can edit the clicked data
        //And if the button clicked, the edited data will collected and inserted into user table
        btnEdit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int i = usertable.getSelectedRow();
                if(i >= 0){
                    model.setValueAt(UserID.getText(), i, 0);
                    model.setValueAt(Password.getText(), i, 1);
                }else
                {
                    System.out.println("Update Error");
                }
            }
        });
        panel.add(btnEdit);
        
        //Create delete button
        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnDelete.setBounds(650, 550, 100, 25);
        
        //If the data from user table clicked, the user can delete it
        btnDelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int i = usertable.getSelectedRow();
                if(i >= 0){
                    model.removeRow(i);
                }else
                {
                    System.out.println("There were issue while Deleting the Row(s).");
                }
            }
        });
        panel.add(btnDelete);
        
        //User can click data inside user table, the data(user id and password) can be obtained
        usertable.addMouseListener(new MouseAdapter(){
           public void mouseClicked(MouseEvent e){
               int i = usertable.getSelectedRow();
               UserID.setText(model.getValueAt(i, 0).toString());
               Password.setText(model.getValueAt(i, 1).toString());
           } 
        });
        
        //Create save button
        JButton btnSave = new JButton("SAVE");
        btnSave.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnSave.setBounds(940, 550, 150, 25);
        
        //If user click the button, the data inside user table will transfered into specific text file
        btnSave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    String filePath = "C:\\Users\\User\\Documents\\NetBeansProjects\\Learning\\Inventory_Management_System\\dist\\UserTable.txt";
                    File file = new File(filePath);
                    if(!file.exists())
                    {
                        file.createNewFile();
                    }
               
                    FileWriter fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);
               
                    //loop for jtable rows
                    for(int i = 0; i < usertable.getRowCount(); i++){
                    //loop for jtable column
                        for(int j = 0; j < usertable.getColumnCount(); j++){
                            bw.write(usertable.getModel().getValueAt(i, j)+" ");
                        }
                        //break line at the begin 
                        //break line at the end 
                        bw.write("\n");
                    }
                    //close BufferedWriter
                    bw.close();
                    //close FileWriter 
                    fw.close();
                    JOptionPane.showMessageDialog(null, "User Successful Added");
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        panel.add(btnSave);
        
        //Create retrieve button
        JButton btnRetrieve = new JButton("RETRIEVE");
        btnRetrieve.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnRetrieve.setBounds(940, 590, 150, 25);
        
        //If user click the button, the from text file will be called into user table
        btnRetrieve.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String filePath = "C:\\Users\\User\\Documents\\NetBeansProjects\\Learning\\Inventory_Management_System\\dist\\UserTable.txt";
                    File file = new File(filePath);
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    
                    model.setColumnIdentifiers(columns);
            
                    // get lines from txt file
                    Object[] tableLines = br.lines().toArray();
            
                    // extratct data from lines
                    // set data to jtable model
                    for(int i = 0; i < tableLines.length; i++)
                    {
                        String line = tableLines[i].toString().trim();
                        String[] data = line.split("\\s+");
                        model.addRow(data);
                    }
            
                }catch (Exception ex) {
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        panel.add(btnRetrieve);
        
        //Back button, for user to back to home page window from user window
        JButton backbutton = new JButton("Back");
        backbutton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        backbutton.setBounds(10, 10, 70, 20);
        backbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == backbutton){
                    new Home_Page().setVisible(true);
                    dispose();
                }
            }
        });
        panel.add(backbutton);
    }
    
    /**
     * @param args the command line arguments
     */
    //Driver class main class
    public static void main(String[] args){
        new Inventory_Management_System().setVisible(true);
    }
}