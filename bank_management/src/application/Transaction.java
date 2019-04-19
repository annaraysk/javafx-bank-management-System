package application;


import javafx.application.Application; 
import javafx.scene.*; 
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*; 
import javafx.stage.*; 
import javafx.scene.image.*;
import javafx.scene.paint.*;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.text.*;
import javafx.geometry.*; 
import javafx.scene.shape.*;


public class Transaction{
    public static void transaction(ResultSet rs,Statement st,String userid){
        Stage myStage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root,600,400);
        
        //For all the 3 buttons
        Button b1 = new Button("Money Received");
        b1.setTranslateX(5);
        b1.setTranslateY(100);
        Button b2 = new Button("Money Sent");
        b2.setTranslateY(150);
        b2.setTranslateX(5);
        Button b3 = new Button("Send Money");
        b3.setTranslateY(200);
        b3.setTranslateX(5);

        b1.setPrefWidth(130);
        b2.setPrefWidth(130);
        b3.setPrefWidth(130);
        
        
		b1.setOnAction((e)->{
        	System.out.println("Transactions involving money Recieved\nFrom\tTo\tamount\tdate and time\t\n");
        	try {
				String newsql7 = "select * from transactions where login2='"+rs.getString("login") +"';";
				ResultSet newrs3 = st.executeQuery(newsql7);
				while (newrs3.next())
				{
					System.out.println(newrs3.getString(1)+"\t"+newrs3.getString(2	)+"\t"+newrs3.getString(3)+"\t"+newrs3.getString(4));
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        
        b2.setOnAction((e)->{
        	System.out.println("Transactions involving money sent\nFrom\tTo\tamount\tdate and time\t\n");
        	try {
				String newsql7 = "select * from transactions where login='"+rs.getString("login")+"';";
				System.out.println(newsql7);
				ResultSet newrs3 = st.executeQuery(newsql7);
				while (newrs3.next())
				{
					System.out.println(newrs3.getString(1)+"\t"+newrs3.getString(2)+"\t"+newrs3.getString(3)+"\t"+newrs3.getString(4));
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        
        //For the table:

        Label label = new Label("Transaction Details:");
        label.setFont(new Font("Times New Roman", 20));
        label.setTranslateX(150);
        label.setTranslateY(100);

        TableView table = new TableView();
        table.setPrefHeight(200);
        table.setPrefWidth(350);
        table.setTranslateX(150);
        table.setTranslateY(70);
        table.setEditable(false);
 
        TableColumn dateCol = new TableColumn("Date");
        TableColumn timeCol = new TableColumn("Time");
        TableColumn accTransferedCol = new TableColumn("Account No.(transfered)");
        TableColumn updatedBalCol = new TableColumn("Updated Balance");
        
        table.getColumns().addAll(dateCol, timeCol, accTransferedCol,updatedBalCol);
 
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);


        //For the reconfirmation of the password

        FlowPane r = new FlowPane();
        Scene scene2 = new Scene(r,600,200);
        label = new Label("Enter the transaction Password:");
        label.setFont(new Font("Times New Roman", 20));
        label.setTranslateX(25);
        label.setTranslateY(75);
        TextField t = new TextField();
        t.setTranslateX(75);
        t.setTranslateY(75);
        Button b = new Button("OK!");
        b.setTranslateY(135);
        b.setTranslateX(60);
        r.getChildren().addAll(label,t,b);


        //calling for transaction
        b3.setOnAction((e)->myStage.setScene(scene2));


        r = new FlowPane();
        Scene scene3 = new Scene(r,600,250);
        label = new Label("Enter the Account No. for Transaction: ");
        label.setFont(new Font("Times New Roman", 20));
        label.setTranslateX(25);
        label.setTranslateY(50);
        TextField tt = new TextField();
        tt.setTranslateX(75);
        tt.setTranslateY(50);
        Label label1 = new Label("Enter the Amount: ");
        label1.setFont(new Font("Times New Roman", 20));
        label1.setTranslateX(25);
        label1.setTranslateY(100);
        TextField t1 = new TextField();
        t1.setTranslateX(240);
        t1.setTranslateY(100);
        Button btn1 = new Button("Back!");
        btn1.setTranslateY(145);
        btn1.setOnAction((e)->myStage.close());
        Button btn2 = new Button("OK!");
        
        btn2.setTranslateY(145);
        btn2.setTranslateX(60);
        btn2.setOnAction((e)->{
        	String temp=t1.getText();
        	System.out.println(temp);
        	int amt= Integer.parseInt(temp);
        	String to=tt.getText();
        	System.out.println("Request To send money ("+amt+") to the account_no :" + to);
        	sendMoney(userid,to,rs,st,amt);
        });
        
        r.getChildren().addAll(label,tt,label1,t1,btn1,btn2);


        //doing the actual transaction
        b.setOnAction((e)->{
        	System.out.println(t.getText());
        	myStage.setScene(scene3);
        	
        });


        root.getChildren().addAll(vbox,b1,b2,b3);
        myStage.setScene(scene);
        myStage.show();
    }
    public static void sendMoney(String from,String to,ResultSet rs,Statement st,int amount)
    {   
    	try
    	{
    		String fromq="select balance from customer_det where login = '"+from +"';";
    		System.out.println(fromq);
        	rs=st.executeQuery(fromq);
        	rs.next();
        	int fbal =rs.getInt(1);
        	String toq="select * from customer_det where account_no = '"+to +"';";
        	rs=st.executeQuery(toq);
        	rs.next();
        	String login_for = rs.getString("login");
        	int tbal =rs.getInt(1);
        	System.out.println("balance = "+fbal);
        	if(fbal>=amount)
        	{
        		fbal=fbal-amount;
        		tbal=tbal+amount;
        		System.out.println(fbal+" "+tbal+" "+amount);
        		fromq="update customer_det set balance ="+ fbal+" where login='"+from+"';";
        		int i=st.executeUpdate(fromq);
        		toq="update customer_det set balance ="+ tbal+" where account_no='"+to+"';";
        		System.out.println(fromq);
        		System.out.println(toq);
        		i=st.executeUpdate(toq);
        		String sql8 = "insert into transcations values ('"+from+"','"+login_for+"',"+amount+",current_timestamp);";
        		st.executeUpdate(sql8);
        		
        	}
        	else {
        		Alert a = new Alert(AlertType.INFORMATION);
        		a.setContentText("Insufficient Balance");
        		a.show();
        	}
        	
        	
        	
    	}catch(Exception e) {}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}