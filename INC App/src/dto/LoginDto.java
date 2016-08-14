package dto;

public class LoginDto {
	private String name;
	private String password;
	
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
}
