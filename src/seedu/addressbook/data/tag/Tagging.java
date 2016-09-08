package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

public class Tagging {
	
	private Person person;
	private Tag tag;
	private char action;
	
	public Tagging(Person person, Tag tag, char action){
		this.person = person;
		this.tag = tag;
		this.action = action;
	}
	
	@Override
	public String toString(){
		return (action + " " + person.getName() + " [" + tag.tagName + "]");
	}
}
