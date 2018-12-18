package com.mygdx.endlessrunning.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.endlessrunning.box2d.RunnerUserData;
import com.mygdx.endlessrunning.enums.Level;
import com.mygdx.endlessrunning.enums.State;
import com.mygdx.endlessrunning.utility.AssetsManage;
import com.mygdx.endlessrunning.utility.AudioUtility;
import com.mygdx.endlessrunning.utility.Constants;
import com.mygdx.endlessrunning.utility.GameManage;

public class Runner extends MainActor{
	private boolean dodging;
    private boolean jumping;
    private boolean hit;
    private Animation runningAnimation;
    private TextureRegion jumpingTexture;
    private TextureRegion dodgingTexture;
    private TextureRegion hitTexture;
    private float stateTime;

    private Sound jumpSound;
    private Sound hitSound;

    private int jumpCount;

    public Runner(Body body) {
        super(body);
        jumpCount = 0;
        runningAnimation = AssetsManage.getAnimation(Constants.RUNNER_RUNNING_ASSETS_ID);
        stateTime = 0f;
        jumpingTexture = AssetsManage.getTextureRegion(Constants.RUNNER_JUMPING_ASSETS_ID);
        dodgingTexture = AssetsManage.getTextureRegion(Constants.RUNNER_DODGING_ASSETS_ID);
        hitTexture = AssetsManage.getTextureRegion(Constants.RUNNER_HIT_ASSETS_ID);
        jumpSound = AudioUtility.getInstance().getJumpSound();
        hitSound = AudioUtility.getInstance().getHitSound();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        float x = screenRectangle.x - (screenRectangle.width * 0.1f);
        float y = screenRectangle.y;
        float width = screenRectangle.width * 1.2f;

        if (dodging) {
            batch.draw(dodgingTexture, x, y + screenRectangle.height / 4, width, screenRectangle.height * 3 / 4);
        } else if (hit) {
            // When he's hit we also want to apply rotation if the body has been rotated
            batch.draw(hitTexture, x, y, width * 0.5f, screenRectangle.height * 0.5f, width, screenRectangle.height, 1f,
                    1f, (float) Math.toDegrees(body.getAngle()));
        } else if (jumping) {
            batch.draw(jumpingTexture, x, y, width, screenRectangle.height);
        } else {
            // Running
            if (GameManage.getInstance().getGameState() == State.RUNNING) {
                stateTime += Gdx.graphics.getDeltaTime();
            }
            batch.draw(runningAnimation.getKeyFrame(stateTime, true), x, y, width, screenRectangle.height);
        }
    }

    @Override
    public RunnerUserData getUserData() {
        return (RunnerUserData) userData;
    }

    public void jump() {

        if (!(jumping || dodging || hit)) {
            body.applyLinearImpulse(getUserData().getJumpingLinearImpulse(), body.getWorldCenter(), true);
            jumping = true;
            AudioUtility.getInstance().playSound(jumpSound);
            jumpCount++;
        }

    }

    public void landed() {
        jumping = false;
    }

    public void dodge() {
        if (!(jumping || hit)) {
            body.setTransform(getUserData().getDodgePosition(), getUserData().getDodgeAngle());
            dodging = true;
        }
    }

    public void stopDodge() {
        dodging = false;
        // If the runner is hit don't force him back to the running position
        if (!hit) {
            body.setTransform(getUserData().getRunningPosition(), 0f);
        }
    }

    public boolean isDodging() {
        return dodging;
    }

    public void hit() {
        body.applyAngularImpulse(getUserData().getHitAngularImpulse(), true);
        hit = true;
        AudioUtility.getInstance().playSound(hitSound);
    }

    public boolean isHit() {
        return hit;
    }

    public void LevelChange(Level newLevel) {
        setGravityScale(newLevel.getRunnerGravityScale());
        getUserData().setJumpingLinearImpulse(newLevel.getRunnerJumpingLinearImpulse());
    }

    public void setGravityScale(float gravityScale) {
        body.setGravityScale(gravityScale);
        body.resetMassData();
    }

    public int getJumpCount() {
        return jumpCount;
    }
}
