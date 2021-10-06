import java.text.SimpleDateFormat;
import java.util.Date;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input=args[0];
		String output=args[1];
		InputOutput io=new InputOutput(input, output + "\\output_" +  new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()) + ".txt" );
		io.readFile();
	}

}