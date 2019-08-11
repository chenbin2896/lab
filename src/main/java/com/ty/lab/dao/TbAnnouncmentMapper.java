package com.ty.lab.dao;

import com.ty.lab.pojo.TbAnnouncment;
import com.ty.lab.pojo.TbAnnouncmentExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbAnnouncmentMapper {
    long countByExample(TbAnnouncmentExample example);

    int deleteByExample(TbAnnouncmentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbAnnouncment record);

    int insertSelective(TbAnnouncment record);

    List<TbAnnouncment> selectByExample(TbAnnouncmentExample example);

    TbAnnouncment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbAnnouncment record, @Param("example") TbAnnouncmentExample example);

    int updateByExample(@Param("record") TbAnnouncment record, @Param("example") TbAnnouncmentExample example);

    int updateByPrimaryKeySelective(TbAnnouncment record);

    int updateByPrimaryKey(TbAnnouncment record);
}