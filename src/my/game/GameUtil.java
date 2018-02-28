package my.game;

import java.awt.Image;
import java.awt.Toolkit;


public class GameUtil {
	private GameUtil() {}; //������˽��
						   //��Ϊ�ǹ�����
	public static Image getImage(String path) {
		return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));
	}
}
