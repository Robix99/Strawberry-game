package Jatek;

import java.util.Random;

public class Edesalma extends Alma {
	@Override
	public void almaLerak(String tomb[][]) {
		
		Random rand=new Random();
		x=0;
		y=0;
		
		int eperx=0; //eper poziciojanak elmentese
		int epery=0;

		
		for(int i=0; i<tomb.length; i++) {
			for(int j=0; j<tomb[i].length; j++){
				if(tomb[i][j].equals("E")) {
					eperx=i;							//megkeresi hol az eper
					epery=j;
				}
			}
		}

		double tavolsag=0;
		
		while(tomb[x][y]!=" " || x<=0 || y<=0 || x==tomb.length-1 || y==tomb.length-1 || tavolsag<=3||tomb[x+1][y]!="█") {
			x=rand.nextInt(tomb[0].length-1)+1;
			y=rand.nextInt(tomb[0].length-1)+1;
			tavolsag=Math.sqrt(Math.pow((x-eperx),2)+Math.pow((y-epery),2)); //legalabb 3 tavolsagra kezdjenek egymastol a kezdeskor
			}
		tomb[x][y]="S";
	}
	
	public Edesalma(int x, int y, int irany) {
		super(x,y, irany);
	}
	
	
	public void Edesalmaesik(String tomb[][]) {
		if(tomb[x+1][y]==" ") {
			if(x!=tomb.length-1) {
			tomb[x+1][y]="S";
			tomb[x][y]=" ";
			setX(x+1);
			}else {
				tomb[x][y]="S";
			}
		}else if(tomb[x+1][y]=="A" || tomb[x+1][y]=="E" ||tomb[x+1][y]=="a" ) {
			if(x!=tomb.length-1) {
			tomb[x+1][y]="S";
			tomb[x][y]=" ";
			setX(x+1);
			}else {
				tomb[x][y]="S";
			}
		}else if(tomb[x+1][y]=="C"|| tomb[x+1][y]=="█"|| tomb[x+1][y]=="▒") {
			tomb[x][y]="S";
		}
	}
}
