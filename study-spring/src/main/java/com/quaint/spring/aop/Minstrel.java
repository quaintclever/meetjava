package com.quaint.spring.aop;

import java.io.PrintStream;

/**
 * <p>
 * desc: 吟唱诗人
 * </p>
 *
 * @author quaint
 * @since 16 June 2020
 */
public class Minstrel {

    private PrintStream stream;

    public Minstrel(PrintStream stream) {
        this.stream = stream;
    }

    void singBeforeQuest(){
        System.out.println("吟唱诗人: 英勇的屠龙勇士啊~~");
    }

    void singAfterQuest(){
        System.out.println("吟唱诗人: 我歌唱你, 赞美你~~");
    }

}
