package site.hesper.bamboo.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import site.hesper.bamboo.gui.MainMenu;

public class Client extends Thread {
	private String server_host_name;
	private int port;
	public MainMenu main_menu;

	public Client() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Client(Runnable target) {
		super(target);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Client(String name) {
		super(name);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Client(ThreadGroup group, Runnable target) {
		super(group, target);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Client(ThreadGroup group, String name) {
		super(group, name);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Client(Runnable target, String name) {
		super(target, name);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Client(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Client(ThreadGroup group, Runnable target, String name, long stackSize) {
		super(group, target, name, stackSize);
		// TODO 自動生成されたコンストラクター・スタブ
	}

//	public Client(ThreadGroup group, Runnable target, String name, long stackSize, boolean inheritThreadLocals) {
//		super(group, target, name, stackSize, inheritThreadLocals);
//		// TODO 自動生成されたコンストラクター・スタブ
//	}

	public Client(MainMenu main_menu, String server_host_name,int port) {
		// TODO 自動生成されたコンストラクター・スタブ
	    //Runメソッドの実装
		this.server_host_name = server_host_name;
		this.port = port;
		this.main_menu = main_menu;
	}
    public void run()
    {
        try{
            //ここでサーバへ接続されます
        	Socket sc = new Socket(server_host_name,port);
        	BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
        	PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sc.getOutputStream())));

            //サーバから受け取ったデータをGUI表示させているのですが，スレッドが終了しないように無限ループさせてます
            while(true){
                try{
                    String str = br.readLine();
//                    this.main_menu.chatArea.append(str + "\n");
                }
                catch(Exception e){
                    br.close();
                    pw.close();
                    sc.close();
                    break;
                }
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
