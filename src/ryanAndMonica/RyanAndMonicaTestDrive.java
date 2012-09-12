package ryanAndMonica;

public class RyanAndMonicaTestDrive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RyanAndMonicaJob job = new RyanAndMonicaJob();
		
		Thread ryan = new Thread(job);
		Thread monica = new Thread(job);
		
		ryan.setName("Ryan");
		monica.setName("Monica");

		ryan.start();
		monica.start();
	}

}
