package demo20171224;

public class Student {
	/**
	 * id
	 */
	private Integer id;
	/**
	 * ѧ��
	 */
	private String no;
	/**
	 * ����
	 */
	private String name;
	/**
	 * ѧԺ
	 */
	private String age;
	/**
	 * �ɼ�
	 */
	private float score;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", no=" + no + ", name=" + name + ", age=" + age + ", score=" + score + "]";
	}
	

}
