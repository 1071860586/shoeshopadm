package com.hpe.ssa.mapper;

import com.hpe.ssa.pojo.Admins;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AdminsMapper {
	//管理员登录
	public Admins login(Admins admins);
}
