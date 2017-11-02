package com.hpe.ssa.service;

import com.hpe.ssa.pojo.Users;
import com.hpe.ssa.utils.Page;

import java.util.List;

/**
 * @author
 */

public interface UserService {
    //用户登录
    public Users loginUser(Users users);
    //分页查询
    public Page<Users> selectAll(Page page);
    //查询总记录
    public int selectAllSum();
    //更改用户权限
    public int delUsers(Users users);
    //模糊查询
    public List<Users> users(String string);
    //通过用户ID查询用户信息
    public Users selectById(int uid);
    //编辑用户
    public int saveUsers(Users users);



}
