import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(1234);
		Socket s = server.accept();

		InputListener listen = new InputListener(s.getOutputStream());
		Thread t = new Thread(listen, "ServerListener");
		t.start();
		OutputPrinter print = new OutputPrinter(s.getInputStream());
		Thread t2 = new Thread(print, "ServerPrinter");
		t2.start();
		
		Scanner s2 = new Scanner(System.in);
		while(s2.nextLine()!="podhum") {
			
		}s2.close();
		server.close();
	}

}
