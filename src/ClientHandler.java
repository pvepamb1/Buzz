import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable{

	Socket s;
	
	public ClientHandler(Socket s) {
		this.s = s;
	}
	
	@Override
	public void run() {
		InputListener listen = null;
		try {
			listen = new InputListener(s.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread t = new Thread(listen, "ServerListener");
		t.start();
		OutputPrinter print = null;
		try {
			print = new OutputPrinter(s.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread t2 = new Thread(print, "ServerPrinter");
		t2.start();
		while(t.isAlive()) {}
	}

}
