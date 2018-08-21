package model;

import javafx.beans.property.SimpleStringProperty;

public class Person {
	
	
	private String firstName;
	private String lastName;
	private String roomNr;
	private String inHour;
	private String outHour;
	
	
	public Person(){
		
		this.firstName = "";
		this.lastName = "";
		this.roomNr = "";
		this.inHour = "";
		this.outHour = "";
		
	}
	
	
	public Person( String firstName, String lastName,String roomNr, String inHour, String outHour){
		
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.roomNr = roomNr;
		this.inHour = inHour;
		this.outHour = outHour;
	}
	
	public void setRoomNr(String roomNr){
		
		this.roomNr = roomNr;
		
	}
	
	public String getRoomNr(){
		
		return roomNr;
		
			}
	
	public void setFirstName(String firstName){
		
		this.firstName =firstName;
		
	}
	
	public String getFirstName(){
		
		return firstName;
		
	}
	
	public void setLastName(String lastName){
		
		this.lastName = lastName;
		
	}

	public String getLastName(){
	
	return lastName;
	
		}
	
public void setInHour(String inHour){
		
		this.inHour = inHour;
		
	}

	public String getInHour(){
	
	return inHour;
	
		}
	
public void setOutHour(String outHour){
		
		this.outHour = outHour;
		
	}

	public String getOutHour(){
	
	return outHour;
	
		}
	
	

}
