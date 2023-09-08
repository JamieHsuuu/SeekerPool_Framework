package com.jamie.web.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class CompanyMember {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer comMemId;
    private String comMemAccount;
    private String comMemPassword;
    private String comName;
    private String taxNum;
    private String comEmail;
    private String comTel;
    private String comAddress;
    private String comPicture;
    private Integer comStatus;
    private Timestamp endSuspendedTime;
    private Integer comRepNum;
    
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
	public String getComPicture() {
		return comPicture;
	}
	public void setComPicture(String comPicture) {
		this.comPicture = comPicture;
	}
	public Integer getComStatus() {
		return comStatus;
	}
	public void setComStatus(Integer comStatus) {
		this.comStatus = comStatus;
	}
	public Timestamp getEndSuspendedTime() {
		return endSuspendedTime;
	}
	public void setEndSuspendedTime(Timestamp endSuspendedTime) {
		this.endSuspendedTime = endSuspendedTime;
	}
	public Integer getComRepNum() {
		return comRepNum;
	}
	public void setComRepNum(Integer comRepNum) {
		this.comRepNum = comRepNum;
	}
	
	@Override
	public String toString() {
		return "CompanyMember [comMemId=" + comMemId + ", comMemAccount=" + comMemAccount + ", comMemPassword="
				+ comMemPassword + ", comName=" + comName + ", taxNum=" + taxNum + ", comEmail=" + comEmail
				+ ", comTel=" + comTel + ", comAddress=" + comAddress + ", comPicture=" + comPicture + ", comStatus="
				+ comStatus + ", endSuspendedTime=" + endSuspendedTime + ", comRepNum=" + comRepNum + "]";
	}

}
