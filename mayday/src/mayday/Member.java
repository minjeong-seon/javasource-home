package mayday;

public class Member {
	//속성 -아이디id, 이름name, 주소address, 이메일email, 나이age(정수)
	//외부접근불가
	private String id;
	private String name;
	private String address;
	private String email;
	private int age;

	//생성자(모든 속성을 초기화 할 수 있는 상태)
	public Member(String id, String name, String address, String email, int age) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.age = age;
	}

	
	//get/set 메소드
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	

	
	//toString 오버라이드
}
