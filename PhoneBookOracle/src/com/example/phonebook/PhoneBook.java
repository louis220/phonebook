package com.example.phonebook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.example.phonebook.dao.PhoneBookDAO;
import com.example.phonebook.dao.PhoneBookDAOImpl;
import com.example.phonebook.vo.PhoneBookVO;




public class PhoneBook {

	public static void main(String[] args) {
		
		
		while(true) {
			System.out.println("1.리스트   2.등록   3.삭제   4.검색   5.종료");
			System.out.println("-------------------------------");
			System.out.println(">메뉴번호:");
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		if( num == 1) {
			System.out.println("<1.리스트>");
			PhoneBookDAO dao= new PhoneBookDAOImpl();
			List<PhoneBookVO> phone_book = dao.getList();
			
			Iterator<PhoneBookVO> iter = phone_book.iterator();
			while (iter.hasNext()) {
				PhoneBookVO phonebook = iter.next();
				System.out.println(phonebook);
			
			}
		}		
		else if( num == 2) {
			System.out.println("<2.등록>");
			System.out.println(">이름:");
			String name =  scanner.next();
			System.out.println(">휴대전화:");
			String hp = scanner.next();
			System.out.println(">집전화:");
			String tel = scanner.next();
			
			PhoneBookVO phonebook = new PhoneBookVO(null, name, hp, tel);
			PhoneBookDAO dao = new PhoneBookDAOImpl();
			boolean isSuccess = dao.insert(phonebook);
			System.out.println("[등록되었습니다.]");
		}
			
		else if( num ==3 ) {
			System.out.println("<3.삭제>");
			System.out.print(">번호:");
			int id = scanner.nextInt();
			
			PhoneBookDAO dao = new PhoneBookDAOImpl();
			boolean isSuccess = dao.delete(Long.valueOf(id));
			System.out.println("[삭제되었습니다.]");
		}
			
		else if(num ==4) {
			
        	
			System.out.println(">이름");
			String name = scanner.next();
			PhoneBookDAO dao= new PhoneBookDAOImpl();
			List<PhoneBookVO> phone_book = dao.getSearchList(name);
			for (PhoneBookVO pb:phone_book) {
				System.out.println(pb);
					}
		}		
		else if(num == 5) {
			System.out.println("*******************************");
			System.out.println("*       감사합니다            *");
			System.out.println("*******************************");
			break;
		}
		
		
		
		
		else if(num !=1 || num !=2 || num !=3 || num !=4 || num !=5 ){
			try {
				System.out.println("[다시입력해주세요]");
						
			}catch (Exception e) {
			    e.printStackTrace();
			    
			}
				}
		
		}
		
	}
}	


