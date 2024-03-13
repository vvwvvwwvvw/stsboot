package com.icia.board.dao;

import org.apache.ibatis.annotations.Mapper;

import com.icia.board.dto.MemberDto;

@Mapper
public interface MemberDao {
	// 로그인 비밀번호를 가져오는 메서드
	String selectPassword(String mid);
	//	로그인 성공 후 회원 정보를 가져오는 메소드
	MemberDto selectMember(String mid); 
}
