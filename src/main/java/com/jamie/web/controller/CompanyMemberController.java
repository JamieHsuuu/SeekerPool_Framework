package com.jamie.web.controller;

import java.io.File;
import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jamie.core.dto.ResultInfoDto;
import com.jamie.core.util.JWTUtil;
import com.jamie.web.dto.CompanyMemberDto;
import com.jamie.web.entity.CompanyMember;
import com.jamie.web.service.CompanyMemberService;
import com.jamie.web.service.ImageService;

@RequestMapping("/frontEnd/companyMembers")
@RestController
public class CompanyMemberController {

	@Autowired
	private CompanyMemberService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ImageService imageService;

	// 註冊
	@PostMapping("/register")
	public ResponseEntity<ResultInfoDto> createCompanyMember(
			@ModelAttribute CompanyMemberDto companyMemberDto) throws IOException {
		
		String imageUrl = imageService.storeImage(companyMemberDto.getComPicture());
		companyMemberDto.setComPictureUrl(imageUrl);
		
		ResultInfoDto resultInfo = service.registerCompanyMember(companyMemberDto);
		
		// 根據註冊結果返回狀態碼
		if (resultInfo.isFlag()) {
			String token = JWTUtil.generateToken(companyMemberDto.getComMemAccount());
			resultInfo.setToken(token);
			return ResponseEntity.ok(resultInfo);
		} else {
			return ResponseEntity.badRequest().body(resultInfo);
		}

	}
	
	// 登入
	@PostMapping("/login")
	public ResponseEntity<ResultInfoDto> login(@RequestBody CompanyMember companyMember) {
		CompanyMember loginComMem = service.login(companyMember);
		ResultInfoDto resultInfo = new ResultInfoDto();
		
		if (loginComMem == null) {
			// 帳號或密碼錯誤
			resultInfo.setFlag(false);
			resultInfo.setMessage("您輸入的帳號或密碼錯誤，請重新確認");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resultInfo);
		} else {
			// 登入成功
			resultInfo.setFlag(true);
			int comMemId = loginComMem.getComMemId();
//			request.getSession().setAttribute("companyMember", comMemId);
			return ResponseEntity.ok(resultInfo);
		}
	}
	
	// 登出
//	@PostMapping("/logout")
	
	// 更新會員資料
	@PutMapping("/profile")
	public ResponseEntity<ResultInfoDto> updateCompanyMember(
			@PathVariable int id,
			@ModelAttribute CompanyMemberDto companyMemberDto) {
		
		ResultInfoDto resultInfo = new ResultInfoDto();
		
		try {
			MultipartFile file = companyMemberDto.getComPicture();
			
			if (file != null && !file.isEmpty()) {
				String imageUrl = imageService.storeImage(file);
				companyMemberDto.setComPictureUrl(imageUrl);
			}			
			// 把DTO轉換成實體物件
			CompanyMember companyMember = modelMapper.map(companyMemberDto, CompanyMember.class);
			service.updateCompanyMember(companyMember);
			
			resultInfo.setFlag(true);
			return ResponseEntity.ok(resultInfo);
			
		} catch (Exception e) {
			resultInfo.setFlag(false);
			resultInfo.setMessage("更新過程中發生錯誤，請稍後再試");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultInfo);
		}
	}
	
	// 更新會員資料
//	@PutMapping("/{id}/avatar")

}
