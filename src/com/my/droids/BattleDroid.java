package com.my.droids;

import com.my.field.PrintMesseges;

public class BattleDroid extends Droid {
	
	private String name = "BattleDroid";
	private int helthLevel=200;
	private int shotPower=30;
	private int shield=200;
	private boolean isBlaster;
	private boolean isWalk=true;
	private PrintMesseges printMesseges = new PrintMesseges();
	
	
	public BattleDroid() {
		
	}

	@Override
	public int GunPower(){
		if(isBlaster==true){
			
			return shotPower+10;
		}else{
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
				printMesseges.printNoSuchItem();
				selectWeapon();
				return 1;
			case 4:
				super.regenerate();
				return 0;
			// case 5: treatFriend();
			}
			return 1;
		
	}
	
	
	
}
