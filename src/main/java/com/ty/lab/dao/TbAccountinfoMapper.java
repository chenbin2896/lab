package com.ty.lab.dao;

import com.ty.lab.pojo.TbAccountinfo;
import com.ty.lab.pojo.TbAccountinfoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbAccountinfoMapper {
    long countByExample(TbAccountinfoExample example);

    int deleteByExample(TbAccountinfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbAccountinfo record);

    int insertSelective(TbAccountinfo record);

    List<TbAccountinfo> selectByExample(TbAccountinfoExample example);

    TbAccountinfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbAccountinfo record, @Param("example") TbAccountinfoExample example);

    int updateByExample(@Param("record") TbAccountinfo record, @Param("example") TbAccountinfoExample example);

    int updateByPrimaryKeySelective(TbAccountinfo record);

    int updateByPrimaryKey(TbAccountinfo record);
}