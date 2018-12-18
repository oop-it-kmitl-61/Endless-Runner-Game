package com.mygdx.endlessrunning.menu;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.endlessrunning.utility.AudioUtility;

public class SoundButton extends GameButton {

    public SoundButton(Rectangle bounds) {
        super(bounds);
    }

    @Override
    protected String getRegionName() {
        return AudioUtility.getInstance().getSoundRegionName();
    }

    @Override
    public void touched() {
        AudioUtility.getInstance().toggleSound();
    }

}
