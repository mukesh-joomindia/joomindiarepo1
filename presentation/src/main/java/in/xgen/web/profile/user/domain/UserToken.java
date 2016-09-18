package in.xgen.web.profile.user.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 * 
 * UserTokens domain object store the tokens value of loggedin user who checked the option remember me option for the login page.
 * 
 * 
 * */
@Entity
@Table(name="usr_login_tokens")
public class UserToken implements Comparable<UserToken>,Serializable{
	

	/*
	 * IdentificationId store encrypted identification number.
	 * */
	

		/**
	 * 
	 */
	private static final long serialVersionUID = 1164713566;
		public int getTokenId() {
		return tokenId;
	}
	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	private int userId;
	public String getIdentificationId() {
		return identificationId;
	}
	public void setIdentificationId(String identificationId) {
		this.identificationId = identificationId;
	}
	public String getTokens() {
		return tokens;
	}
	public void setTokens(String tokens) {
		this.tokens = tokens;
	}
	/*
	 * tokens stores the generated tokens of the user.
	 * 
	 * */
	
	
	public String toString(){
		return "[ identificationId"+identificationId+"\ttokens:"+tokens+"\ttokenId:"+tokenId+""+"\tuserId"+userId+"]";
	}
	
	@Column(name="token_gen_time")
	private Date generatedTime = null;
	@Column(name="identification")
	private String identificationId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="auth_seq_id")
	@SequenceGenerator(name="auth_seq_id",sequenceName="auth_seq_id",allocationSize=20)
	private int tokenId;
	
	@Column(name="tokens")
	private String tokens;

	public Date getGeneratedTime() {
		return generatedTime;
	}
	public void setGeneratedTime(Date generatedTime) {
		this.generatedTime = generatedTime;
	}
	
	
	public int compareTo(UserToken userTokenObj) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
