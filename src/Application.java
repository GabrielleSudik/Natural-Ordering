import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Application {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		SortedSet<String> set = new TreeSet<String>();
		
		//you can use the following method (created below) for both objects
		//because it accepts a Collection as a parameter
		//and all Sets and Lists are types of Collections
		addElements(list);
		addElements(set);
		
		//fyi TreeSet will sort automatically
		//but we need to manually sort the ArrayList
		//with the following line.
		Collections.sort(list);
		
		showElements(list);
		System.out.println();
		showElements(set);
		System.out.println();
		
		//now let's repeat that but using objects of Person instead
		List<Person> list2 = new ArrayList<Person>();
		SortedSet<Person> set2 = new TreeSet<Person>();
		
		addPeople(list2); 
		showPeople(set2);
		
		Collections.sort(list2);
		
		showPeople(list2);
		System.out.println();
		showPeople(set2);
		System.out.println();
		//hmm... showPeople isn't printing the results.
		//it might have something to do with the compareTo method below
		//which is still boilerplate imported stuff
		//not yet re-written by you.

	}

	//Collection can be used as a sort of super class
	//over all sets and lists.
	//useful once in a while like here
	//where we create a method that can be used by both "list" and "set" objects
	private static void addElements(Collection<String> col) {
		col.add("Joe");
		col.add("Bea");
		col.add("Sue");
		col.add("Meg");
		col.add("Bob");
	}
	
	private static void showElements(Collection<String> col) {
		for (String element: col) {
			System.out.println(element);
		}
	}
	
	//these next two methods are for your custom class People
	//don't forget to make sure the parameter is the same as the object you're passing!
	private static void addPeople(Collection<Person> col2) {
		col2.add(new Person("Jack"));
		col2.add(new Person("Bill"));
		col2.add(new Person("Anne"));
		col2.add(new Person("Pegg"));
		col2.add(new Person("Dick"));
	}
	
	private static void showPeople(Collection<Person> col2) {
		for (Person folk: col2) {
			System.out.println(folk);
		}
	}
}

//since it's a custom class, it needs the implements Comparable<Thing> here
class Person implements Comparable<Person>{
	
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}

	//you added this unimplemented method:
	//and of course wrote the specific code.
	@Override
	public int compareTo(Person person) {
		
		return name.compareTo(person.name);
		//you can reverse that by adding a - before name.
	}

	//source--generate hashcode and equals
	//needed because this is a custom class
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
