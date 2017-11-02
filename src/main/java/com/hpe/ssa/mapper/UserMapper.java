package com.hpe.ssa.mapper;



import com.hpe.ssa.pojo.Users;
import com.hpe.ssa.utils.Page;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserMapper {
    public Users loginUser(Users users);
    public List<Users> selectAll(Page page);
    public int selectAllSum();
    public int delUsers(Users users);
    public List<Users> users(String string);//模糊查询
    //通过用户ID查询用户信息
    public Users selectById(int uid);
    public int saveUsers(Users users);

}
