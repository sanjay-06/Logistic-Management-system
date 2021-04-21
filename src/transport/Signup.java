package transport;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import org.bson.Document;

public class Signup extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField email;
    private JTextField username;
    private JTextField mob;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    public void call()
    {
    	this.hide();
    }

    public Signup() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 100, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("New User Register");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(362, 52, 325, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("City");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Email\r\n address");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEmailAddress.setBounds(58, 324, 124, 36);
        contentPane.add(lblEmailAddress);

        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        firstname.setBounds(214, 151, 228, 50);
        contentPane.add(firstname);
        firstname.setColumns(10);

        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lastname.setBounds(214, 235, 228, 50);
        contentPane.add(lastname);
        lastname.setColumns(10);

        email = new JTextField();

        email.setFont(new Font("Tahoma", Font.PLAIN, 15));
        email.setBounds(214, 320, 228, 50);
        contentPane.add(email);
        email.setColumns(10);

        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 15));
        username.setBounds(707, 151, 228, 50);
        contentPane.add(username);
        username.setColumns(10);

        JLabel lblUsername = new JLabel("Age");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblUsername.setBounds(542, 159, 99, 29);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPassword.setBounds(542, 245, 159, 24);
        contentPane.add(lblPassword);

        JLabel lblMobileNumber = new JLabel("Mobile number");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMobileNumber.setBounds(542, 329, 139, 26);
        contentPane.add(lblMobileNumber);

        mob = new JTextField();
        mob.setFont(new Font("Tahoma", Font.PLAIN, 32));
        mob.setBounds(707, 320, 228, 50);
        contentPane.add(mob);
        mob.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(707, 235, 228, 50);
        contentPane.add(passwordField);

        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Name = firstname.getText();
                String city = lastname.getText();
                String emailId = email.getText();
                String Age= username.getText();
                String mobileNumber = mob.getText();
                int len = mobileNumber.length();
                String password = passwordField.getText();
                String jsonfile="";
                String msg = "" + Name;
                msg += " \n";
                	MongoClient mongo = MongoClients.create("mongodb+srv://sanjay:1234@cluster0.cew55.mongodb.net/javauses?retryWrites=true&w=majority");
            	    MongoDatabase database = mongo.getDatabase("javausers");
            	    MongoCollection<Document> collection = database.getCollection("users");
            	    String col_name = "username";
            	    FindIterable <Document> fi = collection.find(Filters.eq(col_name, Name));      
            	    MongoCursor<Document> cursor = fi.iterator();
            	    
            	    try {
            	        while(cursor.hasNext()) {
            	           jsonfile=cursor.next().toJson();
            	        }
            	    } finally {
            	        cursor.close();
            	    }
            	    if (jsonfile!="")
            	    {
	            	    	JOptionPane.showMessageDialog(btnNewButton, "Username already taken");
            	    }
	            	    else 
	            	    {
	                     Document document = new Document();
	                     document.append("Name", Name);
	                     document.append("emailid", emailId);
	                     document.append("city", city);
	                     document.append("Age", Age);
	                     document.append("password", password);
	                     document.append("mobileNumber", mobileNumber);
	                     database.getCollection("signup").insertOne(document);
	                     System.out.println("Document1 inserted successfully");
	                     
	                     Document documentusers = new Document();
	                     documentusers.append("username", Name);
	                     documentusers.append("password", password);
	                     database.getCollection("users").insertOne(documentusers);
	                     System.out.println("Document inserted successfully");
	                     JOptionPane.showMessageDialog(btnNewButton,
	                             "Welcome, " + msg + "Your account is successfully created");
	                        call();
	                        try {
	    			            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	    			                if ("Nimbus".equals(info.getName())) {
	    			                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	    			                    break;
	    			                }
	    			            }
	    			        } catch (ClassNotFoundException ex) {
	    			            java.util.logging.Logger.getLogger(Loginsignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    			        } catch (InstantiationException ex) {
	    			            java.util.logging.Logger.getLogger(Loginsignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    			        } catch (IllegalAccessException ex) {
	    			            java.util.logging.Logger.getLogger(Loginsignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    			        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    			            java.util.logging.Logger.getLogger(Loginsignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    			        }
	    			        //</editor-fold>

	    			        /* Create and display the form */
	    			        java.awt.EventQueue.invokeLater(new Runnable() {
	    			            public void run() {
	    			               Loginsignup l= new Loginsignup();
	    			                l.setVisible(true);
	    			            }
	    			        });
	            	    }
            	    }
                });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(399, 447, 259, 74);
        contentPane.add(btnNewButton);
    }
}