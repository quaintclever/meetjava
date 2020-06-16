package com.quaint.spring.service.impl;

import com.quaint.spring.service.Quest;

import java.io.PrintStream;

/**
 * <p>
 * desc: 屠龙任务
 * </p>
 *
 * @author quaint
 * @since 16 June 2020
 */
public class SlayDragonQuest implements Quest {

    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void embark() {
        stream.println("屠龙任务执行成功!");
    }
}
