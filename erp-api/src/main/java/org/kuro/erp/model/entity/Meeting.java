package org.kuro.erp.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.houkunlin.system.dict.starter.json.DictText;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "t_meeting")
public class Meeting implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "UUID")
    private String uuid;

    @ApiModelProperty(value = "会议题目")
    private String title;

    @ApiModelProperty(value = "创建人ID")
    private Integer creatorId;

    @ApiModelProperty(value = "日期")
    private String date;

    @ApiModelProperty(value = "开会地点")
    private String place;

    @ApiModelProperty(value = "开始时间")
    private String start;

    @ApiModelProperty(value = "结束时间")
    private String end;

    @DictText("meeting_type")
    @ApiModelProperty(value = "会议类型（1在线会议，2线下会议）")
    private Integer type;

    @ApiModelProperty(value = "参与者")
    private Object members;

    @ApiModelProperty(value = "会议内容")
    private String desc;

    @ApiModelProperty(value = "工作流实例ID")
    private String instanceId;

    @ApiModelProperty(value = "出席人员名单")
    private String present;

    @ApiModelProperty(value = "未出席人员名单")
    private String unpresent;

    @DictText("meeting_status")
    @ApiModelProperty(value = "状态（1.申请中，2.审批未通过，3.审批通过，4.会议进行中，5.会议结束）")
    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
