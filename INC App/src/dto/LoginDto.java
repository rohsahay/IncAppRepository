package dto;

public class LoginDto {
	private String name;
	private String password;
	private String privilege;
	
	public LoginDto(){
		
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String a){
		this.name=a;
	}
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String b){
		this.password=b;
	}
	public String getPrivilege(){
		return this.privilege;
	}
	public void setPrivilege(String c){
		this.privilege=c;
	}
}
