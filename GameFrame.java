package feb21;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 游戏窗口类
 * 
 * @author zhxzh
 *
 */
public class GameFrame extends Frame {

	Image img = GameUtil.getImage("Images/sunshine.jpg");

	/**
	 * 加载窗口
	 */
	public void launchFrame() {

		setSize(500, 500);
		setLocation(100, 100);
		setVisible(true);
		new PaintThread().start();
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

		});
	}

	private double x = 100, y = 100;
	private boolean left;
	private boolean up;
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		// System.out.println("I'm painting.");
		// g.drawLine(100, 100, 200, 200);
		// g.drawRect(100, 100, 200, 200);
		// g.drawOval(100, 100, 200, 200);
		// Font f = new Font("宋体", Font.BOLD, 100);
		// g.setFont(f);
		// g.drawString("muller", 200, 200);
		// g.fillRect(100, 100, 20, 20);
		// Color c = g.getColor();
		// g.setColor(Color.red);
		// g.fillOval(300, 300, 20, 20);
		// g.setColor(c);// 钩子，颜色重置
		g.drawImage(img, (int) x, (int) y, null);
//		if (left) {
//			x -= 3;
//		} else
//			x += 3;
//		if (x > 500 - 30) {
//			left = true;
//		}
//		if (x < 0) {
//			left = false;
//		}
		
		
		if (up) {
			y -= 10;
		} else
			y += 10;
		if (y > 500 - 30) {
			up = true;
		}
		if (y < 30) {
			up = false;
		}
	}

	class PaintThread extends Thread {

		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}

	public static void main(String[] args) {
		GameFrame gf = new GameFrame();
		gf.launchFrame();
	}

}
