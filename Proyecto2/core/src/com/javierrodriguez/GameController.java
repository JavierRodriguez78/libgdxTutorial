package com.javierrodriguez;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by xavi on 13/01/18.
 */

public class GameController extends Game {
    private TextureRegion backgroundTexture;
    private SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        backgroundTexture = new TextureRegion(new Texture("background.png"),0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }

    public void render(){
        batch.begin();
        batch.draw(backgroundTexture,0,0);
        batch.end();
    }
}
