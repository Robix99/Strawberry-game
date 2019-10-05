package Jatek;

import java.util.Random;

public class Cseresznye {
	public void cseresznyeLerak(String tomb[][]) {
		Random rand=new Random();
		int x=rand.nextInt(tomb.length-1)+1;
		int y=rand.nextInt(tomb.length-1)+1;
		while(tomb[x][y]!=" ") {
			x=rand.nextInt(tomb[0].length-1)+1;
			y=rand.nextInt(tomb[0].length-1)+1;
		}
			tomb[x][y]="C";
		}
}
