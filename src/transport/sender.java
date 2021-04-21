package transport;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class sender
	extends JFrame
	implements ActionListener {

	private JButton btnNewButton;
	private String recevcity;
	// Components of the Form
	private Container c;
	private JLabel title;
	private JLabel name;
	private JTextField tname;
	private JLabel cit;
	private JLabel quan;
	private JComboBox tcit;
	private JComboBox qty;
	private JLabel ty;
	private JComboBox typegoods;
	private JLabel dob;
	private JComboBox month;
	private JComboBox year;
	private JLabel add;
	private JTextArea tadd;
	private JCheckBox term;
	private JButton sub;
	private JButton reset;
	private JTextArea tout;
	private JLabel res;
	private JTextArea resadd;
	private String addrecev;
	private String data;

	private String qtys[]
		= { "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "10",
			"11", "12", "13", "14", "15",
			"16", "17", "18", "19", "20",
			"21", "22", "23", "24", "25",
			"26", "27", "28", "29", "30",
			"30 < weight < 100" };
	private String city[]
		= { "Coimbatore","Chennai","salem","Trichy","madurai","Tirupur","Theni","Vellore","Tanjore","Karur","namakkal","dindugal","Thuthukudi" };
	
	private String type[]
			= { "common goods","Fragile","Expensive","Canned foods"};
	// constructor, to initialize the components
	// with default values.
	public sender(String cityrecev,String recvadd)
	{
		this.recevcity=cityrecev;
		this.addrecev=recvadd;
		setTitle("sender Form");
		setBounds(300, 90, 900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		c = getContentPane();
		c.setBackground(Color.GRAY);
		c.setLayout(null);
		
		 title = new JLabel(" Goods Details");
	     title.setFont(new Font("Arial", Font.PLAIN, 30));
	     title.setSize(300, 30);
	     title.setLocation(300, 30);
	     title.setForeground(Color.white);
	     c.add(title);

		name = new JLabel("Email-ID");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        name.setForeground(Color.white);
        name.setForeground(Color.white);
        c.add(name);
 
        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 30);
        tname.setLocation(200, 100);
        c.add(tname);
 
        cit = new JLabel("City");
        cit.setFont(new Font("Arial", Font.PLAIN, 20));
        cit.setSize(110, 20);
        cit.setLocation(100, 150);
        cit.setForeground(Color.white);
        c.add(cit);
 
        tcit = new JComboBox(city);
        tcit.setFont(new Font("Arial", Font.PLAIN, 15));
        tcit.setSize(190, 20);
        tcit.setLocation(200, 150);
        c.add(tcit);
        
        ty = new JLabel("Type");
        ty.setFont(new Font("Arial", Font.PLAIN, 20));
        ty.setSize(100, 20);
        ty.setLocation(100, 200);
        ty.setForeground(Color.white);
        c.add(ty);
 
       typegoods =new JComboBox(type);
       typegoods .setFont(new Font("Arial", Font.PLAIN, 15));
       typegoods .setSize(190, 20);
       typegoods .setLocation(200, 200);
        c.add(typegoods);
 
        quan = new JLabel("Quantity");
        quan.setFont(new Font("Arial", Font.PLAIN, 20));
        quan.setSize(190, 20);
        quan.setLocation(100, 250);
        quan.setForeground(Color.white);
        c.add(quan);
 
        qty = new JComboBox(qtys);
        qty.setFont(new Font("Arial", Font.PLAIN, 15));
        qty.setSize(190, 20);
        qty.setLocation(200, 250);
        c.add(qty);
 
 
        add = new JLabel("Address");
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        add.setSize(100, 20);
        add.setLocation(100, 300);
        add.setForeground(Color.white);
        c.add(add);
 
        tadd = new JTextArea();
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        tadd.setSize(200, 75);
        tadd.setLocation(200, 300);
        tadd.setLineWrap(true);
        c.add(tadd);
 
        sub = new JButton("check");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        c.add(sub);
 
        reset = new JButton("confirm");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 450);
        reset.addActionListener(this);
        c.add(reset);
 
        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == sub) 
		{
			    int goodsBill=0,qtyBill,DistBill;
			    String datatitle="\tInvoice\t\t\n";
			    if((String)typegoods.getSelectedItem()=="common Goods")
			    {
			    	goodsBill=100;
			    }
			    else if ((String)typegoods.getSelectedItem()=="Fragile")
			    {
			    	goodsBill=250;
			    }
			    else if  ((String)typegoods.getSelectedItem()=="Canned Foods")
			    {
			    	goodsBill=300;
			    }
			    else if  ((String)typegoods.getSelectedItem()=="Expensive")
			    {
			    	goodsBill=1000;
			    }
			    else
			    {
			    	goodsBill=100;
			    }
			    int Dist;
			    if(Integer.parseInt((String)qty.getSelectedItem())<10)
			    {
			    	qtyBill=Integer.parseInt((String)qty.getSelectedItem())*10;
			    }
			    else if(Integer.parseInt((String)qty.getSelectedItem())>10 && Integer.parseInt((String)qty.getSelectedItem())<30)
			    {
			    	qtyBill=Integer.parseInt((String)qty.getSelectedItem())*25;
			    }
			    else
			    {
			    	qtyBill=Integer.parseInt((String)qty.getSelectedItem())*100;
			    }
			    
			    if ((String)tcit.getSelectedItem() == this.recevcity)
			    {
			    	DistBill=25;
			    }
			    else if ( ((String)tcit.getSelectedItem() == "Coimbatore" && this.recevcity =="Chennai") || (String)tcit.getSelectedItem() == "Chennai" && this.recevcity =="Coimbatore")
			    {
			    	Dist=506;
			    	DistBill=Dist*4;
			    }
			    else if ( ((String)tcit.getSelectedItem() == "Tirupur" && this.recevcity =="Coimbatore") || (String)tcit.getSelectedItem() == "Coimbatore" && this.recevcity =="Tirupur")
			    {
			    	Dist=55;
			    	DistBill=Dist*4;
			    }
			    else if ( ((String)tcit.getSelectedItem() == "Coimbatore" && this.recevcity =="Madurai") || (String)tcit.getSelectedItem() == "Madurai" && this.recevcity =="Coimbatore")
			    {
			    	Dist=216;
			    	DistBill=Dist*4;
			    }
			    else if ( ((String)tcit.getSelectedItem() == "Coimbatore" && this.recevcity =="Salem") || (String)tcit.getSelectedItem() == "Salem" && this.recevcity =="Coimbatore")
			    {
			    	Dist=166;
			    	DistBill=Dist*4;
			    }
			    else if ( ((String)tcit.getSelectedItem() == "Coimbatore" && this.recevcity =="Trichy") || (String)tcit.getSelectedItem() == "Trichy" && this.recevcity =="Coimbatore")
			    {
			    	Dist=217;
			    	DistBill=Dist*4;
			    }
			    else if ( ((String)tcit.getSelectedItem() == "Coimbatore" && this.recevcity =="Theni") || (String)tcit.getSelectedItem() == "Theni" && this.recevcity =="Coimbatore")
			    {
			    	Dist=214;
			    	DistBill=Dist*4;
			    }
			    else if ( ((String)tcit.getSelectedItem() == "Coimbatore" && this.recevcity =="Vellore") || (String)tcit.getSelectedItem() == "Vellore" && this.recevcity =="Coimbatore")
			    {
			    	Dist=391;
			    	DistBill=Dist*4;
			    }
			    else if ( ((String)tcit.getSelectedItem() == "Coimbatore" && this.recevcity =="Tanjore") || (String)tcit.getSelectedItem() == "Tanjore" && this.recevcity =="Coimbatore")
			    {
			    	Dist=268;
			    	DistBill=Dist*4;
			    }
			    else if ( ((String)tcit.getSelectedItem() == "Coimbatore" && this.recevcity =="Karur") || (String)tcit.getSelectedItem() == "Karur" && this.recevcity =="Coimbatore")
			    {
			    	Dist=131;
			    	DistBill=Dist*4;
			    }
			    else if ( ((String)tcit.getSelectedItem() == "Coimbatore" && this.recevcity =="namakkal") || (String)tcit.getSelectedItem() == "namakkal" && this.recevcity =="Coimbatore")
			    {
			    	Dist=152;
			    	DistBill=Dist*4;
			    }
			    else if ( ((String)tcit.getSelectedItem() == "Coimbatore" && this.recevcity =="dindigul") || (String)tcit.getSelectedItem() == "dindigul" && this.recevcity =="Coimbatore")
			    {
			    	Dist=152;
			    	DistBill=Dist*4;
			    }
			    else if ( ((String)tcit.getSelectedItem() == "Coimbatore" && this.recevcity =="Thuthukudi") || (String)tcit.getSelectedItem() == "Thuthukudi" && this.recevcity =="Coimbatore")
			    {
			    	Dist=152;
			    	DistBill=Dist*4;
			    }
			    else
			    {
			    	DistBill=500;
			    }
			    String send="----------------------Sender-----------------------------\n";
			    String data1="Sender City: "+(String)tcit.getSelectedItem()+"\n";
			    String add1="Address: "+tadd.getText()+"\n\n";
			    String rec="----------------------Reciever---------------------------\n";
				String data2="Reciever City: "+this.recevcity+"\n";
				String add2="Address: "+this.addrecev+"\n\n\n";
				String bill="------------------Bill details------------------------------\n\n";
				String data3="Goods Bill: "+"\t"+goodsBill+" rupees\n";
				String data4="Quantity Bill: "+"\t"+qtyBill+" rupees\n";
				String data5="Distance Bill: "+"\t"+DistBill+" rupees\n\n\n";
				String splitter="--------------------------------------------------------------\n\n";
				int total=goodsBill+qtyBill+DistBill;
				System.out.println(total);
				String grandtotal="Grand Total: "+"\t"+total+" rupees";
				
				tout.setText(datatitle +send + data1 + add1+ rec + data2 + add2 +bill+data3 + data4+data5 +splitter+grandtotal);
				tout.setEditable(false);
				this.data=datatitle +send + data1 + add1+ rec + data2 + add2 +bill+data3 + data4+data5 +splitter+grandtotal; 
				
				
		}

		else if (e.getSource() == reset) {
			this.hide();
			JOptionPane.showMessageDialog(btnNewButton,
                    "Order Placed!"+"\n"+"You will recieve an email");
			Mailer.send("transporttestmail@gmail.com","Order Details",tname.getText(),"Greetings!!!",this.data); 
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sender frame = new sender("Coimbatore","Coimbatore");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
