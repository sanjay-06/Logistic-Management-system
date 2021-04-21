package transport;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.lang.Math;   
class Goods
    extends JFrame
    implements ActionListener {
	
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel mno;
    private JTextField tmno;
    private JLabel email;
    private JTextField eid;
    private JLabel citycal;
    private JLabel add;
    private JTextArea tadd;
    private JComboBox cityid;
    private JButton sub;
    private JButton reset;
    private JTextArea resadd;
    private String dat;
    private String city[]
    		= {
    		"Coimbatore","Chennai","salem","Trichy","madurai","Tirupur","Theni","Vellore","Tanjore","Karur","namakkal","dindugal","Thuthukudi"
    		};
 
    // constructor, to initialize the components
    // with default values.
    public Goods()
    {
        setTitle("Transport reciever Details Form");
        setForeground(Color.white);
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.orange);
        setResizable(false);
    
        c = getContentPane();
        c.setBackground(Color.GRAY);
        c.setLayout(null);
 
        title = new JLabel(" Reciever Details");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        title.setForeground(Color.white);
        c.add(title);
 
        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(200, 100);
        name.setForeground(Color.white);
        c.add(name);
 
        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(300, 25);
        tname.setLocation(300, 100);
        c.add(tname);
 
        mno = new JLabel("Mobile No.");
        mno.setFont(new Font("Arial", Font.PLAIN, 20));
        mno.setSize(110, 20);
        mno.setLocation(200, 150);
        mno.setForeground(Color.white);
        c.add(mno);
 
        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(300, 25);
        tmno.setLocation(300, 150);
        c.add(tmno);
 
        email = new JLabel("Email-Id");
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setSize(100, 20);
        email.setLocation(200, 200);
        email.setForeground(Color.white);
        email.setForeground(Color.white);
        c.add(email);
 
       eid =new JTextField();
       eid .setFont(new Font("Arial", Font.PLAIN, 15));
       eid .setSize(300, 25);
       eid .setLocation(300, 200);
        c.add(eid);
 
        citycal = new JLabel("city");
        citycal.setFont(new Font("Arial", Font.PLAIN, 20));
        citycal.setSize(110, 20);
        citycal.setLocation(200, 250);
        citycal.setForeground(Color.white);
        c.add(citycal);
 
        cityid = new JComboBox(city);
        cityid.setFont(new Font("Arial", Font.PLAIN, 15));
        cityid.setSize(300, 25);
        cityid.setLocation(300, 250);
        c.add(cityid);
 
        add = new JLabel("Address");
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        add.setSize(100, 20);
        add.setLocation(200, 300);
        add.setForeground(Color.white);
        c.add(add);
 
        tadd = new JTextArea();
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        tadd.setSize(300, 90);
        tadd.setLocation(300, 300);
        tadd.setLineWrap(true);
        c.add(tadd);
 
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(350, 450);
        sub.addActionListener(this);
        sub.setBackground(Color.WHITE);
        c.add(sub);
 
        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(470, 450);
        reset.addActionListener(this);
        reset.setBackground(Color.WHITE);
        c.add(reset);
 
        setVisible(true);
    }
 
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
    	String[] vehicle= {
    		"TN 68 AW 8334","TN 77 XY 1234","TN48 YT 7284","TN 66 XY 1784","TN 50 AJ 1984"	
    	};
    	String[] name= {
        		"Ram","Raju","Vijay","Akash","dinesh"	
        	};
    	String[] num= {
        		"9856735739","8794683529","8785648368","987553692","977538291"	
        	};
        if (e.getSource() == sub) {
               
                String data
                    = "\nName: "
                      + tname.getText() + "\n"
                      + "Mobile number : "
                      + tmno.getText() + "\n";
                
                String data2= "city: "+ (String)cityid.getSelectedItem()+ "\n";
                String mail=eid.getText().trim();
                String data1="Email-id: "+eid.getText()+"\n"; 
                String data3 = "Address to be delivered : " + tadd.getText();
                String Orderdata ="Reciever details" +"\n"+data + data1 + data2 + data3;
                System.out.println(Orderdata);
                this.hide();
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date currentDate = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(currentDate);
                c.add(Calendar.DATE, 5);
                // convert date to calendar
                Date currentDatePlusOne = c.getTime();

                this.dat=(String)dateFormat.format(currentDatePlusOne);
                int rand=(int)Math.random() * (5 - 1 + 1) + 1;  
                String splitter="\n-------------------------Vehicle Details--------------------------------";
                Mailer.send("sanjayprasad682001@gmail.com","Order Details",mail,"Greetings!!!","Your will recieve an order"+"\n"+"BY:"+dateFormat.format(currentDatePlusOne)+splitter+"\n"+"Vehicle Details:"+"\n"+"Vehicle Number: "+vehicle[rand]+"\n"+"Driver Name: "+name[rand]+"\n"+"Phone number: "+num[rand]); 
                
                new sender((String)cityid.getSelectedItem(), tadd.getText());
                this.hide();
        }
 
        else if (e.getSource() == reset) {
            String def = "";
            tname.setText(def);
            tadd.setText(def);
            tmno.setText(def);
            eid.setText(def);
        }
    }
}
