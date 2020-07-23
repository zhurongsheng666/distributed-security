package com.uaa.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/7/11 16:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_permission")
public class PermissionEntry {

    @TableId
    private Integer id;

    private String code;

    private String description;

    private String url;

}
