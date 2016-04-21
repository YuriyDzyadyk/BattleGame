package com.my.field;

import java.util.Random;

import com.my.droids.BattleDroid;
import com.my.droids.BlasterDroid;
import com.my.droids.Droid;
import com.my.droids.RoketDroid;

public class BattleField {
	
	private Droid FirstShoter;
	private Droid SecondShoter;
	private PrintMesseges printMesseges = new PrintMesseges();
	private boolean isAlive;
	
	
	private Droid droidsCreation() {
	Droid b = null; 
		int myDroid = printMesseges.printGameStart();
	switch (myDroid) {
	case 1:
			return b = new BattleDroid();
	case 2:
			return b = new BlasterDroid();
	case 3:
			return b = new RoketDroid();
	case 4:

	}
	Random rndDroid = new Random();
	switch (rndDroid.nextInt(3)) {
	case 0:
			return b = new BattleDroid();
	case 1:
			return b = new BlasterDroid();
	case 2:
			return b = new RoketDroid();
	}
	return b;
		}
	public void droidSelection(){
	System.out.println("Hi, guys, lets start the battle !");
	Droid b1 = droidsCreation();
	printMesseges.printBattleReport(b1);
	printMesseges.printName(b1);
	b1.setName(printMesseges.giveTheName());
	Droid b2 = droidsCreation();
	printMesseges.printBattleReport(b2);
	printMesseges.printName(b2);
	b2.setName(printMesseges.giveTheName());
	Droid [] droids = {b1, b2};
	Random rnd = new Random();
	
	FirstShoter = droids[rnd.nextInt(droids.length)];
	SecondShoter =(FirstShoter==b2) ? b1: b2;

	}
				
	
	
	
private boolean isAlive(){
	

		if(SecondShoter.getHelthLevel()<=0){
		System.out.println("And winer is " + FirstShoter.getName());
			return isAlive=false;
		}else if(FirstShoter.getHelthLevel()<=0){
			System.out.println("And the winer is " + SecondShoter.getName());
			return isAlive=false;
		}else{
			return isAlive=true;
		}
	
	}
	public void raund(){
		
		do{
		if(isAlive()==true){
			FirstShoter.attack(SecondShoter);
		}else{
			isAlive=false;
			break;
		}
		if(isAlive()==true){
			SecondShoter.attack(FirstShoter);
			
		}else{
			isAlive=false;
			break;
		}
			raund();
		}while(isAlive==true);
		
	}
	

}
