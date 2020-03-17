package com.example.phonebook.dao;

import java.util.List;

import com.example.phonebook.vo.PhoneBookVO;



public interface PhoneBookDAO {

		public List<PhoneBookVO> getList();
		public boolean insert(PhoneBookVO phoneBookVO);
		public boolean delete(Long id); 
		public List<PhoneBookVO> getSearchList(String name);
		
}
