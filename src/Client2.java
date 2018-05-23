import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket client = new Socket("localhost",1234);
		
		InputListener listen = new InputListener(client.getOutputStream());
		Thread t = new Thread(listen, "ClientListener");
		t.start();
		OutputPrinter print = new OutputPrinter(client.getInputStream());
		Thread t2 = new Thread(print, "ClientPrinter");
		t2.start();
		
		while(t.isAlive()){}
		client.close();
	}

}
