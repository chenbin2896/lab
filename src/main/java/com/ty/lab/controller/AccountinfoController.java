package com.ty.lab.controller;

import com.ty.lab.entity.PageResult;
import com.ty.lab.entity.Result;
import com.ty.lab.pojo.TbAccountinfo;
import com.ty.lab.service.AccountinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/accountinfo")
public class AccountinfoController {

    @Autowired
    private AccountinfoService accountinfoService;

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbAccountinfo> findAll() {
        return accountinfoService.findAll();
    }

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows) {
        return accountinfoService.findPage(page, rows);
    }

    /**
     * 增加
     *
     * @param accountinfo
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbAccountinfo accountinfo) {
        try {
            accountinfoService.add(accountinfo);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     *
     * @param accountinfo
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbAccountinfo accountinfo) {
        try {
            accountinfoService.update(accountinfo);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 获取实体
     *
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public TbAccountinfo findOne(Long id) {
        return accountinfoService.findOne(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            accountinfoService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 查询+分页
     *
     * @param brand
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbAccountinfo accountinfo, int page, int rows) {
        return accountinfoService.findPage(accountinfo, page, rows);
    }

}
