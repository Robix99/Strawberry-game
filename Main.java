/**
 * Tutti Frutti jatek  
 * @author Kiss Robert D9AX3A
 * @version 1.0
 */
import Jatek.*;
import java.util.*;
import Jatek.Alma;
import java.util.*;
import java.util.Scanner;
import java.awt.*; 
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame{
	
	
	public static void main(String[] args) {	
		
		
		
		Talaj palya=new Talaj();
		System.out.println("Udvozollek a tutti frutti jatekban!");
		System.out.println("A jatek celja elkerulni a savanyu almakat(a), es megszerezni az osszes cseresznyet(C)!");
		System.out.println("Az epret a 'wasd' billentyukkel, majd az enter megnyomasaval lehet iranyitani!");
		System.out.println("Az X gomb, majd az enter megnyomasaval labdat tudsz kiloni, amivel megolheted az almakat.");
		System.out.println("Ha a labda strapabiro almat(A) talal el, akkor az alma sima almava valtozik es marad 1 elete!");
		System.out.println("A palyan talalhato edes alma(S) lezuhan, ha nincs alatta fold. Ha valami a zuhano almahoz er, az meghal.");
		System.out.println("Sok szerencset!");
		System.out.println("Kerlek valassz palyat:");
		System.out.println("Palya 1(1), palya 2 (2), palya 3(3), random palya(4)");
		
		Scanner sc2= new Scanner(System.in);
		String valasztas=" ";		//Azert String, hogy ha szoveget ad meg, akkor is hiba legyen
		int meret=0; //A palya merete
		
		while(valasztas!="1" ||valasztas!="2"|| valasztas!="3" || valasztas!="4" ) {
			
			valasztas=sc2.nextLine();
			if(valasztas.equals("1")) {
				meret=13;
				break;
			}else if(valasztas.equals("2")) {
				meret=13;
				break;
			}else if(valasztas.equals("3")) {
				meret=13;
				break;
			}else if(valasztas.equals("4")) {
				meret= palya.palyameret();
				break;
			}else{
				System.out.println("Kerlek csak a kovetkezo szamokbol valassz: Palya 1(1), palya 2 (2), palya 3(3), random palya(4) ");
			}
		}
		
		String [][]tomb=new String[meret+2][meret+2]; // Letrehozza a palyat kezelo tombot, azert +2 mert a palya szelei falak
		if(valasztas.equals("1")) {
			palya.palyaelore1(tomb);
		}else if(valasztas.equals("2")) {
			palya.palyaelore2(tomb);
		}else if(valasztas.equals("3")) {
			palya.palyaelore3(tomb);
		}else if(valasztas.equals("4")) {
			palya.palyagen(tomb);
		}
	
		Eper eper=new Eper();
		
		eper.eperLerak(tomb);
		int almak=0;
		int cseresznyek=0;
		
		System.out.println("Kerlek valassz nehezseget: Konnyu(1), Kozepes(2), Nehez(3)");
		
		String valasz=" ";
	
		while(valasz!="1"||valasz!="2"|| valasz!="3") {
			Scanner sc5=new Scanner(System.in);
			valasz=sc5.nextLine();
			
			if(valasz.equals("1")) {
				if((meret)*(meret)%70==0) {
					almak=((meret)*(meret)/70)-2;
					valasz="1";
					break;
				}else {
					almak=((meret)*(meret)/70)-1;
					valasz="1";
					break;
				}
			}else if(valasz.equals("2")) {
				if((meret-2)*(meret)%50==0) {
					almak=((meret*meret)/50)-2;
					valasz="2";
					break;
				}else {
					almak=((meret*meret)/50)-1;	
					valasz="2";
					break; //azert vonunk ki -1/-2-ot , mert 1 strapabiro es 1 vad alma lesz lerakva minden jatekban
				} 	
			
			}else if(valasz.equals("3")) {
				if(meret*meret%30==0) {
					almak=((meret*meret)/30)-2;
					valasz="3";
					break;
				}else {
					almak=((meret*meret)/30)-1;
					valasz="3";
					break;
				}
			}else {
				System.out.println("Kerlek csak az alabbiakbol valassz: Konnyu(1), Kozepes(2), Nehez(3)");
			}
		}
		
		if(valasz.equals("1")) {
			if((meret)*(meret)%20==0) {
				cseresznyek=((meret)*(meret-2)/20);
			}else {
				cseresznyek=((meret)*(meret)/20)+1;
			}
		}else if(valasz.equals("2")) {
			if(meret*meret%14==0) {
				cseresznyek=((meret*meret)/14);
			}else {
				cseresznyek=((meret*meret)/14)+1;
			} 	
			
		}else if(valasz.equals("3")) {
			if(meret*meret%8==0) {
				cseresznyek=((meret*meret)/8);
			}else {
				cseresznyek=((meret*meret)/8)+1;
			}
		}
		
		
		Alma[] alma=new Alma[almak];
		StrapabiroAlma strapa=new StrapabiroAlma(0,0,0,2);
		Edesalma edes=new Edesalma(0,0,0);
		VadAlma vad=new VadAlma(0,0,0);									//letrehozza az objektumokat ( 1 db strapabiro, 1db vad alma ,1 db edes alma es a jateknak megfelelo mennyisegu alma, cseresznye)
		Cseresznye[] cseresznye= new Cseresznye[cseresznyek];
		
		Palyakezelo palyakez=new Palyakezelo();							
		vad.almaLerak(tomb);
		for(int i=0; i<almak; i++) {
			alma[i]=new Alma(0,0,0);									//lerakja a sima alma objektumokat 
			alma[i].almaLerak(tomb);
		}
		
		
		Random rnd = new Random();
		eper.setUtkozhet(rnd.nextInt(3)+1);			//megadja, hogy a labda hanyszor utkozhet
		edes.almaLerak(tomb);
													//lerakja a vad es strapabiro almakat
		
		for(int i=0; i<cseresznyek; i++) {
			cseresznye[i]=new Cseresznye();
			cseresznye[i].cseresznyeLerak(tomb);						//cseresznyek lerakasa
		}
		strapa.almaLerak(tomb);
		palya.palyakiir(tomb); 
		
		int lepes=1;
		int atalakult=0;
		while(lepes<=10000) {
			eper.eperMozog(tomb);
			if (eper.labdamegy==true && eper.getUtkozott()<eper.getUtkozhet()){
				eper.labdaMozog(tomb);
			}
			
			for(int i=0; i<almak; i++) {
				alma[i].almaMozog(tomb);
			}
			
			if(strapa.getEletekszama()==2) {							//ketto kulon metodus foglalkozuk a strapabiro alma ket allapotanak mozgasaval
				strapa.almaMozog(tomb);
			}
			
			else if(strapa.getEletekszama()==1 && atalakult!=1) {		//lepes%2 mert csak minden masodik korben hullik az alma
				strapa.Strapaatalakul(tomb);	
				atalakult=1;
			}
			else if(strapa.getEletekszama()==1) {		//lepes%2 mert csak minden masodik korben hullik az alma
				strapa.egyeletualmaMozog(tomb);
			}
			
			//vad.almaMozog(tomb);
			
			if(lepes%2==0) {  //csak minden masodik korben esik az edes alma
				edes.Edesalmaesik(tomb);
			}
			
			for(int i=0; i<25; i++) {
				System.out.println(); //azert, hogy ne legyen felette az elozo kor kiiratasa
			}
			palya.palyakiir(tomb);
			palyakez.szamlalo(tomb);
			System.out.println("Cseresznyek: "+ palyakez.cseresznyeszam);
			System.out.println("Almak: " + palyakez.almaszam);
			System.out.println("Korok szama: "+ lepes);
			lepes++;
			if(palyakez.eperszam==0) {
				System.out.println("Meghaltal, a jateknak vege!");
				break;
			}else if(palyakez.almaszam==0) {
				System.out.println("Gratulalok, megolted az osszes almat! Nyertel! ");
				break;
				
			}else if(palyakez.cseresznyeszam==0) {
				System.out.println("Gratulalok, megetted az osszes cseresznyet! Nyertel! ");
				break;
			}
		
		}
		
	}
	
	
	
		
}
