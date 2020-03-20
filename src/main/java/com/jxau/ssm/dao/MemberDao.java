package com.jxau.ssm.dao;

import com.jxau.ssm.model.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {
    //根据id查询会员信息
    @Select("select * from member where id=#{id}")
    Member findById(Integer id) throws Exception;
}
