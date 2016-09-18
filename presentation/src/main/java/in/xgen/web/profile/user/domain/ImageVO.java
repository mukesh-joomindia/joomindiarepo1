package in.xgen.web.profile.user.domain;


public class ImageVO extends ContentVO{
	private String contentType;
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	private String usedImgIn;
	public String getUsedImgIn() {
		return usedImgIn;
	}
	public void setUsedImgIn(String usedImgIn) {
		this.usedImgIn = usedImgIn;
	}	
}
