package DotComSimples;

public class SimpleDotComGame {
	public static void main(String[] args) {
		int numOfGuesses = 0;

		GameHelper helper = new GameHelper();

		SimpleDotCom d = new SimpleDotCom();

		int r = (int) (Math.random() * 5);
		int[] locations = {r, r+1, r+2};

		d.setLocationCells(locations);

		boolean isAlive = true;

		while(isAlive){
			String guess = helper.getUserInput("Insira um número");
			String result = d.checkYourself(guess);
			numOfGuesses++;
			if(result.equals("kill")) {
				isAlive = false;
				System.out.println("Você usou " + numOfGuesses + " palpites");
			}
		}
	}
}
