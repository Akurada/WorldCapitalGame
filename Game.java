import java.io.Console;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Game {
	public static void main(String[] args) {
		System.out.println("Guess the capital city: ");
		Console console = System.console();

		try (BufferedReader br = new BufferedReader(new FileReader("capitals.csv"))){
			
			String line;
			while ((line = br.readLine()) != null) {
				String[] cols = line.split(",");
				String country = cols[0];
				String capital = cols[1];
				String answer = console.readLine("What is the capital of " + country + "? ");
				if (answer.equalsIgnoreCase(capital)) {
					System.out.println("Correct!");
				}
				else {
					System.out.println("No, the answer is " + capital);	
				}
			}
		}
	catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
}