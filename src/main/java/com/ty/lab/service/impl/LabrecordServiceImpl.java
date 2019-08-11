package com.ty.lab.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ty.lab.dao.TbLabrecordMapper;
import com.ty.lab.entity.PageResult;
import com.ty.lab.pojo.TbLabrecord;
import com.ty.lab.pojo.TbLabrecordExample;
import com.ty.lab.service.LabrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
public class LabrecordServiceImpl implements LabrecordService {

    @Autowired
    private TbLabrecordMapper labrecordMapper;

    /**
     * 查询全部
     */
    @Override
    public List<TbLabrecord> findAll() {
        return labrecordMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbLabrecord> page = (Page<TbLabrecord>) labrecordMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(TbLabrecord labrecord) {
        labrecordMapper.insert(labrecord);
    }

    /**
     * 修改
     */
    @Override
    public void update(TbLabrecord labrecord) {
        labrecordMapper.updateByPrimaryKey(labrecord);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public TbLabrecord findOne(Long id) {
        return labrecordMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            labrecordMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult findPage(TbLabrecord labrecord, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        TbLabrecordExample example = new TbLabrecordExample();
        example.setOrderByClause("`id`desc");
        TbLabrecordExample.Criteria criteria = example.createCriteria();

        if (labrecord != null) {
            if (labrecord.getLid() != null) {
                criteria.andLidEqualTo(labrecord.getLid());
            }
            if (labrecord.getTimestate() != null && labrecord.getTimestate().length() > 0) {
                criteria.andTimestateLike("%" + labrecord.getTimestate() + "%");
            }
            if (labrecord.getAccountid() != null) {
                criteria.andAccountidEqualTo(labrecord.getAccountid());
            }
            if (labrecord.getState() != null) {
                criteria.andStateEqualTo(labrecord.getState());
            }
            if (labrecord.getDate() != null) {
                criteria.andDateEqualTo(labrecord.getDate());
            }


        }

        Page<TbLabrecord> page = (Page<TbLabrecord>) labrecordMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

}
