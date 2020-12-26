package com.gamecodeschool.c22platformer;

import android.content.Context;
import android.graphics.PointF;

import com.gamecodeschool.c22platformer.GOSpec.GameObjectSpec;

class GameObjectFactory {
    private Context mContext;
    private GameEngine mGameEngineReference;
    private int mPixelsPerMetre;

    GameObjectFactory(Context context,
                      GameEngine gameEngine,
                      int pixelsPerMetre) {

        mContext = context;
        mGameEngineReference = gameEngine;
        mPixelsPerMetre = pixelsPerMetre;
    }

    GameObject create(GameObjectSpec spec, PointF location) {
        GameObject object = new GameObject();

        int mNumComponents = spec.getComponents().length;
        object.setTag(spec.getTag());

        // First give the game object the
        // right kind of transform

        switch(object.getTag()){
            case "Background":
                // Code coming soon
                break;

            case "Player":
                // Code coming soon
                break;

            default:// normal transform
                object.setTransform(new Transform(
                        spec.getSpeed(),
                        spec.getSize().x,
                        spec.getSize().y,
                        location));
                break;
        }


        // Loop through and add/initialize all the components
        for (int i = 0; i < mNumComponents; i++) {
            switch (spec.getComponents()[i]) {
                case "PlayerInputComponent":
                    // Code coming soon
                    break;
                case "AnimatedGraphicsComponent":
                    // Code coming soon
                    break;
                case "PlayerUpdateComponent":
                    // Code coming soon
                    break;
                case "InanimateBlockGraphicsComponent":
                    object.setGraphics(new
                                    InanimateBlockGraphicsComponent(),
                            mContext, spec, spec.getSize(),
                            mPixelsPerMetre);
                    break;
                case "InanimateBlockUpdateComponent":
                    object.setMovement(new
                            InanimateBlockUpdateComponent());
                    break;
                case "MovableBlockUpdateComponent":
                    // Code coming soon
                    break;
                case "DecorativeBlockUpdateComponent":
                    object.setMovement(new
                            DecorativeBlockUpdateComponent());
                    break;
                case "BackgroundGraphicsComponent":
                    // Code coming soon
                    break;
                case "BackgroundUpdateComponent":
                    // Code coming soon
                    break;

                default:
                    // Error unidentified component
                    break;
            }
        }

        // Return the completed GameObject
        // to the LevelManager class
        return object;
    }
}
