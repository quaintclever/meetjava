package com.quaint.spring.aop;

import java.io.PrintStream;

/**
 * <p>
 * desc: 吟唱诗人  xml aop
 * </p>
 *
 * @author quaint
 * @since 16 June 2020
 */
public class XmlMinstrel {

    private PrintStream stream;

    public XmlMinstrel(PrintStream stream) {
        this.stream = stream;
    }

    void singBeforeQuest(){
        stream.println("吟唱诗人: 英勇的屠龙勇士啊~~");
    }

    void singAfterQuest(){
        stream.println("吟唱诗人: 我歌唱你, 赞美你~~");
    }

}
