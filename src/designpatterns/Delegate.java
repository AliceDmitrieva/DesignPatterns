package designpatterns;

public class Delegate {
	public static void main(String[] args) {
		ProjectManager manager = new ProjectManager();
		manager.setDeveloper(new WebDeveloper());
		manager.programme();
	}
}

interface Developer {
	void programme();
}

class WebDeveloper implements Developer {
	public void programme() {
		System.out.println("Code web-application");
	}
}

class MobileDeveloper implements Developer {
	public void programme() {
		System.out.println("Code mobile-application");
	}	
}

class ProjectManager {
	Developer developer;
	void setDeveloper(Developer dev) {
		developer = dev;
	}
	
	void programme() {
		developer.programme();
	}
}