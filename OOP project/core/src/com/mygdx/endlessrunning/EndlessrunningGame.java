package com.mygdx.endlessrunning;


import com.badlogic.gdx.Game;
import com.mygdx.endlessrunning.screens.MainScreen;
import com.mygdx.endlessrunning.utility.AssetsManage;
import com.mygdx.endlessrunning.utility.AudioUtility;

public class EndlessrunningGame extends Game {

	
	@Override
	public void create () {
		AssetsManage.loadAssets();
		setScreen(new MainScreen());
	}

	@Override
	public void dispose () {
		super.dispose();
		AudioUtility.dispose();
		AssetsManage.dispose();
		
	}
}
