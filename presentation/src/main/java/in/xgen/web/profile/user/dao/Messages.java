package in.xgen.web.profile.user.dao;

import java.io.Serializable;
import java.util.Date;

public class Messages implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1558057604486770819L;
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public String getSendName() {
		return sendName;
	}
	public void setSendName(String sendName) {
		this.sendName = sendName;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public Date getMsgDate() {
		return msgDate;
	}
	public void setMsgDate(Date msgDate) {
		this.msgDate = msgDate;
	}
	
	private int msgId;
	private String sendName;
	private String msg;
	private int status;
	private String msgType;
	private Date msgDate;
	
}
