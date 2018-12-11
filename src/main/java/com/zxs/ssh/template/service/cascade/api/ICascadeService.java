package com.zxs.ssh.template.service.cascade.api;

/**
 * Project Name:hibernate-cascade
 * File Name:ICascadeService
 * Package Name:com.zxs.ssh.template.service.cascade.api
 * Date:2018/12/10
 * Author:zengxueshan
 * Description:级联保存、级联删除
 * Copyright (c) 2018, 重庆云凯科技有限公司 All Rights Reserved.
 */


public interface ICascadeService {

    /**
     * 级联保存
     */
    void cascadeSave();
    /**
     * 级联删除
     */
    void cascadeDelete();
    /**
     * 级联更新
     */
    void cascadeUpdate();
}
