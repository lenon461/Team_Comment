import java.io.Serializable;

public class User implements Serializable{
	
	private String name = "";
	private String id = "";
	private String pw = "";
	public Object getId;
	
	public User(String name, String id, String pw)
	{
		this.name = name;
		this.id = id;
		this.pw = pw;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getId()
	{
		return id;
	}
	
	public String getPw()
	{
		return pw;
	}
	
	public String toString()
	{
		String userInfo = "";
		userInfo += "�̸� : " + getName() + "\n";
		userInfo += "ID : " + getId() + "\n";
		userInfo += "PW : " + getPw() + "\n";
		return userInfo;
	}

	public String[] split(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
