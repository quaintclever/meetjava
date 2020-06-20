package com.quaint.spring.service.impl;

import com.quaint.spring.service.Quest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.PrintStream;

/**
 * <p>
 * desc: 屠龙任务
 * </p>
 *
 * @author quaint
 * @since 16 June 2020
 */
@Component
public class SlayDragonQuest implements Quest {

    @Value("#{T(System).err}")
    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    public SlayDragonQuest() {
    }

    @Override
    public void embark() {
        stream.println("屠龙任务进行中!");
    }
}
