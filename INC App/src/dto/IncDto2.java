package dto;

import java.util.Date;

public class IncDto2 {
	private String casenmbr;
	private Date date;
	private String desc;
	private String pendingwth;
	private String status;
	private String comnt;
	private String feanalyst;
	
	public IncDto2(){
		
	}
	
	public void setCasenmbr(String casenmbr){
		this.casenmbr=casenmbr;
	}
	public String getCasenmbr(){
		return casenmbr;
	}
	public void setDate(Date date){
		this.date=date;
	}
	public Date getDate(){
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
	public void setFeanalyst(String feanalyst){
		this.feanalyst=feanalyst;
	}
	public String getFeanalyst(){
		return feanalyst;
	}
	

}
