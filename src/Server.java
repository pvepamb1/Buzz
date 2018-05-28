import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(1234);
		List<Thread> threads = new ArrayList<Thread>();
		ClientHandler ch = new ClientHandler(server.accept());
		Thread t = new Thread(ch, "ClientHandler");
		threads.add(t);
		t.start();
		server.close();
	}

}
