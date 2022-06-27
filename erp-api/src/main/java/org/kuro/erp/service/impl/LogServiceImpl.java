package org.kuro.erp.service.impl;

import org.kuro.erp.mapper.LogMapper;
import org.kuro.erp.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;
}
