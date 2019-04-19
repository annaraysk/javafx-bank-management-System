package application;

import javafx.application.Application; 
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*; 
import javafx.stage.*;
import javafx.scene.image.*;
import javafx.scene.paint.*;
import java.io.*;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.scene.text.*;
import javafx.geometry.*; 
import javafx.scene.shape.*;

public class Profile{
    public static void profile(ResultSet rs,Statement st,String userid){
        try{
        	
        	//sql for extracting data for displaying profile:
        	String query="select * from customer_det where login = '"+ userid +"';";
        	rs = st.executeQuery(query);
        	
        	
        	
        Stage myStage = new Stage();
        Image image = new Image(new FileInputStream("face.jpeg"));  
        ImageView imageView = new ImageView(image); 
        imageView.setFitHeight(100); 
        imageView.setFitWidth(100); 
        imageView.setPreserveRatio(true);
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid,600,600);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 25, 25, 75));
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.BLACK, 30));
        grid.add(scenetitle, 0, 0, 11, 1);
        Label imgLabel = new Label();
        imgLabel.setGraphic(imageView);
        HBox hLabel = new HBox(10);
        hLabel.setAlignment(Pos.TOP_RIGHT);
        hLabel.getChildren().add(imageView);
        grid.add(hLabel,0,1);
        
        
        rs.next();
         
        Label accNum = new Label("Account Number:    ");
        grid.add(accNum, 0, 2);
        TextField accNumField = new TextField();
        grid.add(accNumField, 1, 2);
        accNumField.setText(rs.getString(1));
        
        
        Label accType = new Label("Account Type:    ");
        grid.add(accType, 0, 3);
        TextField accTypeField = new TextField();
        grid.add(accTypeField, 1, 3);
        accTypeField.setText(rs.getString(3));
        
        Label balance = new Label("Balance:    ");
        grid.add(balance, 0, 4);
        TextField balField = new TextField();
        grid.add(balField, 1, 4);
        balField.setText(rs.getString(4));
        
        Label fatherName = new Label("Father's Name:    ");
        grid.add(fatherName, 0, 5);
        TextField fatherField = new TextField();
        grid.add(fatherField, 1, 5);
        fatherField.setText(rs.getString(5));
        
        Label motherName  = new Label("Mother's Number:    ");
        grid.add(motherName, 0, 6);
        TextField motherField = new TextField();
        grid.add(motherField, 1, 6);
        motherField.setText(rs.getString(6));
        
        Label add = new Label("Address:  ");
        grid.add(add,0,7);
        TextArea addText = new TextArea();
        addText.setPrefSize(30, 20);
        grid.add(addText, 1, 7);
        addText.setText(rs.getString(7));
        
        Label mobNum = new Label("Mobile Number:    ");
        grid.add(mobNum, 0, 8);
        TextField mobNumField = new TextField();
        grid.add(mobNumField, 1, 8);
        mobNumField.setText(rs.getString(8));
        
        Label cardNum = new Label("Card Number:    ");
        grid.add(cardNum, 0, 9);
        TextField cardNumField = new TextField();
        grid.add(cardNumField, 1, 9);
        cardNumField.setEditable(false);
        cardNumField.setText(rs.getString(10));
        
        Label expDate = new Label("Exp Date:    ");
        grid.add(expDate, 0, 10);
        TextField expDateField = new TextField();
        grid.add(expDateField, 1, 10);
        expDateField.setEditable(false);
        expDateField.setText(rs.getString(11));
        
        Button btn = new Button("Back");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 0, 11);
        btn.setOnAction((e)->LoggedPage.loggedPage(null,null,null));
        Button btn1 = new Button("Close");
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn1.getChildren().add(btn1);
        grid.add(hbBtn1, 1, 11);
        btn1.setOnAction((e)->myStage.close());
        btn.setOnAction((e)->LoggedPage.loggedPage(null,null,null));
        myStage.setScene(scene);
        myStage.setResizable(false);
        myStage.show();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}