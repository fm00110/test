package beans;

public class Student {
	private String stuname;
	private int age;
	private String id;
	private School school;
	public Student(String stuname, int age, String id, School school) {
		
		this.stuname = stuname;
		this.age = age;
		this.id = id;
		this.school = school;
	}
	@Override
	public String toString() {
		return "Student [stuname=" + stuname + ", age=" + age + ", id=" + id + ", school=" + school + "]";
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

}
