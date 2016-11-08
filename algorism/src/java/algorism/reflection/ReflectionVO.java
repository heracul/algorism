package algorism.reflection;

public class ReflectionVO {
	public ReflectionVO() {
		// TODO Auto-generated constructor stub
	}

	public static final String VO_ID = "VO-01";
	private String name;
	private String home;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName());
		sb.append("&");
		sb.append(getAge());
		sb.append("&");
		sb.append(getHome());
		return sb.toString();
	}
}
