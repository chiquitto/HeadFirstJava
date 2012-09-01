package SimpleGui1B;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleGui1B implements ActionListener {
	public static void main(String[] args) {
		SimpleGui1B gui = new SimpleGui1B();
		gui.go();
	}

	private JButton button;

	public void go() {
		JFrame f = new JFrame();
		button = new JButton("Clique em mim");

		button.addActionListener(this);

		f.getContentPane().add(button);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300, 300);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		button.setText("Clicaram em mim");

	}

}
