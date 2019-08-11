package com.ty.lab.service;

import com.ty.lab.entity.PageResult;
import com.ty.lab.pojo.TbLabstate;

import java.util.List;

/**
 * 服务层接口
 *
 * @author Administrator
 */
public interface LabstateService {

    /**
     * 返回全部列表
     *
     * @return
     */
    public List<TbLabstate> findAll();

    /**
     * 返回分页列表
     *
     * @return
     */
    public PageResult findPage(int pageNum, int pageSize);

    /**
     * 增加
     */
    public void add(TbLabstate labstate);

    /**
     * 修改
     */
    public void update(TbLabstate labstate);

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    public TbLabstate findOne(Long id);

    /**
     * 批量删除
     *
     * @param ids
     */
    public void delete(Long[] ids);

    /**
     * 分页
     *
     * @param pageNum  当前页 码
     * @param pageSize 每页记录数
     * @return
     */
    public PageResult findPage(TbLabstate labstate, int pageNum, int pageSize);

}
