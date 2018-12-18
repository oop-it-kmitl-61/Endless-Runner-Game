package com.mygdx.endlessrunning.menu;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.endlessrunning.enums.State;
import com.mygdx.endlessrunning.utility.Constants;
import com.mygdx.endlessrunning.utility.GameManage;


public class PauseButton extends GameButton {

    public interface PauseButtonListener {
        public void onPause();

        public void onResume();
    }

    private PauseButtonListener listener;

    public PauseButton(Rectangle bounds, PauseButtonListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override
    protected String getRegionName() {
    	return GameManage.getInstance().getGameState() == State.PAUSED ? Constants.PLAY_REGION_NAME : Constants.PAUSE_REGION_NAME;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (GameManage.getInstance().getGameState() == State.OVER) {
            remove();
        }
    }

    @Override
    public void touched() {
        if (GameManage.getInstance().getGameState() == State.PAUSED) {
            listener.onResume();
        } else {
            listener.onPause();
        }
    }

}