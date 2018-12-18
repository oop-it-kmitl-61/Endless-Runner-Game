package com.mygdx.endlessrunning.menu;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.endlessrunning.enums.State;
import com.mygdx.endlessrunning.utility.Constants;
import com.mygdx.endlessrunning.utility.GameManage;

public class Options extends GameButton{
	
	public interface OptionsButtonListener {
        public void onOptions();
    }

	private OptionsButtonListener listener;
	
	public Options(Rectangle bounds, OptionsButtonListener listener) {
        super(bounds);
        this.listener = listener;
    }
	@Override
	protected String getRegionName() {
		// TODO Auto-generated method stub
		return GameManage.getInstance().getGameState() == State.OPTION ? Constants.CLOSE_REGION_NAME :
            Constants.SETTING_REGION_NAME; //WAIT FOR CHANGE
	}

	@Override
	public void touched() {
		// TODO Auto-generated method stub
		listener.onOptions();
	}

}
