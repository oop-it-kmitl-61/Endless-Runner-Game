package com.mygdx.endlessrunning.menu;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.endlessrunning.utility.AudioUtility;

public class MusicButton extends GameButton{
	public MusicButton(Rectangle bounds) {
        super(bounds);
    }

    protected String getRegionName() {
        return AudioUtility.getInstance().getMusicRegionName();
    }

    public void touched() {
        if (AudioUtility.getInstance().getMusic().isPlaying()) {
            AudioUtility.getInstance().pauseMusic();
        }
        AudioUtility.getInstance().toggleMusic();
        AudioUtility.getInstance().playMusic();
    }

}
