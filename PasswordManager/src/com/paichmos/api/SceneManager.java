package com.paichmos.api;

import javax.swing.JFrame;

public class SceneManager 
{

	public JFrame parent;
	Scene lastScene;
	public PluginManager plugin;
	
	public SceneManager(Scene defaultScene, JFrame parent)
	{
		this.plugin = new PluginManager(this);
		this.parent = parent;
		this.lastScene = defaultScene;
		
		defaultScene.manager = this;
		defaultScene.OnStart();
		parent.add(defaultScene);
		parent.setVisible(true);
		
		plugin.loadAllPlugin();
	}
	
	public void goTo(Scene nextScene)
	{
		//Elimino vecchia scena
		lastScene.OnDestroyingRoutine();
		parent.remove(lastScene);
		lastScene = nextScene;
		
		//Aggiungo nuova scena
		nextScene.manager = this;
		nextScene.OnStart();
		parent.add(nextScene);
		parent.setVisible(true);
	}
	
	public void closeApplication()
	{
		lastScene.OnDestroyingRoutine();
		for(IPlugin p : plugin.plugins)
		{
			p.PluginDeconstructor();
		}
		plugin.plugins.clear();
		parent.dispose();
	}
	
}
