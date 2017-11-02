package com.hpe.ssa.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.hpe.ssa.pojo.*;
import com.hpe.ssa.utils.JsonUtils;
import com.hpe.ssa.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hpe.ssa.service.AdminsService;
import com.hpe.ssa.service.PercontentService;

@Controller
public class AdminsController {
	
	@Autowired
	private AdminsService adminsService;
	@Autowired
	private PercontentService percontentService;

	@RequestMapping("/")
	public String showLogin(){
		return "login";
	}

	@RequestMapping("/index")
	public String showIndex(){
		return "pages/admin/index";
	}

	@RequestMapping("/login")
	public ModelAndView login(Admins admins,HttpSession session){
		Admins ad = adminsService.login(admins);
		session.setAttribute("admins", ad);
		ModelAndView mv = new ModelAndView();
		if(ad!=null){
			List<Percontent> percontentList = percontentService.getPercontentList(ad.getA_pcid());
			session.setAttribute("percontentList", percontentList);
			mv.setViewName("redirect:/index");
		}else{
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session){
		session.removeAttribute("admins");
		session.removeAttribute("percontentList");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}
	@RequestMapping("/adminsmgmt")
	public String showAdminsMgmtPage(){
		return "pages/admin/adminsList";
	}
	@RequestMapping("/get/admin/adminsnum")
	@ResponseBody
	public String getTotalNum(){
		return String.valueOf(adminsService.selectAdminsNum());
	}


	@RequestMapping("/admininput")
	public String showShoeAddPage(){
		return "pages/adminAccount/adminAdd";
	}
	@RequestMapping(value = "/get/adminslist",method = RequestMethod.GET)
	@ResponseBody
	public List<Admins> showAdminsList(String index){
		return adminsService.selectAdminsList(Integer.parseInt(index));
	}
@RequestMapping("/get/permissionName")
	@ResponseBody
	public List<Permission> getPermissionNames(){
		return adminsService.selectPermissionList();
}
	@RequestMapping(value = "/add/admin",method = RequestMethod.POST)
	@ResponseBody
	public ResultUtil addNewAdmin(Admins admin){
		if (adminsService.insertAdmin(admin) !=0){
			return new ResultUtil("1","成功");
		}else {
			return new ResultUtil("0","失败");
		}
	}
	@RequestMapping(value = "/edit/admin/update/{aid}",method = RequestMethod.GET)
	public ModelAndView editAdminById(@PathVariable String aid){
		Admins admin = adminsService.selectAdminDetailById(Integer.parseInt(aid));
		ModelAndView mv = new ModelAndView();
		mv.addObject("admin", JsonUtils.objectToJson(admin));
		mv.setViewName("pages/adminAccount/adminEdit");
		return mv;
	}
	@RequestMapping(value = "/edit/admin/delete/{aid}",method = RequestMethod.GET)
	public String deleteAdminById(@PathVariable String aid){
		adminsService.deleteAdmins(Integer.parseInt(aid));
		return "pages/admin/adminsList";
	}
	@RequestMapping(value = "/update/admin",method = RequestMethod.POST)
	@ResponseBody
	public int updateAdminDetail(Admins admin){
		return adminsService.updateAdmins(admin);
	}
}

