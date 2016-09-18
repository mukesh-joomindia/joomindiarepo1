package in.xgen.vo;

import java.sql.Date;

public   class Notification implements Comparable<Notification>{

	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDesctiption() {
		return desctiption;
	}
	public void setDesctiption(String desctiption) {
		this.desctiption = desctiption;
	}
	public Date getNoteDate() {
		return noteDate;
	}
	public void setNoteDate(Date noteDate) {
		this.noteDate = noteDate;
	}
	private String desctiption;
	private Date noteDate;
	

	public int compareTo(Notification o) {
		// TODO Auto-generated method stub
		
		return this.noteDate.compareTo(o.noteDate);
		
		
	}
	
	private User senderId;
	public User getSenderId() {
		return senderId;
	}
	public void setSenderId(User senderId) {
		this.senderId = senderId;
	}
	 
}
