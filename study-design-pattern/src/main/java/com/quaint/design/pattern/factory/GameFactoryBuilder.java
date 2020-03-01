package com.quaint.design.pattern.factory;

/**
 * @author quaint
 * @date 2020-01-05 12:27
 */
public class GameFactoryBuilder {

    public static GameFactory getGame(GameType gameType){

        if (gameType.equals(GameType.MIHOYO_GAME)){
            return new MihoyoGame();
        } else if (gameType.equals(GameType.TENCENT_GAME)){
            return new TencentGame();
        } else if (gameType.equals(GameType.WANGYI_GAME)){
            return new WangYiGame();
        }
        return null;

    }

}
