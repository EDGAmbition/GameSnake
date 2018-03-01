package my.game;

public class Food {
	int x;
	int y;
	Food(){
		x = (int) (10 + (int)15*Math.random());
		y = (int) (6  + (int)15*Math.random());
	}
}
