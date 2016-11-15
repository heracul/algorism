package kkb.exam.constants;

import java.io.File;

public enum ResourceSpec {
	BIN_PATH(ResourceSpec.class.getClass().getResource("/").getPath()),
	PJT_PATH(new File(BIN_PATH.getPath()).getParent()),
	RESOURCE_PATH(new File(PJT_PATH.getPath()+"/resource").getPath());
	
	private String path;
	
	private ResourceSpec(String path) {
		this.path = path; 
	}
	
	public String getPath() {
		return path;
	}
}
