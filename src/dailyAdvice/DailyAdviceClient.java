package dailyAdvice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DailyAdviceClient {
	public static void main(String[] args) {
		DailyAdviceClient client = new DailyAdviceClient();
		client.go();
	}	

	public void go() {
		try {
			Socket s = new Socket("127.0.0.1", 4242);
			s.setSoTimeout(1000);
			
			InputStreamReader is = new InputStreamReader(s.getInputStream());
			BufferedReader reader = new BufferedReader(is);
			
			String advice = reader.readLine();
			System.out.println("Dica:" + advice);
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
