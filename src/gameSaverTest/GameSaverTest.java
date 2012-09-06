package gameSaverTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameSaverTest {
	public static void main(String[] args) {
		GameCharacter one = new GameCharacter(50, "Elf", new String[] {"bow", "sword", "dust"});
		GameCharacter two = new GameCharacter(200, "Troll", new String[] {"bare hands", "big ax"});
		GameCharacter three = new GameCharacter(120, "Magician", new String[] {"spells", "invisibility"});
		GameCharacter four = new GameCharacter(150, "Warior", new String[] {"axe", "blade"});
		
		// Código que faz com que os personagens sejam alterados
		
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("/home/killer/tmp/GameSaverTest.os"));
			os.writeObject(one);
			os.writeObject(two);
			os.writeObject(three);
			os.writeObject(four);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		one = null;
		two = null;
		three = null;
		
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("/home/killer/tmp/GameSaverTest.os"));
			GameCharacter oneRestore = (GameCharacter) is.readObject();
			GameCharacter twoRestore = (GameCharacter) is.readObject();
			GameCharacter threeRestore = (GameCharacter) is.readObject();
			GameCharacter fourRestore = (GameCharacter) is.readObject();
			
			System.out.println("One's type: " + oneRestore.getType());
			System.out.println("Two's type: " + twoRestore.getType());
			System.out.println("Three's type: " + threeRestore.getType());
			System.out.println("Four's type: " + fourRestore.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
