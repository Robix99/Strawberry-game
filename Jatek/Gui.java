package Jatek;

import java.awt.*; 
import javax.swing.*;


public class Gui extends JFrame {
	
	
	
	public void megfigyelo(String tomb[][]) {
		
		for(int i=0; i<tomb.length; i++) {
			for(int j=0; j<tomb[i].length; j++) {
				if(tomb[i][j]=="C") {
					cseresznyeszam++;
				}else if(tomb[i][j]=="A" || tomb[i][j]=="a") {
					almaszam++;
				}else if(tomb[i][j]=="E") {
					eperszam++;
				}
			}
		}
		
		JPanel panel = new JPanel;
		XOButton buttons[] = new XOButton[12];
		setSize(400,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(tomb.length, tomb.length));
		for(int i = 0; i<9; i++){
			buttons[i] = new XOButton();
			panel.add(buttons[i]);
		}
		add(panel);
		
		setVisible(true);
		
	}
}
