package my.game;

import java.awt.Graphics;
import java.awt.Image;

public class Food {
	int x;
	int y;
	Food(){
		while(true) {
			x = (int) (10 + (int)(30*Math.random()));
			y = (int) (6 + (int)(30*Math.random()));
			if(Grid.grid[y][x] != Constant.IS_SNAKE) {
				break;
			}
		}
	}
	
	void newFood() {
		while(true) {
			x = (int) (10 + (int)(30*Math.random()));
			y = (int) (6 + (int)(30*Math.random()));
			if(Grid.grid[y][x] != Constant.IS_SNAKE) {
				break;
			}
		}
	}
	void drawFood(Graphics g) {
		Image img1=GameUtil.getImage("images/huaji.png");
		img1.getHeight(null);
		g.drawImage(img1,x * Constant.SNAKE_WIDTH,y * Constant.SNAKE_HEIGHT,null);
	//	System.out.println(x+" "+y);
	}
}
