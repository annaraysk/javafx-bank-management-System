package application;

import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.*;
import javafx.scene.layout.*; 
import javafx.stage.*; 
import javafx.scene.image.*;
import javafx.scene.paint.*;
import java.io.*;
import java.math.BigInteger;
import javafx.scene.text.*;
import javafx.geometry.*; 
import javafx.scene.shape.*;
import java.security.*; 
import java.sql.*;


public class LoginPage extends Application {
	public String userid;//for profile.java to save the current logged in Id
	static String url = "jdbc:mysql://localhost:3306/bank_management";
	static String user ="root";
	static String pass = "termin111";
    public static void main(String[] args) {
        launch(args);
    }
    public void init(){
        System.out.println("Initialized Scene");
    }
    public void start(final Stage myStage){
        try{
        Connection myCon = DriverManager.getConnection(url, user, pass);
        Statement st = myCon.createStatement();
        MessageDigest md = MessageDigest.getInstance("MD5");  

        myStage.setTitle("Bank Application");
        FlowPane rootNode = new FlowPane();
        GridPane grid = new GridPane();
        GridPane grid1 = new GridPane();
        Button b = new Button("RVCE CAMPUS BANK");
        b.setFont(Font.font("Times New Roman",40));
        b.setTextFill(Color.web("#CF245F"));
        Scene scene1 = new Scene(b,600,500); //entrace
        Scene scene2 = new Scene(rootNode,400,400);//login page
        b.setOnAction((ae)->{myStage.setScene(scene2);});

        //label for the heading
        Label l = new Label("RVCE BANKING");
        l.setTextFill(Color.web("#ff0000", 1));
        l.setFont(new Font("Times New Roman", 30));
        // the login and singup button
        Button b1 = new Button("Log In");
       
        Button b2 = new Button("Sign Up");
        b1.setMaxWidth(Double.MAX_VALUE);
        b2.setMaxWidth(Double.MAX_VALUE);
        Scene scene4 = new Scene(grid1,600,450);
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(15);
        grid1.setVgap(15);
        grid1.setPadding(new Insets(20, 20, 20, 50));
        Text scenetitle = new Text("Please Enter your Details: ");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 30));
        grid1.add(scenetitle, 0, 0, 5, 1);
        Label loginName = new Label("Email ID :    ");
        loginName.setFont(new Font("Times New Roman", 18));
        grid1.add(loginName, 0, 1);
        TextField loginNameField = new TextField();
        grid1.add(loginNameField, 1, 1);
        Label petName = new Label("What was the name of your fav pet?");
        petName.setFont(new Font("Times New Roman", 18));
        grid1.add(petName, 0, 2);
        TextField petNameField = new TextField();
        grid1.add(petNameField, 1, 2);
        Label colorId = new Label("What is your fav color?: \n  ");
        colorId.setFont(new Font("Times New Roman", 18));
        grid1.add(colorId, 0, 3);
        TextField colorField = new TextField();
        grid1.add(colorField, 1, 3);
        Label bestFriend = new Label("Name of your Best Friend: \n ");
        bestFriend.setFont(new Font("Times New Roman", 18));
        grid1.add(bestFriend, 0, 4);
        TextField bfField = new TextField();
        grid1.add(bfField, 1, 4);
        Button btn = new Button("Submit");
        
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid1.add(hbBtn, 1, 9);
        GridPane grid3 = new GridPane();
        Scene scene5 = new Scene(grid3,600,400);
        btn.setOnAction((e)->{ 
        	String sqll = "select * from customer_det where login = '"+loginNameField.getText()+"';";
        	System.out.println(sqll);
        	try {
        		ResultSet newrs1 = st.executeQuery(sqll);
        		if (newrs1.next())
        		{
        			if(newrs1.getString("pet").contentEquals(petNameField.getText()) && newrs1.getString("bestf").equals(bfField.getText()) && newrs1.getString("favCol").equals(colorField.getText()) && newrs1.getString("login").contentEquals(loginNameField.getText())){
        				//code for password changed
        				myStage.setScene(scene5);
        	
        			}	
        		}
        		else {
        			loginNameField.setText("");
        			petNameField.setText("");
        			bfField.setText("");
        			colorField.setText("");
        		}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        });
        
        
        

        grid3.setAlignment(Pos.CENTER);
        grid3.setHgap(15);
        grid3.setVgap(15);
        grid3.setPadding(new Insets(20, 20, 20, 50));
        scenetitle = new Text("Update Password: ");
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 30));
        grid3.add(scenetitle, 0, 0, 5, 1);
        Label newPass = new Label("Enter New Password:    ");
        grid3.add(newPass, 0, 1);
        TextField newPassField = new TextField();
        grid3.add(newPassField, 1, 1);
        Label cnewPass = new Label("Confirm New Password:    ");
        grid3.add(cnewPass, 0, 2);
        TextField cnewPassField = new TextField();
        grid3.add(cnewPassField, 1, 2);
        Button btnpwd = new Button("Submit");
        HBox hbBtnpwd = new HBox(10);
        hbBtnpwd.setAlignment(Pos.BOTTOM_LEFT);
        hbBtnpwd.getChildren().add(btnpwd);
        grid3.add(hbBtnpwd, 1, 4);
        btnpwd.setOnAction((e)->{
        	if (newPassField.getText().contentEquals(cnewPassField.getText()))
        		{	
     	       
				String newsql2 = "UPDATE customer_det SET password=MD5('"+newPassField.getText()+"') where login='a@gmail.com';";
				try {
					st.executeUpdate(newsql2);
					System.out.println("password updated");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        			myStage.setScene(scene2);
        		}
        	else {
        		newPassField.setText("");
        		cnewPassField.setText("");
        	}
        	
        });
        
        Scene scene3 = new Scene(grid,600,800);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 75));
        scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 14, 1);
        Label firstName = new Label("First Name:    ");
        grid.add(firstName, 0, 1);
        TextField firstNameField = new TextField();
        grid.add(firstNameField, 1, 1);
        
        Label lastName = new Label("Last Name:     ");
        grid.add(lastName, 0, 2);
        TextField lastNameField = new TextField();
        grid.add(lastNameField, 1, 2);
        Label fatherName = new Label("Father Name:     ");
        grid.add(fatherName, 0, 3);
        TextField fatherField = new TextField();
        grid.add(fatherField, 1, 3);
        Label motherName = new Label("Mother Name:     ");
        grid.add(motherName, 0, 4);
        TextField motherField = new TextField();
        grid.add(motherField, 1, 4);
        
        
        
        Label acc_no = new Label("Account Number:         ");
        grid.add(acc_no, 0, 5);
        TextField acc_noField = new TextField();
        grid.add(acc_noField, 1, 5);
        
        Label ccNo = new Label("CC Number:   ");
        grid.add(ccNo, 0, 6);
        TextField ccNoField = new TextField();
        grid.add(ccNoField, 1, 6);
        Label email = new Label("Email:           ");
        grid.add(email, 0, 7);
        TextField emailId = new TextField();
        grid.add(emailId, 1, 7);
        Label pw = new Label("Password:           ");
        grid.add(pw, 0, 8);
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 8);
        Label cpw = new Label("Confirm Password: ");
        grid.add(cpw, 0, 9);
        PasswordField cpwBox = new PasswordField();
        grid.add(cpwBox, 1, 9);
        Label add = new Label("Address:           ");
        grid.add(add,0,10);
        TextArea addText = new TextArea();
        addText.setPrefSize(30, 20);
        grid.add(addText, 1, 10);
        Label city = new Label("City :          ");
        grid.add(city, 0, 11);
        TextField cityField = new TextField();
        grid.add(cityField, 1, 11);
        Label mob = new Label("Mob No. :          ");
        grid.add(mob, 0, 12);
        TextField mobNo = new TextField();
        grid.add(mobNo, 1, 12);
        Label pan = new Label("Pan No. :          ");
        grid.add(pan, 0, 13);
        TextField panNo = new TextField();
        grid.add(panNo, 1, 13);
        Label bestf = new Label("Best friend :          ");
        grid.add(bestf, 0, 14);
        TextField bfNo = new TextField();
        grid.add(bfNo, 1, 14);
        Label favCol = new Label("Favourite Colour :          ");
        grid.add(favCol, 0, 15);
        TextField favcolNo = new TextField();
        grid.add(favcolNo, 1, 15);
        Label pet = new Label("Pet Name :          ");
        grid.add(pet, 0, 16);
        TextField petn = new TextField();
        grid.add(petn, 1, 16);
        btn = new Button("Submit");
        btn.setOnAction((e)->{
        	String sql_submit;
        	if(pwBox.getText().equals(cpwBox.getText()))
        	{
        		String acc_holder_name = firstNameField.getText()+" "+lastNameField.getText();
        		sql_submit = "insert into customer_det values ("+acc_noField.getText()+",'"+acc_holder_name+"','DEFAULT',500,'"+fatherField.getText()+"','"+motherField.getText()+"','"+addText.getText()+"','"+mobNo.getText()+"','";
        		sql_submit = sql_submit+cityField.getText()+"','"+ccNoField.getText()+"',\"2029-01-01\""+",'"+emailId.getText()+"',"+"MD5('"+pwBox.getText()+"'"+"),'"+bfNo.getText()+"','"+petn.getText()+"','"+favcolNo.getText()+"' );";
        		System.out.println(sql_submit);
        		try {
					int success_val = st.executeUpdate(sql_submit);
					if (success_val!=0)
					{
						System.out.print("done");
						myStage.setScene(scene2);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        	}
        	else {
        		pwBox.setText("");
        		cpwBox.setText("");
        		
        	}
        });
        
        hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 17);
        b2.setOnAction((ae)->{
        	myStage.setScene(scene3);
        	});
        
        //myStage.setScene(scene3);
        //password and username field
        TextField t1 = new TextField();
        PasswordField p1 = new PasswordField();
        //p1.setText();
        
        //System.out.print("usr="+usr);
        b1.setOnAction((ae)->{
        	
        	boolean conditionForLogin = false;
        	
        	try {
				
				String usr = t1.getText();
		        String pas = p1.getText();
		        String sql1 = "select * from customer_det where login = '"+usr+"' and password= MD5('"+pas+"');";
		        ResultSet rs = st.executeQuery(sql1);
				System.out.print("\nexecuted query successfully\nusername == "+t1.getText()+"\n"+sql1);
				if (rs.next()) {
					userid=usr;  //to save the current user id because to display the profile of that id
					String newsql2 = "insert into login_info values ('"+usr+"',timestampadd(WEEK,0,CURRENT_TIMESTAMP),'yes');";
					st.executeUpdate(newsql2);
					System.out.println("added login info");
					rs=st.executeQuery(sql1);
					rs.next();
					System.out.println(rs.getString(5));
					
					LoggedPage.loggedPage(rs,st,userid);
					
				}
				else
        		{
        		t1.setText("");
        		p1.setText("");
        		}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	//rs.getString(1);
        	
        	
        	
        });
        Hyperlink button = new Hyperlink("               Forgot Password");
        button.setOnAction(e -> myStage.setScene(scene4));
        FileInputStream input = new FileInputStream("backGround.jpeg"); 
        Image image = new Image(input); 
        BackgroundImage backgroundimage = new BackgroundImage(image,BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT); 
        Background background = new Background(backgroundimage);
        VBox vb = new VBox(10);
        vb.setPadding(new Insets(5, 50, 50, 120));
        vb.getChildren().addAll(t1,p1,button,b1,b2);
        HBox hb = new HBox(50);
        hb.setPadding(new Insets(50, 50, 50, 100));
        hb.getChildren().add(l);
        rootNode.setBackground(background);
        rootNode.getChildren().addAll(hb,vb);
        myStage.setScene(scene1);
        myStage.setOpacity(0.85);
        myStage.setResizable(false);
        myStage.show();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void stop(){
        System.out.println("Ending Scene");
    }
}


