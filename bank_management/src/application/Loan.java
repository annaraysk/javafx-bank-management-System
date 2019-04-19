package application;

import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*; 
import javafx.stage.*; 
import javafx.scene.image.*;
import javafx.scene.paint.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.text.*;
import javafx.geometry.*; 
import javafx.scene.shape.*;


public class Loan{
	static String url = "jdbc:mysql://localhost:3306/bank_management";
	static String user ="root";
	static String pass = "termin111";
    public static void loan(){
    	Connection myCon = null;
		try {
			myCon = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			Statement st = myCon.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        Stage myStage = new Stage();
        GridPane root = new GridPane();
        Scene scene = new Scene(root,300,300);
        root.setAlignment(Pos.CENTER);
        root.setHgap(15);
        root.setVgap(15);
        root.setPadding(new Insets(15, 20, 20, 50));


        //All the loan related to Home related stuff
        Button b1 = new Button("Home Loan");
        root.add(b1,0,1);
        GridPane root1 = new GridPane();
        Scene scene2 = new Scene(root1,500,400);
        root1.setAlignment(Pos.CENTER);
        root1.setHgap(10);
        root1.setVgap(10);
        root1.setPadding(new Insets(10, 25, 25, 75));
        
        //confirmation of the loan
        Text scenetitle = new Text("Welcome to Home Loan");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.BLACK, 30));
        root1.add(scenetitle, 0, 0, 5, 1);
        Label panNum = new Label("Enter your Pan Number:    ");
        root1.add(panNum, 0, 1);
        TextField panField = new TextField();
        root1.add(panField, 1, 1);
        Label amt = new Label("Enter the Amount:    ");
        root1.add(amt, 0, 2);
        TextField amtField = new TextField();
        root1.add(amtField, 1, 2);
        Button btn1 = new Button("Close");
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn1.getChildren().add(btn1);
        btn1.setOnAction((e)->myStage.close());
        root1.add(hbBtn1, 1, 3);
        Button btn2 = new Button("OK");
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn2.getChildren().add(btn2);
        root1.add(hbBtn2, 0, 3);
        b1.setOnAction((e)->myStage.setScene(scene2));

        //form submission for the loan application
        GridPane grid = new GridPane();
        Scene scene3 = new Scene(grid,600,400);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 25, 25, 75));
        scenetitle = new Text("Application Form");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.BLACK, 30));
        grid.add(scenetitle, 0, 0, 5, 1);
        Label loanName = new Label("Enter Name:    ");
        grid.add(loanName, 0, 1);
        TextField loanNameField = new TextField();
        grid.add(loanNameField, 1, 1);
        Label loanamt = new Label("Loan Amount Field:    ");
        grid.add(loanamt, 0, 2);
        TextField loanamtField = new TextField();
        grid.add(loanamtField, 1, 2);
        Label dur = new Label("Enter Duration:    ");
        grid.add(dur, 0, 3);
        TextField durField = new TextField();
        grid.add(durField, 1, 3);
        Label text = new Label("I agree to the terms and condition");
        grid.add(text, 1, 4);
        text.setFont(new Font("Times New Roman",15));
        final CheckBox c1 = new CheckBox();
        grid.add(c1,0,4);
        Button btn3 = new Button("SUBMIT");
        HBox hbBtn3 = new HBox(10);
        hbBtn3.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn3.getChildren().add(btn3);
        grid.add(hbBtn3, 0, 5);
        btn3.setDisable(true);
        c1.setOnAction((e)->{btn3.setDisable(false);});
        btn3.setOnAction((e)->{Alert a = new Alert(AlertType.INFORMATION);if(c1.isSelected()){
        a.setContentText("Application Submitted!");}else{a.setContentText("Accept the condition!");}a.show();});
        btn2.setOnAction((e)->myStage.setScene(scene3));


        
        
        //Loans related to Education
        Button b2 = new Button("Education Loan");
        root.add(b2,0,2);
        GridPane root2 = new GridPane();
        Scene scene4 = new Scene(root2,500,400);
        root2.setAlignment(Pos.CENTER);
        root2.setHgap(10);
        root2.setVgap(10);
        root2.setPadding(new Insets(10, 25, 25, 75));
        
        //confirmation of the loan
        scenetitle = new Text("Welcome to Education Loan");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.BLACK, 30));
        root2.add(scenetitle, 0, 0, 5, 1);
        panNum = new Label("Enter your Pan Number:    ");
        root2.add(panNum, 0, 1);
        panField = new TextField();
        root2.add(panField, 1, 1);
        amt = new Label("Enter the Amount:    ");
        root2.add(amt, 0, 2);
        amtField = new TextField();
        root2.add(amtField, 1, 2);
        btn1 = new Button("Close");
        hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn1.getChildren().add(btn1);
        btn1.setOnAction((e)->myStage.close());
        root2.add(hbBtn1, 1, 4);
        btn2 = new Button("OK");
        hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn2.getChildren().add(btn2);
        root2.add(hbBtn2, 0, 4);
        b2.setOnAction((e)->myStage.setScene(scene4));

        
        //form Submission for Education loan
        GridPane grid1 = new GridPane();
        Scene scene5 = new Scene(grid1,600,400);
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.setPadding(new Insets(10, 25, 25, 75));
        scenetitle = new Text("Application Form");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.BLACK, 30));
        grid1.add(scenetitle, 0, 0, 6, 1);
        loanName = new Label("Enter Name:    ");
        grid1.add(loanName, 0, 1);
        loanNameField = new TextField();
        grid1.add(loanNameField, 1, 1);
        loanamt = new Label("Loan Amount Field:    ");
        grid1.add(loanamt, 0, 2);
        loanamtField = new TextField();
        grid1.add(loanamtField, 1, 2);
        dur = new Label("Enter Duration:    ");
        grid1.add(dur, 0, 3);
        durField = new TextField();
        grid1.add(durField, 1, 3);
        Label institute = new Label("Name of the Institute:    ");
        grid1.add(institute, 0, 4);
        TextField instField = new TextField();
        grid1.add(instField, 1, 4);
        text = new Label("I agree to the terms and condition");
        grid1.add(text, 1, 5);
        text.setFont(new Font("Times New Roman",15));
        final CheckBox c = new CheckBox();
        grid1.add(c,0,5);
        final Button btn4 = new Button("SUBMIT");
        hbBtn3 = new HBox(10);
        hbBtn3.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn3.getChildren().add(btn4);
        grid1.add(hbBtn3, 1, 6);
        btn4.setDisable(true);
        c.setOnAction((e)->{btn4.setDisable(false);});
        btn4.setOnAction((e)->{Alert a = new Alert(AlertType.INFORMATION);if(c.isSelected()){
        a.setContentText("Application Submitted!");}else{a.setContentText("Accept the condition!");}a.show();});
        btn2.setOnAction((e)->myStage.setScene(scene5));
        
        
        
        
        
        //To check for the loans already sanctioned
        Button b3 = new Button("Loan Status");
        root.add(b3,0,3);
        FlowPane f = new FlowPane();
        Scene scene1 = new Scene(f,600,600);
        Label label = new Label("Loans Sanctioned:");
        label.setFont(new Font("Times New Roman", 20));
        label.setTranslateX(150);
        label.setTranslateY(100);

        //table for the loan Sanctioned
        TableView table = new TableView();
        table.setPrefHeight(400);
        table.setPrefWidth(400);
        table.setTranslateX(100);
        table.setTranslateY(100);
        table.setEditable(false);
 
        TableColumn dateCol = new TableColumn("Date of Sanction");
        TableColumn timeCol = new TableColumn("Time");
        TableColumn amtCol = new TableColumn("Amount Sanctioned");
        TableColumn leftBalCol = new TableColumn("Amount To be stilled Payed");
        
        table.getColumns().addAll(dateCol, timeCol, amtCol,leftBalCol);
 
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
        f.getChildren().add(vbox);

        //calling the loan status method
        b3.setOnAction((e)->{
        
        	System.out.println("");
        myStage.setScene(scene1);
        });
        
        //setting the properties of the buttons
        b1.setMaxWidth(Double.MAX_VALUE);
        b2.setMaxWidth(Double.MAX_VALUE);
        b3.setMaxWidth(Double.MAX_VALUE);



        //setting the title
        scenetitle = new Text("Loans: ");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 30));
        root.add(scenetitle, 0, 0, 3, 1);
        myStage.setScene(scene);
        myStage.show();
    }
}