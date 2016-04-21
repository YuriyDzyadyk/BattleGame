package com.my.droids;

import com.my.field.PrintMesseges;

public class BlasterDroid extends Droid {

	private String name = "BlasterDroid";
	private int helthLevel = 150;
	private int shotPower = 30;
	private int shield = 150;
	private boolean isBlaster;
	private boolean isRoket;
	private boolean isWalk = true;
	private PrintMesseges printMesseges = new PrintMesseges();

	public BlasterDroid() {
	}

	@Override
	public int GunPower() {
		if (isBlaster == true) {

			return shotPower +10;
		} else if (isRoket == true) {
			return shotPower +20;
		} else {
			return shotPower;
		}
	}

	@Override
	public void shoot(Droid droid) {

		super.shoot(droid);
	}

	@Override
	public void attack(Droid droid) {
		super.attack(droid);

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

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
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

	public boolean isWalk() {
		return isWalk;
	}

	public void setWalk(boolean isWalk) {
		this.isWalk = isWalk;
	}

	@Override
	public int selectWeapon() {
		System.out.print(getName());
		int choise = printMesseges.printSelectWeapon();
		switch (choise) {
		case 1:
			super.fight();
			return 1;
		case 2:
			super.fightWithBlaster();
			return 1;
		case 3:
			super.fightWithRoket();
			return 1;
		case 4:
			super.regenerate();
			return 0;
		}
		return 1;
		
	}

	
}
