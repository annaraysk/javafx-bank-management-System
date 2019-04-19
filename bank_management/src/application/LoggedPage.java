package application;

import javafx.application.Application; 
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*; 
import javafx.stage.*;
import javafx.scene.image.*;
import javafx.scene.paint.*;
import java.io.*;
import java.sql.*;

import javafx.scene.text.*;
import javafx.geometry.*; 
import javafx.scene.shape.*;


public class LoggedPage{
    public static void loggedPage(ResultSet rs,Statement st,String userid){
        Stage myStage = new Stage();
        try{
        Image image = new Image(new FileInputStream("Rvce_logo.jpg"));  
        ImageView imageView = new ImageView(image); 
        imageView.setFitHeight(100); 
        imageView.setFitWidth(100); 
        imageView.setPreserveRatio(true);
        Group root = new Group(imageView);
        Scene scene = new Scene(root,600,400);
        Label l1 = new Label("Account Overview");
        l1.setFont(new Font("Times New Roman",25));
        l1.setTranslateX(90);
        Label l2 = new Label("Balance:");
        l2.setFont(new Font("Times New Roman",20));
        l2.setTranslateX(400);
        TextField t1 = new TextField();
        t1.setTranslateX(480);
        t1.setPrefWidth(80);
        t1.setText(rs.getString("balance"));
        t1.setEditable(false);
        Label l3 = new Label("Rs.");
        l3.setFont(new Font("Times New Roman",20));
        l3.setTranslateX(565);
        Button b1 = new Button("Login History");
        b1.setTranslateX(120);
        b1.setTranslateY(75);
        b1.setPrefWidth(100);
        b1.setOnAction(e->{
        	try {
				String newsql3 = "select * from login_info where login = '"+rs.getString("login")+"';";
				ResultSet newrs2 = st.executeQuery(newsql3);
				if (newrs2.next())
				{
					do {
						System.out.println(newrs2.getString("date"));
					}while (newrs2.next());
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        //Loans Button and related work
        Button b2 = new Button("Loans");
        b2.setTranslateX(250);
        b2.setTranslateY(75);
        b2.setPrefWidth(100);
        b2.setOnAction((e)->Loan.loan());

        
        
        //Transaction button and related Work
        Button b3 = new Button("Transactions");
        b3.setTranslateX(380);
        b3.setTranslateY(75);
        b3.setPrefWidth(100);
        b3.setOnAction((e)->Transaction.transaction(rs,st,userid));

    
        double r=15;
        Button btn1 = new Button();
        btn1.setShape(new Circle(r));
        btn1.setMinSize(2*r, 2*r);
        btn1.setMaxSize(2*r, 2*r);
        MenuButton btn2 = new MenuButton();
        btn2.setShape(new Circle(r));
        btn2.setMinSize(2*r, 2*r);
        btn2.setMaxSize(2*r, 2*r);


        //all functionalities for m1
        MenuItem m1 = new MenuItem("Change UserName");
        GridPane grid = new GridPane();
        Scene scene1 = new Scene(grid,430,250);
        Text scenetitle = new Text("Changing UserName");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.BLACK, 26));
        grid.add(scenetitle, 0, 0, 3, 1);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 25, 25, 75));
        Label curPwd = new Label("Current Password:    ");
        grid.add(curPwd, 0, 1);
        TextField curPwdField = new TextField();
        grid.add(curPwdField, 1, 1);
        Label newUser = new Label("New User Name:    ");
        grid.add(newUser, 0, 2);
        TextField newUserField = new TextField();
        grid.add(newUserField, 1, 2);
        Button btn = new Button("Back");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 0, 3);
        btn.setOnAction((e)->myStage.close());
        Button btn_1 = new Button("Submit");
        HBox hbBtn_1 = new HBox(10);
        hbBtn_1.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn_1.getChildren().add(btn_1);
        grid.add(hbBtn_1, 1, 3);
        Alert a = new Alert(AlertType.NONE);
        btn_1.setOnAction((e)->{
        	try {
				System.out.println("\n\nfor changing username\npresent username and pass = "+rs.getString("login"));
				String newsql4 = " update customer_det set login = '"+newUserField.getText()+"' where login ='"+rs.getString("login")+"' and password=MD5('"+curPwdField.getText()+"');";
				System.out.println(newsql4);
				st.executeUpdate(newsql4);
				System.out.println("username changed ");
        	} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	a.setAlertType(AlertType.INFORMATION); 
        	a.setContentText("User Name has been changed!"); 
        	a.show();
        });
        m1.setOnAction(e->myStage.setScene(scene1));


        //all the functionalities for m2
        MenuItem m2 = new MenuItem("Change Password");
        GridPane grid2 = new GridPane();
        Scene scene2 = new Scene(grid2,430,250);
        scenetitle = new Text("Changing Password");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.BLACK, 26));
        grid2.add(scenetitle, 0, 0, 3, 1);
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(10, 25, 25, 75));
        Label curPwd1 = new Label("Current Password:    ");
        grid2.add(curPwd1, 0, 1);
        TextField curPwdField1 = new TextField();
        grid2.add(curPwdField1, 1, 1);
        Label newUser1 = new Label("New Password:    ");
        grid2.add(newUser1, 0, 2);
        TextField newUserField1 = new TextField();
        grid2.add(newUserField1, 1, 2);
        btn = new Button("Back");
        HBox hb = new HBox(10);
        hb.setAlignment(Pos.BOTTOM_LEFT);
        hb.getChildren().add(btn);
        grid2.add(hb, 0, 3);
        btn.setOnAction((e)->myStage.close());
        btn_1 = new Button("Submit");
        HBox hbBtn_2 = new HBox(10);
        hbBtn_2.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn_2.getChildren().add(btn_1);
        grid2.add(hbBtn_2, 1, 3);
        Alert a1 = new Alert(AlertType.NONE);
        btn_1.setOnAction((e)->{
        	 try {
				String newsql5 = "update customer_det set password=MD5('"+newUserField1.getText()+"') where login='"+rs.getString("login")+"' and password=MD5('"+curPwdField1.getText()+"');";
				st.executeUpdate(newsql5);
				System.out.println(newsql5);
				System.out.println("password changed successfully\n");
        	 } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	a1.setAlertType(AlertType.INFORMATION); 
        	a1.setContentText("Password has been updated!"); 
        	a1.show();
        });
        m2.setOnAction((e)->myStage.setScene(scene2));
        //all functionalities for m3;
        MenuItem m3 = new MenuItem("Change Other Info.");
        GridPane grid3 = new GridPane();
        Scene scene3 = new Scene(grid3,600,600);
        grid3.setAlignment(Pos.CENTER);
        grid3.setHgap(10);
        grid3.setVgap(10);
        grid3.setPadding(new Insets(10, 25, 25, 75));
        scenetitle = new Text("Change other Info.");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.BLACK, 30));
        grid3.add(scenetitle, 0, 0, 8, 1);
        Label imgLabel = new Label();
        Image image1 = new Image(new FileInputStream("face.jpeg"));  
        ImageView imageView1 = new ImageView(image1); 
        imageView1.setFitHeight(100); 
        imageView1.setFitWidth(100); 
        imageView1.setPreserveRatio(true);
        imgLabel.setGraphic(imageView1);
        HBox hLabel = new HBox(10);
        hLabel.setAlignment(Pos.TOP_RIGHT);
        hLabel.getChildren().add(imageView1);
        grid3.add(hLabel,0,1);
        Label accNo = new Label("Account Number:    ");
        grid3.add(accNo, 0, 2);
        TextField accNumField = new TextField();
        grid3.add(accNumField, 1, 2);
        accNumField.setText(rs.getString("account_no"));
        accNumField.setEditable(false);
        Label accType = new Label("Account Type:    ");
        grid3.add(accType, 0, 3);
        TextField accTypeField = new TextField();
        grid3.add(accTypeField, 1, 3);
        accTypeField.setText(rs.getString("account_type"));
        Label fatherName = new Label("Father's Name:    ");
        grid3.add(fatherName, 0, 4);
        TextField fatherField = new TextField();
        grid3.add(fatherField, 1, 4);
        fatherField.setText(rs.getString("father_name"));
        Label motherName  = new Label("Mother's Number:    ");
        grid3.add(motherName, 0, 5);
        TextField motherField = new TextField();
        grid3.add(motherField, 1, 5);
        motherField.setText(rs.getString("mother_name"));
        Label add = new Label("Address:  ");
        grid3.add(add,0,6);
        TextArea addText = new TextArea();
        addText.setPrefSize(30, 20);
        grid3.add(addText, 1, 6);
        addText.setText(rs.getString("address"));
        Label mobNum = new Label("Mobile Number:    ");
        grid3.add(mobNum, 0, 7);
        TextField mobNumField = new TextField();
        grid3.add(mobNumField, 1, 7);
        mobNumField.setText(rs.getString("ph_no"));
        Button bt = new Button("Back");
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn2.getChildren().add(bt);
        grid3.add(hbBtn2, 0, 8);
        btn.setOnAction((e)->myStage.close());
        Button btn_2 = new Button("Submit");
        HBox hbBtn_3 = new HBox(10);
        hbBtn_3.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn_3.getChildren().add(btn_2);
        grid3.add(hbBtn_3, 1, 8);
        Alert a2 = new Alert(AlertType.NONE);
        btn_2.setOnAction((e)->{
        	try {
				String newsql6 =  "update customer_det set account_type='"+accTypeField.getText()+"',father_name='"+fatherField.getText()+"', mother_name='"+motherField.getText()+"', address='"+addText.getText()+"',ph_no = '"+mobNumField.getText()+"' where login='"+rs.getString("login")+"';";
				st.executeUpdate(newsql6);
				System.out.println("updated details");
        	} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}    
        	a2.setAlertType(AlertType.CONFIRMATION);
        	a2.setContentText("The changes are saved!!");
        	a2.show();
        });
        m3.setOnAction(e->myStage.setScene(scene3));
        //end of all the drop menu
        btn2.getItems().addAll(m1, m2, m3);
        Button btn3 = new Button();
        btn3.setShape(new Circle(r));
        btn3.setMinSize(2*r, 2*r);
        btn3.setMaxSize(2*r, 2*r);
        image = new Image(new FileInputStream("face.jpeg"));  
        Circle cir1 = new Circle(0,300,14); 
        cir1.setFill(new ImagePattern(image));
        image = new Image(new FileInputStream("Settings_black.png"));  
        Circle cir2 = new Circle(0,335,14); 
        cir2.setFill(new ImagePattern(image));
        image = new Image(new FileInputStream("powerButton.jpeg"));  
        Circle cir3 = new Circle(0,370,14);
        cir3.setFill(new ImagePattern(image));
        btn1.setGraphic(cir1);
        btn2.setGraphic(cir2);
        btn3.setGraphic(cir3);
        btn1.setTranslateY(300);
        btn2.setTranslateY(335);
        btn3.setTranslateY(370);
        btn1.setOnAction((e)->Profile.profile(rs,st,userid));
        btn3.setOnAction((e)->myStage.close());



        //for the table for the login details!!!
        Label label = new Label("Login Details");
        label.setFont(new Font("Arial", 20));
        label.setTranslateX(210);
        label.setTranslateY(100);

        TableView table = new TableView();
        table.setPrefHeight(200);
        table.setPrefWidth(350);
        table.setTranslateX(120);
        table.setTranslateY(105);
        table.setEditable(false);
 
        TableColumn dateCol = new TableColumn("Date");
        TableColumn timeCol = new TableColumn("Time");
        TableColumn emailCol = new TableColumn("Email");
        
        table.getColumns().addAll(dateCol, timeCol, emailCol);
 
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        root.getChildren().addAll(l1,l2,t1,l3,vbox,btn1,btn2,btn3,b1,b2,b3);
        myStage.setScene(scene);
        myStage.setResizable(false);
        myStage.show();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}