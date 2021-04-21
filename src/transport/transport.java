// Java program to implement
// a Simple Registration Form
// using Java Swing
package transport;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

class transport
	extends JFrame
	implements ActionListener {
    String ConsumerNo;
	String Consumercid;
	String PrevReading;
	int CurrReading;
	String EBConn;
	double Bill;
	private JButton btnNewButton;
	// Components of the Form
	 private Container c;
	    private JLabel title;
	    private JLabel cid;
	    private JTextField tcid;
	    private JLabel cname;
	    private JTextField tcname;
	    private JLabel ppmeter;
	    private JTextField pmeter;
	    private JLabel cmeter;
	    private JTextField ccmeter;
	    private JLabel add;
	    private JTextArea tadd;
	    private JCheckBox term;
	    private JButton sub;
	    private JButton reset;
	    private JTextArea tout;
	    private JLabel res;
	    private JTextArea resadd;

	// constructor, to initialize the components
	// with default values.
	public transport()
	{
		setTitle("User Details");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
  
        c = getContentPane();
        c.setLayout(null);
  
        title = new JLabel("Consumer Information");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(400, 30);
        title.setLocation(300, 30);
        c.add(title);
  
        cid = new JLabel("Customer ID");
        cid.setFont(new Font("Arial", Font.PLAIN, 20));
        cid.setSize(250, 20);
        cid.setLocation(50, 100);
        c.add(cid);
  
        tcid = new JTextField();
        tcid.setFont(new Font("Arial", Font.PLAIN, 15));
        tcid.setSize(250, 30);
        tcid.setLocation(400, 100);
        c.add(tcid);
  
        cname = new JLabel("Customer cid");
        cname.setFont(new Font("Arial", Font.PLAIN, 20));
        cname.setSize(250, 20);
        cname.setLocation(50, 150);
        c.add(cname);
  
        tcname = new JTextField();
        tcname.setFont(new Font("Arial", Font.PLAIN, 15));
        tcname.setSize(250, 30);
        tcname.setLocation(400, 150);
        c.add(tcname);
  
        ppmeter = new JLabel("Previous Month Meter Reading");
        ppmeter.setFont(new Font("Arial", Font.PLAIN, 20));
        ppmeter.setSize(300, 20);
        ppmeter.setLocation(50, 200);
        c.add(ppmeter);
  
        pmeter = new JTextField();
        pmeter.setFont(new Font("Arial", Font.PLAIN, 15));
        pmeter.setSize(250, 30);
        pmeter.setLocation(400, 200);
        c.add(pmeter);
  
        cmeter = new JLabel("Current Month Meter Reading");
        cmeter.setFont(new Font("Arial", Font.PLAIN, 20));
        cmeter.setSize(300, 20);
        cmeter.setLocation(50, 250);
        c.add(cmeter);
  
        ccmeter = new JTextField();
        ccmeter.setFont(new Font("Arial", Font.PLAIN, 15));
        ccmeter.setSize(250, 30);
        ccmeter.setLocation(400, 250);
        c.add(ccmeter);
  
  
        add = new JLabel("Address");
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        add.setSize(100, 20);
        add.setLocation(50, 300);
        c.add(add);
  
        tadd = new JTextArea();
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        tadd.setSize(250, 100);
        tadd.setLocation(400, 300);
        tadd.setLineWrap(true);
        c.add(tadd);
  
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 30);
        sub.setLocation(400, 450);
        sub.addActionListener(this);
        c.add(sub);
        
		setVisible(true);
	}

	// method actionPerformed()
	// to get the action performed
	// by the user and act accordingly
	public void actionPerformed(ActionEvent e)
	{
			if (e.getSource() == sub) {
				Scanner sc = new Scanner(System.in);
				ConsumerNo =  tcid.getText()+"\n";
				Consumercid = tcname.getText()+"\n";
				PrevReading = pmeter.getText()+"\n";
				CurrReading = Integer.parseInt(ccmeter.getText());
	            System.out.println(ConsumerNo + Consumercid  + PrevReading);
	            calculate_bill();
	            display();
			}
			else {
				tout.setText("");
				resadd.setText("");
				res.setText("Please accept the"
							+ " terms & conditions..");
			}
	}
		
	double calculate_bill()
	{
		
	if(CurrReading>=0 && CurrReading<=50)
	Bill=CurrReading*2.50;
	else if(CurrReading>100 && CurrReading <= 200)
	Bill=(50*2.50)+((CurrReading-100)*3.50);
	else if(CurrReading>200 && CurrReading <= 500)
	Bill=(50*2.50)+(100*2.50)+((CurrReading-200)*4);
	else
	Bill=(50*2.50)+(100*3.50)+(300*4)+((CurrReading-500)*5.50);
	return Bill;
	}
	void display()
	{
		
	String value="----------------------------------"+"\n"+"ELCTRICITY BILL"+"\n"+
		"----------------------------------"+"\n"+"Consumer Number: "+ConsumerNo+"\n"+
			"Consumer cid: "+Consumercid+"\n"+"Consumer Previous Units: "+PrevReading;
	String value2="Consumer Current Units: "+CurrReading+"\n"+"----------------------------------"+"\n"+"Total Amount(Rs.): "+Bill;
	
	JOptionPane.showMessageDialog(btnNewButton, value+value2);
	}

	public static void main(String[] args) throws Exception
	{
		transport f = new transport();
	}
}
