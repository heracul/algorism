package algorism.sosu;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import algorism.utils.BaseUtils;

public class SosuFinder {

	public static void main(String[] args) throws IOException {
		byte[]bite = new byte[24];
//		BufferedInputStream bis = new BufferedInputStream(System.in);
//		bis.read(bite);
		List<Integer> sosuList = new ArrayList<Integer>();
//		String inputStr = new String(bite);
		long startTime = System.currentTimeMillis();
		
		int min = 1;
		int max = 1000000;
		
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
			for(int i=0; i<sosuList.size(); i++) {
				if(min <= sosuList.get(i) && max >= sosuList.get(i)) {
					System.out.println(sosuList.get(i));
				}
			}
			long endTime = System.currentTimeMillis();
			BaseUtils.printElapseTime(startTime, endTime);
		}finally {
//			if(bis != null) {
//				bis.close();
//			}
		}
	}
}
