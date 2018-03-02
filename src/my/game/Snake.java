package my.game;

import java.awt.Graphics;
import java.awt.Image;

public class Snake {
	
	public int x;
	public int y;
	static int direction = 37;
	
	Snake(){
		x=10;
		y=10;
	}
	Snake(int x,int y){
		this.x=x;
		this.y=y;
	}
//	int h=0;
	public void drawSnake(Graphics g) {
		Image img1=GameUtil.getImage("images/tushe.png");
		//≤‚ ‘”Ôæ‰
		img1.getHeight(null);
//		System.out.print(h++);
		g.drawImage(img1, 
				x * Constant.SNAKE_WIDTH, 
				y * Constant.SNAKE_HEIGHT, 
				null);
		
	}
	
	public static void changeDirection(int key) {
		if(Math.abs(key - Snake.direction )!= 2) {
			switch(key) {
			case 37:
				Snake.direction=37; //left
				break;
			case 38:
				Snake.direction=38; //up
				break;
			case 39:
				Snake.direction=39; //right
				break;
			case 40:
				Snake.direction=40; //down
				break;
			}
		}
	}
	
	
}
