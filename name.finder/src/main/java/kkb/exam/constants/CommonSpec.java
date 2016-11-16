package kkb.exam.constants;

public enum CommonSpec {
	DEFAULT_ENCODING("UTF-8"),
	CSV_FILE_NAME("/etc/comments.csv"),
	FIND_NAME_ARRAY("FIND_NAME_ARRAY", new String[]{"초등학교", "초", "중학교", "중",  "고등학교", "대학교"}),
	REMOVE_WORD_ARRAY("", new String[]{
					  "입니다", "합니다", "같아요", "저희", "우리", "힘든", "짜장면", "를", "내려주시와요", "최초", "초딩", "중딩", "고딩", "대딩",
					  "나초롬", "문초록", "댓글은", "진짜", "아닌", "서초현", "울초", "김초", "기본중","학교중", "공부중", "사용중", "학생중", "식중독",
					  "초등학생", "중학생", "고등학생", "대학생", "화내는", "예비", "주세용", "못하는", "남중도", "여중도", "나중에", "김현중", "먹고어요중",
					  "소중한", "이용중인데", "다른중보다", "와중에", "여중아이들", "로딩중", "배고픈와중", "재학중", "기억중", "그렇고", "김민중", "년중", "이번에",
					  "학년중", "못먹고", "가틍데", "똥싸는중", "그중에", "좋아요", "김효중", "할께요"
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
