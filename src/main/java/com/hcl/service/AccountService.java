package com.hcl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.repository.*;
import com.hcl.domain.*;

@Service
public class AccountService {

	@Autowired
	AccountRepository repository;

	public boolean checkAccountExist(String username) {

		if (repository.findByUsername(username) == null) {
			return false;
		}
		return true;
	}

	public boolean isAdmin(String username) {
		if (username!="") {
			if (repository.isAdmin(username) == 1)
				return true;
			return false;
		}
		return false;
	}

	public Account checkLogin(String username, String password) {
		if (repository.findByUsernameAndPassword(username, password) != null) {
			return repository.findByUsernameAndPassword(username, password);
		}
		return null;

	}

	public Account findByUsername(String username) {
		return repository.findByUsername(username);
	}

	public Account findByEno(int eno) {
		return repository.findByEno(eno);
	}
}