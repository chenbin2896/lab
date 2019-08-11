package com.ty.lab.dao;

import com.ty.lab.pojo.TbLabstate;
import com.ty.lab.pojo.TbLabstateExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbLabstateMapper {
    long countByExample(TbLabstateExample example);

    int deleteByExample(TbLabstateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbLabstate record);

    int insertSelective(TbLabstate record);

    List<TbLabstate> selectByExample(TbLabstateExample example);

    TbLabstate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbLabstate record, @Param("example") TbLabstateExample example);

    int updateByExample(@Param("record") TbLabstate record, @Param("example") TbLabstateExample example);

    int updateByPrimaryKeySelective(TbLabstate record);

    int updateByPrimaryKey(TbLabstate record);
}