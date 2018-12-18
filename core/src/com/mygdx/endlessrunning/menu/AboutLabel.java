package com.mygdx.endlessrunning.menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;
import com.mygdx.endlessrunning.utility.AssetsManage;
import com.mygdx.endlessrunning.utility.Constants;

public class AboutLabel extends Actor{
	private Rectangle bounds;
    private BitmapFont font;

    public AboutLabel(Rectangle bounds) {
        this.bounds = bounds;
        setWidth(bounds.width);
        setHeight(bounds.height);
        font = AssetsManage.getSmallFont();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        font.setColor(Color.RED);
        font.draw(batch, Constants.ABOUT_TEXT, bounds.x, bounds.y, bounds.width, Align.center, true);
    }

}
