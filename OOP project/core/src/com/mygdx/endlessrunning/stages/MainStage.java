package com.mygdx.endlessrunning.stages;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.mygdx.endlessrunning.actors.Enemy;
import com.mygdx.endlessrunning.actors.GameBG;
import com.mygdx.endlessrunning.actors.Ground;
import com.mygdx.endlessrunning.actors.Runner;
import com.mygdx.endlessrunning.actors.Score;
import com.mygdx.endlessrunning.enums.Level;
import com.mygdx.endlessrunning.enums.State;
import com.mygdx.endlessrunning.menu.AboutButton;
import com.mygdx.endlessrunning.menu.AboutLabel;
import com.mygdx.endlessrunning.menu.Dodge;
import com.mygdx.endlessrunning.menu.DodgeChangeButton;
import com.mygdx.endlessrunning.menu.DodgeChanging;
import com.mygdx.endlessrunning.menu.GameLabel;
import com.mygdx.endlessrunning.menu.Jump;
import com.mygdx.endlessrunning.menu.JumpChangeButton;
import com.mygdx.endlessrunning.menu.JumpChanging;
import com.mygdx.endlessrunning.menu.MusicButton;
import com.mygdx.endlessrunning.menu.Options;
import com.mygdx.endlessrunning.menu.PauseButton;
import com.mygdx.endlessrunning.menu.PausedLabel;
import com.mygdx.endlessrunning.menu.SoundButton;
import com.mygdx.endlessrunning.menu.StartButton;
import com.mygdx.endlessrunning.menu.Tutorial;
import com.mygdx.endlessrunning.utility.AssetsManage;
import com.mygdx.endlessrunning.utility.AudioUtility;
import com.mygdx.endlessrunning.utility.BodyUtility;
import com.mygdx.endlessrunning.utility.Constants;
import com.mygdx.endlessrunning.utility.GameManage;
import com.mygdx.endlessrunning.utility.WorldUtility;
import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;

public class MainStage extends Stage implements ContactListener{
	private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;
    
    private Random random;
    private Constants con;
    private World world;
    private Ground ground;
    private Runner runner;
    private int jump = 62; //SPACE
    private int dodge = 57; //L-ALT
    protected String jump_s = "SPACE";
    protected String dodge_s = "L-ALT";

    private final float TIME_STEP = 1 / 300f;
    private float accumulator = 0f;

    private OrthographicCamera camera;

    private SoundButton soundButton;
    private MusicButton musicButton;
    private PauseButton pauseButton;
    private StartButton startButton;
    private AboutButton aboutButton;
    private Options optionsButton;
    private JumpChangeButton jumpButton;
    private DodgeChangeButton dodgeButton;
    private Score score;
    private float totalTimePassed;
    private boolean tutorialShown;


    public MainStage() {
        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));      
    	con = new Constants();
        setUpCamera();
        setUpStageBase();
        setUpGameLabel();
        setUpMainMenu();
        Gdx.input.setInputProcessor(this);
        AudioUtility.getInstance().init();
        onGameOver();
    }

    private void setUpStageBase() {
    	
        setUpWorld();
        setUpFixedMenu();
    }

    private void setUpGameLabel() {
    	
        Rectangle gameLabelBounds = new Rectangle(0, getCamera().viewportHeight * 7 / 8,
                getCamera().viewportWidth, getCamera().viewportHeight / 4);
        addActor(new GameLabel(gameLabelBounds));
    }

    private void setUpAboutText() {
        Rectangle gameLabelBounds = new Rectangle(0, getCamera().viewportHeight * 5 / 8,
                getCamera().viewportWidth, getCamera().viewportHeight / 4);
        addActor(new AboutLabel(gameLabelBounds));
    }


    private void setUpFixedMenu() {
    	
        setUpSound();
        setUpMusic();
        setUpScore();
    }

    private void setUpSound() {
        Rectangle soundButtonBounds = new Rectangle(getCamera().viewportWidth / 64,
                getCamera().viewportHeight * 13 / 20, getCamera().viewportHeight / 10,
                getCamera().viewportHeight / 10);
        soundButton = new SoundButton(soundButtonBounds);
        addActor(soundButton);
    }

    private void setUpMusic() {
        Rectangle musicButtonBounds = new Rectangle(getCamera().viewportWidth / 64,
                getCamera().viewportHeight * 4 / 5, getCamera().viewportHeight / 10,
                getCamera().viewportHeight / 10);
        musicButton = new MusicButton(musicButtonBounds);
        addActor(musicButton);
    }

    private void setUpScore() {
        Rectangle scoreBounds = new Rectangle(getCamera().viewportWidth * 47 / 64,
                getCamera().viewportHeight * 57 / 64, getCamera().viewportWidth / 4,
                getCamera().viewportHeight / 8);
        score = new Score(scoreBounds);
        addActor(score);
    }

    private void setUpPause() {
        Rectangle pauseButtonBounds = new Rectangle(getCamera().viewportWidth / 64,
                getCamera().viewportHeight * 1 / 2, getCamera().viewportHeight / 10,
                getCamera().viewportHeight / 10);
        pauseButton = new PauseButton(pauseButtonBounds, new GamePauseButtonListener());
        addActor(pauseButton);
    }


    private void setUpMainMenu() {
    	
        setUpStart();
        setUpOptions();
      
        setUpAbout();
    }

    private void setUpStart() {
        Rectangle startButtonBounds = new Rectangle(getCamera().viewportWidth * 3 / 16,
                getCamera().viewportHeight / 4, getCamera().viewportWidth / 4,
                getCamera().viewportWidth / 4);
        startButton = new StartButton(startButtonBounds, new GameStartButtonListener());
        addActor(startButton);
    }


    private void setUpOptions() {
    	
    	
    	if(GameManage.getInstance().getGameState() != State.OPTION) {
    		Rectangle optionsButtonBounds = new Rectangle(getCamera().viewportWidth * 9 / 16,
                    getCamera().viewportHeight / 4, getCamera().viewportWidth / 4,
                    getCamera().viewportWidth / 4);
            optionsButton = new Options(optionsButtonBounds, new GameOptionsButtonListener());
        	addActor(optionsButton);
    	}
    	if(GameManage.getInstance().getGameState() == State.OPTION) {
    		Rectangle optionsButtonBounds = new Rectangle(getCamera().viewportWidth * 23 / 25,
                    getCamera().viewportHeight * 13 / 20, getCamera().viewportHeight / 10,
                    getCamera().viewportHeight / 10);
            optionsButton = new Options(optionsButtonBounds, new GameOptionsButtonListener());
        	addActor(optionsButton);
        	setJump();
        	setDodge();
    	}
    	 
    	
    }

	private void setDodge() {
    	Rectangle gameLabelBounds = new Rectangle(-170, (getCamera().viewportHeight * 5 / 8)-50,
                getCamera().viewportWidth, getCamera().viewportHeight / 4);
        addActor(new Dodge(gameLabelBounds, dodge_s));
        Rectangle dodgeButtonBounds = new Rectangle(getCamera().viewportWidth * 15 / 25,
                getCamera().viewportHeight * 11 / 20-50, getCamera().viewportHeight / 10,
                getCamera().viewportHeight / 10);
        dodgeButton = new DodgeChangeButton(dodgeButtonBounds, new GameDodgeChangeListener());
        addActor(dodgeButton);
	}

	private void setJump() {
		Rectangle gameLabelBounds = new Rectangle(-170, getCamera().viewportHeight * 5 / 8,
                getCamera().viewportWidth, getCamera().viewportHeight / 4);
        addActor(new Jump(gameLabelBounds, jump_s));
        Rectangle jumpButtonBounds = new Rectangle(getCamera().viewportWidth * 15 / 25,
                getCamera().viewportHeight * 11 / 20, getCamera().viewportHeight / 10,
                getCamera().viewportHeight / 10);
        jumpButton = new JumpChangeButton(jumpButtonBounds, new GameJumpChangeListener());
        addActor(jumpButton);
	}

	private void setUpAbout() {
    	
    	if (GameManage.getInstance().getGameState() != State.OPTION) {
    		Rectangle aboutButtonBounds = new Rectangle(getCamera().viewportWidth * 23 / 25,
                    getCamera().viewportHeight * 13 / 20, getCamera().viewportHeight / 10,
                    getCamera().viewportHeight / 10);
            aboutButton = new AboutButton(aboutButtonBounds, new GameAboutButtonListener());
            addActor(aboutButton);
    	}
        
    }

    private void setUpWorld() {
        world = WorldUtility.createWorld();
        world.setContactListener(this);
        setUpBackground();
        setUpGround();
    }

    private void setUpBackground() {
        addActor(new GameBG());
    }

    private void setUpGround() {
        ground = new Ground(WorldUtility.createGround(world));
        addActor(ground);
    }

    private void setUpCharacters() {
        setUpRunner();
        setUpPauseLabel();
        createEnemy();
    }

    private void setUpRunner() {
        if (runner != null) {
            runner.remove();
        }
        runner = new Runner(WorldUtility.createRunner(world));
        addActor(runner);
    }

    private void setUpCamera() {
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }


    private void setUpPauseLabel() {
        Rectangle pauseLabelBounds = new Rectangle(0, getCamera().viewportHeight * 7 / 8,
                getCamera().viewportWidth, getCamera().viewportHeight / 4);
        addActor(new PausedLabel(pauseLabelBounds));
    }

    private void setUpTutorial() {
        if (tutorialShown) {
            return;
        }
        setUpLeftTutorial();
        setUpRightTutorial();
        tutorialShown = true;
    }

    private void setUpLeftTutorial() {
        float width = getCamera().viewportHeight / 4;
        float x = getCamera().viewportWidth / 4 - width / 2;
        Rectangle leftTutorialBounds = new Rectangle(x, getCamera().viewportHeight * 9 / 20, width,
                width);
        addActor(new Tutorial(leftTutorialBounds, Constants.TUTORIAL_LEFT_REGION_NAME,
                Constants.TUTORIAL_LEFT_TEXT));
    }
 
    private void setUpRightTutorial() {
        float width = getCamera().viewportHeight / 4;
        float x = getCamera().viewportWidth * 3 / 4 - width / 2;
        Rectangle rightTutorialBounds = new Rectangle(x, getCamera().viewportHeight * 9 / 20, width,
                width);
        addActor(new Tutorial(rightTutorialBounds, Constants.TUTORIAL_RIGHT_REGION_NAME,
                Constants.TUTORIAL_RIGHT_TEXT));
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (GameManage.getInstance().getGameState() == State.PAUSED) return;

        if (GameManage.getInstance().getGameState() == State.RUNNING) {
            totalTimePassed += delta;
            updateLevel();
        }

        Array<Body> bodies = new Array<Body>(world.getBodyCount());
        world.getBodies(bodies);

        for (Body body : bodies) {
            update(body);
        }

        // Fixed timestep
        accumulator += delta;

        while (accumulator >= delta) {
            world.step(TIME_STEP, 6, 2);
            accumulator -= TIME_STEP;
        }

    }

    private void update(Body body) {
        if (!BodyUtility.bodyInBounds(body)) {
            if (BodyUtility.bodyIsEnemy(body) && !runner.isHit()) {
                createEnemy();
            }
            world.destroyBody(body);
        }
    }

    private void createEnemy() {
        Enemy enemy = new Enemy(WorldUtility.createEnemy(world));
        enemy.getUserData().setLinearVelocity(
                GameManage.getInstance().getLevel().getEnemyLinearVelocity());
        addActor(enemy);
    }
    
    @Override
    public boolean keyDown (int keycode) {
    	Gdx.input.setInputProcessor(this);
    	if (GameManage.getInstance().getGameState() == State.OVER) {
    		if(Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
    			clear();
                setUpStageBase();
                setUpCharacters();
                setUpPause();
                setUpTutorial();
                onGameResumed();
    		}
    	}
    	if (GameManage.getInstance().getGameState() == State.CHANGE_J) {
    		jump = keycode;
    		jump_s = Keys.toString(keycode);
    		clear();
    		setUpStageBase();
            setUpGameLabel();
    		onGameOver();
        	
    	}
    	if (GameManage.getInstance().getGameState() == State.CHANGE_D) {
    		dodge = keycode;
    		dodge_s = Keys.toString(keycode);
    		clear();
    		setUpStageBase();
            setUpGameLabel();
    		onGameOver();
        	
    	}
    	if (GameManage.getInstance().getGameState() == State.CHANGE_D) {
    		
    	}
    	
    	if (GameManage.getInstance().getGameState() == State.RUNNING) {
        	if(keycode == jump) {
        		runner.jump();
        	}
        	if(keycode == dodge) {
        		runner.dodge();
        		
        	}
        	if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
        		 onGamePaused();
        		 return false;
        	}
        	
    	}
    	if (GameManage.getInstance().getGameState() == State.PAUSED) {
    		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
       		 onGameResumed();
       		 return false;
       	}
    	} 

		return false;	
    }
    
    @Override
    public boolean keyUp (int keycode) {

    	if (GameManage.getInstance().getGameState() == State.RUNNING) {
    		if (runner.isDodging()) {
    			runner.stopDodge();
    		}
            
        } 
		return true;
    }

    @Override
    public void beginContact(Contact contact) {

        Body a = contact.getFixtureA().getBody();
        Body b = contact.getFixtureB().getBody();

        if ((BodyUtility.bodyIsRunner(a) && BodyUtility.bodyIsEnemy(b)) ||
                (BodyUtility.bodyIsEnemy(a) && BodyUtility.bodyIsRunner(b))) {
            if (runner.isHit()) {
                return;
            }
            runner.hit();
            onGameOver();
        } else if ((BodyUtility.bodyIsRunner(a) && BodyUtility.bodyIsGround(b)) ||
                (BodyUtility.bodyIsGround(a) && BodyUtility.bodyIsRunner(b))) {
            runner.landed();
        }

    }

    private void updateLevel() {

        if (GameManage.getInstance().isMaxLevel()) {
            return;
        }

        Level currentDifficulty = GameManage.getInstance().getLevel();

        if (totalTimePassed > GameManage.getInstance().getLevel().getLevel() * 5) {

            int nextDifficulty = currentDifficulty.getLevel() + 1;
            String difficultyName = "LEVEL_" + nextDifficulty;
            GameManage.getInstance().setLevel(Level.valueOf(difficultyName));

            runner.LevelChange(GameManage.getInstance().getLevel());
            score.setMultiplier(GameManage.getInstance().getLevel().getScoreMultiplier());
        }

    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }

    private class GamePauseButtonListener implements PauseButton.PauseButtonListener {

        @Override
        public void onPause() {
            onGamePaused();
        }

        @Override
        public void onResume() {
            onGameResumed();
        }

    }

    private class GameStartButtonListener implements StartButton.StartButtonListener {

        @Override
        public void onStart() {
            clear();
            setUpStageBase();
            setUpCharacters();
            setUpPause();
            setUpTutorial();
            onGameResumed();
        }

    }
    private class GameOptionsButtonListener implements Options.OptionsButtonListener{
    	
		@Override
		public void onOptions() {
			// TODO Auto-generated method stub
			AssetsManage.updateAssets();
			if (GameManage.getInstance().getGameState() == State.OVER) {
                onGameOptions();
            } else {
            	GameManage.getInstance().setGameState(State.OVER);
                clear();
                setUpStageBase();
                setUpGameLabel();
                setUpMainMenu();
            }
		}
    	
    }

    private class GameAboutButtonListener implements AboutButton.AboutButtonListener {

        @Override
        public void onAbout() {
        	AssetsManage.updateAssets();
            if (GameManage.getInstance().getGameState() == State.OVER) {
                onGameAbout();
            } else {
            	GameManage.getInstance().setGameState(State.OVER);
                clear();
                setUpStageBase();
                setUpGameLabel();
                setUpMainMenu();
            }
        }

    }

    private class GameJumpChangeListener implements JumpChangeButton.JumpChangeListener{

		@Override
		public void JumpChange() {
			// TODO Auto-generated method stub
			jumpChange();
			
	        
		}
    	
    }
    
    private class GameDodgeChangeListener implements DodgeChangeButton.DodgeChangeListener{

		@Override
		public void DodgeChange() {
			// TODO Auto-generated method stub
			dodgeChange();
		}
    	
    }
    private void onGamePaused() {
        GameManage.getInstance().setGameState(State.PAUSED);
    }
    private void dodgeChange() {
    	setUpStageBase();
    	Rectangle gameLabelBounds = new Rectangle(0, getCamera().viewportHeight * 5 / 8,
                getCamera().viewportWidth, getCamera().viewportHeight / 4);
        addActor(new DodgeChanging(gameLabelBounds));
    	
    	GameManage.getInstance().setGameState(State.CHANGE_D);
    }
    private void jumpChange() {
    	setUpStageBase();
    	Rectangle gameLabelBounds = new Rectangle(0, getCamera().viewportHeight * 5 / 8,
                getCamera().viewportWidth, getCamera().viewportHeight / 4);
        addActor(new JumpChanging(gameLabelBounds));
    	
    	GameManage.getInstance().setGameState(State.CHANGE_J);
        
        
        
    }
    private void onGameResumed() {
        GameManage.getInstance().setGameState(State.RUNNING);
    }

    private void onGameOver() {
        GameManage.getInstance().setGameState(State.OVER);
        GameManage.getInstance().resetLevel();
        totalTimePassed = 0;
    	random = new Random();
    	int oneTwoThree = random.nextInt(3) + 1;
    	con.setrand(oneTwoThree);
        AssetsManage.updateAssets();
        setUpStageBase();
        setUpGameLabel();
        setUpMainMenu();
    }
 
    private void onGameAbout() {
        GameManage.getInstance().setGameState(State.ABOUT);
        clear();
        AssetsManage.updateAssets();
        setUpStageBase();
        setUpGameLabel();
        setUpAboutText();
        setUpAbout();
    }
    
    private void onGameOptions() {

    	 GameManage.getInstance().setGameState(State.OPTION);
    	 clear();
    	 AssetsManage.updateAssets();
    	 setUpStageBase();
         setUpGameLabel();
         setUpOptions();
    }

}