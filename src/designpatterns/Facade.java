package designpatterns;

public class Facade {
	public static void main(String[] args) {
		Drawing drawing = new Drawing();
		drawing.makeDrawing();
	}
}

class Drawing {
	Paper paper = new Paper();
	Pencil pencil = new Pencil();
	PencilSharpener pencilSharpener = new PencilSharpener();
	
	public void makeDrawing() {
		paper.takePaper();
		pencil.setSharpen();
		pencilSharpener.sharpenPencil(pencil);
	}
}

class Paper {
	void takePaper() {
		System.out.println("Take paper");
	}
}

class Pencil {
	private boolean sharpen = false;
	boolean isSharpen() {
		return sharpen;
	}
	
	void takePencil() {
		System.out.println("Take pencil");
	}
	
	void setSharpen() {
		sharpen = true;
	}
}

class PencilSharpener{
	void sharpenPencil(Pencil pencil) {
		if (!pencil.isSharpen()) {
			System.out.println("Sharpen pencel");
		}
		else {
			pencil.takePencil();
		}
	}
}