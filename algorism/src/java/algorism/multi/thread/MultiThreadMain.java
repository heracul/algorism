package algorism.multi.thread;

import java.util.HashMap;
import java.util.Map;

public class MultiThreadMain {

	public static void main(String[] args)  {
		Map<String, Double> accountMap = new HashMap<String, Double>();
		accountMap.put("cash", 120000D);
		MultiThreadManager mtm = new MultiThreadManager(accountMap);
		mtm.init();
		mtm.start();
	}
}
