package designpatterns;

public class FactoryMethod {
	public static void main(String[] args) {
		Artist artist = new PortraitArtist();
		Picture picture = artist.drawPicture();
		picture.showPicture();
	}
}

interface Picture {
	void showPicture();
}
class LandscapePicture implements Picture {
	
	@Override
	public void showPicture() {
		System.out.println("Showing landscape picture");
	}
}

class PortraitPicture implements Picture {
	
	@Override
	public void showPicture() {
		System.out.println("Showing portrait picture");
	}
}

interface Artist {
	Picture drawPicture();
}

class LandscapeArtist implements Artist {
	
	@Override
	public Picture drawPicture() {
		return new LandscapePicture();
	}	
}

class PortraitArtist implements Artist {
	
	@Override
	public Picture drawPicture() {
		return new PortraitPicture();
	}	
}
