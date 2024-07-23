package FlappyBird;

public class addPoint {
	private static int point = 0;
	private Bird bird = new Bird();
	private static boolean b1 = false,b2 = false, b3 = false, b4 = false;
	
	Tube tube = new Tube();
	
	public int getPoint() {
		return point;
	}
	
	public void congdiem() {
		if(bird.getX() + 30 >= tube.getX1() && bird.getX() < tube.getX1() + 50) b1 = true;
		if(bird.getX() + 30 >= tube.getX2() && bird.getX() < tube.getX2() + 50) b2 = true;
		if(bird.getX() + 30 >= tube.getX3() && bird.getX() < tube.getX3() + 50) b3 = true;
		if(bird.getX() + 30 >= tube.getX4() && bird.getX() < tube.getX4() + 50) b4 = true;
		
		if(b1 == true && bird.getX() >tube.getX1() + 50) {point++; b1 = false;}
		if(b2 == true && bird.getX() >tube.getX2() + 50) {point++; b2 = false;}
		if(b3 == true && bird.getX() >tube.getX3() + 50) {point++; b3 = false;}
		if(b4 == true && bird.getX() >tube.getX4() + 50) {point++; b4 = false;}
	}
}
