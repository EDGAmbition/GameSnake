package my.game;

import java.awt.Image;
import java.awt.Toolkit;


public class GameUtil {
	private GameUtil() {}; //构造类私有
						   //因为是工具类
	public static Image getImage(String path) {
		return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));
	}
}
