package algorism.sosu;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import algorism.utils.BaseUtils;

public class SosuFinder {

	public static void main(String[] args) throws IOException {
		BufferedReader br = null;
		String inputStr = BaseUtils.getKeyboardInput(br);
		int index = inputStr.indexOf(" ");
		List<Integer> sosuList = new ArrayList<Integer>();
		long startTime = System.currentTimeMillis();
		long midTime = 0L;
		int min = Integer.parseInt(inputStr.substring(0, index));
		int max = Integer.parseInt(inputStr.substring(index+1, inputStr.length()));
		
		try {
			sosuList.add(2);
			for(int i=2; i<max; i++) {
				for(int j=0; j<sosuList.size();j++) {
					if(i%sosuList.get(j)==0) {
						break;
					}
					if(j+1 == sosuList.size()) {
						sosuList.add(i);
					}
				}
			}
			midTime = System.currentTimeMillis();
			BaseUtils.printElapseTime(startTime, midTime);
//			for(int i=0; i<sosuList.size(); i++) {
//				if(min <= sosuList.get(i) && max >= sosuList.get(i)) {
//					System.out.println(sosuList.get(i));
//				}
//			}
			long endTime = System.currentTimeMillis();
			BaseUtils.printElapseTime(startTime, endTime);
		}finally {
			BaseUtils.closeBufferedReader(br);
		}
	}
}
