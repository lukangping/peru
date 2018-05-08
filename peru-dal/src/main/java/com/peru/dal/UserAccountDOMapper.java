package com.peru.dal;

import com.peru.dal.UserAccountDO;
import com.peru.dal.UserAccountDOCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserAccountDOMapper {
    int countByExample(UserAccountDOCriteria example);

    int deleteByExample(UserAccountDOCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserAccountDO record);

    int insertSelective(UserAccountDO record);

    List<UserAccountDO> selectByExampleWithRowbounds(UserAccountDOCriteria example, RowBounds rowBounds);

    List<UserAccountDO> selectByExample(UserAccountDOCriteria example);

    UserAccountDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserAccountDO record, @Param("example") UserAccountDOCriteria example);

    int updateByExample(@Param("record") UserAccountDO record, @Param("example") UserAccountDOCriteria example);

    int updateByPrimaryKeySelective(UserAccountDO record);

    int updateByPrimaryKey(UserAccountDO record);
}