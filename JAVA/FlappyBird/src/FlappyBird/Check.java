package FlappyBird;

public class Check {
	Bird bird = new Bird();
	Tube tube = new Tube();

	public boolean died() {
		// chạm đất
		if (bird.getY() + 40 >= 400)
			return true;

		// ống trên
		if (bird.getY() <= tube.getH1() && (((bird.getX() + 35) >= tube.getX1())) && bird.getX() <= (tube.getX1() + 50))
			return true;

		if (bird.getY() <= tube.getH2() && (((bird.getX() + 35) >= tube.getX2())) && bird.getX() <= (tube.getX2() + 50))
			return true;

		if (bird.getY() <= tube.getH3() && (((bird.getX() + 35) >= tube.getX3())) && bird.getX() <= (tube.getX3() + 50))
			return true;

		if (bird.getY() <= tube.getH4() && (((bird.getX() + 35) >= tube.getX4())) && bird.getX() <= (tube.getX4() + 50))
			return true;

		// ống dưới
		if ((bird.getY() + 35) >= (tube.getH1() + 150)
				&& (((bird.getX() + 35) >= tube.getX1()) && bird.getX() <= (tube.getX1() + 50)))
			return true;

		if ((bird.getY() + 35) >= (tube.getH2() + 150)
				&& (((bird.getX() + 35) >= tube.getX2()) && bird.getX() <= (tube.getX2() + 50)))
			return true;

		if ((bird.getY() + 35) >= (tube.getH3() + 150)
				&& (((bird.getX() + 35) >= tube.getX3()) && bird.getX() <= (tube.getX3() + 50)))
			return true;

		if ((bird.getY() + 35) >= (tube.getH4() + 150)
				&& (((bird.getX() + 35) >= tube.getX4()) && bird.getX() <= (tube.getX4() + 50)))
			return true;

		// if(bird.getY() + 35 <= tube.getH1() + 150) return true;
		return false;
	}
}
