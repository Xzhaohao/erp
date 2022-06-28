package org.kuro.erp.mapper;

import org.apache.ibatis.annotations.Param;
import org.kuro.erp.model.entity.Meeting;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

public interface MeetingMapper extends Mapper<Meeting> {

    ArrayList<HashMap> searchOfflineMeetingByPage(
            @Param("page") Integer page, @Param("limit") Integer limit,
            @Param("date") String date, @Param("mold") String mold, @Param("userId") String userId
    );

    Integer searchOfflineMeetingCount();
}
