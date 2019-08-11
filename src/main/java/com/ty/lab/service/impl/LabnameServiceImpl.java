package com.ty.lab.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ty.lab.dao.TbLabnameMapper;
import com.ty.lab.entity.PageResult;
import com.ty.lab.pojo.TbLabname;
import com.ty.lab.pojo.TbLabnameExample;
import com.ty.lab.service.LabnameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
public class LabnameServiceImpl implements LabnameService {

    @Autowired
    private TbLabnameMapper labnameMapper;

    /**
     * 查询全部
     */
    @Override
    public List<TbLabname> findAll() {
        return labnameMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbLabname> page = (Page<TbLabname>) labnameMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(TbLabname labname) {
        labnameMapper.insert(labname);
    }

    /**
     * 修改
     */
    @Override
    public void update(TbLabname labname) {
        labnameMapper.updateByPrimaryKey(labname);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public TbLabname findOne(Long id) {
        return labnameMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            labnameMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult findPage(TbLabname labname, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        TbLabnameExample example = new TbLabnameExample();
        TbLabnameExample.Criteria criteria = example.createCriteria();

        if (labname != null) {
            if (labname.getName() != null && labname.getName().length() > 0) {
                criteria.andNameLike("%" + labname.getName() + "%");
            }
            if (labname.getState() != null) {
                criteria.andStateEqualTo(labname.getState());
            }

        }

        Page<TbLabname> page = (Page<TbLabname>) labnameMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

}
