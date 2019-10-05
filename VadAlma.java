package Jatek;

import java.util.Random;

public class VadAlma extends Alma {
	
	public VadAlma(int x, int y, int irany) {
		super(x,y, irany);
	}
	
public void almaLerak(String tomb[][]) {
		
		Random rand=new Random();
		x=0;
		y=0;
		
		int eperx=0; //eper poziciojanak elmentese
		int epery=0;
		x=rand.nextInt(tomb[0].length-1)+1;
		y=rand.nextInt(tomb[0].length-1)+1;
		
		for(int i=0; i<tomb.length; i++) {
			for(int j=0; j<tomb[i].length; j++){
				if(tomb[i][j].equals("E")) {
					eperx=i;							//megkeresi hol az eper
					epery=j;
				}
			}
		}

		double tavolsag=0;
		
		while(tomb[x][y]!=" " || x<=0 || y<=0 || x==tomb.length-1 || y==tomb.length-1 || tavolsag<=3 &&(tomb[x+1][y]!=" " || tomb[x-1][y]!=" " ||tomb[x][y+1]!=" " ||tomb[x][y-1]!=" " )){
			x=rand.nextInt(tomb[0].length-1)+1;
			y=rand.nextInt(tomb[0].length-1)+1;		//Azert kell ennyi feltetel, hogy az almak ne szoruljanak be 4 fal koze, mert akkor instant megolnek minket
			tavolsag=Math.sqrt(Math.pow((x-eperx),2)+Math.pow((y-epery),2)); //Legalabb 3 tavolsagra kell lenniuk az almaknak az epertol kezdeskor
			}
		tomb[x][y]="V";
	}
	
public void almaMozog(String tomb[][]) {
	int lepett=0;
	int futott=0;

	if(tomb[x][y]!="V") {			//Ha meghalt ne tudjon elkezdeni ujra mozogni
	
	}else {
		while(lepett==0 && futott<20) {
			int x=this.x;
			int y=this.y;
			int eperx=1500;
			int epery=1500;
			
			for (int i=0; i<tomb.length; i++) {
				for (int j=0; j<tomb[i].length; j++) {
					if (tomb[i][j]=="E") {
						eperx=i;
						epery=j;
					}
				}
			}
			double tavolsag=Math.sqrt(Math.pow((x-eperx),2)+Math.pow((y-epery),2)); //Legalabb 3 tavolsagra kell lenniuk az almaknak az epertol kezdeskor
			
			if(tavolsag<=4) {
			
				Random rnd=new Random();
				int esely=rnd.nextInt(5)+1;
				
				if(esely==1 || esely==2) {
					if(eperx>x && epery>y) {
						int ut=rnd.nextInt(2)+1;
						if(ut==2) {
							irany=4;
						}else {
							irany=3;
						}
					}else if(eperx<x && epery<y) {
						int ut=rnd.nextInt(2)+1;
						if(ut==2) {
							irany=2;
						}else {
							irany=1;
						}
					}else if(eperx==x && epery<y) {
						irany=2;
					}else if(eperx==x && epery>y) {
						irany=4;
					}else if(eperx<x && epery==y) {
						irany=1;
					}else if(eperx>x && epery==y) {
						irany=3;
					}else if(eperx<x && epery>y) {
						int ut=rnd.nextInt(2)+1;
						if(ut==2) {
							irany=4;
						}else {
							irany=1;
						}
					}else if(eperx>x && epery<y) {
						int ut=rnd.nextInt(2)+1;
						if(ut==2) {
							irany=2;
						}else {
							irany=3;
						}
					}
				}
				
				if(esely==5) {
					int jelenirany=irany;
			
			while(jelenirany==irany ) {
				if(irany==1) {
					int random=rnd.nextInt(2)+1; 
					if(random==2) {
						irany=4;
					}
					else {
						irany=2;
					}
				}else if(irany==2) {
					int random=rnd.nextInt(2)+1; 
					if(random==2) {
						irany=1;
					}
					else {
						irany=3;
					}					//ha 5 random szamot generalok akkor minden egyes szam 20% valoszinuseggel fordul elo, tehat ekkor valt iranyt az alma
				}else if(irany==3) {
					int random=rnd.nextInt(2)+1; 
					if(random==2) {
						irany=4;
					}
					else {
						irany=2;
					}
				}else if(irany==4) {
					int random=rnd.nextInt(2)+1; 
					if(random==2) {
						irany=1;
					}
					else {
						irany=3;
					}
				}
			}
		}else if(esely==1 || esely==2){
	 	
		
	
			if(irany==1) {
				if(tomb[x-1][y]==" " || tomb[x-1][y]=="E") {
					if(x-1!=0) {
						tomb[x][y]=(" ");
						tomb[x-1][y]="V";
						setX(x-1);
						lepett++;	
						irany=1;
					}
				}else if(tomb[x-1][y]=="a"|| tomb[x][y+1]=="A") {
					tomb[x][y]="V";
					lepett++;
					irany=1;
				}else if(tomb[x-1][y]=="O"||tomb[x-1][y]=="S") {
					tomb[x][y]=" ";
					irany=1;
				}
				else {
					tomb[x][y]="V";
					irany=1;
				}
	
			}else if(irany==2) {
				if (tomb[x][y-1]==" "|| tomb[x][y-1]=="E") {
					if(y-1!=0) {
						tomb[x][y]=" ";
						tomb[x][y-1]="V";
						setY(y-1);
						lepett++;
						irany=2;
					}
				}else if(tomb[x][y-1]=="a"|| tomb[x][y+1]=="A") {
					tomb[x][y]="V";
					lepett++;
					irany=2;
				}else if(tomb[x][y-1]=="O"||(tomb[x][y-1]=="S" && tomb[x+1][y-1]==" ")) {   //tehat ha az alma eppen esik
					tomb[x][y]=" ";
					irany=2;
				}
				else {
					tomb[x][y]="V";
					irany=2;
				}
			}else if(irany==3) {
				if(tomb[x+1][y]==" "|| tomb[x+1][y]=="E") {
					if(x+1!=tomb.length-1) {
						tomb[x][y]=" ";
						tomb[x+1][y]="V";
						setX(x+1);
						lepett++;
						irany=3;
					}
				}else if(tomb[x+1][y]=="a"|| tomb[x][y+1]=="A") {
				
					tomb[x][y]="V";
					lepett++;
					irany=3;
				}else if(tomb[x+1][y]=="O"||(tomb[x+1][y]=="S" && tomb[x+2][y]==" ")) {
					tomb[x][y]=" ";
					irany=3;
				}
				else {
					tomb[x][y]="V";
					irany=3;
				}
			}
			else if (irany==4) {
				if(tomb[x][y+1]==" "|| tomb[x][y+1]=="E") {
					if(y+1!=tomb.length-1) {
						tomb[x][y]=" ";
						tomb[x][y+1]="V";
						setY(y+1);
						lepett++;
						irany=4;
				
					}
				}else if(tomb[x][y+1]=="a" || tomb[x][y+1]=="A") {
				
					tomb[x][y]="V";
					lepett++;
					irany=4;
				
				}else if(tomb[x][y+1]=="O" ||(tomb[x][y+1]=="S" && tomb[x+1][y+1]==" ")) {   //tehat ha az edes alma eppen zuhan
					tomb[x][y]=" ";
					irany=4;
				}else {
					tomb[x][y]="V";
					irany=4;
				}
			}
			irany=rnd.nextInt(4)+1;
			futott++;
		}
	}else {
		Random rnd=new Random();
		int esely=rnd.nextInt(5)+1;
		
		if(esely==5) {
			int jelenirany=irany;
		
		while(jelenirany==irany ) {
			if(irany==1) {
				int random=rnd.nextInt(2)+1; 
				if(random==2) {
					irany=4;
				}
				else {
					irany=2;
				}
			}else if(irany==2) {
				int random=rnd.nextInt(2)+1; 
				if(random==2) {
					irany=1;
				}
				else {
					irany=3;
				}					//ha 5 random szamot generalok akkor minden egyes szam 20% valoszinuseggel fordul elo, tehat ekkor valt iranyt az alma
			}else if(irany==3) {
				int random=rnd.nextInt(2)+1; 
				if(random==2) {
					irany=4;
				}
				else {
					irany=2;
				}
			}else if(irany==4) {
				int random=rnd.nextInt(2)+1; 
				if(random==2) {
					irany=1;
				}
				else {
					irany=3;
				}
			}
		}
	}else {
 	
	

		if(irany==1) {
			if(tomb[x-1][y]==" " || tomb[x-1][y]=="E") {
				if(x-1!=0) {
					tomb[x][y]=(" ");
					tomb[x-1][y]="V";
					setX(x-1);
					lepett++;	
					irany=1;
				}
			}else if(tomb[x-1][y]=="a"|| tomb[x-1][y]=="A") {
				tomb[x][y]="V";
				lepett++;
				irany=1;
			}else if(tomb[x-1][y]=="O"||tomb[x-1][y]=="S") {
				tomb[x][y]=" ";
				irany=1;
			}
			else {
				tomb[x][y]="V";
				irany=1;
			}

		}else if(irany==2) {
			if (tomb[x][y-1]==" "|| tomb[x][y-1]=="E") {
				if(y-1!=0) {
					tomb[x][y]=" ";
					tomb[x][y-1]="V";
					setY(y-1);
					lepett++;
					irany=2;
				}
			}else if(tomb[x][y-1]=="a"|| tomb[x][y-1]=="A") {
				tomb[x][y]="V";
				lepett++;
				irany=2;
			}else if(tomb[x][y-1]=="O"||(tomb[x][y-1]=="S" && tomb[x+1][y-1]==" ")) {   //tehat ha az alma eppen esik
				tomb[x][y]=" ";
				irany=2;
			}
			else {
				tomb[x][y]="V";
				irany=2;
			}
		}else if(irany==3) {
			if(tomb[x+1][y]==" "|| tomb[x+1][y]=="E") {
				if(x+1!=tomb.length-1) {
					tomb[x][y]=" ";
					tomb[x+1][y]="V";
					setX(x+1);
					lepett++;
					irany=3;
				}
			}else if(tomb[x+1][y]=="a"|| tomb[x+1][y]=="A") {
			
				tomb[x][y]="V";
				lepett++;
				irany=3;
			}else if(tomb[x+1][y]=="O"||(tomb[x+1][y]=="S" && tomb[x+2][y]==" ")) {
				tomb[x][y]=" ";
				irany=3;
			}
			else {
				tomb[x][y]="V";
				irany=3;
			}
		}
		else if (irany==4) {
			if(tomb[x][y+1]==" "|| tomb[x][y+1]=="E") {
				if(y+1!=tomb.length-1) {
					tomb[x][y]=" ";
					tomb[x][y+1]="V";
					setY(y+1);
					lepett++;
					irany=4;
			
				}
			}else if(tomb[x][y+1]=="a" || tomb[x][y+1]=="A" ) {
			
				tomb[x][y]="V";
				lepett++;
				irany=4;
			
			}else if(tomb[x][y+1]=="O" ||(tomb[x][y+1]=="S" && tomb[x+1][y+1]==" ")) {   //tehat ha az edes alma eppen zuhan
				tomb[x][y]=" ";
				irany=4;
			}else {
				tomb[x][y]="V";
				irany=4;
			}
		}
		irany=rnd.nextInt(4)+1;
		futott++;
	}
	}
}
	}
}
}
