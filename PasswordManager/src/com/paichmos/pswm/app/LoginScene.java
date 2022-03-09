package com.paichmos.pswm.app;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.paichmos.api.FileSystem;
import com.paichmos.api.Scene;
import com.paichmos.api.controls.PButton;

public class LoginScene extends Scene{

	private static final long serialVersionUID = 1L;
     
	PButton btnLogin = new PButton();
	PButton btnSignIn = new PButton();
	
	JTextField username = new JTextField();
	JTextField password = new JTextField();
	
	//960
	//540
	
	@Override
	public void OnStart() {
		setLayout(null);
		
		manager.parent.setTitle("Login Page");
        
		//Bottone di login
		btnLogin.setText("Log In");
		btnLogin.setSize(100,64);
		btnLogin.setBorder(null);
		btnLogin.setColorOver(Color.red);
		btnLogin.setColorClick(Color.blue);
		btnLogin.setLocation((manager.parent.getWidth()/2)-(btnLogin.getWidth()/2)-55,manager.parent.getHeight()-((30)+btnLogin.getHeight()*2));
		
		//Bottone di registrazione
		btnSignIn.setText("Sign In");
		btnSignIn.setSize(100,64);
		btnSignIn.setBorder(null);
		btnSignIn.setColorOver(Color.red);
		btnSignIn.setColorClick(Color.blue);
		btnSignIn.setLocation((manager.parent.getWidth()/2)-(btnSignIn.getWidth()/2)+55,manager.parent.getHeight()-((30)+btnSignIn.getHeight()*2));
		
		System.out.println(btnSignIn.getY());
		
		//username
		username.setSize(200,22);	
		username.setLocation((manager.parent.getWidth()/2)-(username.getWidth()/2),manager.parent.getHeight()/2);
		
		//password
		password.setSize(200,22);
		password.setLocation((manager.parent.getWidth()/2)-(username.getWidth()/2),(manager.parent.getHeight()/2)+(username.getHeight()+20));
		
		//Action Button
		btnLogin.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						if(password.getText() == "")
							JOptionPane.showMessageDialog(manager.parent,"INSERISCI UNA PASSWORD");
							checkLogin(username.getText(),password.getText());
						
					}
		
				});
		
		btnSignIn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(password.getText() == "")
					JOptionPane.showMessageDialog(manager.parent,"INSERISCI UNA PASSWORD");
				signIn(username.getText(),password.getText());
				
			}

		});
		
		//add(Object) 
		add(btnLogin);
		add(btnSignIn);
		add(username);
		add(password);
	}
	
	@Override
	public void OnDestroyingRoutine() {
		
	}
	
	void checkLogin(String user, String password)
	{
		try {
			File f = new File(FileSystem.baseFolder.concat("profile.txt"));
			if(!f.exists())
			{
				JOptionPane.showMessageDialog(manager.parent, "Utente non registrato");
				return;
			}
			Scanner scan = new Scanner(f);
			
		
			List<String[]> lines = new ArrayList<String[]>();
			
			while(scan.hasNextLine())
			{
				lines.add(scan.nextLine().split(","));
			}
			
			scan.close();
			
			boolean existUser = false;
			boolean correctPsw = false;
			
			for(String[] users : lines)
			{
				if(users[0].equals(user))
				{
					existUser = true;
					if(users[1].equals(password))
					{
						correctPsw = true;
						JOptionPane.showMessageDialog(manager.parent,"LOGIN EFFETTUATO");
					}

					if(!correctPsw)
						JOptionPane.showMessageDialog(manager.parent,"PASSWORD O UTENTE ERRATI");
					return;
					
				}
			}
			
			if(!existUser)
				JOptionPane.showMessageDialog(manager.parent,"UTENTE NON REGISTRATO");
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void signIn(String user, String password)
	{
		try {
			File f = new File(FileSystem.baseFolder.concat("profile.txt"));
			if(!f.exists())
			{
				f.createNewFile();
			}
			
			final String data = user+","+password;
			
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(f);
			
			while(scan.hasNextLine())
			{
				if(user == scan.nextLine().split(",")[0])
				{
					JOptionPane.showMessageDialog(manager.parent, "Utente gia' registrato");
					return;
				}
				
			}
			
			scan.close();
			
			FileWriter file = new FileWriter(FileSystem.baseFolder.concat("profile.txt"));
			
			file.write(data);
			file.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
