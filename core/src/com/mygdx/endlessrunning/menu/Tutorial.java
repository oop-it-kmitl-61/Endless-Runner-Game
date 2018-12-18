package com.mygdx.endlessrunning.menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.utils.Align;
import com.mygdx.endlessrunning.enums.State;
import com.mygdx.endlessrunning.utility.AssetsManage;
import com.mygdx.endlessrunning.utility.GameManage;

public class Tutorial extends Actor {

    private TextureRegion textureRegion;
    private Rectangle bounds;
    private BitmapFont font;
    private String text;

    public Tutorial(Rectangle bounds, String assetsId, String text) {
        this.bounds = bounds;
        this.text = text;
        textureRegion = AssetsManage.getTextureRegion(assetsId);
        SequenceAction sequenceAction = new SequenceAction();
        sequenceAction.addAction(Actions.delay(4f));
        sequenceAction.addAction(Actions.removeActor());
        addAction(sequenceAction);
        font = AssetsManage.getSmallestFont();
        setWidth(bounds.width);
        setHeight(bounds.height);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (GameManage.getInstance().getGameState() == State.OVER) {
            remove();
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        font.setColor(Color.RED);
        batch.draw(textureRegion, bounds.x, bounds.y, bounds.width, bounds.height);
        font.draw(batch, text, bounds.x, bounds.y, bounds.width,
                Align.center, true);
    }
}
