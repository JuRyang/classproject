package form;

public class RegForm {
	
	private String id; //사용자 아이디
	private String pw; //사용자 비밀번호
	private String name;//사용자 이름

	//기본생성자
	public RegForm() {
		
	}

	public RegForm(String id, String pw, String name) {
	
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	//getter setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "RegForm [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
	
	
}
