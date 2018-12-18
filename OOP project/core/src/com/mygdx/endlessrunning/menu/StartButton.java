package com.mygdx.endlessrunning.menu;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.endlessrunning.enums.State;
import com.mygdx.endlessrunning.utility.Constants;
import com.mygdx.endlessrunning.utility.GameManage;

public class StartButton extends GameButton {

    public interface StartButtonListener {
        public void onStart();
    }

    private StartButtonListener listener;

    public StartButton(Rectangle bounds, StartButtonListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override
    protected String getRegionName() {
        return Constants.BIG_PLAY_REGION_NAME;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (GameManage.getInstance().getGameState() != State.OVER) {
            remove();
        }
    }

    @Override
    public void touched() {
        listener.onStart();
    }

}
