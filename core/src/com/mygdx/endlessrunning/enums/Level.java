package com.mygdx.endlessrunning.enums;

import com.badlogic.gdx.math.*;
import com.mygdx.endlessrunning.utility.Constants;
public enum Level {
	LEVEL_1(1, Constants.ENEMY_LINEAR_VELOCITY, Constants.RUNNER_GRAVITY_SCALE, Constants.RUNNER_JUMPING_LINEAR_IMPULSE, 5),
    LEVEL_2(2, new Vector2(-12f, 0f), Constants.RUNNER_GRAVITY_SCALE * 1.1f, new Vector2(0, 13f), 10),
    LEVEL_3(3, new Vector2(-14f, 0f), Constants.RUNNER_GRAVITY_SCALE * 1.1f, new Vector2(0, 13f), 20),
    LEVEL_4(4, new Vector2(-16f, 0f), Constants.RUNNER_GRAVITY_SCALE * 1.1f, new Vector2(0, 13f), 40),
    LEVEL_5(5, new Vector2(-18f, 0f), Constants.RUNNER_GRAVITY_SCALE * 1.1f, new Vector2(0, 13f), 80),
    LEVEL_6(6, new Vector2(-20f, 0f), Constants.RUNNER_GRAVITY_SCALE * 1.3f, new Vector2(0, 14f), 120),
    LEVEL_7(7, new Vector2(-22f, 0f), Constants.RUNNER_GRAVITY_SCALE * 1.3f, new Vector2(0, 14f), 160),
    LEVEL_8(8, new Vector2(-24f, 0f), Constants.RUNNER_GRAVITY_SCALE * 1.3f, new Vector2(0, 14f), 200),
    LEVEL_9(9, new Vector2(-26f, 0f), Constants.RUNNER_GRAVITY_SCALE * 1.5f, new Vector2(0, 15f), 250),
    LEVEL_10(10, new Vector2(-28f, 0f), Constants.RUNNER_GRAVITY_SCALE * 1.5f, new Vector2(0, 15f), 300),
    LEVEL_11(11, new Vector2(-30f, 0f), Constants.RUNNER_GRAVITY_SCALE * 1.6f, new Vector2(0, 15f), 350),
    LEVEL_12(12, new Vector2(-32f, 0f), Constants.RUNNER_GRAVITY_SCALE * 1.7f, new Vector2(0, 16f), 400),
    LEVEL_13(13, new Vector2(-34f, 0f), Constants.RUNNER_GRAVITY_SCALE * 2.1f, new Vector2(0, 18f), 500);

    private int level;
    private Vector2 enemyLinearVelocity;
    private float runnerGravityScale;
    private Vector2 runnerJumpingLinearImpulse;
    private int scoreMultiplier;

    Level(int level, Vector2 obstacleLinearVelocity, float runnerGravityScale, Vector2 runnerJumpingLinearImpulse,
               int scoreMultiplier) {
        this.level = level;
        this.enemyLinearVelocity = obstacleLinearVelocity;
        this.runnerGravityScale = runnerGravityScale;
        this.runnerJumpingLinearImpulse = runnerJumpingLinearImpulse;
        this.scoreMultiplier = scoreMultiplier;
    }

    public int getLevel() {
        return level;
    }

    public Vector2 getEnemyLinearVelocity() {
        return enemyLinearVelocity;
    }

    public float getRunnerGravityScale() {
        return runnerGravityScale;
    }

    public Vector2 getRunnerJumpingLinearImpulse() {
        return runnerJumpingLinearImpulse;
    }

    public int getScoreMultiplier() {
        return scoreMultiplier;
    }

}
