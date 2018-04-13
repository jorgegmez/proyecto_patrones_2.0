package ucenfotec.logic.objects;

public class Item {
	
	private String name;
	private int power;
	
	public Item(String pName, int pPower) {
		this.setName(pName);
		this.setPower(pPower);
	}
	
	public Item() {}
	
	public int addPowerToCharacterByItem() {
		return 0;//Refactorizar después
	}

	public String getName() {
		return name;
	}

	public void setName(String pName) {
		this.name = pName;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int pPower) {
		this.power = pPower;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", power=" + power + "]";
	}
	
}
