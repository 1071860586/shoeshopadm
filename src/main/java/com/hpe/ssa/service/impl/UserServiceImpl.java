package com.hpe.ssa.service.impl;

import com.hpe.ssa.mapper.UserMapper;
import com.hpe.ssa.pojo.Users;
import com.hpe.ssa.service.UserService;
import com.hpe.ssa.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserMapper userDaoImpl;

   /* public UserMapper getUserMapper() {
        return userDaoImpl;
    }

    public void setUserMapper(UserMapper userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }*/

     @Override
    public Users loginUser(Users users) {
        //用户登录
        Users user = userDaoImpl.loginUser(users);
        return user;
    }

    @Override
    public Page<Users> selectAll(Page page) {
        //分页查询
        System.out.println("------------");
       int curPage = page.getCurPage();
       Page<Users> usersPage = new Page<Users>();
       usersPage.setCurPage((curPage-1)*5);
       usersPage.setPageNumber(5);
       List<Users> list = userDaoImpl.selectAll(usersPage);//返回查询的数组
        int rows = userDaoImpl.selectAllSum();//数据库总记录数
        Page<Users> page1 = new Page<Users>();
        page1.setData(list);
        page1.setCurPage(curPage);
        page1.setRows(rows);
        int totalPage = rows/5+1;
        page1.setTotalPage(totalPage);

        return page1;
    }

    @Override
    public int selectAllSum() {
        //查询总记录
        int i = userDaoImpl.selectAllSum();
        return i;
    }

    @Override
    public int delUsers(Users users) {
        //更改用户权限
        int  i = userDaoImpl.delUsers(users);
        return i;
    }

    @Override
    public List<Users> users(String string) {
        //查询操作
        List<Users> usersList =  userDaoImpl.users(string);
        return usersList;
    }

    @Override
    public Users selectById(int uid) {
        //通过id查询用户信息
        Users users = userDaoImpl.selectById(uid);
        return users;
    }

    @Override
    public int saveUsers(Users users) {
        //更新用户信息
        int i = userDaoImpl.saveUsers(users);
        return i;
    }

}
