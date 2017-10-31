package com.hpe.ssa.mapper;

import java.util.List;

import com.hpe.ssa.pojo.Percontent;


public interface PercontentMapper {
	//获取权限菜单列表
	public List<Percontent> getPercontentList(int pc_perid);
}
