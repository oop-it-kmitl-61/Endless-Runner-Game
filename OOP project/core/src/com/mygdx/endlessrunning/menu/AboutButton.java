package com.mygdx.endlessrunning.menu;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.endlessrunning.enums.State;
import com.mygdx.endlessrunning.utility.Constants;
import com.mygdx.endlessrunning.utility.GameManage;

public class AboutButton extends GameButton{
	public interface AboutButtonListener {
        public void onAbout();
    }

    private AboutButtonListener listener;

    public AboutButton(Rectangle bounds, AboutButtonListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override
    protected String getRegionName() {
        return GameManage.getInstance().getGameState() == State.ABOUT ? Constants.CLOSE_REGION_NAME :
                Constants.ABOUT_REGION_NAME;
    }

    @Override
    public void touched() {
        listener.onAbout();
    }

}
