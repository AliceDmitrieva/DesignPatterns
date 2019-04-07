package designpatterns;

public class Builder {
	public static void main(String[] args) {
		Director director = new Director();
		director.setBuilder(new BigHouseBuilder());
		House house = director.buildHouse();
	}
}
class House {
	private int countOfBricks = 100;
	private int countOfWindows = 10;
	
	public int getCountOfBricks() {
		return countOfBricks;
	}
	
	public int getCountOfWindows() {
		return countOfWindows;
	}
	
	public void setCountOfBricks(int countOfBricks) {
		this.countOfBricks = countOfBricks;
	};
	
	public void setCountOfWindows(int countOfWindows) {
		this.countOfWindows = countOfWindows;
	}
}

interface HouseBuilder {
	void createNewHouse();
	void dragBricks();
	void mason();
	void roof();
	void setUpDoor();
	void setUpWindows();
	House getHouse();
}

class SmallHouseBuilder implements HouseBuilder {
	House house;
	private int countOfBricks;
	private int countOfWindows;	
	
	@Override
	public void createNewHouse() {
		house = new House();
	}
	
	@Override
	public void dragBricks() {
		house.setCountOfBricks(700);
	}

	@Override
	public void mason() {
		System.out.println("Mason for small house");		
	}

	@Override
	public void roof() {
		System.out.println("Roof for small house");		
	}

	@Override
	public void setUpDoor() {
		System.out.println("Set up door for small house");		
	}

	@Override
	public void setUpWindows() {
		house.setCountOfWindows(150);		
	}
	
	@Override
	public House getHouse() {
		return house;
	}
}

class BigHouseBuilder implements HouseBuilder {
	House house;
	private int countOfBricks;
	private int countOfWindows;	
	
	@Override
	public void createNewHouse() {
		house = new House();
	}
	
	@Override
	public void dragBricks() {
		house.setCountOfBricks(55600);
	}

	@Override
	public void mason() {
		System.out.println("Mason for big house");		
	}

	@Override
	public void roof() {
		System.out.println("Roof for big house");		
	}

	@Override
	public void setUpDoor() {
		System.out.println("Set up door for big house");		
	}

	@Override
	public void setUpWindows() {
		house.setCountOfWindows(1000);
	}
	
	@Override
	public House getHouse() {
		return house;
	}
}

class Director {
	HouseBuilder builder;
	void setBuilder(HouseBuilder b) {
		builder = b;
	}
	
	House buildHouse() {
		builder.createNewHouse();
		builder.dragBricks();
		builder.mason();
		builder.roof();
		builder.setUpDoor();
		builder.setUpWindows();
		return builder.getHouse();
	}
}

