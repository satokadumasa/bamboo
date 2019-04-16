package site.hesper.bamboo.net;

import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
	public int port;
	public Server(int port) {
		this.port = port;
	}
	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(port);
			while(true) {
				try {
					Socket sc = ss.accept();
					ConnectToClient cc= new ConnectToClient (sc);
					cc.start();
				}
				catch(Exception e){
					e.printStackTrace();
					break;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
