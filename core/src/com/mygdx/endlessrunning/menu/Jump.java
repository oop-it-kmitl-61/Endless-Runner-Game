package com.mygdx.endlessrunning.menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;
import com.mygdx.endlessrunning.utility.AssetsManage;

public class Jump extends Actor{
	private Rectangle bounds;
    private BitmapFont font;
    private String jump;

    public Jump(Rectangle bounds, String jump) {
        this.bounds = bounds;
        setWidth(bounds.width);
        setHeight(bounds.height);
        font = AssetsManage.getSmallFont();
        this.jump = jump;
        
    } 

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        font.setColor(Color.RED);
        font.draw(batch, "JUMP BUTTON = " + jump , bounds.x, bounds.y, bounds.width, Align.center, true);
    }

}
