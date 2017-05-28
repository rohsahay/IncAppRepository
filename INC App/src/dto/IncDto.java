package dto;

public class IncDto {
	private String casenmbr;
	private String date;
	private String desc;
	private String pendingwth;
	private String status;
	private String comnt;
	private String fe_analyst;
	private String SerialNo;
	public IncDto(){
		
	}
	
	public void setCasenmbr(String casenmbr){
		this.casenmbr=casenmbr;
	}
	public String getCasenmbr(){
		return casenmbr;
	}
	public void setDate(String date){
		this.date=date;
	}
	public String getDate(){
		return date;
	}
	public void setDesc(String desc){
		this.desc=desc;
	}
	public String getDesc(){
		return desc;
	}
	public void setPendingwth(String pendingwth){
		this.pendingwth=pendingwth;
	}
	public String getPendingwth(){
		return pendingwth;
	}
	public void setStatus(String status){
		this.status=status;
	}
	public String getStatus(){
		return status;
	}
	public void setComnt(String comnt){
		this.comnt=comnt;
	}
	public String getComnt(){
		return comnt;
	}
	public void setAnalyst(String fe_analyst){
		this.fe_analyst=fe_analyst;
	}
	public String getAnalyst(){
		return fe_analyst;
	}
	public void setSerialNo(String sr){
		this.SerialNo=sr;
	}
	public String getSerialNo(){
		return SerialNo;
	}

}
