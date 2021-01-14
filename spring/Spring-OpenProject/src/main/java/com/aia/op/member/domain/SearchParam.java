package com.aia.op.member.domain;

public class SearchParam {
	
	private int p;
	private String serchType;
	private String keyword;
	
	public SearchParam(int p, String serchType, String keyword) {
		this.p = p;
		this.serchType = serchType;
		this.keyword = keyword;
		
		if(this.p < 1) {
			this.p = 1;
			
		}
	}
	
	public SearchParam() {
		this.p = 1;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public String getSerchType() {
		return serchType;
	}

	public void setSerchType(String serchType) {
		this.serchType = serchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "SearchParam [p=" + p + ", serchType=" + serchType + ", keyword=" + keyword + "]";
	}
	
	
	
	

}
