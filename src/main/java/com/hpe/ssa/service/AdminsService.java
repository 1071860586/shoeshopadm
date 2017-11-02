package com.hpe.ssa.service;

import java.util.List;
import com.hpe.ssa.pojo.Admins;
import com.hpe.ssa.pojo.AdminsList;
import com.hpe.ssa.pojo.Permission;


public interface AdminsService {
	//管理员登录
	public Admins login(Admins admins);
	//新增管理员
	public int addAdmins(Admins admins);
	//修改管理员
	public int updateAdmins(Admins admins);
	//删除管理员
	public int deleteAdmins(int aid);
	//根据ID获取管理员信息
	public Admins getAdminsById(int id);
	//获取管理员列表
	public List<Admins> getAdminsList();
	//获取管理员总数用于分页
	public int selectAdminsNum();
	//获取要修改的管理员信息
	public Admins selectAdminDetailById(int aid);
	//获取管理员管理页面管理员列表
	public List<Admins> selectAdminsList(int index);
	//获取管理员权限列表
	public List<Permission> selectPermissionList();
	//从前台获取数据添加新的管理员
	public int insertAdmin(Admins admin);
}
