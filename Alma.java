package Jatek;
import java.util.Random;



public class Alma {
	
	Random rnd= new Random();
	public int x=0;
	public int y=0;
	public int irany=rnd.nextInt(4)+1;
	
	public Alma(int x, int y, int irany) {
		this.x = x;
		this.y = y;
		this.irany = irany;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
		
		tomb[x][y]="a";
	}
		
		
	public void almaMozog(String tomb[][]) {
		int lepett=0;
		int futott=0;
	
		if(tomb[x][y]=="a") {
			while(lepett==0 && futott<100) {		//futott<100 --> ennyiszer probaljon meg uj utat talalni. ha vegkepp nem tud sehova sem lepni akkor veget er a ciklus 100 proba utan
				int x=this.x;
				int y=this.y;
				Random rnd=new Random();
				int esely=rnd.nextInt(5)+1;				//ha random generalunk 5 szamot, abbol az egyik megfelel 20%-nak.
			
				if(esely==5) {			
					if(irany==1) {
						int random=rnd.nextInt(2)+1; 
						if	(random==2) {
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
						}					
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
				
					if(irany==1) {
						if(tomb[x-1][y]==" " || tomb[x-1][y]=="E") {
							if(x-1!=0) {
								tomb[x][y]=(" ");
								tomb[x-1][y]="a";
								setX(x-1);
								lepett=1;	
								irany=1;
							}
						}else if(tomb[x-1][y]=="a"|| tomb[x-1][y]=="A" || tomb[x-1][y]=="V"|| tomb[x-1][y]=="C") {
							tomb[x][y]="a";
							irany=1;
						}else if(tomb[x-1][y]=="O") {
							tomb[x][y]=" ";
							irany=1;
						}
						else {
							tomb[x][y]="a";
							irany=1;
						}
						
					}else if(irany==2) {
						if (tomb[x][y-1]==" "|| tomb[x][y-1]=="E") {
							if(y-1!=0) {
								tomb[x][y]=" ";
								tomb[x][y-1]="a";
								setY(y-1);
								lepett=1;
								irany=2;
							}
						}else if(tomb[x][y-1]=="a"|| tomb[x][y-1]=="A"|| tomb[x][y-1]=="V"|| tomb[x][y-1]=="C") {
							tomb[x][y]="a";
							irany=2;
						}else if(tomb[x][y-1]=="O") {   //tehat ha az alma eppen esik
							tomb[x][y]=" ";
							irany=2;
						}
						else {
							tomb[x][y]="a";
							irany=2;
						}
					}else if(irany==3) {
						if(tomb[x+1][y]==" "|| tomb[x+1][y]=="E") {
							if(x+1!=tomb.length-1) {
								tomb[x][y]=" ";
								tomb[x+1][y]="a";
								setX(x+1);
								lepett=1;
								irany=3;
							}
						}else if(tomb[x+1][y]=="a"|| tomb[x+1][y]=="A"|| tomb[x+1][y]=="V"|| tomb[x+1][y]=="C") {
							tomb[x][y]="a";
							irany=3;
						}else if(tomb[x+1][y]=="O") {
							tomb[x][y]=" ";
							irany=3;
						}
						else {
							tomb[x][y]="a";
							irany=3;
						}
					}
					else if (irany==4) {
						if(tomb[x][y+1]==" "|| tomb[x][y+1]=="E") {
							if(y+1!=tomb.length-1) {
								tomb[x][y]=" ";
								tomb[x][y+1]="a";
								setY(y+1);
								lepett=1;
								irany=4;
							}
						}else if(tomb[x][y+1]=="a" || tomb[x][y+1]=="A" || tomb[x][y+1]=="V"|| tomb[x][y+1]=="C") {
							tomb[x][y]="a";
							
							irany=4;
						}else if(tomb[x][y+1]=="O") {   //tehat ha az edes alma eppen zuhan
							tomb[x][y]=" ";
							irany=4;
						}else {
							tomb[x][y]="a";
							irany=4;
						}
					}else {
					irany=rnd.nextInt(4)+1;
					lepett=0;
					}
					futott++;		
			}
			}
		}
	}

