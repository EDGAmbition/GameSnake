package my.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class GameFrame extends MyFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4456516978889554848L;
	
	public void paint(Graphics g) {
		 drawBound(g); //ª≠±ﬂΩÁ
		// drawSnake(g); //ª≠…ﬂ
		 
		 Image img1=GameUtil.getImage("images/tushe.png");
		 //≤‚ ‘”Ôæ‰
		 System.out.println(img1.getHeight(null));
		 g.drawImage(img1, 100, 100, null);
	}
	
	/**
	 * ª≠±ﬂΩÁ
	 * @param g
	 */
	
	private void drawBound(Graphics g) {
		Color old=g.getColor();
		 g.setColor(Color.black);
		 g.drawRect(
					 (Constant.FRAME_WIDTH-Constant.GAME_FRAME_WIDTH)/2,
					 (Constant.FRAME_HEIGHT-Constant.GAME_FRAME_HEIGHT)/2,
					 Constant.GAME_FRAME_WIDTH,
					 Constant.GAME_FRAME_HEIGHT
				 	); 
		 g.setColor(old);
	}
	
	public static void main(String[] args) {
		GameFrame gf = new GameFrame();
		gf.launchFrame();
	}
	
}
