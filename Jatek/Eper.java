package Jatek;

import java.util.Random;
import java.io.*;
import java.util.Scanner;

public class Eper {

	public boolean vanlabda=true;
	public String irany;
	public String labdairany;
	public boolean labdamegy=true;
	public int utkozott=0;
	private int utkozhet=0;
	public boolean labdaolt=false;
	

	public boolean isLabdaolt() {
		return labdaolt;
	}


	public void setLabdaolt(boolean labdaolt) {
		this.labdaolt = labdaolt;
	}


	public boolean isVanlabda() {
		return vanlabda;
	}


	public void setVanlabda(boolean vanlabda) {
		this.vanlabda = vanlabda;
	}


	public String getIrany() {
		return irany;
	}


	public void setIrany(String irany) {
		this.irany = irany;
	}


	public String getLabdairany() {
		return labdairany;
	}


	public void setLabdairany(String labdairany) {
		this.labdairany = labdairany;
	}


	public boolean isLabdamegy() {
		return labdamegy;
	}


	public void setLabdamegy(boolean labdamegy) {
		this.labdamegy = labdamegy;
	}


	public int getUtkozott() {
		return utkozott;
	}


	public void setUtkozott(int utkozott) {
		this.utkozott = utkozott;
	}


	public int getUtkozhet() {
		return utkozhet;
	}


	public void setUtkozhet(int utkozhet) {
		this.utkozhet = utkozhet;
	}


	public void eperLerak(String tomb[][]) {
		Random rand=new Random();
		int m = rand.nextInt(tomb[0].length-1)+0;
		int n = rand.nextInt(tomb[0].length-1)+0;
		
		while(tomb[m][n]!=" ") {
			m=rand.nextInt(tomb[0].length-1)+0;
			n=rand.nextInt(tomb[0].length-1)+0;	
		}
		tomb[m][n]="E";
		
		}

	
	public void eperMozog(String tomb[][]) {
		Scanner sc = new Scanner(System.in);
		String bemenet;
		bemenet=sc.next();
		int x=0;
		int y=0;

		for (int i=0; i<tomb.length; i++) {
			for (int j=0; j<tomb[i].length; j++) {
				if (tomb[i][j]=="E") {
					x=i;
					y=j;
				}
			}
		}
		if(bemenet.equals("w")) {
			if(x-1!=0) {
				if(tomb[x-1][y]==" "||tomb[x-1][y]=="█"||tomb[x-1][y]=="C" ) {
					tomb[x][y]=" ";
					tomb[x-1][y]="E";
					irany="w";
				}else if(tomb[x-1][y]=="a" || tomb[x-1][y]=="A") {
					tomb[x][y]=" ";
				}else if(tomb[x-1][y]=="O") {
					tomb[x][y]=" ";
					tomb[x-1][y]="E";
					vanlabda=true;
					utkozott=0;
				}
			}
		}else if (bemenet.equals("a")) {
			if(y-1!=0) {
				if(tomb[x][y-1]==" "||tomb[x][y-1]=="█"||tomb[x][y-1]=="C" ) {
				tomb[x][y]=" ";
				tomb[x][y-1]="E";
				irany="a";
				}else if(tomb[x][y-1]=="a"|| tomb[x][y-1]=="A") {
					tomb[x][y]=" ";
				}else if(tomb[x][y-1]=="O") {
					tomb[x][y]=" ";
					tomb[x][y-1]="E";
					vanlabda=true;
					utkozott=0;
				}
			}
		}else if (bemenet.equals("s")) {
			if(x+1!=tomb.length-1) {
				if(tomb[x+1][y]==" "||tomb[x+1][y]=="█"||tomb[x+1][y]=="C" ) {
					tomb[x][y]=" ";
					tomb[x+1][y]="E";
					irany="s";
					}else if(tomb[x+1][y]=="a"||tomb[x+1][y]=="A") {
						tomb[x][y]=" ";
					}else if(tomb[x+1][y]=="O") {
						tomb[x][y]=" ";
						tomb[x+1][y]="E";
						vanlabda=true;
						utkozott=0;
					}
			}
		}else if (bemenet.equals("d")) {
			if(y+1!=tomb.length-1) {
				if(tomb[x][y+1]==" "||tomb[x][y+1]=="█"||tomb[x][y+1]=="C" ) {
					tomb[x][y]=" ";
					tomb[x][y+1]="E";
					irany="d";
					}else if(tomb[x][y+1]=="a"||tomb[x][y+1]=="A") {
						tomb[x][y]=" ";
					}else if(tomb[x][y+1]=="O") {
						tomb[x][y]=" ";
						tomb[x][y+1]="E";
						vanlabda=true;
						utkozott=0;
					}
			}
		}
		else if (bemenet.equals("x")) {
			labdamegy=true;
			
			if(irany.equals("w") && x!=0 && vanlabda==true) {
				if(tomb[x-1][y]==" ") {
					tomb[x][y]="E";
					tomb[x-1][y]="O";
					labdairany="w";
					vanlabda=false;
				}
				else if(tomb[x-1][y]=="a" ||tomb[x-1][y]=="V" ) {
					tomb[x-1][y]="O";
					tomb[x][y]="E";
					labdairany="w";
					vanlabda=false;
				}
			}else if(irany.equals("a") && y!=0 && vanlabda==true) {
				if(tomb[x][y-1]==" ") {
					tomb[x][y]="E";
					tomb[x][y-1]="O";
					labdairany="a";
					vanlabda=false;
				}
				else if(tomb[x][y-1]=="a"||tomb[x][y-1]=="V") {
					tomb[x][y-1]="O";
					tomb[x][y]="E";
					labdairany="a";
					vanlabda=false;
				}
			}else if(irany.equals("s") && x!=tomb.length-1 && vanlabda==true) {
				if(tomb[x+1][y]==" ") {
					tomb[x][y]="E";
					tomb[x+1][y]="O";
					labdairany="s";
					vanlabda=false;
				}
				else if(tomb[x+1][y]=="a" || tomb[x+1][y]=="V") {
					tomb[x+1][y]="O";
					tomb[x][y]="E";
					labdairany="s";
					vanlabda=false;
				}
			} else if(irany.equals("d") && y!=tomb.length-1 && vanlabda==true) {
				if(tomb[x][y+1]==" ") {
					tomb[x][y]="E";
					tomb[x][y+1]="O";
					labdairany="d";
					vanlabda=false;
				}
				else if(tomb[x][y+1]=="a" ||tomb[x][y+1]=="V") {
					tomb[x][y+1]="O";
					tomb[x][y]="E";
					labdairany="d";
					vanlabda=false;
				}
			}
		}
		
	}
	public void labdaMozog(String tomb[][]) {
		int x=1500; //ekkora palya ugy sem lenne, csak azert hogy tudjuk, hogy van e lent labda
		int y=1500;
		
		
		for (int i=0; i<tomb.length; i++) {
			for (int j=0; j<tomb[i].length; j++) {
				if (tomb[i][j]=="O") {					//ladba poziciojanak megtalalasa
					x=i;
					y=j;
				}
			}
		}
		if(x!=1500 && y!=1500 && labdamegy==true) { //ha 1500 maradt az ertekuk, akkor nincs lent labda
		if(labdairany=="w") {
			if(tomb[x-1][y]==" "&& x-1!=0) {
				tomb[x][y]=" ";
				tomb[x-1][y]="O";
				labdairany="w";
			}else if(tomb[x-1][y]=="a"||tomb[x-1][y]=="V") {
				tomb[x][y]=" ";
				tomb[x-1][y]="O";
				labdamegy=false;
			}
			
				else if(tomb[x-1][y]=="A"){
				tomb[x][y]="O";
				labdamegy=false;
				
			}else if(tomb[x-1][y]=="█" || tomb[x-1][y]=="C"||x-1==0|| tomb[x-1][y]=="S"|| tomb[x-1][y]=="▒") {
				int lepett=0;
				int futas=0;
				utkozott++;
				while(lepett==0 && futas<20) {
					Random szam= new Random();
					int utvalasztas=szam.nextInt(3)+1;
					if(utvalasztas==1) {
						if(tomb[x][y-1]==" " && y-1!=0) {
							tomb[x][y]=" ";
							tomb[x][y-1]="O";
							labdairany="a";
							lepett++;
						}
					}else if(utvalasztas==2) {
						if(tomb[x+1][y]==" " && x+1!=tomb.length-1) {
							tomb[x][y]=" ";
							tomb[x+1][y]="O";
							labdairany="s";
							lepett++;
						}
					}else if(utvalasztas==3) {
						if(tomb[x][y+1]==" " && y+1!=tomb.length-1) {
							tomb[x][y]=" ";
							tomb[x][y+1]="O";
							labdairany="d";
							lepett++;
						}
					}futas++;
				}
			}else if (tomb[x-1][y]=="E") {
				tomb[x][y]=" ";
				vanlabda=true;
				utkozott=0;
			}
		}else if(labdairany=="a") {
			if(tomb[x][y-1]==" "&& y-1!=0) {
				tomb[x][y]=" ";
				tomb[x][y-1]="O";
				labdairany="a";
			}else if(tomb[x][y-1]=="a"|| tomb[x][y-1]=="V") {
				tomb[x][y]=" ";
				tomb[x][y-1]="O";
				labdamegy=false;
			}else if(tomb[x][y-1]=="A"){
				tomb[x][y]="O";
				labdamegy=false;
			}else if(tomb[x][y-1]=="█" ||tomb[x][y-1]=="C"||y-1==0||tomb[x][y-1]=="S"||tomb[x][y-1]=="▒") {
				int lepett=0;
				int futas=0;
				utkozott++;
				while(lepett==0 && futas<20) {
					Random szam= new Random();
					int utvalasztas=szam.nextInt(3)+1;
					if(utvalasztas==1) {
						if(tomb[x-1][y]==" " && x-1!=0) {
							tomb[x][y]=" ";
							tomb[x-1][y]="O";
							labdairany="w";
							lepett++;
						}
					}else if(utvalasztas==2) {
						if(tomb[x+1][y]==" " && x+1!=tomb.length-1) {
							tomb[x][y]=" ";
							tomb[x+1][y]="O";
							labdairany="s";
							lepett++;
						}
					}else if(utvalasztas==3) {
						if(tomb[x][y+1]==" " && y+1!=0) {
							tomb[x][y]=" ";
							tomb[x][y+1]="O";
							labdairany="d";
							lepett++;
						}
					}futas++;
				}
			}else if (tomb[x][y-1]=="E") {
				tomb[x][y]=" ";
				vanlabda=true;
				utkozott=0;
			}
		}else if(labdairany=="s") {
			if(tomb[x+1][y]==" "&& x+1!=tomb.length-1) {
				tomb[x][y]=" ";
				tomb[x+1][y]="O";
				labdairany="s";
			}else if(tomb[x+1][y]=="a" || tomb[x+1][y]=="V") {
				tomb[x][y]=" ";
				tomb[x+1][y]="O";
				labdamegy=false;
			}else if(tomb[x+1][y]=="A"){
				tomb[x][y]="O";
				labdamegy=false;
			}
			else if(tomb[x+1][y]=="█" ||tomb[x+1][y]=="C"|| x+1==tomb.length-1 ||tomb[x+1][y]=="V" ||tomb[x+1][y]=="▒") {
				int lepett=0;
				int futas=0;
				utkozott++;
				while(lepett==0 && futas<20) {
					Random szam= new Random();
					int utvalasztas=szam.nextInt(3)+1;
					if(utvalasztas==1) {
						if(tomb[x-1][y]==" " && x-1!=0) {
							tomb[x][y]=" ";
							tomb[x-1][y]="O";
							labdairany="w";
							lepett++;
						}
					}else if(utvalasztas==2) {
						if(tomb[x][y-1]==" " && y-1!=0) {
							tomb[x][y]=" ";
							tomb[x][y-1]="O";
							labdairany="a";
							lepett++;
						}
					}else if(utvalasztas==3) {
						if(tomb[x][y+1]==" " && y+1!=tomb.length-1) {
							tomb[x][y]=" ";
							tomb[x][y+1]="O";
							labdairany="d";
							lepett++;
						}
					}futas++;
				}
			}else if (tomb[x+1][y]=="E") {
				tomb[x][y]=" ";
				vanlabda=true;
				utkozott=0;
			}
		}else if(labdairany=="d") {
			if(tomb[x][y+1]==" " && y+1!=tomb.length-1) {
				tomb[x][y]=" ";
				tomb[x][y+1]="O";
				labdairany="d";
			}else if(tomb[x][y+1]=="a" ||tomb[x][y+1]=="V" ) {
				tomb[x][y]=" ";
				tomb[x][y+1]="O";
				labdamegy=false;
			}else if(tomb[x][y+1]=="A"){
				tomb[x][y]="O";
				labdamegy=false;
				
			}else if(tomb[x][y+1]=="█" || y+1==tomb.length-1||tomb[x][y+1]=="C"||tomb[x][y+1]=="S" ||tomb[x][y+1]=="▒" ) {
				int lepett=0;
				int futas=0;
				utkozott++;
				while(lepett==0 && futas<20) {
					Random szam= new Random();
					int utvalasztas=szam.nextInt(3)+1;
					if(utvalasztas==1) {
						if((tomb[x-1][y]==" " || tomb[x-1][y]=="a"|| tomb[x-1][y]=="V") && x-1!=0) {
							tomb[x][y]=" ";
							tomb[x-1][y]="O";
							labdairany="w";
							lepett++;
						}
					}else if(utvalasztas==2) {
						if((tomb[x+1][y]==" "|| tomb[x+1][y]=="a"|| tomb[x+1][y]=="V") && x+1!=tomb.length-1) {
							tomb[x][y]=" ";
							tomb[x+1][y]="O";
							labdairany="s";
							lepett++;
						}
					}else if(utvalasztas==3) {
						if((tomb[x][y-1]==" " || tomb[x][y-1]=="a"|| tomb[x][y-1]=="V")&& y-1!=0) {
							tomb[x][y]=" ";
							tomb[x][y-1]="O";
							labdairany="a";
							lepett++;
						}
					}futas++;
				}
			}else if (tomb[x][y+1]=="E") {
				tomb[x][y]=" ";
				vanlabda=true;
				utkozott=0;
			}
		}
	}
	}
}
