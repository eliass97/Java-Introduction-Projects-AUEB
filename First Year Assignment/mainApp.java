/*
Alexandros Tzovaras -> P3150171
Ilias Settas -> P3150156
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class mainApp extends JFrame implements ActionListener, MouseListener {
	
	private static final String Blu = "Blu-ray";
	private static final String DVD = "DVD";
	private static final String LED = "LED";
	private static final String HomeConsole = "Home Console";
	private static final String Handheld = "Handheld";
	public boolean gamingVisible = false;
	public boolean videoVisible = false;
	public boolean departmentVisible = false;
	public boolean catVisible = true;
	private JButton Buy;
	private JButton Back;
	private JButton SearchOrders;
	private JButton SearchSales;
	private JButton ArriveOrder;
	private JList list2;
	private JList list3;
	private JList listVideoSound;
	private JList listDepartment;
	private JList listGaming;
	private JList listCat;
	private JLabel label;
	private ImageIcon imIco1;
	private DefaultListModel listModelCat;
	private DefaultListModel listModel2;
	private DefaultListModel listModel3;
	private DefaultListModel listModelVideoSound;
	private DefaultListModel listModelGaming;
	private DefaultListModel listModelDepartment;
	private JTextArea resultArea = new JTextArea("Double-click on a \n category and a product to \n view it's info and image.\n You can also buy products \n after you have chosen a category.",10,20);
	private JTextArea resultArea2 = new JTextArea("Complete a chosen order or \n search for one by customer's name.",10,20);
	private JTextArea resultArea3 = new JTextArea("Search for a sale by customer's name.",10,20);
	static ArrayList <Device> available = new ArrayList <Device>(); 
	static ArrayList <Orders> ordered = new ArrayList <Orders>(); 
    static ArrayList <Sales> sold = new ArrayList <Sales>();
	static StoreFileAvailable Product1 = new StoreFileAvailable();
    static StoreFileOrder Product2 = new StoreFileOrder();
	static StoreFileSale Product3 = new StoreFileSale();
	static WriteFileSale ProductS = new WriteFileSale();
	static WriteFileOrder ProductO = new WriteFileOrder();
	
	public mainApp() {
		
		setTitle("myStore"); 
		drawFrame(); 
        Buy.addActionListener(this);	
        Back.addActionListener(this);		
		SearchOrders.addActionListener(this);
		SearchSales.addActionListener(this);
		ArriveOrder.addActionListener(this);
		listCat.addMouseListener(this);
		listVideoSound.addMouseListener(this);
		listGaming.addMouseListener(this);
		listDepartment.addMouseListener(this);
		setVisible(true);
	} 
	
	public void drawFrame() {
		
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel panel1 = new JPanel();
        tabbedPane.addTab("Available", null, panel1, null);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        JPanel panel2 = new JPanel();
        tabbedPane.addTab("Orders", null, panel2, null);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        JPanel panel3 = new JPanel();
        tabbedPane.addTab("Sales", null, panel3, null);
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
		getContentPane().add(tabbedPane);
		setBounds(300, 300, 350, 150); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Buy = new JButton("Buy");
		panel1.add(Buy);
		Buy.setVisible(false);
		Back = new JButton("Back");
		panel1.add(Back);
		SearchOrders = new JButton("Search Order");
		panel2.add(SearchOrders);
		SearchSales = new JButton("Search Sale");
		panel3.add(SearchSales);
		ArriveOrder = new JButton("Complete Order");
		panel2.add(ArriveOrder); 
		listModelCat = new DefaultListModel();
		listModel2 = new DefaultListModel();
		listModel3 = new DefaultListModel();
		listModelGaming = new DefaultListModel();
		listModelVideoSound = new DefaultListModel();
		listModelDepartment = new DefaultListModel();
		listModelCat.addElement("Video & Sound");
		listModelCat.addElement("Gaming");
		listModelCat.addElement("Home Department");
		listCat = new JList(listModelCat);
		for (Device it : available) {
			if (it instanceof Console) {
				listModelGaming.addElement(it.getName());
			} else if (it instanceof TV || it instanceof BlueRayDVDPlayer || it instanceof Camera) {
				listModelVideoSound.addElement(it.getName()); 
			} else {
				listModelDepartment.addElement(it.getName()); 
			}
		}
		listDepartment = new JList(listModelDepartment);
		listVideoSound = new JList(listModelVideoSound); 
		listGaming = new JList(listModelGaming);
		listDepartment.setSelectedIndex(0);
		listVideoSound.setSelectedIndex(0);
		listGaming.setSelectedIndex(0);
		for (Orders it : ordered) {
			listModel2.addElement(it.getName()); 
		}
		list2 = new JList(listModel2);
		list2.setSelectedIndex(0);
		for (Sales it : sold) {
			listModel3.addElement(it.getName()); 
		}
		list3 = new JList(listModel3);
		list3.setSelectedIndex(0); 
		panel1.add(listCat);
		panel1.add(listVideoSound);
		listVideoSound.setVisible(false);
		panel1.add(listGaming);
		listGaming.setVisible(false);
		panel1.add(listDepartment);
		listDepartment.setVisible(false);
		panel2.add(list2);
		panel3.add(list3);
		label = new JLabel();
		label.setSize(300,300);
		label.setIcon(new ImageIcon("Images/welcome.jpg"));
		Container cp = getContentPane();
        cp.setLayout(new BorderLayout()); 
		panel1.setLayout(new FlowLayout());
		JScrollPane listScrollerCat = new JScrollPane(listCat);
		JScrollPane listScrollerGaming = new JScrollPane(listGaming);
		JScrollPane listScrollerVideoSound = new JScrollPane(listVideoSound);
		JScrollPane listScrollerDepartment = new JScrollPane(listDepartment);
		JScrollPane listScroller2 = new JScrollPane(list2);
		JScrollPane listScroller3 = new JScrollPane(list3);
		listScrollerCat.setPreferredSize(new Dimension(150, 100));
		listScrollerVideoSound.setPreferredSize(new Dimension(150, 100));
        listScrollerGaming.setPreferredSize(new Dimension(150, 100));
        listScrollerDepartment.setPreferredSize(new Dimension(150, 100));		
        listScroller2.setPreferredSize(new Dimension(150, 100));
        listScroller3.setPreferredSize(new Dimension(150, 100));		
		resultArea.setFont(new Font("Serif", Font.ITALIC, 18)); 
		resultArea2.setFont(new Font("Serif", Font.ITALIC, 18));
		resultArea3.setFont(new Font("Serif", Font.ITALIC, 18));
		resultArea.setEditable(false);
		resultArea2.setEditable(false);
		resultArea3.setEditable(false);
        panel1.add(listScrollerCat);
        panel1.add(listScrollerVideoSound); 
        panel1.add(listScrollerGaming);
        panel1.add(listScrollerDepartment);
        listScrollerDepartment.setVisible(true);	
        listScrollerVideoSound.setVisible(true);	
        listScrollerGaming.setVisible(true);			
		panel2.add(listScroller2);
		panel3.add(listScroller3);
		panel1.add(resultArea);
		panel2.add(resultArea2);
		panel3.add(resultArea3);
		cp.add(label, BorderLayout.LINE_END);
		cp.add(tabbedPane, BorderLayout.LINE_START);
		pack();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == Back) {
			Buy.setVisible(false);
			listCat.setVisible(true);
			catVisible = true;
			gamingVisible = false;
			videoVisible = false;
			departmentVisible = false;
			listVideoSound.setVisible(false);
			listGaming.setVisible(false);
			listDepartment.setVisible(false);
			resultArea.setText("Double-click on a \n category and view the info \n of a specific product.\n You can also buy products \n after you have chosen a category.");
		} else if (e.getSource() == Buy) {
			resultArea.setText("If you want to cancel \n while buying a product \n then cancel all 3 requests \n and the sale won't be \n recorded.");
			if (gamingVisible == true){
				int k = listGaming.getSelectedIndex();
				int j = 1;
				for(int i=0;i<available.size();i++){
				   if(listModelGaming.getElementAt(k).equals(available.get(i).getName())){
					   j = i;
				   }
				}
				if(available.get(j).getNumber() > 0) {
				    String cusname = "";
				    cusname = (String)JOptionPane.showInputDialog(this, "Please enter your name.");
				    String cusphone = "";
				    cusphone = (String)JOptionPane.showInputDialog(this, "Please enter your phone number."); 
				    String cusdate = "";
				    cusdate = (String)JOptionPane.showInputDialog(this, "Please enter the current date.");
				    int z = sold.size();
				    if (cusname.equals("") || cusphone.equals("") || cusdate.equals("")) {
					
				    } else {
				        available.get(j).setNumber(available.get(j).getNumber()-1);
				        Sales telsale = new Sales(z, available.get(j).getName(), cusname, cusphone, cusdate, available.get(j).getPrice() - (available.get(j).getPrice() * 0.25));
				        sold.add(telsale);
				        ProductS.add(telsale);
		                ProductS.createFile("sale.txt");
				        int c = sold.size() -1;
				        listModel3.addElement(sold.get(c).getName());
				        resultArea.setText("Price:"+Double.toString(available.get(j).getPrice() - (Product1.get(j).getPrice() * 0.25)));
				    }
				} else {
                    String cusname = "";
				    cusname = (String)JOptionPane.showInputDialog(this, "This product is not available. Please enter your name to create an order.");
				    String cusphone = "";
				    cusphone = (String)JOptionPane.showInputDialog(this, "Please enter your phone number."); 
				    String cusdate = "";
				    cusdate = (String)JOptionPane.showInputDialog(this, "Please enter the current date.");
				    String cusarr = "";
				    cusarr = (String)JOptionPane.showInputDialog(this, "Please enter the arrival date.");
				    int z = ordered.size();
				    if (cusname.equals("") || cusphone.equals("") || cusdate.equals("") || cusarr.equals("")) {
				
				    } else {
				        Orders telorder = new Orders(z, available.get(j).getName(), cusname, cusphone, cusdate,cusarr, available.get(j).getPrice() - (available.get(j).getPrice() * 0.25),false);
				        ordered.add(telorder);
				        ProductO.add(telorder);
				        int c = ordered.size() -1;
				        listModel2.addElement(ordered.get(c).getName());
				    }
				}
			} else if (videoVisible == true) {
				int k = listVideoSound.getSelectedIndex();
				int j = 1;
				for(int i=0;i<available.size();i++){
				   if(listModelVideoSound.getElementAt(k).equals(available.get(i).getName())){
					   j = i;
				   }
				}
				if (available.get(j).getNumber() > 0 ) {
				    String cusname = "";
				    cusname = (String)JOptionPane.showInputDialog(this, "Please enter your name.");
				    String cusphone = "";
				    cusphone = (String)JOptionPane.showInputDialog(this, "Please enter your phone number."); 
				    String cusdate = "";
				    cusdate = (String)JOptionPane.showInputDialog(this, "Please enter the current date.");
				    int z = sold.size();
				    if (cusname.equals("") || cusphone.equals("") || cusdate.equals("")) {
					
				    } else {
				        available.get(j).setNumber(available.get(j).getNumber()-1);
				        Sales telsale = new Sales(z, available.get(j).getName(), cusname, cusphone, cusdate, available.get(j).getPrice() - (available.get(j).getPrice() * 0.25));
				        sold.add(telsale);
				        ProductS.add(telsale);
		                ProductS.createFile("sale.txt");
				        int c = sold.size() -1;
				        listModel3.addElement(sold.get(c).getName());
				        resultArea.setText("Price:"+Double.toString(available.get(j).getPrice() - (available.get(j).getPrice() * 0.25)));
				    }
				} else { 
				    String cusname = "";
				    cusname = (String)JOptionPane.showInputDialog(this, "This product is not available. Please enter your name to create an order.");
				    String cusphone = "";
				    cusphone = (String)JOptionPane.showInputDialog(this, "Please enter your phone number."); 
				    String cusdate = "";
				    cusdate = (String)JOptionPane.showInputDialog(this, "Please enter the current date.");
				    String cusarr = "";
				    cusarr = (String)JOptionPane.showInputDialog(this, "Please enter the arrival date.");
				    int z = ordered.size();
				    if (cusname.equals("") || cusphone.equals("") || cusdate.equals("") || cusarr.equals("")) {
				
				    } else {
				        Orders telorder = new Orders(z, available.get(j).getName(), cusname, cusphone, cusdate,cusarr, available.get(j).getPrice() - (available.get(j).getPrice() * 0.25),false);
				        ordered.add(telorder);
				        ProductO.add(telorder);
				        int c = ordered.size() -1;
				        listModel2.addElement(ordered.get(c).getName()); 
				    }
				}
			} else if (departmentVisible == true) {
				int k = listDepartment.getSelectedIndex();
				int j = 1;
				for(int i=0;i<Product1.size();i++){
				   if(listModelDepartment.getElementAt(k).equals(available.get(i).getName())){
					   j = i;
				   }
				}
				if(available.get(j).getNumber()>0){
				    String cusname = "";
				    cusname = (String)JOptionPane.showInputDialog(this, "Please enter your name.");
				    String cusphone = "";
				    cusphone = (String)JOptionPane.showInputDialog(this, "Please enter your phone number."); 
				    String cusdate = "";
				    cusdate = (String)JOptionPane.showInputDialog(this, "Please enter the current date.");
				    int z = sold.size();
				    if (cusname.equals("") || cusphone.equals("") || cusdate.equals("")) {
				
				    } else {
				        available.get(j).setNumber(available.get(j).getNumber()-1);
				        Sales telsale = new Sales(z, available.get(j).getName(), cusname, cusphone, cusdate, available.get(j).getPrice() - (available.get(j).getPrice() * 0.25));
				        sold.add(telsale);
				        ProductS.add(telsale);
		                ProductS.createFile("sale.txt");
				        int c = sold.size() -1;
				        listModel3.addElement(sold.get(c).getName());
				        resultArea.setText("Price:"+Double.toString(available.get(j).getPrice() - (available.get(j).getPrice() * 0.25)));
				    }
				} else{
				    String cusname = "";
				    cusname = (String)JOptionPane.showInputDialog(this, "This product is not available. Please enter your name to create an order.");
				    String cusphone = "";
				    cusphone = (String)JOptionPane.showInputDialog(this, "Please enter your phone number."); 
				    String cusdate = "";
				    cusdate = (String)JOptionPane.showInputDialog(this, "Please enter the current date.");
				    String cusarr = "";
				    cusarr = (String)JOptionPane.showInputDialog(this, "Please enter the arrival date.");
				    int z = ordered.size();
				    if (cusname.equals("") || cusphone.equals("") || cusdate.equals("") || cusarr.equals("")) {
				
				    } else {
				        Orders telorder = new Orders(z, available.get(j).getName(), cusname, cusphone, cusdate,cusarr, available.get(j).getPrice() - (available.get(j).getPrice() * 0.25),false);
				        ordered.add(telorder);
				        ProductO.add(telorder);
				        int c = ordered.size() -1;
				        listModel2.addElement(ordered.get(c).getName());
				    }
			    }
			}
		} else if (e.getSource() == SearchOrders) {
			String search = "";
			search = (String)JOptionPane.showInputDialog(this, "Please enter the customer's name.");
			boolean done = false;
			for(int at=0; at<ordered.size();at++){
				if(ordered.get(at).getName().equals(search) && done == false){
					done = true;
					resultArea2.setText("It's the number "+(at+1)+".");
					list2.setSelectedIndex(at);
				}
			}
			if(done = false){
				resultArea2.setText("No customer has that name.");
			}	
		} else if (e.getSource() == SearchSales) {
			String search = "";
			search = (String)JOptionPane.showInputDialog(this, "Please enter the customer's name.");
			boolean done = false;
			for(int at=0; at<sold.size();at++){
				if(sold.get(at).getName().equals(search) && done == false){
					done = true;
					resultArea3.setText("It's the number "+(at+1)+".");
					list3.setSelectedIndex(at);
				}
			}
			if(done = false){
				resultArea2.setText("No customer has that name.");
			}
		} else if (e.getSource() == ArriveOrder) {
			int j =list2.getSelectedIndex();
			if (j != -1 && ordered.get(j).getDone() == false) {
				String date = "";
				date = (String)JOptionPane.showInputDialog(this, "Enter the date.");
				if(date.equals("")){
					
				} else {
					int z = sold.size();
					Sales unk = new Sales(z,ordered.get(j).getDevice(),ordered.get(j).getName(),ordered.get(j).getPhone(),date,ordered.get(j).getFinalCost());
                    sold.add(unk);			       
				    ordered.get(j).setDone(true);
					ProductS.add(unk); 
					ProductS.createFile("sale.txt");
					ProductO.createFile("order.txt");
					listModel3.addElement(ordered.get(j).getName());
				}
			}
		}
	}

    public void mouseClicked(MouseEvent evt) {
		
        JList listCat = (JList)evt.getSource();
        if (evt.getClickCount() == 2 && catVisible == true) {
			int index = listCat.locationToIndex(evt.getPoint());
			listCat.setVisible(false);
			if (index == 0) {
				listVideoSound.setVisible(true);
				catVisible = false;
				Buy.setVisible(true);
				gamingVisible = false;
				videoVisible = true;
				departmentVisible = false;
			} else if (index == 1) {
				listGaming.setVisible(true);
				Buy.setVisible(true);
				gamingVisible = true;
				catVisible = false;
				videoVisible = false;
				departmentVisible = false;
			} else if (index == 2) {
				listDepartment.setVisible(true);
				Buy.setVisible(true);
				gamingVisible = false;
				videoVisible = false;
				catVisible = false;
				departmentVisible = true;
			} else {
				
			}
        } else if (evt.getClickCount() == 2 && gamingVisible == true) {
			int s = listGaming.getSelectedIndex();
			int o = 0;
			for(int i=0;i<Product1.size();i++){
				   if(listModelGaming.getElementAt(s).equals(available.get(i).getName())){
					   o = i;
				   }
				}
				label.setIcon(new ImageIcon(available.get(o).getImagePath()));
				resultArea.setText(available.get(o).getContents());
		} else if (evt.getClickCount() == 2 && departmentVisible == true) {
			int s = listDepartment.getSelectedIndex();
			int o = 0;
			for(int i=0;i<available.size();i++){
				   if(listModelDepartment.getElementAt(s).equals(available.get(i).getName())){
					   o = i;
				   }
				}
				label.setIcon(new ImageIcon(available.get(o).getImagePath()));
				resultArea.setText(available.get(o).getContents());
		} else if (evt.getClickCount() == 2 && videoVisible == true) {
			int s = listVideoSound.getSelectedIndex();
			int o = 0;
			for(int i=0;i<available.size();i++){
				if(listModelVideoSound.getElementAt(s).equals(available.get(i).getName())){
				    o = i;
				}
			}
		    label.setIcon(new ImageIcon(available.get(o).getImagePath()));
		    resultArea.setText(available.get(o).getContents());
		}	
    }

	public void mouseExited(MouseEvent event) {} 
	
	public void mouseEntered(MouseEvent event) {}
	
	public void mouseReleased(MouseEvent event) {}
	
	public void mousePressed(MouseEvent event) {}

	public static void main(String[] args) { 
		
        Product1.loadFile("available.txt");
		Product1.get(0).setImagePath("Images/LG FH0C3QD.jpg");
        Product1.get(1).setImagePath("Images/Bosch WAE20037IT.jpg");
		Product1.get(2).setImagePath("Images/Samsung UE48JU6400.jpg");
		Product1.get(3).setImagePath("Images/LG 32LF510B.jpg");
		Product1.get(4).setImagePath("Images/Morris S88211DAP.jpg");
		Product1.get(5).setImagePath("Images/Whirlpool ARC2353.jpg");
		Product1.get(6).setImagePath("Images/Sony PS4.jpg");
		Product1.get(7).setImagePath("Images/Xbox one.png");
		Product1.get(8).setImagePath("Images/Sony PS3 Super Slim.jpg");
		Product1.get(9).setImagePath("Images/Nintendo 3DS.jpg");
		Product1.get(10).setImagePath("Images/Sony PS Vita.jpg");
		Product1.get(11).setImagePath("Images/Canon PS SX412 IS.jpg");
		Product1.get(12).setImagePath("Images/Sony DSCW800.jpg");
		Product1.get(13).setImagePath("Images/Sony BDPS1500.jpeg");
		Product1.get(14).setImagePath("Images/Samsung BDJ5500.jpg");
        Product1.get(15).setImagePath("Images/Philips DVP2880.jpg");
		Product1.get(16).setImagePath("Images/Sony DVPSR760.jpg");
        Product2.loadFile("order.txt");
        Product3.loadFile("sale.txt");
		for (int i=0; i<Product1.size();i++){
			available.add(Product1.get(i));
		}
		for (int i=0; i < Product2.size();i++){
			int z = ordered.size();
            Orders order2 = new Orders(z, Product2.get(i).getDevice(), Product2.get(i).getName(), Product2.get(i).getPhone(), Product2.get(i).getOrderDate(),Product2.get(i).getArriveDate(), Product2.get(i).getFinalCost(),Product2.get(i).getDone());
			ordered.add(order2);
			ProductO.add(order2);
		    ProductO.createFile("order.txt");
        }
		for (int i=0; i < Product3.size();i++){
			int z = sold.size();
            Sales sale2 = new Sales(z, Product3.get(i).getDevice(), Product3.get(i).getName(), Product3.get(i).getPhone(), Product3.get(i).getSaleDate(), Product3.get(i).getFinalCost());
			sold.add(sale2);
			ProductS.add(sale2);
		    ProductS.createFile("sale.txt");
        }
		ProductS.createFile("sale.txt");
		ProductO.createFile("order.txt");
		new mainApp();		
	}
}