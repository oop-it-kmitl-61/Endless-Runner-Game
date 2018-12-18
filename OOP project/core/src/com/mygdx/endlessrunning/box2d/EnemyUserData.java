package com.mygdx.endlessrunning.box2d;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.endlessrunning.enums.UserDataType;
import com.mygdx.endlessrunning.utility.Constants;

public class EnemyUserData extends UserData{
	private Vector2 linearVelocity;
    private String animationAssetId;

    public EnemyUserData(float width, float height, String animationAssetId) {
        super(width, height);
        userDataType = UserDataType.ENEMY;
        linearVelocity = Constants.ENEMY_LINEAR_VELOCITY;
        this.animationAssetId = animationAssetId;
    }

    public void setLinearVelocity(Vector2 linearVelocity) {
        this.linearVelocity = linearVelocity;
    }

    public Vector2 getLinearVelocity() {
        return linearVelocity;
    }

    public String getAnimationAssetId() {
        return animationAssetId;
    }
}
