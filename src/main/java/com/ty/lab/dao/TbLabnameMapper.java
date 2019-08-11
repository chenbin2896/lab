package com.ty.lab.dao;

import com.ty.lab.pojo.TbLabname;
import com.ty.lab.pojo.TbLabnameExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbLabnameMapper {
    long countByExample(TbLabnameExample example);

    int deleteByExample(TbLabnameExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbLabname record);

    int insertSelective(TbLabname record);

    List<TbLabname> selectByExample(TbLabnameExample example);

    TbLabname selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbLabname record, @Param("example") TbLabnameExample example);

    int updateByExample(@Param("record") TbLabname record, @Param("example") TbLabnameExample example);

    int updateByPrimaryKeySelective(TbLabname record);

    int updateByPrimaryKey(TbLabname record);
}