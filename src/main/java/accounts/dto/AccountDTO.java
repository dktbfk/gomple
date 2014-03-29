package accounts.dto;

import java.sql.Date;

public class AccountDTO {
	private String id;
	private String password;
	private String name;
	private long accountnumber;
	private int amount;
	private int telphone;
	private String address;
	private Date date;
	public AccountDTO() {
		super();
	}
	public AccountDTO(String id, String password, String name,
			long accountnumber, int amount, int telphone, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.accountnumber = accountnumber;
		this.amount = amount;
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
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTelphone() {
		return telphone;
	}
	public void setTelphone(int telphone) {
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
