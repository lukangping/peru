package com.peru.dal;

import com.peru.dal.ReportHourlyDO;
import com.peru.dal.ReportHourlyDOCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ReportHourlyDOMapper {
    int countByExample(ReportHourlyDOCriteria example);

    int deleteByExample(ReportHourlyDOCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReportHourlyDO record);

    int insertSelective(ReportHourlyDO record);

    List<ReportHourlyDO> selectByExampleWithRowbounds(ReportHourlyDOCriteria example, RowBounds rowBounds);

    List<ReportHourlyDO> selectByExample(ReportHourlyDOCriteria example);

    ReportHourlyDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReportHourlyDO record, @Param("example") ReportHourlyDOCriteria example);

    int updateByExample(@Param("record") ReportHourlyDO record, @Param("example") ReportHourlyDOCriteria example);

    int updateByPrimaryKeySelective(ReportHourlyDO record);

    int updateByPrimaryKey(ReportHourlyDO record);
}