package site.hesper.bamboo.net;

import java.util.Random;

public class RamdomStrings {

	public RamdomStrings() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	private final String stringchar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private Random rnd = new Random();
	private StringBuffer sbf = new StringBuffer(15);

	public String GetRandomString(int cnt) {
		for (int i = 0; i < cnt; i++) {
			int val = rnd.nextInt(stringchar.length());
			sbf.append(stringchar.charAt(val));
		}

		return sbf.toString();
	}
}
