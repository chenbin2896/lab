package com.ty.lab.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ty.lab.dao.TbAccountinfoMapper;
import com.ty.lab.entity.PageResult;
import com.ty.lab.pojo.TbAccountinfo;
import com.ty.lab.pojo.TbAccountinfoExample;
import com.ty.lab.service.AccountinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
public class AccountinfoServiceImpl implements AccountinfoService {

    @Autowired
    private TbAccountinfoMapper accountinfoMapper;

    /**
     * 查询全部
     */
    @Override
    public List<TbAccountinfo> findAll() {
        return accountinfoMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbAccountinfo> page = (Page<TbAccountinfo>) accountinfoMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public int add(TbAccountinfo accountinfo) {
        return accountinfoMapper.insert(accountinfo);
    }

    /**
     * 修改
     */
    @Override
    public void update(TbAccountinfo accountinfo) {
        accountinfoMapper.updateByPrimaryKey(accountinfo);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public TbAccountinfo findOne(Long id) {
        return accountinfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            accountinfoMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult findPage(TbAccountinfo accountinfo, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        TbAccountinfoExample example = new TbAccountinfoExample();
        TbAccountinfoExample.Criteria criteria = example.createCriteria();

        if (accountinfo != null) {
            if (accountinfo.getUsername() != null && accountinfo.getUsername().length() > 0) {
                criteria.andUsernameLike("%" + accountinfo.getUsername() + "%");
            }
            if (accountinfo.getPassword() != null && accountinfo.getPassword().length() > 0) {
                criteria.andPasswordLike("%" + accountinfo.getPassword() + "%");
            }
            if (accountinfo.getPhone() != null && accountinfo.getPhone().length() > 0) {
                criteria.andPhoneLike("%" + accountinfo.getPhone() + "%");
            }
            if (accountinfo.getRealname() != null && accountinfo.getRealname().length() > 0) {
                criteria.andRealnameLike("%" + accountinfo.getRealname() + "%");
            }
            if (accountinfo.getState() != null) {
                criteria.andStateEqualTo(accountinfo.getState());
            }
            if (accountinfo.getLevel() != null) {
                criteria.andLevelEqualTo(accountinfo.getLevel());
            }

        }

        Page<TbAccountinfo> page = (Page<TbAccountinfo>) accountinfoMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

}
