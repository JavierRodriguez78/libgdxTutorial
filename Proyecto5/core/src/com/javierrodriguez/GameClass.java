package com.javierrodriguez;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by xavi on 14/01/18.
 */

public class GameClass implements ApplicationListener {

    //Duración de la animación.
    private static float FRAME_DURATION = .05f;
    //Clase para dibujar la pantalla
    private SpriteBatch batch;
    //Atlas con toda la animación.
    private TextureAtlas charset;
    //Cuadro que debe ser dibujado en cada momento.
    private TextureRegion currentFrame;
    //Animación del personaje corriendo.
    private Animation runningAnimation;
    //Acumulación del tiempo que lleva representada una animación.
    private float elapsed_time = 0f;
    //Variables auxiliares para saber donde se debe pintar la imagen.
    private float origin_x, origin_y;



    @Override
    public void create() {
    batch = new SpriteBatch();
    charset = new TextureAtlas(Gdx.files.internal("charset.atlas"));
    Array<TextureAtlas.AtlasRegion> runningFrames = charset.findRegions("running");
    runningAnimation = new Animation(FRAME_DURATION,runningFrames, Animation.PlayMode.LOOP);
    TextureRegion firstTexture =runningFrames.first();
    origin_x = (Gdx.graphics.getWidth() - firstTexture.getRegionWidth())/2 ;
    origin_y = (Gdx.graphics.getHeight() - firstTexture.getRegionHeight())/2;
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
    Gdx.gl.glClearColor(1.0f,.8f,.667f,1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    elapsed_time += Gdx.graphics.getDeltaTime();
    currentFrame = (TextureRegion) runningAnimation.getKeyFrame(elapsed_time);
    batch.begin();
    batch.draw(currentFrame, origin_x,origin_y);
    batch.end();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
    charset.dispose();
    batch.dispose();
    }
}
