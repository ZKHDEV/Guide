package com.zkh.guide.mapper;

import com.zkh.guide.po.GuideUser;
import com.zkh.guide.po.GuideUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuideUserMapper {
    long countByExample(GuideUserExample example);

    int deleteByExample(GuideUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(GuideUser record);

    int insertSelective(GuideUser record);

    List<GuideUser> selectByExample(GuideUserExample example);

    GuideUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") GuideUser record, @Param("example") GuideUserExample example);

    int updateByExample(@Param("record") GuideUser record, @Param("example") GuideUserExample example);

    int updateByPrimaryKeySelective(GuideUser record);

    int updateByPrimaryKey(GuideUser record);
}