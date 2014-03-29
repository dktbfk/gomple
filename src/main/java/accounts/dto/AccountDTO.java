package accounts.dto;

import java.sql.Date;

public class AccountDTO {
	private String id;
	private String password;
	private String name;
	private String accountnumber;
	private int amount;
	private String telphone;
	private String address;
	private Date date;
	public AccountDTO() {
		super();
	}
	public AccountDTO(String id, String password, String name,
			String accountnumber, String telphone, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.accountnumber = accountnumber;
		this.telphone = telphone;
		this.address = address;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "AccountDTO [id=" + id + ", password=" + password + ", name="
				+ name + ", accountnumber=" + accountnumber + ", amount="
				+ amount + ", telphone=" + telphone + ", address=" + address
				+ ", date=" + date + "]";
	}
}
