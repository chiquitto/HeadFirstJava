package dailyAdvice;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {

	public static void main(String[] args) {
		DailyAdviceServer server = new DailyAdviceServer();
		server.go();
	}

	private String[] adviceList = {
			"Morda pedaços menores.",
			"Use o jeans apertado. Não, ele NÃO faz você parecer gordo.",
			"Só vou dizer uma palavra: inapropriado",
			"Pelo menos hoje seja honesto. Diga a seu chefe o que realmente pensa.",
			"Reconsidere este corte de cabelo"
			};

	public void go() {
		try {
			ServerSocket serverSock = new ServerSocket(4242);

			while (true) {
				System.out.println("Aguardando uma conexão.");
				Socket sock = serverSock.accept();

				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String advice = getAdvice();
				writer.println(advice);
				writer.close();

				System.out.println(advice);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getAdvice() {
		int r = (int) (Math.random() * adviceList.length);
		return adviceList[r];
	}
}
