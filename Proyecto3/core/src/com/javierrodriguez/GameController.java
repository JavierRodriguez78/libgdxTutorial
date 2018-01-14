package com.javierrodriguez;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by xavi on 14/01/18.
 */

public class GameController extends Game {
    private TextureRegion backgroundTexture;
    private Texture texture_stripe;
    private SpriteBatch batch;
    private Sprite sprite;

    @Override
    public void create() {
        batch = new SpriteBatch();
        backgroundTexture = new TextureRegion(new Texture("background.png"),0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        texture_stripe = new Texture(Gdx.files.internal("player.png"));
        sprite = new Sprite(texture_stripe,10,10,100,100);

    }

    public void render(){
        batch.begin();
        batch.draw(backgroundTexture,0,0);
        sprite.draw(batch);
        batch.end();
    }

    public void dispose(){
        batch.dispose();
    }
}
