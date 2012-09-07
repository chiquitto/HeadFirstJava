package quizCard;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class QuizCardPlayer {
	public static void main(String[] args) {
		QuizCardPlayer reader = new QuizCardPlayer();
		reader.go();
	}

	private JFrame frame;
	private JTextArea display;
	private JButton nextButton;
	private boolean isShowAnswer;
	private QuizCard currentCard;
	private int currentCardIndex;
	private ArrayList<QuizCard> cardList;

	public void go() {
		frame = new JFrame();
		JPanel mainPanel = new JPanel();
		Font bigfont = new Font("sanserif", Font.BOLD, 24);

		display = new JTextArea(10, 20);
		display.setFont(bigfont);
		display.setLineWrap(true);
		display.setEditable(false);

		JScrollPane qScroller = new JScrollPane(display);
		qScroller
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		nextButton = new JButton("Mostrar pergunta");

		mainPanel.add(qScroller);
		mainPanel.add(nextButton);

		nextButton.addActionListener(new NextCardListener());

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem loadMenuItem = new JMenuItem("Carregar baralho");

		loadMenuItem.addActionListener(new OpenMenuListener());

		fileMenu.add(loadMenuItem);

		menuBar.add(fileMenu);

		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(640, 500);
		frame.setVisible(true);
	}

	public class NextCardListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			/**
			 * Verifica o flag booleano isShowAnswer para saber
			 * se atualmente está sendo exibida uma pergunta
			 * ou uma resposta e faz o que for apropriado
			 * dependendo do que for retornado
			 */
			
			if(isShowAnswer) {
				// Exibir a resposta
				display.setText(currentCard.getAnswer());
				nextButton.setText("Próxima carta");
				isShowAnswer = false;
			}
			else {
				// Exibe a proxima pergunta
				if(currentCardIndex < cardList.size()) {
					showNextCard();
				}
				else {
					// não há mais cartões
					display.setText("Aquela era a última carta.\nFim do jogo.");
					nextButton.setEnabled(false);
				}
			}
		}

	}

	public class OpenMenuListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JFileChooser fileOpen = new JFileChooser();
			fileOpen.showOpenDialog(frame);
			loadFile(fileOpen.getSelectedFile());
		}

	}

	private void showNextCard() {
		currentCard = cardList.get(currentCardIndex);
		currentCardIndex++;
		display.setText(currentCard.getQuestion());
		nextButton.setText("Mostrar pergunta");
		isShowAnswer = true;
	}

	private void loadFile(File file) {
		cardList = new ArrayList<QuizCard>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine()) != null) {
				makeCard(line);
			}
			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void makeCard(String lineToParse) {
		String[] result = lineToParse.split("/");
		QuizCard card = new QuizCard(result[0], result[1]);
		cardList.add(card);
		System.out.println("Carta feita");
	}
}
