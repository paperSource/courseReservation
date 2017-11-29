package cn.edu.chenggong.po;

public class Users {
	private int id;// id  
	private String usersName;// 用户名
	private String usersPwd;// 用户密码
	private String sex;// 性别
	private int age;// 年龄
	private String tellphoneNum;// 电话号码
	private int usersState;//用户状态 0管理员 1普通用户
	private String emilName;//邮箱地址
	private String emilCode;//邮箱验证码
	public Users() {
		super();
	}

	public Users(int id, String usersName, String usersPwd, String sex,
			int age, String tellphoneNum,int usersState,String emilCode,String emilName) {
		super();
		this.id = id;
		this.usersName = usersName;
		this.usersPwd = usersPwd;
		this.sex = sex;
		this.age = age;
		this.tellphoneNum = tellphoneNum;
		this.usersState = usersState;
		this.emilCode = emilCode;
		this.emilName = emilName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public String getUsersPwd() {
		return usersPwd;
	}

	public void setUsersPwd(String usersPwd) {
		this.usersPwd = usersPwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTellphoneNum() {
		return tellphoneNum;
	}

	public void setTellphoneNum(String tellphoneNum) {
		this.tellphoneNum = tellphoneNum;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", usersName=" + usersName + ", usersPwd="
				+ usersPwd + ", sex=" + sex + ", age=" + age
				+ ", tellphoneNum=" + tellphoneNum + ", usersState="
				+usersState+ "]"+", emilCode="
				+emilCode+ "]"+", emilName="
				+emilName+ "]";
	}

	public int getUsersState() {
		return usersState;
	}

	public void setUsersState(int usersState) {
		this.usersState = usersState;
	}

	public String getEmilCode() {
		return emilCode;
	}

	public void setEmilCode(String emilCode) {
		this.emilCode = emilCode;
	}

	public String getEmilName() {
		return emilName;
	}

	public void setEmilName(String emilName) {
		this.emilName = emilName;
	}

		
}
