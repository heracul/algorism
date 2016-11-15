package kkb.exam.constants;

public enum CommonSpec {
	DEFAULT_ENCODING("UTF-8"),
	CSV_FILE_NAME("/etc/comments.csv"),
	FIND_NAME_ARRAY("FIND_NAME_ARRAY", new String[]{"초등학교", "중학교", "고등학교", "대학교"}),
	REMOVE_WORD_ARRAY("", new String[]{
					  "입니다", "합니다", "같아요", "저희", "우리", "힘든"
	});
	
	private String name;
	private String[]attribute;
	
	private CommonSpec(String name) {
		this.name = name;
		this.attribute = null;
	}
	
	private CommonSpec(String name, String[]attribute) {
		this.name = name;
		this.attribute = attribute;
	}
	public String getName() {
		return name;
	}
	public String[] getAttribute() {
		return attribute;
	}
}
