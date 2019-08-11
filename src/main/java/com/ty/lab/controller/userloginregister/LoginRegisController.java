package com.ty.lab.controller.userloginregister;

import com.ty.lab.dao.TbAccountinfoMapper;
import com.ty.lab.pojo.TbAccountinfo;
import com.ty.lab.pojo.TbAccountinfoExample;
import com.ty.lab.service.AccountinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登录注册控制器
 */
@RestController
public class LoginRegisController {

    @Autowired
    private TbAccountinfoMapper accountinfoMapper;

    @Autowired
    private AccountinfoService accountinfoService;

    /**
     * 用户登录
     *
     * @param user
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public Map login(@RequestBody TbAccountinfo user, HttpSession session) {
        Map map = new HashMap();
        System.out.println(user);

        //查找user
        TbAccountinfoExample example = new TbAccountinfoExample();
        TbAccountinfoExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());
        // criteria.andRidEqualTo(2);      //2代表普通用户角色

        //根据条件查找用户是否存在
        List<TbAccountinfo> tbUsers = accountinfoMapper.selectByExample(example);

        //查找结果等于1，该用户存在；将用户信息保存在session中
        if (tbUsers.size() == 1) {

            TbAccountinfo tbUser = tbUsers.get(0);
            session.setAttribute("username", tbUser.getUsername());
            session.setAttribute("userid", tbUser.getId());
            map.put("message", "登录成功");
            map.put("username", tbUser.getUsername());
            map.put("userid", tbUser.getId());
        } else {
            map.put("message", "用户不存在或密码错误");
        }

        return map;
    }

    /**
     * 注销登录
     *
     * @return
     */
    @RequestMapping("/logout")
    public Map logout(HttpSession session) {
        Map map = new HashMap();

        if (session.getAttribute("username") != null && session.getAttribute("userid") != null) {
            session.removeAttribute("username");
            session.removeAttribute("userid");
            map.put("message", "已注销");
        } else {
            map.put("message", "程序异常！");
        }

        return map;

    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @RequestMapping("/register")
    public Map register(@RequestBody TbAccountinfo user) {
        Map map = new HashMap();
        user.setState(0);
        user.setLevel(0);

        //调用service方法，添加用户到数据库
        int add = accountinfoService.add(user);
        System.out.println(add);
        //添加成功
        if (add != 0) {
            map.put("code", "OK");
            map.put("message", "注册成功");
        } else {
            map.put("code", "fail");
            map.put("message", "注册失败");
        }

        return map;
    }

    /**
     * 判断是否登录
     *
     * @param session
     * @return
     */
    @RequestMapping("/checklogin")
    public Map checklogin(HttpSession session) {
        Map map = new HashMap();
        //从session中获取用户名和用户ID
        String username = (String) session.getAttribute("username");
        Long userid = (Long) session.getAttribute("userid");

        //session中不存在用户信息，返回logout
        if (username == null || userid == null) {
            map.put("message", "logout");
        } else {
            map.put("message", "login");
            map.put("username", username);
            map.put("userid", userid);
        }
        return map;
    }

}
