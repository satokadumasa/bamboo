package site.hesper.bamboo.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class ConnectToClient extends Thread {
	private Socket sc;
	private BufferedReader br;
	private PrintWriter pw;

	public ConnectToClient(Socket s) {
		sc = s;
	}

	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sc.getOutputStream())));
		} catch (Exception e) {
			e.printStackTrace();
		}
		while (true) {
			try {
				//受信バッファからデータを読み込む（今回は文字列）
				String str = br.readLine();
				System.out.println(str);
				Random rnd = new Random();
				RamdomStrings rs = new RamdomStrings();
				//クライアントからのメッセージの語尾＋ランダムな文字配列を送信バッファへ渡す
				pw.println(
						"Server : [" + str.charAt(str.length() - 1) + rs.GetRandomString(rnd.nextInt(10)) + "] (^_^)!");
				//ここが重要！flushメソッドを呼ぶことでソケットを通じてデータを送信する
				pw.flush();
			} catch (Exception e) {
				try {
					br.close();
					pw.close();
					sc.close();
					System.out.println("Good Bye !!");
					break;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
