package com.jamie.web.service;

import java.util.List;

import com.jamie.core.dto.ResultInfoDto;
import com.jamie.web.dto.CompanyMemberDto;
import com.jamie.web.entity.CompanyMember;

public interface CompanyMemberService {
	
	ResultInfoDto registerCompanyMember(CompanyMemberDto companyMemberDto);
	
	CompanyMember login(CompanyMember companyMember);
	
	CompanyMember getCompanyMemberById(int id);
	
	String sendValidCode(CompanyMember companyMember);
	
	boolean checkValidCode(String inputValidCode, String validCode);
	
	void updateCompanyMember(CompanyMember companyMember);

	void updateCompanyStatus(CompanyMember companyMember);
	
	public List<CompanyMember> findAll();
	
	public CompanyMember getInfoForApplicants(int id);
	
}
