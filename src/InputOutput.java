import java.io.*;

public class InputOutput {
	String inputFile=null;
	String outputFile=null;
	
	public InputOutput(String inputFile, String outputFile) {
		this.inputFile=inputFile;
		this.outputFile=outputFile;
	}
	
	public void readFile() { //Reading the Input from input.txt 
		MovieTheatreGrid mtg=new MovieTheatreGrid();
		try {
			BufferedReader br=new BufferedReader(new FileReader(inputFile));
			String s;
			while((s=br.readLine())!=null) {
				String[] input=s.split(" ");   // Splitting "R001 2" into "R001" and "2" 
				String outputText=mtg.allocate(input[0], Integer.parseInt(input[1])); // Resultant Output Row for the Booking Request
				System.out.println(outputText);
				writeFile(outputText);
				
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception___________");
		}
	}
	
	public void writeFile(String outputText) { //Writing the Output to the Output.txt
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter(outputFile, true));
			bw.write(outputText + "\n");
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception___________");
		}
	}
}
