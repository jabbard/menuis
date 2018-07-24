/*
 * This package contains two java classes.
 */
package menuis;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

//Team work
public class MenuInfo {

    /*
    Declaring variables
     */
    private ArrayList<MenuItem> list;
    
    private JFrame frame;
    private JFrame additionalFrame;

    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenuItem menuHelp;
    private JMenuItem menuItemOpen;
    private JMenuItem menuItemOpenAdd;
    private JMenuItem menuItemClose;
    private JSeparator openSeparator;
    private JSeparator openAddSeparator;
    
    private JPanel pnlTable;
    private JPanel pnlSearch;
    private JPanel pnlInsert;
    private JPanel pnlSpiciness;
    
    private JComboBox comboCategory;
    private JComboBox comboFoodCategory;

    private JTable tblMenu;
    private JScrollPane scrlPane;
    
    private JLabel lblDishNumber;
    private JLabel lblTitle1;
    private JLabel lblDishName;
    private JLabel lblCategory;
    private JLabel lblPrice;
    private JLabel lblTitle;
       
    private JTextField txtDishName;
    private JTextField txtDishNumber;
    private JTextField txtPrice;
    private JTextField txtSearch;
    
    private JRadioButton radVeryHot;
    private ButtonGroup btnGroupSpiciness;
    private JRadioButton radMediumHot;
    private JRadioButton radMildHot;
    
    private JButton btnInsert;
    private JButton btnClear;
    private JButton btnSearch;
    private JButton btnAddToTable;
    private JButton btnClearTable;
    private JButton btnAvailableDish;
    /*
     Constructor of MenuInfo class
     */
    public MenuInfo() {
        // calling method
        initComponents();

        //instantiating arraylist object
        list = new ArrayList<>();
        

    }
    
    public void initMenuBar(){
        menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 700, 30);
        frame.add(menuBar);
        

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuHelp = new JMenuItem("Help");
        menuHelp.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                JOptionPane.showMessageDialog(frame,"This is a information system"
                        + " that lets you add items to "
                        + "the table and also search for the item of your choice.","HELP!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
                
            });
        
                
        
        menuBar.add(menuHelp);
        
        //Action perfoming open new package source   
        menuItemOpen = new JMenuItem("Open");
         //Adding shortcut keys
        KeyStroke ctrlO = KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK);
        menuItemOpen.setAccelerator(ctrlO);
        
        menuFile.add(menuItemOpen);
        menuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                //Open a new document
                try {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:\\Users\\pradhumna dhungana\\Desktop\\selection sort.txt");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });

        //Action perfomed open the additional frame
        menuItemOpenAdd = new JMenuItem("Add");
        //Adding shortcut keys
        KeyStroke ctrlN = KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK);
        menuItemOpenAdd.setAccelerator(ctrlN);
        
        menuFile.add(menuItemOpenAdd);
        menuItemOpenAdd.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //open addtitional frame
                try {
                    btnAddToTableActionPerformed(ae);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });

        //Adding separaor
        openSeparator = new JSeparator();
        menuItemOpenAdd.add(openSeparator);

        //Action performed exit    
        menuItemClose = new JMenuItem("Close");
          //Adding shortcut keys
        KeyStroke ctrlQ = KeyStroke.getKeyStroke(KeyEvent.VK_Q,InputEvent.CTRL_MASK);
        menuItemClose.setAccelerator(ctrlQ);
        
        menuFile.add(menuItemClose);
        menuItemClose.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        //Adding separator
        openAddSeparator = new JSeparator();
        menuItemClose.add(openAddSeparator);
    }
            

    public void initComponents() {
        frame = new JFrame("Record System");
     
        initMenuBar();
        lblTitle = new JLabel("Foodopedia Record System");
        lblTitle.setFont(new Font("Century Gothic", 0, 22));
        lblTitle.setBounds(180, 40, 310, 40);
        frame.add(lblTitle);

        //creating panel
        pnlTable = new JPanel();
        pnlTable.setBorder(BorderFactory.createTitledBorder(null,
                "Menu Details", TitledBorder.CENTER, TitledBorder.ABOVE_TOP,
                new Font("Century Gothic", 0, 14)));
        pnlTable.setLayout(null);
        pnlTable.setBounds(40, 140, 600, 320);
        frame.add(pnlTable);

        //creating table
        tblMenu = new JTable();
        tblMenu.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Dish no.", "Dish Name", "Category", "Spiciness", "Price"
                }
        ));

        scrlPane = new JScrollPane();
        scrlPane.setViewportView(tblMenu);
        scrlPane.setBounds(20, 40, 560, 250);
        pnlTable.add(scrlPane);

     //inserting a picture
        Icon search = new ImageIcon("C:\\Users\\pradhumna dhungana\\Desktop\\searching.png");

        btnSearch = new JButton(search);
        btnSearch.setBounds(606, 110, 30, 23);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        frame.add(btnSearch);

        txtSearch = new JTextField("Insert Price");
        txtSearch.setBounds(470, 110, 120, 23);
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearch.setText("");
            }
        });
        frame.add(txtSearch);

        pnlSearch = new JPanel();
        pnlSearch.setBorder(BorderFactory.createTitledBorder(null,
                "Search Parameters", TitledBorder.CENTER, TitledBorder.ABOVE_TOP,
                new Font("Century Gothic", 0, 12)));
        pnlSearch.setLayout(null);
        pnlSearch.setBounds(350, 465, 290, 70);
        frame.add(pnlSearch);

        //Dishes within category to display        
        btnAvailableDish = new JButton("View Available Dish");
        btnAvailableDish.setBounds(130, 27, 150, 30);
        btnAvailableDish.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvailableDishActionPerformed(evt);
            }
        });
        pnlSearch.add(btnAvailableDish);

        //creating combo box categories
        String[] items = {"Fish", "Chicken", "Pork", "Buff", "Vegetable"};

        comboCategory = new JComboBox(items);
        comboCategory.setBounds(15, 27, 100, 30);
        pnlSearch.add(comboCategory);

        btnAddToTable = new JButton("Add to Table");
        btnAddToTable.setBounds(40, 490, 130, 30);
        btnAddToTable.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToTableActionPerformed(evt);
            }
        });
        frame.add(btnAddToTable);

        btnClearTable = new JButton("Clear Table");
        btnClearTable.setBounds(200, 490, 130, 30);
        btnClearTable.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnClearTableActionPerformed(e);
            }
        });
        frame.add(btnClearTable);

        frame.setLayout(null);
        frame.setSize(700, 630);
        frame.setVisible(true);
    }

    /*
    Access Modifier : public 
    Reurn type : void
    Method Description : action implementing a menu item to open a new folder
     */
   

    /*
    * Access Modifier : public
    * Return type : void
    * Method description: A button having action to open a new Java Frame.
     */
    public void btnAddToTableActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            additionalFrame = new JFrame("Add To Table");


            lblTitle1 = new JLabel("Foodopedia Record System");
            lblTitle1.setFont(new Font("Century Gothic", 0, 22));
            lblTitle1.setBounds(160, 40, 310, 40);
            additionalFrame.add(lblTitle1);

            pnlInsert = new JPanel();
            pnlInsert.setBorder(BorderFactory.createTitledBorder(null,
                    "Insert parameters", TitledBorder.CENTER, TitledBorder.ABOVE_TOP,
                    new Font("Century Gothic", 0, 14)));
            pnlInsert.setLayout(null);
            pnlInsert.setBounds(45, 100, 500, 280);
            additionalFrame.add(pnlInsert);

            lblDishNumber = new JLabel("Dish Number");
            lblDishNumber.setBounds(100, 30, 100, 30);
            pnlInsert.add(lblDishNumber);

            lblDishName = new JLabel("Dish Name");
            lblDishName.setBounds(100, 70, 100, 30);
            pnlInsert.add(lblDishName);

            lblCategory = new JLabel("Category");
            lblCategory.setBounds(100, 110, 100, 30);
            pnlInsert.add(lblCategory);

            lblPrice = new JLabel("Price");
            lblPrice.setBounds(100, 230, 100, 30);
            pnlInsert.add(lblPrice);

            txtDishNumber = new JTextField();
            txtDishNumber.setBounds(230, 30, 150, 25);
            pnlInsert.add(txtDishNumber);

            txtDishName = new JTextField();
            txtDishName.setBounds(230, 70, 150, 25);
            pnlInsert.add(txtDishName);

            txtPrice = new JTextField();
            txtPrice.setBounds(230, 230, 150, 25);
            pnlInsert.add(txtPrice);

            String[] items = {"Fish", "Chicken", "Pork", "Buff", "Vegetable"};

            comboFoodCategory = new JComboBox(items);
            comboFoodCategory.setBounds(230, 110, 100, 25);
            pnlInsert.add(comboFoodCategory);

            pnlSpiciness = new JPanel();
            pnlSpiciness.setBorder(BorderFactory.createTitledBorder(null,
                    "Spiciness", TitledBorder.LEFT, TitledBorder.ABOVE_TOP,
                    new Font("Century Gothic", 0, 12)));
            pnlSpiciness.setLayout(null);
            pnlSpiciness.setBounds(80, 150, 320, 70);
            pnlInsert.add(pnlSpiciness);

            btnGroupSpiciness = new ButtonGroup();
            //Adding radio button to button group
            radVeryHot = new JRadioButton("Very hot");
            radVeryHot.setBounds(10, 25, 75, 25);
            btnGroupSpiciness.add(radVeryHot);
            pnlSpiciness.add(radVeryHot);

            radMediumHot = new JRadioButton("Medium Hot");
            radMediumHot.setBounds(95, 25, 100, 25);
            radMediumHot.setSelected(true);
            btnGroupSpiciness.add(radMediumHot);
            pnlSpiciness.add(radMediumHot);

            radMildHot = new JRadioButton("Mild Hot");
            radMildHot.setBounds(200, 25, 75, 25);
            btnGroupSpiciness.add(radMildHot);
            pnlSpiciness.add(radMildHot);

            btnInsert = new JButton("Insert");
            btnInsert.setBounds(125, 400, 100, 25);
            btnInsert.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnInsertActionPerformed(e);
                }
            });
            additionalFrame.add(btnInsert);

            btnClear = new JButton("Clear");
            btnClear.setBounds(350, 400, 100, 25);
            btnClear.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnClearActionPerformed(e);
                }
            });
            additionalFrame.add(btnClear);

            additionalFrame.setLayout(null);
            additionalFrame.setSize(600, 600);
            additionalFrame.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Check all the parameters!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
     *  Access modifier : public
     *  Return type : void
     *  Component : button
     *  Method description : An action performed to insert values, returned from the texfields, to table, and store those menu details in an arraylist.
     */
    public void btnInsertActionPerformed(java.awt.event.ActionEvent e) {
        try {
            int dishNum = Integer.parseInt(txtDishNumber.getText());
            String name = txtDishName.getText();
            String capital = name.substring(0, 1).toUpperCase();
            String dishName = capital + name.substring(1);
            String category = comboFoodCategory.getSelectedItem().toString();
            String spiciness = radVeryHot.getText();
            if (radMediumHot.isSelected()) {
                spiciness = radMediumHot.getText();
            } else if (radMildHot.isSelected()) {
                spiciness = radMildHot.getText();
            }
            double price = Double.parseDouble(txtPrice.getText());

            //Validation   
            int rowCount = tblMenu.getRowCount();
            //The condition executes only when the table is empty
            if (rowCount == 0 && price > 0) {
                MenuItem menuItem = new MenuItem(dishNum, dishName, category, spiciness, price);
                DefaultTableModel model = (DefaultTableModel) tblMenu.getModel();
                model.addRow(new Object[]{menuItem.getDishNumber(), menuItem.getDishName(), menuItem.getCategory(), menuItem.getSpiciness(), menuItem.getPrice()});
                list.add(menuItem);
                //adding details of menu items in an arraylist.
                btnClearActionPerformed(e);
                //clears the text fields after adding.
            } else if (rowCount > 0 && price > 0) {
                //The condition executes when table is not empty.  

                boolean allowed = false;
                int i = 0;
                for (MenuItem s : list) {
                   i= i+1;
                    if (dishNum != s.getDishNumber()) {
                    //The condition executes when the same dish numbers are not repeated in the table.
                        if (!dishName.equalsIgnoreCase(s.getDishName()) || !category.equalsIgnoreCase(s.getCategory()) || !spiciness.equalsIgnoreCase(s.getSpiciness())) {
                            //This condition executes when same dish name,category and spiciness are not repeated in the table.
                            if(i==list.size()){
                                allowed = true;
                            }
                        } else {
                            //This condition executes when same dish name,category and spiciness are repeated in the table.
                            allowed = false;
                            JOptionPane.showMessageDialog(frame, "Please enter valid data.", "Error", JOptionPane.ERROR_MESSAGE);
                            btnClearActionPerformed(e);
                            break;
                        }
                    } else {
                        //The condition executes when the same dish numbers are repeated in the table.
                        JOptionPane.showMessageDialog(frame, "Please enter valid dishnumber", "Error", JOptionPane.ERROR_MESSAGE);
                        btnClearActionPerformed(e);
                        break;
                    }
                }

                if (allowed) {
                    MenuItem menuItem = new MenuItem(dishNum, dishName, category, spiciness, price);
                    DefaultTableModel mdl = (DefaultTableModel) tblMenu.getModel();
                    mdl.addRow(new Object[]{menuItem.getDishNumber(), menuItem.getDishName(), menuItem.getCategory(), menuItem.getSpiciness(), menuItem.getPrice()});
                    btnClearActionPerformed(e);
                    list.add(menuItem);
                }
            }
        } catch (Exception f) {

            JOptionPane.showMessageDialog(frame,
                    "Please see if any of the parameters are left"
                    + " empty or the correct data types have been"
                    + " entered in the text fields", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
     * Access Modifier:public
     * return type: void
     * Component: button
     * method description:An action performed to set the textfields to null.
     */
    public void btnClearActionPerformed(java.awt.event.ActionEvent e) {
        try {
            txtDishNumber.setText("");
            txtDishName.setText("");
            txtPrice.setText("");
            radMediumHot.setSelected(true);
            comboFoodCategory.setSelectedIndex(0);
        } catch (Exception f) {
            JOptionPane.showMessageDialog(frame,
                    "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
     * Access modifier : public
     * Return type : void
     * Component : button
     * Method description : An action peformed to set the text fields empty.
     */
    public void btnClearTableActionPerformed(java.awt.event.ActionEvent e) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tblMenu.getModel();
        defaultTableModel.setRowCount(0);
    }

   

    /*
     * Access modifier : public
     * Return type : int
     * Method description : returns the index number of the search value.
     */
    public int binarySearch(ArrayList<MenuItem> list, int low, int high, double key) {
        if (low <= high) {
            int mid = (low + high) / 2;

            System.out.println("Searching " + list.get(mid).getPrice() + " " + key);
            if (list.get(mid).getPrice() == key) {
                return mid;
            } else if (list.get(mid).getPrice() < key) {
                System.out.print("Right");
                return binarySearch(list, mid + 1, high, key);
            } else if (list.get(mid).getPrice() > key) {
                System.out.print("Left");
                return binarySearch(list, low, mid - 1, key);
            }
        }
        return -1;

    }

    /*
     * Access modifier : public
     * Return type : void
     * Method description : Dispalys menu details, of the index number returned 
                            by method binarySearch()in a message box.
     */
    public void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
        try{ 
            int textPri = Integer.parseInt(txtSearch.getText());       
            double pri = (double) textPri;
            int index = binarySearch(sort(list), 0, list.size() - 1, pri);
            JOptionPane.showMessageDialog(frame,"Dish Name : "+list.get(index).getDishName() + "\nCategory : " + list.get(index).getCategory() + "\nSpiciness :" +list.get(index).getSpiciness()+"\nPrice: "+list.get(index).getPrice(),"Search Result",JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e){
            JOptionPane.showMessageDialog(frame, "There are no dishes of this price.", "SORRY", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /*
     * Access modifier : public
     * Return type : ArrayList<MenuItem>
     * Method description :Sorts the prices in an ArrayList.  
     */
    public ArrayList<MenuItem> sort(ArrayList<MenuItem> li) {

        for (int i = 0; i < li.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < li.size(); j++) {
                if (li.get(j).getPrice() < li.get(minIndex).getPrice()) {
                    minIndex = j;
                }
            }

            MenuItem mark = li.get(minIndex);
            li.set(minIndex, li.get(i));
            li.set(i, mark);
        }
        return li;
    }

    /*
       * Access Modifier: public
       * return type: void
       * Component : button
       * Message descprition : Method called to perform action where dish name are 
                                displayed according to the combo box.
     */
    public void btnAvailableDishActionPerformed(java.awt.event.ActionEvent evt) {
        ArrayList<String> categ = new ArrayList<>();
        String s = (String) comboCategory.getSelectedItem();
        
        for (int i = 0; i < list.size(); i++) {
            String st = list.get(i).getCategory();
            if (st.equals(s)) {
                String name = list.get(i).getDishName();
                categ.add(name);
                } 
        }
        if(!categ.isEmpty()){
            String a="";
            for (String str : categ){
                a+=str + "\n";
            }
            JOptionPane.showMessageDialog(frame,"There are "+categ.size()+" number "
                    + "of dishes of category " + s + "  and they are : \n"
                    + a, "Search Result", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(frame,"Sorry there are no items for"
                    + " this category","title",JOptionPane.PLAIN_MESSAGE);
        }

    }   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new MenuInfo();
    }
}
