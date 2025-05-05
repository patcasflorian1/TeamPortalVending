package org.eurovending.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column  (name="name", nullable = false, length = 256) 
	private String name;
	@Column  (name="phoneNumber") 
	private String phoneNumber;
	@Column  (name="email") 
	private String email;
	@Column  (name="salt") 
	private String salt;
	@Column  (name="password") 
	private String password;
	@Transient 
	private String retypePassword;
	@Column  (name="role") 
	private String role; //superadmin,admin,employ
	@Column  (name="statute") 
	private String statute; //forbidden,active
	@Column  (name="operator") 
	private String operator; // nume operator care efectueaza inregistararea
	@Column  (name="dataEntry") 
	private String dataEntry;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRetypePassword() {
		return retypePassword;
	}
	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}
	public String getStatute() {
		return statute;
	}
	public void setStatute(String statute) {
		this.statute = statute;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getDataEntry() {
		return dataEntry;
	}
	public void setDataEntry(String dataEntry) {
		this.dataEntry = dataEntry;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Users(int id, String name, String phoneNumber, String email, String salt, String password, String role,
			String statute, String operator, String dataEntry) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.salt = salt;
		this.password = password;
		this.role = role;
		this.statute = statute;
		this.operator = operator;
		this.dataEntry = dataEntry;
	}
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ",phoneNumber" + phoneNumber + ",email" + email +
				",salt" + salt + ", role=" + role + ",statute" + statute + ",operator" + operator + ",dataEntry" + dataEntry + "]";
	}
	
	
	
}
