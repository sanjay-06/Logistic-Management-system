package transport;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.bson.Document;
import java.util.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class user extends JFrame
{
	String userName;
    String Password;
   user(String username,String password) {
	   System.out.println("hello");
      // Username Label
	   this.userName=username;
	   this.Password=password;
	   actionPerformed();
	   
	 
   }
   public String[] action(String search)
   {
	   String[] userval=new String[2];
	   try
	   {
	    String jsonfile="";
		MongoClient mongoClient = MongoClients.create("mongodb+srv://sanjay:1234@cluster0.cew55.mongodb.net/javauses?retryWrites=true&w=majority");
	    MongoDatabase database = mongoClient.getDatabase("javausers");
	    MongoCollection<Document> collection = database.getCollection("users");
	    String col_name = "username";
	    FindIterable <Document> fi = collection.find(Filters.eq(col_name, search));      
	    MongoCursor<Document> cursor = fi.iterator();
	    try {
	        while(cursor.hasNext()) 
	        {
	           jsonfile=cursor.next().toJson();
	        }
	    } finally {
	        cursor.close();
	    }
	    if (jsonfile=="")
	    {
	    	throw new Exception("Invalid");
	    }
	    String[] users=jsonfile.substring(jsonfile.indexOf("username")-1,jsonfile.length()-1).split(",");
	    String[] w1=users[0].split("(.*):");
	    String[] w2=users[1].split("(.*):");
	    for(String w:w1){  
	    	userval[0]=w;  
	    	}  
	    for(String w:w2){  
	    	userval[1]=w;  
	    }
	    return userval;
	   }
	   catch(Exception e)
	   {
		   userval[0]="";
		   userval[1]="";
		   return userval;
	   }
   }
   public void success()
   {
	   JFrame f
       = new JFrame(
           "User Details Form");
	   JOptionPane
       .showMessageDialog(
          f,
           "Successfully logged in");
   }
   public void unsuccess()
   {
	   JFrame f
       = new JFrame(
           "User Details Form");
	   JOptionPane
       .showMessageDialog(
          f,
           "Invalid user");
   }
   
   public void actionPerformed() {
      
      String[] users= action(this.userName);
      if (users[0] == "" && users[1]=="")
      {
    	  JFrame f
	       = new JFrame(
	           "User Details Form");
		   JOptionPane
	       .showMessageDialog(
	          f,
	           "User not found");
		   this.hide();
		   Signup frame1 = new Signup();
           frame1.setVisible(true);
      }
      this.userName='"'+this.userName+'"';
      this.Password='"'+this.Password+'"';
      if (this.userName.trim().equals(users[0].trim()) && this.Password.trim().equals(users[1].trim())) {
    	  this.hide();
    	  success();
    	  this.hide();
    	  new Goods();
      } else if (!this.userName.trim().equals(users[0].trim()) && this.Password.trim().equals(users[1].trim()))  {
    	  JFrame f
	       = new JFrame(
	           "User Details Form");
    	  JOptionPane
	       .showMessageDialog(
	          f,
	           "Invalid user");
		   this.hide();
         this.hide();
         unsuccess();
         this.hide();
      }
   }
   
}