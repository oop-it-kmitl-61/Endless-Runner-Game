package com.mygdx.endlessrunning.box2d;

import com.mygdx.endlessrunning.enums.UserDataType;

public class GroundUserData extends UserData{
	 public GroundUserData(float width, float height) {
	        super(width, height);
	        userDataType = UserDataType.GROUND;
	    }
}
