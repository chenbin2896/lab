package com.ty.lab.controller;

import com.ty.lab.entity.PageResult;
import com.ty.lab.entity.Result;
import com.ty.lab.pojo.TbAnnouncment;
import com.ty.lab.service.AnnouncmentService;
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
@RequestMapping("/announcment")
public class AnnouncmentController {

    @Autowired
    private AnnouncmentService announcmentService;

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbAnnouncment> findAll() {
        return announcmentService.findAll();
    }

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows) {
        return announcmentService.findPage(page, rows);
    }

    /**
     * 增加
     *
     * @param announcment
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbAnnouncment announcment) {
        try {
            announcmentService.add(announcment);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     *
     * @param announcment
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbAnnouncment announcment) {
        try {
            announcmentService.update(announcment);
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
    public TbAnnouncment findOne(Long id) {
        return announcmentService.findOne(id);
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
            announcmentService.delete(ids);
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
    public PageResult search(@RequestBody TbAnnouncment announcment, int page, int rows) {
        return announcmentService.findPage(announcment, page, rows);
    }

}
