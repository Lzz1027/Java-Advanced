package lab3;

@Table("user")
public class User{
	@Column("id")
    private int id;

	@Column("username")
    private String username = "";
    
	@Column("age")
    private int age;

    @Column("email")
    private String email = "";

    @Column("telephone")
    private String telephone = "";

	public void setId(int id) {
		this.id = id;		
	}

	public void setUsername(String username) {
		this.username = username;		
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;		
	}

	public void setEmail(String email) {
		this.email = email;		
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getID() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getTelephone() {
		return telephone;
	}
	public String getEmail() {
		return email;
	}
	public int getAge() {
		return age;
	}
}

