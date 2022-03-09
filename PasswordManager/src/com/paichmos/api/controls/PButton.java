package com.paichmos.api.controls;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class PButton extends JButton {
	
	private static final long serialVersionUID = 1L;

	boolean over;
    Color color;
    Color colorOver;
    Color colorClick;
    Color borderColor;
    Color colorOverText;
    Color colorText;
	int radius = 0;
	//costruttore
    public PButton() {
        setColor(Color.WHITE);
        colorOver = new Color(51, 51, 51);
        colorOverText = Color.white;
        colorText = Color.black;
        colorClick = new Color(255, 255, 255, 0);
        borderColor = new Color(51, 51, 51);
        setForeground(colorText);
        setContentAreaFilled(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(colorOver);
                setForeground(colorOverText);
                over = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(color);
                setForeground(colorText);
                over = false;

            }

            @Override
            public void mousePressed(MouseEvent me) {
                 setBackground(colorClick);
               
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (over) {
                    setBackground(colorOver);
                } else {
                    setBackground(color);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	    g2.setColor(borderColor);
	    g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(getBackground());
        
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        super.paintComponent(grphcs);
    }

	public boolean isOver() {
		return over;
	}

	public void setOver(boolean over) {
		this.over = over;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		setBackground(color);
	}

	public Color getColorOver() {
		return colorOver;
	}

	public void setColorOver(Color colorOver) {
		this.colorOver = colorOver;
	}

	public Color getColorClick() {
		return colorClick;
	}

	public void setColorClick(Color colorClick) {
		this.colorClick = colorClick;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public Color getColorOverText() {
		return colorOverText;
	}

	public void setColorOverText(Color colorOverText) {
		this.colorOverText = colorOverText;
	}

	public Color getColorText() {
		return colorText;
	}

	public void setColorText(Color colorText) {
		this.colorText = colorText;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
    
}
