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
import java.util.Vector;
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
// Begin the Order class
public class Order extends JFrame{
    
    //Specify the window size
    private final int WINDOW_WIDTH = 1100;
    private final int WINDOW_HEIGHT = 665;
    int OrderId;
    int i = 1;
    String ProductName;
    int flag = 0, ProductID, ProductQty;
    
    // Begin the Order constructor
    public Order(){
        
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
        JLabel titlelabel = new JLabel("ORDER");
        titlelabel.setFont(new Font("Tahoma", Font.BOLD, 28));
        titlelabel.setBounds(475, 50, 250, 40);
        panel.add(titlelabel);
        
        //Set icon location on file, insert icon into label and set the icon specific location(x, y, length, height) and add label icon to the panel.
        ImageIcon Icon = new ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Learning\\Inventory_Management_System\\Icon\\Order(1).png");
        JLabel Icon1 = new JLabel(Icon);
        Icon1.setBounds(340, 40, 200, 65);
        panel.add(Icon1);
        
        //Create title, set the title font, set the title specific location(x,y,length,height) and add to panel
        JLabel producttablelabel = new JLabel("PRODUCT LIST");
        producttablelabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        producttablelabel.setBounds(260, 120, 200, 40);
        panel.add(producttablelabel);
        
        //Create array string for columns product table
        String[] columns = { "Product ID", "Product Name", "Quantity", "Detail", "Category" };
        
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
        pane.setBounds(10, 150, 645, 350);
        panel.add(pane);
        
        //Create title, set the title font, set the title specific location(x,y,length,height) and add to panel
        JLabel ordertablelabel = new JLabel("ORDER LIST");
        ordertablelabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        ordertablelabel.setBounds(800, 120, 200, 40);
        panel.add(ordertablelabel);
        
        //Create array string for order, order table
        String[] Order = { "Order ID","Product ID", "Product Name", "Quantity" };
        
        //Create order table
        JTable ordertable = new JTable();
        DefaultTableModel model1 = new DefaultTableModel();
        model1.setColumnIdentifiers(Order);
        ordertable.setModel(model1);
        ordertable.setBackground(Color.CYAN.brighter());
        ordertable.setForeground(Color.black);
        ordertable.setFont(font);
        ordertable.setRowHeight(30);
        JScrollPane pane1 = new JScrollPane(ordertable);
        pane1.setBounds(700, 150, 345, 350);
        panel.add(pane1);
        
        //Create Quantity label and Quantity text field
        JLabel ProductQtyLabel = new JLabel("Quantity");
        ProductQtyLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ProductQtyLabel.setBounds(10,580, 150, 25);
        JTextField Qty = new JTextField();
        Qty.setBounds(110, 580, 100, 25);
        panel.add(ProductQtyLabel);
        panel.add(Qty);
        
        //Create retrieve button
        JButton btnRetrieve = new JButton("RETRIEVE");
        btnRetrieve.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnRetrieve.setBounds(10, 500, 150, 25);
        
        //Call the data from text file into product table
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
        
        //User can click data inside product table, the data(product id, product name and product quantity) can be obtained
        producttable.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
               DefaultTableModel model = (DefaultTableModel)producttable.getModel();
               int Myindex = producttable.getSelectedRow();
               ProductID = Integer.valueOf(model.getValueAt(Myindex, 0).toString());
               ProductName = model.getValueAt(Myindex, 1).toString();
               ProductQty = Integer.valueOf(model.getValueAt(Myindex, 2).toString());
               flag = 1;
            } 
        });
        
        //Create add to order table button
        JButton btnAdd = new JButton("Add To Order Table");
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnAdd.setBounds(260, 580, 200, 25);
        
        //If the user click the product table data, the data automatically collectted and entering order table
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(flag == 0 || Qty.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Select Product and Enter Quantity");
                }
                else
                {
                    Vector v = new Vector();
                    v.add(i);
                    v.add(ProductID);
                    v.add(ProductName);
                    v.add(Qty.getText());
                    DefaultTableModel dt = (DefaultTableModel)ordertable.getModel();
                    dt.addRow(v);
                    i++;
                }
            }
        });
        panel.add(btnAdd);
        
        //Create order table
        JButton btnOrder = new JButton("ORDER");
        btnOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnOrder.setBounds(700, 500, 150, 25);
        
        //If the user click the button, the data will collected and inserted into text file and the quantity of the data will deducted
        btnOrder.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String filePath = "C:\\Users\\User\\Documents\\NetBeansProjects\\Learning\\Inventory_Management_System\\dist\\OrderTable.txt";
                    File file = new File(filePath);
                    if(!file.exists())
                    {
                        file.createNewFile();
                    }
                    FileWriter fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);
               
                    //loop for jtable rows
                    for(int i = 0; i < ordertable.getRowCount(); i++){
                    //loop for jtable column
                        for(int j = 0; j < ordertable.getColumnCount(); j++){
                            bw.write(ordertable.getModel().getValueAt(i, j)+" ");
                        }
                        //break line at the begin 
                        //break line at the end 
                        bw.write("\n");
                    }
                    //close BufferedWriter
                    bw.close();
                    //close FileWriter 
                    fw.close();
                    JOptionPane.showMessageDialog(null, "Product Reducing");
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                
                int i = producttable.getSelectedRow();
                if(i >= 0){
                    model.setValueAt(ProductQty = ProductQty - Integer.valueOf(Qty.getText()), i, 2); //the quantity auto deduct
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
                        for(int q = 0; q < producttable.getRowCount(); q++){
                        //loop for jtable column
                            for(int j = 0; j < producttable.getColumnCount(); j++){
                                bw.write(producttable.getModel().getValueAt(q, j)+" ");
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
            }
        });
        panel.add(btnOrder);
        
        //Back button, for user to back to home page window from order window
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