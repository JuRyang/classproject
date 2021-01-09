package com.aia.firstspring.domain;

import org.springframework.web.multipart.MultipartFile;

public class ReportUploadRequest {
	
	private String sn;
	private MultipartFile report; //uploadform에 있는 이름과 같아야 한다.
	
	
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public MultipartFile getReport() {
		return report;
	}
	public void setReport(MultipartFile report) {
		this.report = report;
	}

	
	

}
