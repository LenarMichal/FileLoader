package controller;

import java.util.Comparator;

import model.Person;

public class Komparator implements Comparator<Person> {
	
	Person p1 = new Person();
	Person p2 = new Person();
	
	
	public int compare(Person p1 , Person p2) {
		
		
        if(Integer.parseInt(p1.getOutHour()) - Integer.parseInt(p1.getInHour())  > Integer.parseInt(p2.getOutHour()) - Integer.parseInt(p2.getInHour())) 
        	return 1;
        else if(Integer.parseInt(p1.getOutHour()) - Integer.parseInt(p1.getInHour())  < Integer.parseInt(p2.getOutHour()) - Integer.parseInt(p2.getInHour()))
        	return -1;
        else return 0;
	}

	

	


}
