package com.quaint.spring.service.impl;

import com.quaint.spring.service.Knight;
import com.quaint.spring.service.Quest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * desc: 勇敢的骑士
 * </p>
 *
 * @author quaint
 * @since 16 June 2020
 */
@Component
public class BraveKnight implements Knight {

    @Autowired
    private Quest quest;

    public BraveKnight(Quest quest){
        this.quest = quest;
    }

    public BraveKnight() {
    }

    @Override
    public void embarkOnQuest(){
        System.out.println("骑士接收到任务!");
        quest.embark();
    }

}
