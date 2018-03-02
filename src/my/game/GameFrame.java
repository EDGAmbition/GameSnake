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
	Food f = new Food();
	boolean gameEnd =false;
	
	public void launchFrame() {
		super.launchFrame();
		addKeyListener(new KeyMonitor());
		Init();
	}
	
	public void paint(Graphics g) {
		if(gameEnd == false) {
			drawBound(g); //»­±ß½ç	
			moveAndEat(); //ÒÆ¶¯Éß			
			drawSnake(g); //»­Éß						
			f.drawFood(g);//»­³ÔµÄ
		}
		else {
			g.drawString("Game Over", 150, 150);
		}
	}
	private void drawSnake(Graphics g) {
		for(Iterator<Snake> i = snakeBody.iterator();i.hasNext();) {
			Snake s2 = i.next();
			s2.drawSnake(g);
		}
	}
	private boolean gameOver(Snake s){
		return (s.x>=40 ||s.x<10 || s.y>=36 || s.y<6) || Grid.grid[s.y][s.x];
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
			Snake.changeDirection(temp);
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}
		
	}
	
	private void Init() {
		snakeBody.add(new Snake(20,10));
		snakeBody.add(new Snake(21,10));
		snakeBody.add(new Snake(22,10));
		f.newFood();
		setGrid();
		gameEnd =false;
	}
	
	private void setGrid() {
		for(int i=6;i<=35;i++) {
			for(int j=10;j<39;j++) {
				Grid.grid[i][j] =false;
			}
		}
		for(Iterator<Snake> i = snakeBody.iterator();i.hasNext();) {
			Snake s = i.next();
			Grid.grid[s.y][s.x] = true;
		}
	}
	
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
	private void moveAndEat() {
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
		if(gameOver(s)) {
			System.out.println("Game Over");
			gameEnd= true;
			
		}
		else
			Grid.grid[s.y][s.x] = true;
		
		if(snakeBody.getFirst().x == f.x && snakeBody.getFirst().y == f.y ) {
			f.newFood();			
		}
		else {
			Snake tempRemove = snakeBody.removeLast();
			Grid.grid[tempRemove.y][tempRemove.x] = false;
		}
	}
	public static void main(String[] args) {
		GameFrame gf = new GameFrame();
		gf.launchFrame();
	}
	
}
