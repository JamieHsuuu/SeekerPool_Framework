package com.jamie.web.dto;

import org.springframework.web.multipart.MultipartFile;

public class CompanyMemberDto {
	
	private Integer comMemId;
	private String comMemAccount;
	private String comMemPassword;
	private String comName;
	private String taxNum;
	private String comEmail;
	private String comTel;
	private String comAddress;
	private MultipartFile comPicture;
	private String comPictureUrl;
	
	public CompanyMemberDto() {
	}
	
	public CompanyMemberDto(String comMemAccount, String taxNum, String comEmail, String comTel) {
		this.comMemAccount = comMemAccount;
		this.taxNum = taxNum;
		this.comEmail = comEmail;
		this.comTel = comTel;
	}

	public Integer getComMemId() {
		return comMemId;
	}

	public void setComMemId(Integer comMemId) {
		this.comMemId = comMemId;
	}
	
	public String getComMemAccount() {
		return comMemAccount;
	}

	public void setComMemAccount(String comMemAccount) {
		this.comMemAccount = comMemAccount;
	}

	public String getComMemPassword() {
		return comMemPassword;
	}

	public void setComMemPassword(String comMemPassword) {
		this.comMemPassword = comMemPassword;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getTaxNum() {
		return taxNum;
	}

	public void setTaxNum(String taxNum) {
		this.taxNum = taxNum;
	}

	public String getComEmail() {
		return comEmail;
	}

	public void setComEmail(String comEmail) {
		this.comEmail = comEmail;
	}

	public String getComTel() {
		return comTel;
	}

	public void setComTel(String comTel) {
		this.comTel = comTel;
	}

	public String getComAddress() {
		return comAddress;
	}

	public void setComAddress(String comAddress) {
		this.comAddress = comAddress;
	}
	
	public MultipartFile getComPicture() {
		return comPicture;
	}

	public void setComPicture(MultipartFile comPicture) {
		this.comPicture = comPicture;
	}

	public String getComPictureUrl() {
		return comPictureUrl;
	}

	public void setComPictureUrl(String comPictureUrl) {
		this.comPictureUrl = comPictureUrl;
	}

}
