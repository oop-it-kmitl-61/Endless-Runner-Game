package com.mygdx.endlessrunning.menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;
import com.mygdx.endlessrunning.utility.AssetsManage;

public class DodgeChanging extends Actor{
	private Rectangle bounds;
    private BitmapFont font;

    public DodgeChanging(Rectangle bounds) {
        this.bounds = bounds;
        setWidth(bounds.width);
        setHeight(bounds.height);
        font = AssetsManage.getSmallFont();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        font.setColor(Color.RED);
        font.draw(batch, "Pressed any Key to change Dodge input", bounds.x, bounds.y, bounds.width, Align.center, true);
    }
}
