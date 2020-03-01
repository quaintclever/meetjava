package com.quaint.design.pattern.factory;

/**
 * @author quaint
 * @date 2020-01-05 12:24
 */
public class MihoyoGame implements GameFactory {

    @Override
    public String getGameName() {
        return "米忽悠游戏!";
    }
}
