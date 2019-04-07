package designpatterns;

public class AbstractFactoryMethod {
	public static void main(String[] args) {
		CharacterFactory factory = new UserCharacterFactory();
		Archer archer = factory.getArcher();
		Knight knight = factory.getKnight();
		Dragon dragon = factory.getDragon();
		
		archer.shoot();
		knight.attack();
		dragon.burn();
		dragon.eat();
	}
}

interface Archer {
	void shoot();	
}

interface Knight {
	void attack();
	void defend();
}

interface Dragon {
	void fly();
	void burn();
	void eat();
}

interface CharacterFactory {
	Archer getArcher();
	Knight getKnight();
	Dragon getDragon();
}

class UserArcher implements Archer {
	
	@Override
	public void shoot() {
		System.out.println("Shoot at the enemy");
	}
}

class UserKnight implements Knight {

	@Override
	public void attack() {
		System.out.println("Attack the enemy!");		
	}

	@Override
	public void defend() {
		System.out.println("Defend from the enemy!");		
	}	
}

class UserDragon implements Dragon {

	@Override
	public void fly() {
		System.out.println("Fly over enemy land");		
	}

	@Override
	public void burn() {
		System.out.println("Burn all enemies!");		
	}

	@Override
	public void eat() {
		System.out.println("Eat all enemies!");		
	}	
}

class EnemyArcher implements Archer {
	
	@Override
	public void shoot() {
		System.out.println("Shoot at the user' warriors");
	}
}

class EnemyKnight implements Knight {

	@Override
	public void attack() {
		System.out.println("Attack the user' warriors!");		
	}

	@Override
	public void defend() {
		System.out.println("Defend from the user' warriors!");		
	}	
}

class EnemyDragon implements Dragon {

	@Override
	public void fly() {
		System.out.println("Fly over user land");		
	}

	@Override
	public void burn() {
		System.out.println("Burn all user' warriors!");		
	}

	@Override
	public void eat() {
		System.out.println("Eat all user' warriors!");		
	}	
}

class UserCharacterFactory implements CharacterFactory {

	@Override
	public Archer getArcher() {
		return new UserArcher();
	}

	@Override
	public Knight getKnight() {
		return new UserKnight();
	}

	@Override
	public Dragon getDragon() {
		return new UserDragon();
	}	
}

class EnemyCharacterFactory implements CharacterFactory {

	@Override
	public Archer getArcher() {
		return new EnemyArcher();
	}

	@Override
	public Knight getKnight() {
		return new EnemyKnight();
	}

	@Override
	public Dragon getDragon() {
		return new EnemyDragon();
	}	
}
