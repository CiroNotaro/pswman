package com.paichmos.pswm.listeners;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import com.paichmos.api.SceneManager;
import com.paichmos.pswm.app.MainScene;

public class MainSceneListener implements ComponentListener{
	
	SceneManager manager;
	
	public MainSceneListener(final SceneManager m)
	{
		manager = m;
	}
	
	@Override
	public void componentResized(ComponentEvent e) {
		MainScene.rec_bar.setBounds(0,0,manager.parent.getWidth(),36);
		MainScene.rec_buttonsContainer.setLocation(MainScene.rec_bar.getWidth()-(MainScene.rec_buttonsContainer.getWidth()+16),0);
	}

	@Override
	public void componentMoved(ComponentEvent e) {}

	@Override
	public void componentShown(ComponentEvent e) {}

	@Override
	public void componentHidden(ComponentEvent e) {}


}
