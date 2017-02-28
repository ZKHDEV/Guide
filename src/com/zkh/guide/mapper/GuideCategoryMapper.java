package com.zkh.guide.mapper;

import com.zkh.guide.po.GuideCategory;
import com.zkh.guide.po.GuideCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuideCategoryMapper {
    long countByExample(GuideCategoryExample example);

    int deleteByExample(GuideCategoryExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(GuideCategory record);

    int insertSelective(GuideCategory record);

    List<GuideCategory> selectByExample(GuideCategoryExample example);

    GuideCategory selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective(@Param("record") GuideCategory record, @Param("example") GuideCategoryExample example);

    int updateByExample(@Param("record") GuideCategory record, @Param("example") GuideCategoryExample example);

    int updateByPrimaryKeySelective(GuideCategory record);

    int updateByPrimaryKey(GuideCategory record);
}