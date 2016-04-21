package com.my.droids;

//прописати вибір персонажа !!!

import java.util.Random;
import java.util.Scanner;

import javax.xml.bind.ParseConversionEvent;

import com.my.field.PrintMesseges;

public abstract class Droid {
	private String name;
	private int helthLevel;
	private int shotPower;
	private int blasterReloading = 1;
	private int rocketReloading = 0;
	private int aidKit = 0;
	private int shield;
	private boolean isAidKit;
	private boolean isBlaster;
	private boolean isRoket;
	private PrintMesseges printMesseges = new PrintMesseges();

	public abstract int GunPower();



	public void shoot(Droid droid) {

		droid.setHelthLevel(droid.getHelthLevel() - GunPower());

	}

	

	public void attack(Droid droid) {
		int weaponSelect = selectWeapon();
		if(weaponSelect==1){
		selectDefense(droid);
		printMesseges.printBattleReport(droid);
		}else{
		printMesseges.printBattleReport(droid);
		printMesseges.noAttack();
		}
	}

	private void selectDefense(Droid droid) {
		int actionChoiser = printMesseges.printSelectDefense(droid);
			switch (actionChoiser) {
		case 1:
			battleWihtShield(droid);
			break;

		case 2:
			tryToEscape(droid);
			break;
		case 3:
			shoot(droid);
			break;
		}

	}

	public void battleWihtShield(Droid droid) {
		if (droid.getShield() > 0) {
			System.out.println("Well done, shield potect you");
			droid.setShield(droid.getShield() - GunPower());
			if (droid.getShield() > 0) {
				//System.out.println("pover of it " + droid.getShield());
			} else {
				System.out.println("Your shield out of pover");
			}
		} else {
			System.out.println("you don't have shield any more");
			shoot(droid);
		}

	}

	public void tryToEscape(Droid droid) {
		if(droid instanceof RoketDroid){
			System.out.println( "You are not JEDAY. You don't know how to block shots");
			selectDefense(droid);
		}else{
		Random isWalk = new Random();
		if (isWalk.nextBoolean() == true) {
			System.out.println("Well done, you are master. Lightsaber saved you.");
			
		} else {
			System.out.println("Damn, it's not your day, Enemy hit you");
			shoot(droid);
		}
		}
	}

	public abstract int selectWeapon();

	protected void fight() {
		roketCheck();
		blasterCheck();
		aidCheck();

	}

	protected void fightWithRoket() {
		if (rocketReloading % 3 == 0) {
			System.out.println("You will use Roket");
			setRoket(true);
			rocketReloading++;
			blasterCheck();
			aidCheck();

		} else {
			System.out.println("Reloding, Roket is not avalible ");
			selectWeapon();
		}

	}

	protected void fightWithBlaster() {

		if (blasterReloading % 2 != 0) {
			System.out.println("You will use Blaster");
			setBlaster(true);
			blasterReloading++;
			roketCheck();
			aidCheck();
		} else {
			System.out.println("Reloding, Blaster is not avalible ");
			selectWeapon();
		}
	}

	protected void regenerate() {

		if (aidKit % 4 == 0) {
			setAidKit(true);
			aidKit++;
			blasterCheck();
			roketCheck();
		} else {
			// System.out.println("Reloding, ");
			selectWeapon();
		}
			System.out.println("You choose first aid");
			setHelthLevel(getHelthLevel() + 50);
			System.out.println("Now  " + getName() + " your helth of is " + getHelthLevel());

	}

	private void blasterCheck() {
		if (blasterReloading % 2 != 0) {
			//System.out.println("B R");
		} else {
			// System.out.println("stil reloading");
			blasterReloading++;
		}
	}

	private void aidCheck() {
		if (aidKit % 4 == 0) {

		} else {
			aidKit++;
		}

	}

	private void roketCheck() {
		if (rocketReloading % 3 == 0) {
			// System.out.println(" R reload");
		} else {
			// System.out.println("Roket stil reloading");
			rocketReloading++;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHelthLevel() {
		return helthLevel;
	}

	public void setHelthLevel(int helthLevel) {
		this.helthLevel = helthLevel;
	}


	public int getShotPower() {
		return shotPower;
	}

	public void setShotPower(int shotPower) {
		this.shotPower = shotPower;
	}

	public int getBlasterReloading() {
		return blasterReloading;
	}

	public void setBlasterReloading(int blasterReloading) {
		this.blasterReloading = blasterReloading;
	}

	public int getRocketReloading() {
		return rocketReloading;
	}

	public void setRocketReloading(int rocketReloading) {
		this.rocketReloading = rocketReloading;
	}

	public int getAidKit() {
		return aidKit;
	}

	public void setAidKit(int aidKit) {
		this.aidKit = aidKit;
	}

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	public boolean isAidKit() {
		return isAidKit;
	}

	public void setAidKit(boolean isAidKit) {
		this.isAidKit = isAidKit;
	}

	public boolean isBlaster() {
		return isBlaster;
	}

	public void setBlaster(boolean isBlaster) {
		this.isBlaster = isBlaster;
	}

	public boolean isRoket() {
		return isRoket;
	}

	public void setRoket(boolean isRoket) {
		this.isRoket = isRoket;
	}

	

}
