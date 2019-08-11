package com.ty.lab.service;

import com.ty.lab.entity.PageResult;
import com.ty.lab.pojo.TbLabname;

import java.util.List;

/**
 * 服务层接口
 *
 * @author Administrator
 */
public interface LabnameService {

    /**
     * 返回全部列表
     *
     * @return
     */
    public List<TbLabname> findAll();

    /**
     * 返回分页列表
     *
     * @return
     */
    public PageResult findPage(int pageNum, int pageSize);

    /**
     * 增加
     */
    public void add(TbLabname labname);

    /**
     * 修改
     */
    public void update(TbLabname labname);

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    public TbLabname findOne(Long id);

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
    public PageResult findPage(TbLabname labname, int pageNum, int pageSize);

}
