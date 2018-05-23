
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class InputListener implements Runnable{
	
	DataOutputStream output;

	public InputListener(OutputStream outputStream) {
		output = new DataOutputStream(outputStream);
	}


	@Override
	public void run() {
		Scanner s = new Scanner(System.in);
		while(true) {
		String line = s.nextLine();
		if(line != "") {
			try {
				output.writeUTF(line);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}
	}
}
