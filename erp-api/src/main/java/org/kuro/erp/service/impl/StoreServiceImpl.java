package org.kuro.erp.service.impl;

import org.kuro.erp.mapper.StoreMapper;
import org.kuro.erp.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;
}
