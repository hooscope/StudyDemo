package com.example.studyDemo.entity;

/**
 * @Author: hao wu
 * @Date： 2023/1/9 22:18
 */
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 设备基本信息表
 */
@Data
@TableName("t_device_info")
public class TDeviceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 设备编号
     */
    @TableId
    private Integer id;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 设备标识码
     */
    private String  deviceIdentification;

    /**
     * 设备ID
     */
    private String  deviceId;

    /**
     * 设备状态(0在线，1离线，2未知)
     */
    private Integer status;

    /**
     * 设备创建时间
     */
    @JsonFormat(pattern = "YYYY-MM-DD hh:mm:ss")
    private Date createDate;

}
