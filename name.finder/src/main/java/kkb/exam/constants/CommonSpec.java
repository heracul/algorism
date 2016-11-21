package kkb.exam.constants;

public enum CommonSpec {
	DEFAULT_ENCODING("UTF-8"),
	CSV_FILE_NAME("/etc/comments.csv"),
	CSV_SEPARATOR("\""),
	FIND_NAME_ARRAY("FIND_NAME_ARRAY", new String[]{"초등학교", "중학교", "고등학교", "대학교", "초", "중", "고", "대"}),
//	FIND_NAME_ARRAY("FIND_NAME_ARRAY", new String[]{"초등학교", "중학교", "고등학교", "대학교"}),
	REMOVE_WORD_ARRAY("", new String[]{
					  //조사 및 접속사 
					  "를","그리고", "그런데", "그래서", "그렇다고", "글고", "그렇고", "나중에",  "그중에",  
					  //명사 및 대명사
					  "자장면", "짜장면", "초딩", "중딩", "고딩", "대딩","나초롬", "문초록", "댓글","서초현", "울초", "김초은", "최초","초등학생", "중학생", "고등학생", "대학생",
					  "김현중", "최윤라", "김효중", "김민중","기말","꼭대기","예비", "이상민","여중아이들", "윤혜란", "고수희", "김유나고", "최고", "행복", "키", "취업",
					  "기본중","학교중", "공부중", "사용중", "학생중", "식중독", "학년중", "로딩중",  "재학중", "기억중", "년중", "남중도", "여중도", "표시","친구들", "축제",
					  "저희", "우리", "힘든","진짜", "아닌", "골고루", "광고에서","백번이고", "문제고", "시험기간이고", "시험을보고", "시험이고", "학교고","퇴화", "택시",
					  "은홍강은비강전수진전전고", "제발요", "자장면이", "마지막초","중간고사", "기말고사", "여고생", "고생","힐링","힘내","피곤","확인","활동","화이팅","한복","후배",
					  "체육", "첫차", "척박", "쫄깃", "짜장밥", "짭조름", "지불", "준비", "졸업", "제보", "응원", "위치", "연습", "연무", "혈기왕성", "한번","탱글","태그쫌",
					  "우울", "우사인볼트","예민", "앞", "뒤", "옆", "신청", "스테레스", "수학여행", "시험기간", "속는셈", "선물","생각","사용", "사랑","불구", "보충","민망",
					  "돈", "님", "냠냠","기겁", "기절","극복","교시", "공부", "거짓말", "감사","선배", "무료","들께", "넷볼부", "까칠", "훌륭", "얘들","애들", "맛", "못",
					  "무시", "대박", "충실", "한마음", "힘이", "이용", "뻑뻑", "끝","깔", "최고","모습", "똥", "다른", "허덕", "신경질","망고", "손홍고", "집중", "나물",
					  "치킨", "이거","월요일", "화요일", "수요일", "금요일", "목요일", "토요일", "일요일", "병중", "대회", "학년", "대표", "고기", "최대", "대단", "급식","대부분",
					  "세면대","서로에", "몇", "대기", "그대", "밥대신", "조선시대", "대한", "대문",
					  //서술어 및 동사, 형용사, 부사
					  "싶습니당", "싶습니다", "십습니다", "입니다", "합니다", "같아요",  "내려주시와요", "먹고어요중","고픕니다","채워지고", "맛잇다고","도와", "안됀다고","보시고",
					  "움직","태우고","만들어","주세용", "주시고", "마치고", "하시고", "나오고", "뽑히고", "아프고", "나누고", "드리고","사주심다고","힘들어", "안하고","해주세요",
					  "마르고", "달래고", "모르고", "시키고", "다니고",  "어디고", "찌들고", "이쁘고", "망치고", "귀엽고", "힘들고", "배우고", "화내는","같이", "따듯한","있긴한대",
					  "한다고", "좋아요",  "할께요", "보내고", "남기고", "바르고", "아니고", "만들고", "부수고", "새기고", "지키고", "예쁘고", "시키고", "했다고", "치실거",
					  "도대체", "도대채", "남기고", "배고픈와중", "됩니다",  "가틍데", "스럽고", "있었고", "두렵고", "아프고", "누르고", "미루고", "태그고", "같습니다", "펼쳐가고",
					  "마시고", "넘쳐", "힘내고", "해지고", "다이고",  "먹으", "아시고", "간다고", "준비고", "넓어", "잘", "좋아","나눠","꼭", "먹겟", "먹고","먹는", "먹기", 
					  "먹겠", "같다", "깨지고", "돼지고", "풀리고","지나고", "노맛이고", "먹어", "드시고", "안됬다고", "시켜","좀", "적게", "있게","잇다","하는","바른", "토하고",
					  "어지고", "떨어뜨리고", "해보고", "때리고", "많아", "힘들", "었고", "구리고", "걸린", "더러워", "지리고", "안주고", "눌러", "준대", "없는", "왜", "즐거운",
					  "미치고", "먹었다", "말라", "많이니", "뛰어", "따뜻", "되어","들어", "당하고","달하고","달라","마다", "가르쳐", "가르켜","주시느","주느라", "했는", "가득한",
					  "듣는", "내시고", "보이고", "조금주고", "된다고",  "덜고", "되주고", "단합이고", "기다리고", "있었지", "거라고","양도적고","불쌍", "친하고", "이라고",
					  "활기차고", "생기고", "채우고", "싸는", "소중한", "인데", "중보다", "와중에", "이번에", "가지고", "것이고", "열심히", "굴리고", "싶음", "보고만", "위해",
					  "짓는", "굶주", "길어", "나누시고", "내고싶네요", "널리고", "느끼고", "달리고", "늘러주고", "고맙고", "떨어", "지치고", "이기도", "온다고", "추워", "났다고",
					  "부러", "먹여두리고", "고고", "부르시고", "하다고", "터지고" ,"하겠고","싶다고", "사주신", "주신", "즐겁고", "지어","않", "아프",   "없다", "없어",
					  "해주고", "착하고", "좋고", "같고", "되고", "않고", "쓰고", "없고", "려고", "믿고", "싸고", "싶고", "풀고", "뿌고", "좁고",  "듣고", "안대네",
					  "놓고","받고", "있고", "뭐고", "놀고", "꾸고", "크고", "얻고", "씻고", "웃고", "고운", "잊고", "맞고", "밝고", "인가는", "넣고", "잇고", "쏘신",
					  "얹고", "승기고", "찌고","말고", "굶고", "롭고", "째고", "크고", "너무", "아니", "냐고", "찌고", "겪고", "항상", "쌓고", "고플","고프","고픈",					  
	}),
	REMOVE_SEPECIFIC_WORD_ARRAY("", new String[]{
						"신고", "안고", "예고", "이고", "주고", "벌고", "보고","라고","하고", "참고", "박고", "타고", "오고", "가고", "치고", "두고", "입고", "수고",
						"배고", "알고", "달고", "들고", "밀고", "적고", "작고", "참고", "먹고", "지고", "나고", "시고", "다고", "내고", "리고", "제대", "절대", "순대",
						"반대", "기대", "대신", "안대", 
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
