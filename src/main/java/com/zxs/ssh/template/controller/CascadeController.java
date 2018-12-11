package com.zxs.ssh.template.controller;

import com.zxs.ssh.template.service.cascade.api.ICascadeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Project Name:hibernate-cascade
 * File Name:CascadeController
 * Package Name:com.zxs.ssh.template.controller
 * Date:2018/12/10
 * Author:zengxueshan
 * Description:级联测试
 * Copyright (c) 2018, 重庆云凯科技有限公司 All Rights Reserved.
 */

@RestController("cascadeController")
public class CascadeController {

    @Resource(name = "cascadeService")
    private ICascadeService cascadeService;

    /**
     * 测试级联保存
     *
     * @return 结果
     */
    @RequestMapping("test1")
    public String test1(){
        String res = "ok";
        this.cascadeService.cascadeSave();
        return res;
    }

    /**
     * 测试级联删除
     *
     * @return 结果
     */
    @RequestMapping("test2")
    public String test2(){
        String res = "ok";
        this.cascadeService.cascadeDelete();
        return res;
    }

    /**
     * 测试级联更新
     *
     * @return 结果
     */
    @RequestMapping("test3")
    public String test3(){
        String res = "ok";
        this.cascadeService.cascadeUpdate();
        return res;
    }
}
