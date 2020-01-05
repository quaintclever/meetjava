package com.quaint.sp.design.pattern.factory;

/**
 * 简单工厂模式
 * @author quaint
 * @date 2020-01-05 12:31
 */
public class FactoryMain {

    public static void main(String[] args) {

        String gameName = GameFactoryBuilder.getGame(GameType.MIHOYO_GAME).getGameName();
        System.out.println(gameName);
        String gameName2 = GameFactoryBuilder.getGame(GameType.WANGYI_GAME).getGameName();
        System.out.println(gameName2);
        String gameName3 = GameFactoryBuilder.getGame(GameType.TENCENT_GAME).getGameName();
        System.out.println(gameName3);


    }

}
