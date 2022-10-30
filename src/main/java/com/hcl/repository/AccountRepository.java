package com.hcl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.domain.Account;
import com.hcl.domain.Employee;

public interface AccountRepository extends JpaRepository<Account, Integer>  {
//  
//	@Query(value = "SELECT a.Id,a.Username,a.Password,a.isAdmin,a.Eno FROM account a WHERE a.USERNAME = ?1 AND a.PASSWORD = ?2" ,nativeQuery = true)
	public Account findByUsernameAndPassword(String username, String password);
	
	public Account findByUsername(String username);
	
	@Query(value = "SELECT isAdmin FROM account WHERE USERNAME = ?1",nativeQuery = true)
	public int isAdmin(String username);
	
	@Query(value = "SELECT * FROM ACCOUNT WHERE ENO = ?1",nativeQuery = true)
	public Account findByEno(int eno);
	
}