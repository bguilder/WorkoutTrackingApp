package health;

import java.util.LinkedList;

public class Exercise {

	String name;
	int reps;
	int weight;
	int exerciseID;
	Integer[]set = new Integer[2];
	LinkedList<Integer[]> totalSets = new LinkedList<Integer[]>(); //ArrayList of the total sets with reps and weight

	public Exercise(){	
	}
	
	public Exercise(String name, Integer[] set, int exerciseNum) {
		this.name = name;
		this.set = set;
	}
	public Exercise(String name, LinkedList<Integer[]> totalSets){
		this.name = name;
		this.totalSets = totalSets;		
	}
	public Exercise(String name, int exerciseNum){
		this.name = name;
		this.exerciseID = exerciseNum;
	}
	
	public void addSet(int reps, int weight){
		Integer[]s1 = new Integer[2];
		s1[0]=reps;
		s1[1]=weight;
		totalSets.add(s1);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getReps() {
		return reps;
	}
	public void setReps(int reps) {
		this.reps = reps;
	}
	
	public void printSets(){
		Integer[]gg = new Integer[2];
		
		for(int n=0; n<totalSets.size(); n++){

			gg = totalSets.get(n);			
			for(int x=0;x<gg.length;x++){
				System.out.print(gg[x] + " ");
			}
			System.out.println();
		}
	
	}

	@Override
	public String toString(){
		return "Exercise Name: " + getName()  ;
	}
	
}
