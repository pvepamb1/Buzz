import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class OutputPrinter implements Runnable{
	
	DataInputStream input;
	
	public OutputPrinter(InputStream inputStream) {
		input = new DataInputStream(inputStream);
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				if(input.available()>1) {
					System.out.println(input.readUTF());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
