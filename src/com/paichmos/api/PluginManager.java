package com.paichmos.api;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class PluginManager 
{
	SceneManager manager;
	public List<IPlugin> plugins = new ArrayList<IPlugin>();
	
	public PluginManager(SceneManager m)
	{
		this.manager = m;
	}
	
	public void loadAllPlugin()
	{
		File folder = new File(FileSystem.pluginFolder);
		File[] listOfFiles = folder.listFiles();
		
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	if(isJar(file.getName()))
		    	{
		    		File jar = new File(file.getPath());
		    		try {
		    			ClassLoader loader = URLClassLoader.newInstance(new URL[] { jar.toURL() });
		    			IPlugin plugin = (IPlugin)loader.loadClass("pswm.plugin.Main").newInstance();
		    			plugins.add(plugin);
		    			plugins.get(plugins.size()-1).PluginConstructor(manager);
		    		} catch (MalformedURLException e) {
		    			e.printStackTrace();
		    		} catch (InstantiationException e) {
		    			e.printStackTrace();
		    		} catch (IllegalAccessException e) {
		    			e.printStackTrace();
		    		} catch (ClassNotFoundException e) {
		    			e.printStackTrace();
		    		}
		    	}
		    }
		}
	}
	
	boolean isJar(String name)
	{
		if(!name.contains("."))
			return false;
		
		String e = "";
		
		for(int i = name.lastIndexOf(".")+1; i < name.length(); i++)
		{
			e+=name.charAt(i);
		}
		
		if(e.equals("jar"))
				return true;
		
		return false;
	}
	public void clearAll()
	{
		plugins.clear();
	}
}
