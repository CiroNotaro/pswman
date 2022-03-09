package com.paichmos.pswm.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.paichmos.api.Scene;
import com.paichmos.api.controls.PButton;
import com.paichmos.pswm.listeners.MainSceneListener;

@SuppressWarnings("serial")
public class MainScene extends Scene{

	public static JLabel lbl_appName = new JLabel();
	
	public static JPanel rec_bar = new JPanel();
	public static JPanel rec_buttonsContainer = new JPanel();
	
	public static PButton btn_settings = new PButton();
	public static PButton btn_login = new PButton();
	public static JButton btn_plugin = new JButton();
	
	MainSceneListener listeners;
	
	@Override
	public void OnStart() {
		manager.parent.setMinimumSize(new Dimension(640,360));
		
		setLayout(null);
		setBackground(Color.white);
		
		lbl_appName.setFont(new Font(Font.SANS_SERIF, 32, 32));
		lbl_appName.setForeground(Color.white);
		lbl_appName.setBounds(0,0,manager.parent.getWidth(),36);
		lbl_appName.setText("Password Manager");
		
		rec_bar.setBounds(lbl_appName.getBounds());
		rec_bar.setBackground(Color.cyan);
		rec_bar.setLayout(null);
		
		rec_buttonsContainer.setLayout(null);
		rec_buttonsContainer.setBorder(null);
		rec_buttonsContainer.setSize(200,36);
		rec_buttonsContainer.setBackground(Color.cyan);
		rec_buttonsContainer.setLocation(rec_bar.getWidth()-(rec_buttonsContainer.getWidth()+16),0);
		
		btn_settings.setText("Settings");
		btn_settings.setFocusPainted(false);
		btn_settings.setFont(new Font(Font.SANS_SERIF, 12, 12));
		btn_settings.setFont(btn_settings.getFont().deriveFont(btn_settings.getFont().getStyle() | Font.BOLD));
		btn_settings.setColor(null);
		btn_settings.setBorder(null);
		btn_settings.setBorderColor(new Color(0,0,0,0));
		btn_settings.setColorOverText(Color.white);
		btn_settings.setColorText(Color.white);
		btn_settings.setColorOver(new Color(255,255,255,150));
		btn_settings.setColorClick(new Color(255,255,255,255));
		btn_settings.setForeground(Color.white);
		btn_settings.setLocation(0,0);
		btn_settings.setSize(100,rec_buttonsContainer.getHeight());
		btn_settings.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}

		});
		
		btn_login.setText("Login");
		btn_login.setFocusPainted(false);
		btn_login.setFont(new Font(Font.SANS_SERIF, 12, 12));
		btn_login.setFont(btn_login.getFont().deriveFont(btn_login.getFont().getStyle() | Font.BOLD));
		btn_login.setColor(null);
		btn_login.setBorder(null);
		btn_login.setBorderColor(new Color(0,0,0,0));
		btn_login.setColorOverText(Color.white);
		btn_login.setColorText(Color.white);
		btn_login.setColorOver(new Color(255,255,255,150));
		btn_login.setColorClick(new Color(255,255,255,255));
		btn_login.setForeground(Color.white);
		btn_login.setLocation(100,0);
		btn_login.setSize(100,rec_buttonsContainer.getHeight());
		btn_login.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}

		});
		
		rec_buttonsContainer.add(btn_settings);
		rec_buttonsContainer.add(btn_login);
		
		rec_bar.add(rec_buttonsContainer);
		
		add(lbl_appName);
		add(rec_bar);
		
		listeners = new MainSceneListener(manager);
		addComponentListener(listeners);
	}

	@Override
	public void OnDestroyingRoutine() {

	}

}
