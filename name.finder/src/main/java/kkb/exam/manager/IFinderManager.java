package kkb.exam.manager;

import java.util.Map;

public interface IFinderManager {

	public abstract void init();
	public abstract void findWord(String readLine, Map<String, Integer>nameMap, boolean doDistinct);
	
}
