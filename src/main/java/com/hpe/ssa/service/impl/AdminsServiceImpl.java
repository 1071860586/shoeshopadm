package com.hpe.ssa.service.impl;

import java.util.List;

import com.hpe.ssa.pojo.Permission;
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

	@Override
	public int addAdmins(Admins admins) {
		return 0;
	}

	@Override
	public int updateAdmins(Admins admins) {
		return adminsMapper.updateAdmins(admins);
	}

	@Override
	public int deleteAdmins(int aid) {
		return adminsMapper.deleteAdmins(aid);
	}

	@Override
	public Admins getAdminsById(int id) {
		return null;
	}

	@Override
	public List<Admins> getAdminsList() {
		return adminsMapper.getAdminsList();
	}

	@Override
	public int selectAdminsNum() {
		return adminsMapper.selectAdminsNum();
	}

	@Override
	public Admins selectAdminDetailById(int aid) {
		return adminsMapper.selectAdminDetailById(aid);
	}

	@Override
	public List<Admins> selectAdminsList(int index) {
		return adminsMapper.selectAdminsList(index);
	}

	@Override
	public List<Permission> selectPermissionList() {
		return adminsMapper.selectPermissionList();
	}

	@Override
	public int insertAdmin(Admins admin) {
		return adminsMapper.insertAdmin(admin);
	}

}
