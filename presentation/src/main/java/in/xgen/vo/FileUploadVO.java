package in.xgen.vo;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadVO {

	MultipartFile files = null;

	public MultipartFile getFiles() {
		return files;
	}

	public void setFiles(MultipartFile files) {
		this.files = files;
	}
	
}
