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
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
// Begin the Product class
public class Product extends JFrame{
    
    //Specify the window size
    private final int WINDOW_WIDTH = 1100;
    private final int WINDOW_HEIGHT = 665;
    
   // Begin the Product constructor
    public Product() throws IOException{
        
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
        JLabel titlelabel = new JLabel("PRODUCT LIST");
        titlelabel.setFont(new Font("Tahoma", Font.BOLD, 28));
        titlelabel.setBounds(440, 50, 250, 40);
        panel.add(titlelabel);
        
        //Set icon location on file, insert icon into label and set the icon specific location(x, y, length, height) and add label icon to the panel.
        ImageIcon Icon = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Learning\\Inventory_Management_System\\Icon\\Product(1).png");
        JLabel Icon1 = new JLabel(Icon);
        Icon1.setBounds(300, 40, 200, 65);
        panel.add(Icon1);
        
        //Creating array and string for the data
        String[] columns = { "Product ID", "Product Name", "Quantity", "Detail", "Category"};
        String[] data = new String[10];
        
        //Create product table
        JTable producttable = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        producttable.setModel(model);
        producttable.setBackground(Color.CYAN.brighter());
        producttable.setForeground(Color.black);
        Font font = new Font("", 1, 18);
        producttable.setFont(font);
        producttable.setRowHeight(30);
        JScrollPane pane = new JScrollPane(producttable);
        pane.setBounds(10, 120, 1070, 350);
        panel.add(pane);
        
        //Create product id label and product id text field for user entering data
        JLabel ProductIDLabel = new JLabel("Product ID");
        ProductIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ProductIDLabel.setBounds(70,470, 150, 25);
        JTextField ProductID = new JTextField();
        ProductID.setBounds(70, 500, 100, 25);
        panel.add(ProductIDLabel);
        panel.add(ProductID);
        
        //Create product name label and product name text field for user entering data
        JLabel ProductNameLabel = new JLabel("Product Name");
        ProductNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ProductNameLabel.setBounds(290,470, 150, 25);
        JTextField ProductName = new JTextField();
        ProductName.setBounds(290, 500, 100, 25);
        panel.add(ProductNameLabel);
        panel.add(ProductName);
        
        //Create product quantity label and product quantity text field for user entering data
        JLabel ProductQtyLabel = new JLabel("Product Quantity");
        ProductQtyLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ProductQtyLabel.setBounds(510,470, 150, 25);
        JTextField ProductQty = new JTextField();
        ProductQty.setBounds(510, 500, 100, 25);
        panel.add(ProductQtyLabel);
        panel.add(ProductQty);
        
        //Create product detail label and product detail text field for user entering data
        JLabel ProductDetailLabel = new JLabel("Product Detail");
        ProductDetailLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ProductDetailLabel.setBounds(730,470, 150, 25);
        JTextField ProductDetail = new JTextField();
        ProductDetail.setBounds(730, 500, 100, 25);
        panel.add(ProductDetailLabel);
        panel.add(ProductDetail);
        
        //Create product category label and product category text field for user entering data
        JLabel ProductCatLabel = new JLabel("Product Category");
        ProductCatLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ProductCatLabel.setBounds(940,470, 150, 25);
        JTextField ProductCat = new JTextField();
        ProductCat.setBounds(940, 500, 100, 25);
        panel.add(ProductCatLabel);
        panel.add(ProductCat);
        
        //Create add button
        JButton btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnAdd.setBounds(350, 550, 100, 25);
        
        //If user click add button, the data inside text field will insert into array data [0]-[4]
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data[0] = ProductID.getText();
                data[1] = ProductName.getText();
                data[2] = ProductQty.getText();
                data[3] = ProductDetail.getText();
                data[4] = ProductCat.getText();
                model.addRow(data);
            }
        });
        panel.add(btnAdd);
        
        //Create edit button
        JButton btnEdit = new JButton("Edit");
        btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnEdit.setBounds(510, 550, 100, 25);
        
        //If user click line inside product table, the data will generate into text field and user can edit and the data will edited inside product table.
        btnEdit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int i = producttable.getSelectedRow();
                if(i >= 0){
                    model.setValueAt(ProductID.getText(), i, 0);
                    model.setValueAt(ProductName.getText(), i, 1);
                    model.setValueAt(ProductQty.getText(), i, 2);
                    model.setValueAt(ProductDetail.getText(), i, 3);
                    model.setValueAt(ProductCat.getText(), i, 4);
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
        
        //User click line inside product table, and click delete button, the data will be deleted from product table
        btnDelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int i = producttable.getSelectedRow();
                if(i >= 0){
                    model.removeRow(i);
                }else
                {
                    System.out.println("There were issue while Deleting the Row(s).");
                }
            }
        });
        panel.add(btnDelete);
        
        //User can click data inside product table, and the data will generate into text field
        producttable.addMouseListener(new MouseAdapter(){
           public void mouseClicked(MouseEvent e){
               int i = producttable.getSelectedRow();
               ProductID.setText(model.getValueAt(i, 0).toString());
               ProductName.setText(model.getValueAt(i, 1).toString());
               ProductQty.setText(model.getValueAt(i, 2).toString());
               ProductDetail.setText(model.getValueAt(i, 3).toString());
               ProductCat.setText(model.getValueAt(i, 4).toString());
           } 
        });
        
        //Create save button
        JButton btnSave = new JButton("SAVE");
        btnSave.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnSave.setBounds(940, 550, 150, 25);
        
        //If user click the button, the data inside product table will transfered into specific text file
        btnSave.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String filePath = "C:\\Users\\User\\Documents\\NetBeansProjects\\Learning\\Inventory_Management_System\\dist\\ProductTable.txt";
                    File file = new File(filePath);
                    if(!file.exists())
                    {
                        file.createNewFile();
                    }
               
                    FileWriter fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);
               
                    //loop for jtable rows
                    for(int i = 0; i < producttable.getRowCount(); i++){
                    //loop for jtable column
                        for(int j = 0; j < producttable.getColumnCount(); j++){
                            bw.write(producttable.getModel().getValueAt(i, j)+" ");
                        }
                        //break line at the begin 
                        //break line at the end 
                        bw.write("\n");
                    }
                    //close BufferedWriter
                    bw.close();
                    //close FileWriter 
                    fw.close();
                    JOptionPane.showMessageDialog(null, "Data Exported");
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
        
        //If user click the button, the from text file will be called into product table
        btnRetrieve.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String filePath = "C:\\Users\\User\\Documents\\NetBeansProjects\\Learning\\Inventory_Management_System\\dist\\ProductTable.txt";
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
                    Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        panel.add(btnRetrieve);
        
        //Back button, for user to back to home page window from product window
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
    public static void main(String[] args) {
        new Inventory_Management_System().setVisible(true);
    }
}