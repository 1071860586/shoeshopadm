package com.hpe.ssa.controller;


import com.hpe.ssa.pojo.Users;
import com.hpe.ssa.service.UserService;
import com.hpe.ssa.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControllerUser {
    @Autowired
    @Qualifier("userServiceImpl")
    public UserService userService;

  /*  public UserServiceImpl getUserServiceImpl() {
        return userServiceImpl;
    }

    public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }
*/

    /**
     * 用户登录验证
     * @param user
     */
    @RequestMapping("/Userlogin.action")
    public void loginUser(Users user){
       Users users = userService.loginUser(user);
        ModelAndView modelAndView = new ModelAndView();
       if(users != null && users.getUdelete() != 1){
           System.out.println("登录成功");
           //跳转到主页面
           modelAndView.addObject("user",users);
           modelAndView.setViewName("");
       }else{
           //登录失败
           //跳转到失败页面
       }


    }

    /**
     * 查询操作
     * @param request
     * @return
     */
    @RequestMapping("/users.action")
    public ModelAndView users(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        String search = request.getParameter("search");
        System.out.println("要查询的信息："+search);
        List<Users> usersList =  userService.users(search);

        if(usersList!= null){
            Page<Users> page = new Page<Users>();
            page.setData(usersList);
            modelAndView.addObject("page",page);
            System.out.println("查询的数据:"+page);
            modelAndView.setViewName("WEB-INF/pages/userManagement/userList.jsp");
        }
        return modelAndView;

    }


    @RequestMapping("/go.action")
    public ModelAndView selectAll(Page pages){
        System.out.println("开始执行Controller...");
        if(pages == null){
            pages.setCurPage(1);
        }
        System.out.println(pages);
        Page<Users> page = userService.selectAll(pages);

        System.out.println("输出数据："+page);
        ModelAndView modelAndView = new ModelAndView();

        if(page != null){

            modelAndView.addObject("page",page);
            modelAndView.setViewName("WEB-INF/pages/userManagement/userList.jsp");
        }
       return modelAndView;
    }

    /**
     * 更改用户权限
     * @param request
     * @return ModelAndView对象
     */
    @RequestMapping("/delUsers.action")
    public ModelAndView delUsers(HttpServletRequest request){
        String Delid = request.getParameter("delid");
        String Del = request.getParameter("del");
        int delid = Integer.parseInt(Delid);
        int del = Integer.parseInt(Del);
        Users users = new Users();
        users.setUid(delid);
        users.setUdelete(del);
        //---------------------------
        int i = userService.delUsers(users);
        ModelAndView modelAndView = new ModelAndView();
        if(i>0){
            System.out.println("用户权限修改成功");
            modelAndView.setViewName("WEB-INF/pages/userManagement/userList.jsp");
        }
        return modelAndView;
    }


    /**
     * 编辑用户信息
     * @param request
     * @return ModelAndView
     */
    @RequestMapping("/editUsers.action")
    public ModelAndView editUsers(HttpServletRequest request){
        String userid = request.getParameter("id");
        System.out.println("要编辑的用户id："+userid);
        int uid = Integer.parseInt(userid);
        Users users = userService.selectById(uid);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users",users);
        modelAndView.setViewName("WEB-INF/pages/userManagement/userInput.jsp");
        return modelAndView;
    }
    @RequestMapping("/saveUsers.action")
    public ModelAndView saveUsers(Users user){
        System.out.println("编辑数据。。。");
        System.out.println(user);
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("------BUG: Mybatis更新数据返回值为int，却显示为，原因：--------");
         int i = userService.saveUsers(user);
        System.out.println("返回的数据："+i);
        if(i>0){
            modelAndView.addObject("update","更新成功");
            modelAndView.setViewName("WEB-INF/pages/userManagement/userInput.jsp");
        }
        return modelAndView;

    }

}
