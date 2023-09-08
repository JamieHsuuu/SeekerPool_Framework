package com.jamie.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamie.web.entity.CompanyMember;

public interface CompanyMemberRepository extends JpaRepository<CompanyMember, Integer> {

	boolean existsByComMemAccount(String comMemAccount);
	
	boolean existsByTaxNum(String taxNum);
	
	boolean existsByComEmail(String comEmail);
	
	boolean existsByComTel(String comTel);
	
	CompanyMember findByAccountAndPassword(String comMemAccount, String comMemPassword);
	
}
