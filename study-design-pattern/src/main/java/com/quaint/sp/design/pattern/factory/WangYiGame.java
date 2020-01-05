package com.quaint.sp.design.pattern.factory;

/**
 * @author quaint
 * @date 2020-01-05 12:25
 */
public class WangYiGame implements GameFactory {

    @Override
    public String getGameName() {
        return "网易游戏";
    }
}
