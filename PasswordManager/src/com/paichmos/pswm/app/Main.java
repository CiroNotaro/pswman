package com.paichmos.pswm.app;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.paichmos.api.SceneManager;

public class Main {

	public static void main(String[] args) {

		JFrame f = new JFrame("TEST");
		f.setSize(960,540);
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f.setLocationRelativeTo(null);
		
		
		SceneManager loop = new SceneManager(new LoginScene(), f);
		f.addWindowListener(new WindowAdapter() {

		    @Override
		    public void windowClosing(WindowEvent e) {
		       loop.closeApplication();
		    }
		});
		f.setVisible(true);
	}

}
