package com.jamie.web.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jamie.core.dto.ResultInfoDto;
import com.jamie.core.util.RandCodeUtil;
import com.jamie.core.util.SendEmailUtil;
import com.jamie.web.dao.CompanyMemberRepository;
import com.jamie.web.dto.CompanyMemberDto;
import com.jamie.web.entity.CompanyMember;
import com.jamie.web.service.CompanyMemberService;

@Service
public class CompanyMemberServiceImpl implements CompanyMemberService {

	@Autowired
	private CompanyMemberRepository companyMemberRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	@Transactional
	public ResultInfoDto registerCompanyMember(CompanyMemberDto companyMemberDto) {
		ResultInfoDto resultInfo = new ResultInfoDto();

		// 1. 獲取各項前台表單的註冊資訊
		boolean isAccountExist = companyMemberRepository.existsByComMemAccount(companyMemberDto.getComMemAccount());
		boolean isTaxNumExist = companyMemberRepository.existsByTaxNum(companyMemberDto.getTaxNum());
		boolean isComEmailExist = companyMemberRepository.existsByComEmail(companyMemberDto.getComEmail());
		boolean isComTelExist = companyMemberRepository.existsByComTel(companyMemberDto.getComTel());

		// 2. 判斷資訊是否重複
		if (isAccountExist) {
			resultInfo.setFlag(false);
			resultInfo.setMessage("您的帳號已被註冊，請重新輸入");
			return resultInfo;
		}

		if (isTaxNumExist) {
			resultInfo.setFlag(false);
			resultInfo.setMessage("您的統一編號已被使用，請重新輸入");
			return resultInfo;
		}

		if (isComEmailExist) {
			resultInfo.setFlag(false);
			resultInfo.setMessage("您的信箱已被使用，請重新輸入");
			return resultInfo;
		}

		if (isComTelExist) {
			resultInfo.setFlag(false);
			resultInfo.setMessage("您的電話號碼已被使用，請重新輸入");
			return resultInfo;
		}

		// 將 DTO 轉換為 DAO 實體
		CompanyMember companyMember = modelMapper.map(companyMemberDto, CompanyMember.class);
		companyMemberRepository.save(companyMember);

		resultInfo.setFlag(true);
		resultInfo.setMessage("註冊成功");

		return resultInfo;

	}

	@Override
	public CompanyMember login(CompanyMember companyMember) {
		CompanyMember loginComMem = companyMemberRepository.findByAccountAndPassword(companyMember.getComMemAccount(),
				companyMember.getComMemPassword());
		return loginComMem;
	}

	@Override
	public CompanyMember getCompanyMemberById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendValidCode(CompanyMember companyMember) {
		// 取得隨機驗證碼
		String randomCode = RandCodeUtil.getRandomCode(6);
		// 寄信給使用者
		String email = companyMember.getComEmail();
		String subject = "【Seeker's Pool】驗證碼通知";
		String name = companyMember.getComName();
		String emailText = name + "，您好！\n您的驗證碼為：" + randomCode + "\n請於5分鐘內驗證完成！";

		// 開立多執行緒寄信
		Thread t1 = new Thread(() -> SendEmailUtil.sendMail(email, subject, emailText));
		t1.start();

		return randomCode;
	}

	@Override
	public boolean checkValidCode(String inputValidCode, String validCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateCompanyMember(CompanyMember companyMember) {
		companyMemberRepository.save(companyMember);
	}

	@Override
	public void updateCompanyStatus(CompanyMember companyMember) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CompanyMember> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyMember getInfoForApplicants(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
