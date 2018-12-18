package com.mygdx.endlessrunning.menu;

import com.badlogic.gdx.math.Rectangle;

import com.mygdx.endlessrunning.utility.Constants;

public class DodgeChangeButton extends GameButton{
	public interface DodgeChangeListener {
        public void DodgeChange();
    }

    private DodgeChangeListener listener;

    public DodgeChangeButton(Rectangle bounds, DodgeChangeListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override     
    protected String getRegionName() {
        return Constants.CHANGE_REGION_NAME;
    }

    @Override
    public void touched() {
        listener.DodgeChange();
    }

}
