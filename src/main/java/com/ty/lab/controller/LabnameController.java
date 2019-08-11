package com.ty.lab.controller;

import com.ty.lab.entity.PageResult;
import com.ty.lab.entity.Result;
import com.ty.lab.pojo.TbLabname;
import com.ty.lab.service.LabnameService;
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
@RequestMapping("/labname")
public class LabnameController {

    @Autowired
    private LabnameService labnameService;

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbLabname> findAll() {
        return labnameService.findAll();
    }

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows) {
        return labnameService.findPage(page, rows);
    }

    /**
     * 增加
     *
     * @param labname
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbLabname labname) {
        try {
            labnameService.add(labname);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     *
     * @param labname
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbLabname labname) {
        try {
            labnameService.update(labname);
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
    public TbLabname findOne(Long id) {
        return labnameService.findOne(id);
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
            labnameService.delete(ids);
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
    public PageResult search(@RequestBody TbLabname labname, int page, int rows) {
        return labnameService.findPage(labname, page, rows);
    }

}
