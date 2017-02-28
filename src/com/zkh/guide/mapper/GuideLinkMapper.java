package com.zkh.guide.mapper;

import com.zkh.guide.po.GuideLink;
import com.zkh.guide.po.GuideLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuideLinkMapper {
    long countByExample(GuideLinkExample example);

    int deleteByExample(GuideLinkExample example);

    int deleteByPrimaryKey(Integer linkId);

    int insert(GuideLink record);

    int insertSelective(GuideLink record);

    List<GuideLink> selectByExampleWithBLOBs(GuideLinkExample example);

    List<GuideLink> selectByExample(GuideLinkExample example);

    GuideLink selectByPrimaryKey(Integer linkId);

    int updateByExampleSelective(@Param("record") GuideLink record, @Param("example") GuideLinkExample example);

    int updateByExampleWithBLOBs(@Param("record") GuideLink record, @Param("example") GuideLinkExample example);

    int updateByExample(@Param("record") GuideLink record, @Param("example") GuideLinkExample example);

    int updateByPrimaryKeySelective(GuideLink record);

    int updateByPrimaryKeyWithBLOBs(GuideLink record);

    int updateByPrimaryKey(GuideLink record);
}