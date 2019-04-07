package designpatterns;

public class Prototype {
	public static void main(String[] args) {
		Cat simon = new Cat(10, "Simon");
		System.out.println(simon);
		
		Cat copyOfSimon = (Cat) simon.copy();
		System.out.println(copyOfSimon);
		
		CatFactory factory = new CatFactory(simon);
		Cat copyOfSimonTwo = factory.makeCopy();
		System.out.println(copyOfSimonTwo);
		
		factory = new CatFactory(new Cat(13, "Casper"));
		Cat casper = factory.makeCopy();
		System.out.println(casper);
	}
}

interface Copyable {
	Object copy();
}

class Cat implements Copyable {
	int age;
	String name;
	public Cat (int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Cat [age=" + age + ", name=" + name + "]";
	}
	
	@Override
	public Object copy() {
		Cat copyOfCat = new Cat(age, name);
		return copyOfCat;
	}
}

class CatFactory {
	Cat cat;
	
	public CatFactory(Cat cat) {
		this.cat = cat;
	}
	
	public Cat makeCopy() {
		return (Cat) cat.copy();
	}
}