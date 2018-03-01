package my.game;


import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyFrame extends Frame { 
	private static final long serialVersionUID = 402298709346937645L;
	
	int level; 

	public MyFrame(){
		super();
		level = 1000;
	}
	public void launchFrame() {
		//设置窗口参数
		setSize(Constant.FRAME_WIDTH,Constant.FRAME_HEIGHT);
		setLocation(100,100);
		setVisible(true);
		//启动线程
		new paintThread().start();
		
		addWindowListener((WindowListener) new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}	  
		});
	}
	
	//内部类
	class paintThread extends Thread{
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(level);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}  
			 }
		 }
	 }
}
