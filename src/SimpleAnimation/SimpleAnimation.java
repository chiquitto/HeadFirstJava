package SimpleAnimation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleAnimation {

	int x = 70;
	int y = 70;

	public static void main(String[] args) {
		SimpleAnimation s = new SimpleAnimation();
		s.go();
	}

	private void go() {
		JFrame f = new JFrame();

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyDrawPanel d = new MyDrawPanel();

		f.getContentPane().add(d);
		f.setSize(300, 300);
		f.setVisible(true);

		for (int i = 0; i < 130; i++) {
			x++;
			y++;

			d.repaint();

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
		}
	}

	class MyDrawPanel extends JPanel {
		protected void paintComponent(Graphics g) {
			g.setColor(Color.white);
			g.fillRect(0, 0, getWidth(), getHeight());
			
			g.setColor(Color.green);
			g.fillOval(x, y, 40, 40);
		}
	}
}
