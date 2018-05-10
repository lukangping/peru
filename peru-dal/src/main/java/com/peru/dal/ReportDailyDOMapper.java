package com.peru.dal;

import com.peru.dal.ReportDailyDO;
import com.peru.dal.ReportDailyDOCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ReportDailyDOMapper {
    int countByExample(ReportDailyDOCriteria example);

    int deleteByExample(ReportDailyDOCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReportDailyDO record);

    int insertSelective(ReportDailyDO record);

    List<ReportDailyDO> selectByExampleWithRowbounds(ReportDailyDOCriteria example, RowBounds rowBounds);

    List<ReportDailyDO> selectByExample(ReportDailyDOCriteria example);

    ReportDailyDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReportDailyDO record, @Param("example") ReportDailyDOCriteria example);

    int updateByExample(@Param("record") ReportDailyDO record, @Param("example") ReportDailyDOCriteria example);

    int updateByPrimaryKeySelective(ReportDailyDO record);

    int updateByPrimaryKey(ReportDailyDO record);
}