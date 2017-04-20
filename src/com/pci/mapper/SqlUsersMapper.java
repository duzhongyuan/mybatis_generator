package com.pci.mapper;

import com.pci.pojo.SqlUsers;
import com.pci.pojo.SqlUsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SqlUsersMapper {
    int countByExample(SqlUsersExample example);

    int deleteByExample(SqlUsersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SqlUsers record);

    int insertSelective(SqlUsers record);

    List<SqlUsers> selectByExample(SqlUsersExample example);

    SqlUsers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SqlUsers record, @Param("example") SqlUsersExample example);

    int updateByExample(@Param("record") SqlUsers record, @Param("example") SqlUsersExample example);

    int updateByPrimaryKeySelective(SqlUsers record);

    int updateByPrimaryKey(SqlUsers record);
}