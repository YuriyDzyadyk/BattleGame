package com.my.field;

import java.util.Scanner;

import com.my.droids.BattleDroid;
import com.my.droids.Droid;
import com.my.droids.RoketDroid;

public class PrintMesseges {

	public String giveTheName() {
		System.out.println("Please give the name to your soldiers ");
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();

	}
	public void printName(Droid droid) {
		System.out.println("I'm a " + droid.getName());
		
	}
	
	public int printGameStart() {
		System.out.println("\n Choose your hero:\n1. Battle Droid \n2. Blaster Droid \n3. Roket Droid \n4. Choose randomly");
		Scanner sc = new Scanner(System.in);
		int herroChooser = 0;
		if (sc.hasNextInt()) {
			herroChooser = sc.nextInt();
			if(herroChooser>0&&herroChooser<5){
				return herroChooser;
			}else{
				System.out.println("Try again. Use numbers from 1 to 4");
				printGameStart();
				return 0;
			}
			
		} else {
			System.out.println("Your choise is wrong. ( Use numbers from 1 to 4)");
			printGameStart();
			return 0;
	}
		}
	
	public int printSelectDefense(Droid droid){
		
		System.out.println(droid.getName()
				+ " you under atack, choose type of protection: \n1. Use shield for protection \n2. \"I'm a JEDAY and I use only lightsaber\" \n3. \"I want to be a hero and fight without anything\"   ");
		Scanner sc0 = new Scanner(System.in);
		int actionChoiser = 0;
		if (sc0.hasNextInt()) {
			actionChoiser = sc0.nextInt();
			if(actionChoiser>0&&actionChoiser<4){
				return actionChoiser;
			}else{
				System.out.println("Try again. Use numbers from 1 to 3");
				printSelectDefense(droid);
				return 0;
			}
		} else {
			System.out.println("Your choise is wrong");
			printSelectDefense(droid);
			return 0;
		}
					
	}
	
	public int printSelectWeapon() {
		System.out.println(" take a weapon and strikes: \n1. Use your Lightsaber \n2. Use Blaster \n3. Use a Rockt \n4. \"I'm to weak a will use first aid kit\"");
		Scanner sc = new Scanner(System.in);
		int choise = 0;
		if (sc.hasNextInt()) {
			choise = sc.nextInt();
			if(choise>0&&choise<5){
				return choise;
			}else{
				System.out.println("Try again. Use numbers from 1 to 4");
				printSelectWeapon();
				return 0;
			}
		} else {
			System.out.println("Your choise is wrong. (press from 1 to 4)");
			printSelectWeapon();
			return 0;
		}
		
	}
	
	
	public void printBattleReport(Droid droid) {
		 System.out.println("Battle Summary (damages/inventory)");
		 System.out.println("______________________________");
		 System.out.println("| " + droid.getName() + " Helth:\t" +droid.getHelthLevel());
		 System.out.println("______________________________");
		 System.out.println("| Shield pover:\t"+ printShieldStatus(droid));
		 System.out.println("______________________________");
		 System.out.println("| Lightsaber:\t"+ "Loaded");
		 System.out.println("______________________________");
		 System.out.println("| Blaster:\t" + printBlasterStatus(droid));
		 System.out.println("_______________________________");
		 System.out.println("| Rocket:\t" + printRoketStatus(droid));
		 System.out.println("_______________________________");
		 System.out.println("| Aid:\t\t" + printAidStatus(droid));
		 System.out.println("_______________________________");
	}

	private String printBlasterStatus(Droid droid) {
		return (droid.getBlasterReloading() % 2 != 0) ? " Loaded" : "Reloading";
	}

	private String printAidStatus(Droid droid) {
		if(droid instanceof RoketDroid){
		return "No, such item";
	}else{
		return (droid.getAidKit() % 4 == 0) ? " Loaded" : "Reloading";
		}
	}

	private String printRoketStatus(Droid droid) {
		if(droid instanceof BattleDroid){
			return "No, such item";
		}else{
			return (droid.getRocketReloading() % 3 == 0) ? " Loaded" : "Reloading";			
		}
	}
	private String printShieldStatus(Droid droid) {
		return (droid.getShield()>0) ? (""+droid.getShield()) : "Shield broken";
	}
	public void printNoSuchItem() {
		System.out.println("No, such item");
		
	}
	public void noAttack() {
		System.out.println("He does not shoot. Your turn");
		
	}
	

}
