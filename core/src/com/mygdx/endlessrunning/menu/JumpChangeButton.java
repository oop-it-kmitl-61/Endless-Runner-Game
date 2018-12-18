package com.mygdx.endlessrunning.menu;

import com.badlogic.gdx.math.Rectangle;
//import com.mygdx.endlessrunning.enums.State;
import com.mygdx.endlessrunning.utility.Constants;


public class JumpChangeButton extends GameButton{
	public interface JumpChangeListener {
        public void JumpChange();
    }

    private JumpChangeListener listener;

    public JumpChangeButton(Rectangle bounds, JumpChangeListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override     
    protected String getRegionName() {
        return Constants.CHANGE_REGION_NAME;
    }

    @Override
    public void touched() {
        listener.JumpChange();
    }

}
