package cn.edu.chenggong.po;

public class Users {
	private int id;// id  
	private String usersName;// 用户名
	private String usersPwd;// 用户密码
	private String sex;// 性别
	private int age;// 年龄
	private String tellphoneNum;// 电话号码
	private String roleFlag;// 角色：1:用户、0:管理员
	private int usersState;
	public Users() {
		super();
	}

	public Users(int id, String usersName, String usersPwd, String sex,
			int age, String tellphoneNum, String roleFlag,int usersState) {
		super();
		this.id = id;
		this.usersName = usersName;
		this.usersPwd = usersPwd;
		this.sex = sex;
		this.age = age;
		this.tellphoneNum = tellphoneNum;
		this.roleFlag = roleFlag;
		this.usersState = usersState;
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

	public String getRoleFlag() {
		return roleFlag;
	}

	public void setRoleFlag(String roleFlag) {
		this.roleFlag = roleFlag;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", usersName=" + usersName + ", usersPwd="
				+ usersPwd + ", sex=" + sex + ", age=" + age
				+ ", tellphoneNum=" + tellphoneNum + ", roleFlag=" + roleFlag
				+usersState+ "]";
	}

	public int getUsersState() {
		return usersState;
	}

	public void setUsersState(int usersState) {
		this.usersState = usersState;
	}

		
}
