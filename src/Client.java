import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket client = new Socket("localhost",1234);
		
		InputListener listen = new InputListener(client.getOutputStream());
		Thread t = new Thread(listen, "ClientListener");
		t.start();
		OutputPrinter print = new OutputPrinter(client.getInputStream());
		Thread t2 = new Thread(print, "ClientPrinter");
		t2.start();
		
		Scanner s2 = new Scanner(System.in);
		while(s2.nextLine()!="podhum") {
			
		}s2.close();
		client.close();
	}

}
