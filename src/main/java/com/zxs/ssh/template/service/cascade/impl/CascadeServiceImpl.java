package com.zxs.ssh.template.service.cascade.impl;

import com.zxs.ssh.template.dao.common.api.ICommonDao;
import com.zxs.ssh.template.model.*;
import com.zxs.ssh.template.service.cascade.api.ICascadeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Project Name:hibernate-cascade
 * File Name:CascadeServiceImpl
 * Package Name:com.zxs.ssh.template.service.cascade.impl
 * Date:2018/12/10
 * Author:zengxueshan
 * Description:级联保存、级联删除
 * Copyright (c) 2018, 重庆云凯科技有限公司 All Rights Reserved.
 */

@Service("cascadeService")
@Transactional
public class CascadeServiceImpl implements ICascadeService{

    @Resource(name = "commonDao")
    private ICommonDao commonDao;

    /**
     * 级联保存
     */
    @Override
    public void cascadeSave() {
/*        ParkModel parkModel = new ParkModel();
        parkModel.setParkName("D区东门停车场");
        CrossingModel crossingModel = new CrossingModel();
        crossingModel.setCrossingName("前门入口");
        crossingModel.setParkModel(parkModel);
        this.commonDao.save(crossingModel);*/

/*        RecordModel recordModel = new RecordModel();
        recordModel.setRecordState("NORMAL");
        recordModel.setCrossingModel(this.commonDao.queryAll(CrossingModel.class).get(0));
        List<SectionModel> sectionModels = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            SectionModel sectionModel = new SectionModel();
            sectionModel.setSectionName("section-"+(i+1));
            sectionModel.setSectionState("NORMAL");
            sectionModels.add(sectionModel);
        }
        recordModel.setSectionModels(sectionModels);
        this.commonDao.save(recordModel);*/

        CrossingStateModel crossingStateModel = new CrossingStateModel();
        crossingStateModel.setCrossingState("NORMAL");
        crossingStateModel.setCrossingModel(this.commonDao.queryAll(CrossingModel.class).get(0));
        this.commonDao.save(crossingStateModel);
    }

    /**
     * 级联删除
     */
    @Override
    public void cascadeDelete() {
/*        List<ParkModel> list = this.commonDao.queryAll(ParkModel.class);
        if(list != null && !list.isEmpty()){
            this.commonDao.delete(list.get(0));
        }*/

/*        CrossingModel crossingModel = this.commonDao.queryModel(null,CrossingModel.class);
        if(crossingModel != null){
            this.commonDao.delete(crossingModel);
        }*/

/*        RecordModel recordModel = this.commonDao.queryModel(null,RecordModel.class);
        if(recordModel != null){
            this.commonDao.delete(recordModel);
        }*/

        CrossingStateModel crossingStateModel = this.commonDao.queryModel(null,CrossingStateModel.class);
        if(crossingStateModel != null){
            this.commonDao.delete(crossingStateModel);
        }
    }

    /**
     * 级联更新
     */
    @Override
    public void cascadeUpdate() {
/*        List<CrossingModel> list = this.commonDao.queryAll(CrossingModel.class);
        if(list != null && !list.isEmpty()){
            CrossingModel crossingModel = list.get(0);
            crossingModel.setCrossingName("后门入口");
            ParkModel parkModel = crossingModel.getParkModel();
            parkModel.setParkName("D区西门停车场");
            crossingModel.setParkModel(parkModel);
            this.commonDao.update(crossingModel);
        }*/

/*        List<RecordModel> list = this.commonDao.queryAll(RecordModel.class);
        if(list != null && !list.isEmpty()){
            RecordModel recordModel = list.get(0);
            recordModel.setRecordState("EXCEPTION");
            List<SectionModel> sectionModels = recordModel.getSectionModels();
            for (int i = 0; i < sectionModels.size(); i++) {
                SectionModel sectionModel = sectionModels.get(i);
                sectionModel.setSectionState("EXCEPTION");
            }
            recordModel.setSectionModels(sectionModels);
            this.commonDao.update(recordModel);
        }*/

        CrossingStateModel crossingStateModel = this.commonDao.queryModel(null,CrossingStateModel.class);
        if(crossingStateModel != null){
            crossingStateModel.setCrossingState("EXCEPTION4");
            CrossingModel crossingModel = crossingStateModel.getCrossingModel();
            crossingModel.setCrossingName("test4");
            crossingStateModel.setCrossingModel(null);
            this.commonDao.update(crossingStateModel);
        }
    }
}
