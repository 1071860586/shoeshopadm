package com.hpe.ssa.service.impl;

import java.util.List;

import com.hpe.ssa.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpe.ssa.mapper.AdminsMapper;
import com.hpe.ssa.pojo.Admins;

@Service
public class AdminsServiceImpl implements AdminsService {
	@Autowired
	private AdminsMapper adminsMapper;
	@Override
	public Admins login(Admins admins) {
		Admins ad = adminsMapper.login(admins);
		return ad;
	}

/*	@Override
	public int addAdmins(Admins admins) {
		return 0;
	}

	@Override
	public int updateAdmins(Admins admins) {
		return 0;
	}

	@Override
	public int deleteAdmins(Admins admins) {
		return 0;
	}

	@Override
	public Admins getAdminsById(int id) {
		return null;
	}

	@Override
	public List<Admins> getAdminsList() {
		return null;
	}*/

}
