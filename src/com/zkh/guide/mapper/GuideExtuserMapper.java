package com.zkh.guide.mapper;

import com.zkh.guide.po.GuideExtuser;
import com.zkh.guide.po.GuideExtuserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuideExtuserMapper {
    long countByExample(GuideExtuserExample example);

    int deleteByExample(GuideExtuserExample example);

    int deleteByPrimaryKey(Integer extuserId);

    int insert(GuideExtuser record);

    int insertSelective(GuideExtuser record);

    List<GuideExtuser> selectByExample(GuideExtuserExample example);

    GuideExtuser selectByPrimaryKey(Integer extuserId);

    int updateByExampleSelective(@Param("record") GuideExtuser record, @Param("example") GuideExtuserExample example);

    int updateByExample(@Param("record") GuideExtuser record, @Param("example") GuideExtuserExample example);

    int updateByPrimaryKeySelective(GuideExtuser record);

    int updateByPrimaryKey(GuideExtuser record);
}