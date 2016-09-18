package health;

import java.util.LinkedList;

public class Exercise {

	String name;
	int reps;
	int weight;
	int exerciseID;
	Integer[]set = new Integer[2];//store each set in an array
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
	
	public StringBuilder printSets(){
		//array to store each set in
		Integer[]x = new Integer[2];
		StringBuilder string = new StringBuilder();
		//get each set[]
		for(int n=0; n<totalSets.size(); n++){
			x = totalSets.get(n);	
			//print out the set array
			for(int i=0;i<x.length;i++){
				if(i==0){
					string.append("Reps: " + x[i] + " ");
				}
				else if(i==1){
					string.append("Weight: " + x[i] + " ");
				}			
			}		
		}
	return string;
	}

	public StringBuilder printExercise(){
		StringBuilder string = new StringBuilder();
		string.append("Exercise Name" + getName() + " ");
		string.append(printSets());
		return string;
	}
	
}
