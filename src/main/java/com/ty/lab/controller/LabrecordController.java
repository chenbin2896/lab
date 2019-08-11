package com.ty.lab.controller;

import com.ty.lab.entity.PageResult;
import com.ty.lab.entity.Result;
import com.ty.lab.pojo.TbLabrecord;
import com.ty.lab.service.LabrecordService;
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
@RequestMapping("/labrecord")
public class LabrecordController {

    @Autowired
    private LabrecordService labrecordService;

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbLabrecord> findAll() {
        return labrecordService.findAll();
    }

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows) {
        return labrecordService.findPage(page, rows);
    }

    /**
     * 增加
     *
     * @param labrecord
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbLabrecord labrecord) {
        try {
            labrecordService.add(labrecord);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     *
     * @param labrecord
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbLabrecord labrecord) {
        try {
            labrecordService.update(labrecord);
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
    public TbLabrecord findOne(Long id) {
        return labrecordService.findOne(id);
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
            labrecordService.delete(ids);
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
    public PageResult search(@RequestBody TbLabrecord labrecord, int page, int rows) {
        return labrecordService.findPage(labrecord, page, rows);
    }

}
