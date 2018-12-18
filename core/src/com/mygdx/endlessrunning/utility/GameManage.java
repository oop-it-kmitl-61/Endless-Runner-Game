package com.mygdx.endlessrunning.utility;

import com.mygdx.endlessrunning.enums.Level;
import com.mygdx.endlessrunning.enums.State;

public class GameManage {
    private static GameManage ourInstance = new GameManage();

    public static final String PREFERENCES_NAME = "preferences";

    private State gameState;
    private Level level;

    public static GameManage getInstance() {
        return ourInstance;
    }

    private GameManage() {
        gameState = State.OVER;
    }

    public State getGameState() {
        return gameState;
    }

    public void setGameState(State gameState) {
        this.gameState = gameState;
    } 

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public boolean isMaxLevel() {
        return level == Level.values()[Level.values().length - 1];
    }

    public void resetLevel() {
        setLevel(Level.values()[0]);
    }
}
