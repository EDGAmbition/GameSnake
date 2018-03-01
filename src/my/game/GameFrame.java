package my.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.LinkedList;

public class GameFrame extends MyFrame{

	private static final long serialVersionUID = -4456516978889554848L;
	
	LinkedList<Snake> snakeBody= new LinkedList<Snake>();
	
	public void launchFrame() {
		super.launchFrame();
		addKeyListener(new KeyMonitor());
		snakeBody.add(new Snake(15,5));
		snakeBody.add(new Snake(16,5));
		snakeBody.add(new Snake(17,5));
	}
	
	public void paint(Graphics g) {
		drawBound(g); //»­±ß½ç
		for(Iterator<Snake> i = snakeBody.iterator();i.hasNext();) {
			Snake s = i.next();
			s.drawSnake(g);
		}
		
		Snake s = new Snake(snakeBody.getFirst().x , snakeBody.getFirst().y);
		switch(Snake.direction) {
			case 37:
				s.x--;
				break;
			case 38:				
				s.y--;
				break;
			case 39:				
				s.x++;
				break;
			case 40:				
				s.y++;
				break;
		}
		snakeBody.addFirst(s);
		snakeBody.removeLast();
		/*
		Image img1=GameUtil.getImage("images/tushe.png");
		for(int i=3;i<=17;i++){
		g.drawImage(img1, 
				10 * Constant.GRID_WIDTH, 
				i * Constant.GRID_HEIGHT, 
				null
				);
		}
		*/
	}
	
	
	/**
	 * »­±ß½ç
	 * @param g
	 */
	private void drawBound(Graphics g) {
		Color old=g.getColor();
		g.setColor(Color.black);
		g.drawRect(
					 150,
					 90,
					 Constant.GAME_FRAME_WIDTH,
					 Constant.GAME_FRAME_HEIGHT
				 	); 
		g.setColor(old);
	}
	
	
	/**
	 * ¼üÅÌ¼àÌý
	 * @param args
	 */
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent arg0) {
			System.out.println(arg0.getKeyCode());
			int temp = arg0.getKeyCode();
			if(Math.abs(temp - Snake.direction )!= 2) {
				switch(temp) {
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

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}
		
	}
	public static void main(String[] args) {
		GameFrame gf = new GameFrame();
		gf.launchFrame();
	}
	
}
