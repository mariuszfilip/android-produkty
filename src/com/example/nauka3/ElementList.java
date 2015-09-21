package com.example.nauka3;

public class ElementList {
	
	private String name;
	
	private int id;
	
	public ElementList(int id_input,String name_input){
		setId(id_input);
		setName(name_input);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString(){
		return name;
		
	}
	

}
