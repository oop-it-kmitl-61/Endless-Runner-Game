package com.mygdx.endlessrunning.utility;

import com.badlogic.gdx.math.Vector2;

public class Constants {
	public static final String GAME_NAME = "EndlessRunner Game";
    public static final int APP_WIDTH = 800;
    public static final int APP_HEIGHT = 480;
    public static final float WORLD_TO_SCREEN = 32;
    public static final Vector2 WORLD_GRAVITY = new Vector2(0, -10);
    public static final float GROUND_X = 0;
    public static final float GROUND_Y = 0;
    public static final float GROUND_WIDTH = 25f;
    public static final float GROUND_HEIGHT = 2f;
    public static final float GROUND_DENSITY = 0f;
    public static final float RUNNER_X = 2;
    public static final float RUNNER_Y = GROUND_Y + GROUND_HEIGHT;
    public static final float RUNNER_WIDTH = 1f;
    public static final float RUNNER_HEIGHT = 2f;
    public static final float RUNNER_GRAVITY_SCALE = 3f;
    public static final float RUNNER_DENSITY = 0.5f;
    public static final float RUNNER_DODGE_X = 2f;
    public static final float RUNNER_DODGE_Y = 1.5f;
    public static final Vector2 RUNNER_JUMPING_LINEAR_IMPULSE = new Vector2(0, 13f);
    public static final float RUNNER_HIT_ANGULAR_IMPULSE = 10f;
    public static final float ENEMY_X = 25f;
    public static final float ENEMY_DENSITY = RUNNER_DENSITY;
    public static final float RUNNING_SHORT_ENEMY_Y = 1.5f;
    public static final float RUNNING_LONG_ENEMY_Y = 2f;
    public static final float FLYING_ENEMY_Y = 3f;
    public static final Vector2 ENEMY_LINEAR_VELOCITY = new Vector2(-10f, 0);
    public static final String BACKGROUND_ASSETS_ID = "background";
    public static final String GROUND_ASSETS_ID = "ground";
    public static final String RUNNER_RUNNING_ASSETS_ID = "runner_running";
    public static final String RUNNER_DODGING_ASSETS_ID = "runner_dodging";
    public static final String RUNNER_HIT_ASSETS_ID = "runner_hit";
    public static final String RUNNER_JUMPING_ASSETS_ID = "runner_jumping";
    public static final String RUNNING_SMALL_ENEMY_ASSETS_ID = "running_small_enemy";
    public static final String RUNNING_LONG_ENEMY_ASSETS_ID = "running_long_enemy";
    public static final String RUNNING_BIG_ENEMY_ASSETS_ID = "running_big_enemy";
    public static final String RUNNING_WIDE_ENEMY_ASSETS_ID = "running_wide_enemy";
    public static final String FLYING_SMALL_ENEMY_ASSETS_ID = "flying_small_enemy";
    public static final String FLYING_WIDE_ENEMY_ASSETS_ID = "flying_wide_enemy";
    public static String BACKGROUND_IMAGE_PATH = "city.png";
    public static String GROUND_IMAGE_PATH = "ground2.png";
    public static String SPRITES_ATLAS_PATH = "spriterand1.txt";
    public static String[] RUNNER_RUNNING_REGION_NAMES = new String[] {"layer1", "layer2", "layer3"};
    public static String RUNNER_DODGING_REGION_NAME = "slide";
    public static String RUNNER_HIT_REGION_NAME = "died";
    public static String RUNNER_JUMPING_REGION_NAME = "jump";
    public static String[] RUNNING_SMALL_ENEMY_REGION_NAMES = new String[] {"g4layer1", "g4layer2", "g4layer3"};
    public static String[] RUNNING_LONG_ENEMY_REGION_NAMES = new String[] {"g1layer1", "g1layer2", "g1layer3"};
    public static String[] RUNNING_BIG_ENEMY_REGION_NAMES = new String[] {"g2layer1", "g2layer2", "g2layer3"};
    public static String[] RUNNING_WIDE_ENEMY_REGION_NAMES = new String[] {"g3layer1", "g3layer2", "g3layer3"};
    public static String[] FLYING_SMALL_ENEMY_REGION_NAMES = new String[] {"fly1layer1", "fly1layer2"};
    public static String[] FLYING_WIDE_ENEMY_REGION_NAMES = new String[] {"fly2layer1", "fly2layer2", "fly2layer3"};
    public static String SOUND_ON_REGION_NAME = "sound on";
    public static String SOUND_OFF_REGION_NAME = "sound off";
    public static String MUSIC_ON_REGION_NAME = "music on";
    public static String MUSIC_OFF_REGION_NAME = "music off";
    public static String PAUSE_REGION_NAME = "pause";
    public static String PLAY_REGION_NAME = "play";
    public static String BIG_PLAY_REGION_NAME = "big play";
    public static String ABOUT_REGION_NAME = "info";
    public static String CLOSE_REGION_NAME = "exit";
    public static String SETTING_REGION_NAME = "big setting"; 
    public static String CHANGE_REGION_NAME = "change"; 
    public static String TUTORIAL_LEFT_REGION_NAME = "tuto crouch";
    public static String TUTORIAL_RIGHT_REGION_NAME = "tuto jump";
    public static final String TUTORIAL_LEFT_TEXT = "\nPressed L-alt to dodge";
    public static final String TUTORIAL_RIGHT_TEXT = "\nPressed SPACE to jump";
    public static final String RUNNER_JUMPING_SOUND = "jump.wav";
    public static final String RUNNER_HIT_SOUND = "hit.wav";
    public static final String GAME_MUSIC = "fun_in_a_bottle.mp3";
    public static final String FONT_NAME = "roboto_bold.ttf";
    public static final String ABOUT_TEXT = "Pressed ENTER to play\nPressed ESC to PAUSE & Play " +
            "\nPressed L-alt to dodge\nPressed SPACE to jump";
    public static final String PAUSED_LABEL = "Paused";
    
    public Constants() { 
    	
    }
	public void setrand(int rand) {
		if (rand == 1) {
			BACKGROUND_IMAGE_PATH = "city.png";
		    GROUND_IMAGE_PATH = "ground2.png";
		    SPRITES_ATLAS_PATH = "spriterand1.txt";
		    RUNNER_RUNNING_REGION_NAMES = new String[] {"layer1", "layer2", "layer3"};
		    RUNNER_DODGING_REGION_NAME = "slide";
		    RUNNER_HIT_REGION_NAME = "died";
		    RUNNER_JUMPING_REGION_NAME = "jump";
		    RUNNING_SMALL_ENEMY_REGION_NAMES = new String[] {"g4layer1", "g4layer2", "g4layer3"};
		    RUNNING_LONG_ENEMY_REGION_NAMES = new String[] {"g1layer1", "g1layer2", "g1layer3"};
		    RUNNING_BIG_ENEMY_REGION_NAMES = new String[] {"g2layer1", "g2layer2", "g2layer3"};
		    RUNNING_WIDE_ENEMY_REGION_NAMES = new String[] {"g3layer1", "g3layer2", "g3layer3"};
		    FLYING_SMALL_ENEMY_REGION_NAMES = new String[] {"fly1layer1", "fly1layer2"};
		    FLYING_WIDE_ENEMY_REGION_NAMES = new String[] {"fly2layer1", "fly2layer2", "fly2layer3"};
		    SOUND_ON_REGION_NAME = "sound on";
		    SOUND_OFF_REGION_NAME = "sound off";
		    MUSIC_ON_REGION_NAME = "music on";
		    MUSIC_OFF_REGION_NAME = "music off";
		    PAUSE_REGION_NAME = "pause";
		    PLAY_REGION_NAME = "play";
		    BIG_PLAY_REGION_NAME = "big play";
		    ABOUT_REGION_NAME = "info";
		    CLOSE_REGION_NAME = "exit";
		    SETTING_REGION_NAME = "big setting"; 
		    CHANGE_REGION_NAME = "change"; 
		    TUTORIAL_LEFT_REGION_NAME = "tuto crouch";
		    TUTORIAL_RIGHT_REGION_NAME = "tuto jump";
		}
		if (rand == 2) {
			BACKGROUND_IMAGE_PATH = "forest.png";
		    GROUND_IMAGE_PATH = "ground2.png";
		    SPRITES_ATLAS_PATH = "spriterand2.txt";
		    RUNNER_RUNNING_REGION_NAMES = new String[] {"layer1", "layer2", "layer3"};
		    RUNNER_DODGING_REGION_NAME = "slide";
		    RUNNER_HIT_REGION_NAME = "died";
		    RUNNER_JUMPING_REGION_NAME = "jump";
		    RUNNING_SMALL_ENEMY_REGION_NAMES = new String[] {"g4layer1", "g4layer2", "g4layer3"};
		    RUNNING_LONG_ENEMY_REGION_NAMES = new String[] {"g1layer1", "g1layer2", "g1layer3"};
		    RUNNING_BIG_ENEMY_REGION_NAMES = new String[] {"g2layer1", "g2layer2", "g2layer3"};
		    RUNNING_WIDE_ENEMY_REGION_NAMES = new String[] {"g3layer1", "g3layer2", "g3layer3"};
		    FLYING_SMALL_ENEMY_REGION_NAMES = new String[] {"fly1layer1", "fly1layer2"};
		    FLYING_WIDE_ENEMY_REGION_NAMES = new String[] {"fly2layer1", "fly2layer2", "fly2layer3"};
		    SOUND_ON_REGION_NAME = "sound on";
		    SOUND_OFF_REGION_NAME = "sound off";
		    MUSIC_ON_REGION_NAME = "music on";
		    MUSIC_OFF_REGION_NAME = "music off";
		    PAUSE_REGION_NAME = "pause";
		    PLAY_REGION_NAME = "play";
		    BIG_PLAY_REGION_NAME = "big play";
		    ABOUT_REGION_NAME = "info";
		    CLOSE_REGION_NAME = "exit";
		    SETTING_REGION_NAME = "big setting"; 
		    CHANGE_REGION_NAME = "change"; 
		    TUTORIAL_LEFT_REGION_NAME = "tuto crouch";
		    TUTORIAL_RIGHT_REGION_NAME = "tuto jump";
		}
		if (rand == 3) {
			BACKGROUND_IMAGE_PATH = "graveyard.png";
		    GROUND_IMAGE_PATH = "ground2.png";
		    SPRITES_ATLAS_PATH = "spriterand3.txt";
		    RUNNER_RUNNING_REGION_NAMES = new String[] {"layer1", "layer2", "layer3"};
		    RUNNER_DODGING_REGION_NAME = "slide";
		    RUNNER_HIT_REGION_NAME = "died";
		    RUNNER_JUMPING_REGION_NAME = "jump";
		    RUNNING_SMALL_ENEMY_REGION_NAMES = new String[] {"g4layer1", "g4layer2", "g4layer3"};
		    RUNNING_LONG_ENEMY_REGION_NAMES = new String[] {"g1layer1", "g1layer2", "g1layer3"};
		    RUNNING_BIG_ENEMY_REGION_NAMES = new String[] {"g2layer1", "g2layer2", "g2layer3"};
		    RUNNING_WIDE_ENEMY_REGION_NAMES = new String[] {"g3layer1", "g3layer2", "g3layer3"};
		    FLYING_SMALL_ENEMY_REGION_NAMES = new String[] {"fly1layer1", "fly1layer2"};
		    FLYING_WIDE_ENEMY_REGION_NAMES = new String[] {"fly2layer1", "fly2layer2"};
		    SOUND_ON_REGION_NAME = "sound on";
		    SOUND_OFF_REGION_NAME = "sound off";
		    MUSIC_ON_REGION_NAME = "music on";
		    MUSIC_OFF_REGION_NAME = "music off";
		    PAUSE_REGION_NAME = "pause";
		    PLAY_REGION_NAME = "play";
		    BIG_PLAY_REGION_NAME = "big play";
		    ABOUT_REGION_NAME = "info";
		    CLOSE_REGION_NAME = "exit";
		    SETTING_REGION_NAME = "big setting"; 
		    CHANGE_REGION_NAME = "change"; 
		    TUTORIAL_LEFT_REGION_NAME = "tuto crouch";
		    TUTORIAL_RIGHT_REGION_NAME = "tuto jump";
		}
	}

}