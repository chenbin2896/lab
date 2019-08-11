package com.ty.lab.controller;

import com.ty.lab.entity.PageResult;
import com.ty.lab.entity.Result;
import com.ty.lab.pojo.TbLabstate;
import com.ty.lab.service.LabstateService;
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
@RequestMapping("/labstate")
public class LabstateController {

    @Autowired
    private LabstateService labstateService;

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbLabstate> findAll() {
        return labstateService.findAll();
    }

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows) {
        return labstateService.findPage(page, rows);
    }

    /**
     * 增加
     *
     * @param labstate
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbLabstate labstate) {
        try {
            labstateService.add(labstate);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     *
     * @param labstate
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbLabstate labstate) {
        try {
            labstateService.update(labstate);
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
    public TbLabstate findOne(Long id) {
        return labstateService.findOne(id);
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
            labstateService.delete(ids);
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
    public PageResult search(@RequestBody TbLabstate labstate, int page, int rows) {
        return labstateService.findPage(labstate, page, rows);
    }

}
