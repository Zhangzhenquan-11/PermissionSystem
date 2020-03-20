package com.jxau.ssm.service;

import com.jxau.ssm.model.SysLog;

import java.util.List;

public interface SysLogService {

    void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll() throws Exception;
}
