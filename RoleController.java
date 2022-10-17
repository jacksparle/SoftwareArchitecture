package cn.wolfcode.controller;

import cn.wolfcode.entity.T_Role;
import cn.wolfcode.service.RoleService;
import cn.wolfcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;




public class RoleController {

    @Autowired
    RoleService roleServiceImpl;
    //生成对象

    @RequestMapping("/roleAdd")
    public ModelAndView roleAdd(
            @RequestParam(name = "rname",required = true)String rname,
            @RequestParam(name = "rdesc",required = true)String rdesc,
            /*@RequestParam(name = "rolelei",required = true)*/String rolelei,
            HttpServletRequest req
            /*@RequestBody Map<String,Object> map*/){

        System.out.println("开始增加角色");
        ModelAndView mav = new ModelAndView();
        ServletContext servletContext = req.getServletContext();
        Object Info = servletContext.getAttribute("rid");
        System.out.println(servletContext.getAttribute("rid"));

        mav.setViewName("roleAdd.jsp");
        mav.addObject("roleInfo",(String)Info);

        if ( rname == "" || rdesc == "" ){
            mav.setViewName("roleAdd.jsp");
            System.out.println("空问题 ROLELI ="+rolelei);
            mav.addObject("empty_msg","不能为空！（“*” 为必填信息）");
            return mav;
        }

        T_Role role = roleServiceImpl.getRoleInfo1("rname",rname);

        if (role != null){
            mav.setViewName("roleAdd.jsp");
            System.out.println("角色名字重复");
            mav.addObject("acountExist_msg","角色名字已存在！");
            return mav;
        }
int a ;




        T_Role roleUpdate = new T_Role();
        /*   roleUpdate.setRid(Integer.parseInt(rid));*/
        roleUpdate.setRnamne(rname);
        roleUpdate.setRdesc(rdesc);
        System.out.println("运行完成");

        mav.setViewName("roleAdd.jsp");
        mav.addObjectc("Complete_msg","保存成功！角色创建完成！");
        return mav;
    }


}
