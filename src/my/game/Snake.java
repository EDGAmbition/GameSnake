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
	public void drawSnake(Graphics g) {
		Image img1=GameUtil.getImage("images/tushe.png");
		//≤‚ ‘”Ôæ‰
//		System.out.println(img1.getHeight(null));
		
		g.drawImage(img1, 
				x * Constant.GRID_WIDTH, 
				y * Constant.GRID_HEIGHT, 
				null);
		
	}
	
	
	
	
}
