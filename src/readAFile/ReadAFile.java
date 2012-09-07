package readAFile;

import java.io.*;

public class ReadAFile {
	public static void main(String[] args) {
		try {
			File myFile = new File("/home/killer/tmp/Arquivo.txt");
			FileReader fileReader = new FileReader(myFile);
			
			BufferedReader reader = new BufferedReader(fileReader);
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
