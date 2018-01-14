package com.javierrodriguez;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.input.GestureDetector;

/**
 * Created by xavi on 14/01/18.
 */

public class GameController extends Game implements InputProcessor{
    private TextureRegion backgroundTexture;
    private Texture texture_sprite;
    private SpriteBatch batch;
    private Sprite sprite;
    private float posX, posY;

    @Override
    public void create() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        batch = new SpriteBatch();
        backgroundTexture = new TextureRegion(new Texture("background.png"),0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        texture_sprite = new Texture(Gdx.files.internal("player.png"));
        sprite = new Sprite(texture_sprite);
        posX = w/2 -sprite.getWidth()/2;
        posY = w/2-sprite.getWidth()/2;
        sprite.setPosition(posX, posY);
        Gdx.input.setInputProcessor(this);

    }

    public void render(){
        sprite.setPosition(posX, posY);
        batch.begin();
        batch.draw(backgroundTexture,0,0);
        sprite.draw(batch);
        batch.end();
    }

    public void dispose(){
        batch.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        float moveAmount = 1.0f;
        if(keycode == Input.Keys.DOWN)
        {
            posY-=moveAmount;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        float moveAmount = 1.0f;
        if(keycode == Input.Keys.DOWN)
        {
            Gdx.input.vibrate(2000);
            posY-=moveAmount;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
