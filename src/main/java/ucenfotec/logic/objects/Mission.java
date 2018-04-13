package ucenfotec.logic.objects;

import java.util.ArrayList;


public class Mission {
	
	private String name;
	private ArrayList<Objective> objectives;
	
	public Mission(String pName) {
		this.setName(pName);
	}
	
	public Mission() {}
	
	public void addObjetivesIntoMission(String pName, boolean pStatus){
		Objective newObjective = new Objective(pName, pStatus);
		
		try {
			this.objectives.add(newObjective);
		}catch(Exception error) {
			error.getClass();
			error.getMessage();
		}
		
	}
	
	public int objectivesAchieved() {
		return 0;//Refactorizar después
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Objective> getObjectives() {
		return objectives;
	}
	
	
}
