package Jatek;
import javax.swing.*;
import java.awt.*; 
import javax.swing.Timer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//feladata szamon tartani, az aktulis almak, eprek, es cseresznyek szamat.

public class Palyakezelo extends JFrame{
	public int almaszam=0;
	public int eperszam=0;
	public int cseresznyeszam=0;
	
	
	
	
	public int getAlmaszam() {
		return almaszam;
	}

	public void setAlmaszam(int almaszam) {
		this.almaszam = almaszam;
	}

	public int getEperszam() {
		return eperszam;
	}

	public void setEperszam(int eperszam) {
		this.eperszam = eperszam;
	}

	public int getCseresznyeszam() {
		return cseresznyeszam;
	}

	public void setCseresznyeszam(int cseresznyeszam) {
		this.cseresznyeszam = cseresznyeszam;
	}

	public void szamlalo(String tomb[][]) {
		int cseresznyeszam=0;
		int almaszam=0;
		int eperszam=0;
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
		JPanel panel = new JPanel();
		
		setSize(770,770);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(tomb.length, tomb.length));
		JLabel labels[][] = new JLabel[tomb.length][tomb.length];
		
		
		
		
		for(int i=0; i<tomb.length; i++) {
			for(int j=0; j<tomb.length; j++) {
				
				if(tomb[i][j]=="E") {
					labels[i][j]=new JLabel();
					panel.add(labels[i][j]);
					ImageIcon imgThisImg = new ImageIcon("eper.png");

					labels[i][j].setIcon(imgThisImg);
				}
				else if(tomb[i][j]=="C") {
					labels[i][j]=new JLabel();
					panel.add(labels[i][j]);
					ImageIcon imgThisImg = new ImageIcon("cherry.jpg");

					labels[i][j].setIcon(imgThisImg);
				}
				else if(tomb[i][j]=="a") {
					labels[i][j]=new JLabel();
					panel.add(labels[i][j]);
					ImageIcon imgThisImg = new ImageIcon("alma.png");

					labels[i][j].setIcon(imgThisImg);
				}else if(tomb[i][j]=="O") {
					labels[i][j]=new JLabel();
					panel.add(labels[i][j]);
					ImageIcon imgThisImg = new ImageIcon("ball.png");

					labels[i][j].setIcon(imgThisImg);
				}
				else if(tomb[i][j]=="A") {
					labels[i][j]=new JLabel();
					panel.add(labels[i][j]);
					ImageIcon imgThisImg = new ImageIcon("alma.png");

					labels[i][j].setIcon(imgThisImg);
				}
				else if(tomb[i][j]=="V") {
					labels[i][j]=new JLabel();
					panel.add(labels[i][j]);
					ImageIcon imgThisImg = new ImageIcon("green.png");

					labels[i][j].setIcon(imgThisImg);
				}
				else if(tomb[i][j]=="S") {
					labels[i][j]=new JLabel();
					panel.add(labels[i][j]);
					ImageIcon imgThisImg = new ImageIcon("sta.jpg");

					labels[i][j].setIcon(imgThisImg);
				}
				else if(tomb[i][j]==" ") {
					labels[i][j]=new JLabel();
					panel.add(labels[i][j]);
					ImageIcon imgThisImg = new ImageIcon("ures.png");

					labels[i][j].setIcon(imgThisImg);
				}
				else if(tomb[i][j]=="█") {
					labels[i][j]=new JLabel();
					panel.add(labels[i][j]);
					ImageIcon imgThisImg = new ImageIcon("ground.png");

					labels[i][j].setIcon(imgThisImg);
				}
				else if(tomb[i][j]=="▒") {
					labels[i][j]=new JLabel();
					panel.add(labels[i][j]);
					ImageIcon imgThisImg = new ImageIcon("ground.png");

					labels[i][j].setIcon(imgThisImg);
				}
			}
		}
		add(panel);

		setVisible(true);
		panel.invalidate();
		panel.validate();
		panel.repaint();
		this.almaszam=almaszam;
		this.cseresznyeszam=cseresznyeszam;
		this.eperszam=eperszam;
	}
}
