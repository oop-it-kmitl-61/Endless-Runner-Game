package com.mygdx.endlessrunning.menu;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;
import com.mygdx.endlessrunning.enums.State;
import com.mygdx.endlessrunning.utility.AssetsManage;
import com.mygdx.endlessrunning.utility.Constants;
import com.mygdx.endlessrunning.utility.GameManage;


public class PausedLabel extends Actor {

    private Rectangle bounds;
    private BitmapFont font;

    public PausedLabel(Rectangle bounds) {
        this.bounds = bounds;
        setWidth(bounds.width);
        setHeight(bounds.height);
        font = AssetsManage.getSmallFont();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if (GameManage.getInstance().getGameState() == State.PAUSED) {
            font.draw(batch, Constants.PAUSED_LABEL, bounds.x, bounds.y, bounds.width,
                    Align.center, true);
        }
    }
}
