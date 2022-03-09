package com.paichmos.api;

import javax.swing.JPanel;

public abstract class Scene extends JPanel
{
	private static final long serialVersionUID = 1L;
	/**
     * <Code>SceneManager manager</Code> ci consente di interagire con la finestra.
     * <br>Puoi:
     * <br>-Cambiare scena con il metodo <Code>goTo(Scene)</Code>
     * <br>-Accedere all'oggetto <Code>JFrame parent</Code> 
     */
	public SceneManager manager;
	
	/**
     * Viene richiamata una sola volta nel momento in cui instanzi la scena. 
     */
	public abstract void OnStart();
	
	/**
     * Viene richiamata una sola volta nel momento in cui distruggi la scena. 
     */
	public abstract void OnDestroyingRoutine();
}
