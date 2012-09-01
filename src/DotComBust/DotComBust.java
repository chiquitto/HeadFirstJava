package DotComBust;


import java.util.ArrayList;

/**
 *
 * @author Chiquitto <chiquitto@chiquitto.com.br>
 */
public class DotComBust {

    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    public static void main(String[] args) {
	DotComBust g = new DotComBust();
	g.setUpGame();
	g.startPlaying();
    }

    private void setUpGame() {
	DotCom d1 = new DotCom();
	d1.setName("DotCom1");
	dotComList.add(d1);
	
	DotCom d2 = new DotCom();
	d2.setName("DotCom1");
	dotComList.add(d2);
	
	DotCom d3 = new DotCom();
	d3.setName("DotCom3");
	dotComList.add(d3);
	
	for(DotCom dotComToSet : dotComList) {
	    ArrayList<String> newLocation = helper.placeDotCom(3);
	    dotComToSet.setLocationCells(newLocation);
	}
    }

    private void startPlaying() {
	while(!dotComList.isEmpty()) {
	    String userGuess = helper.getUserInput("Insira um palpite");
	    checkUserGuess(userGuess);
	}
	finishGame();
    }

    private void checkUserGuess(String userGuess) {
	numOfGuesses++;
	String result = "errado";
	for(DotCom dotComToTest : dotComList) {
	    result = dotComToTest.checkYourself(userGuess);
	    if(result.equals("correto")) {
		break;
	    }
	    if(result.equals("eliminar")) {
		dotComList.remove(dotComToTest);
		break;
	    }
	}
	System.out.println(result);
    }

    private void finishGame() {
	System.out.println("Todas as DotCom foram eliminadas.");
	if(numOfGuesses <= 18) {
	    System.out.println("Você só usou " + numOfGuesses + " palpites");
	    System.out.println("Você saiu antes de eliminar suas opções");
	}
	else {
	    System.out.println("Demorou demais. " + numOfGuesses + " palpites");
	    System.out.println("Não haverá pesca com essas opções");
	}
    }
}
