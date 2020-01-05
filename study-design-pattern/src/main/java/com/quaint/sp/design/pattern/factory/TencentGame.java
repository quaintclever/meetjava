package com.quaint.sp.design.pattern.factory;

/**
 * @author quaint
 * @date 2020-01-05 12:26
 */
public class TencentGame implements GameFactory {

    @Override
    public String getGameName() {
        return "腾讯游戏";
    }
}
