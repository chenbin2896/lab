package com.ty.lab.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ty.lab.dao.TbAnnouncmentMapper;
import com.ty.lab.entity.PageResult;
import com.ty.lab.pojo.TbAnnouncment;
import com.ty.lab.pojo.TbAnnouncmentExample;
import com.ty.lab.service.AnnouncmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
public class AnnouncmentServiceImpl implements AnnouncmentService {

    @Autowired
    private TbAnnouncmentMapper announcmentMapper;

    /**
     * 查询全部
     */
    @Override
    public List<TbAnnouncment> findAll() {
        return announcmentMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbAnnouncment> page = (Page<TbAnnouncment>) announcmentMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(TbAnnouncment announcment) {
        announcmentMapper.insert(announcment);
    }

    /**
     * 修改
     */
    @Override
    public void update(TbAnnouncment announcment) {
        announcmentMapper.updateByPrimaryKey(announcment);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public TbAnnouncment findOne(Long id) {
        return announcmentMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            announcmentMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult findPage(TbAnnouncment announcment, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        TbAnnouncmentExample example = new TbAnnouncmentExample();
        TbAnnouncmentExample.Criteria criteria = example.createCriteria();

        if (announcment != null) {
            if (announcment.getContent() != null && announcment.getContent().length() > 0) {
                criteria.andContentLike("%" + announcment.getContent() + "%");
            }

        }

        Page<TbAnnouncment> page = (Page<TbAnnouncment>) announcmentMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

}
