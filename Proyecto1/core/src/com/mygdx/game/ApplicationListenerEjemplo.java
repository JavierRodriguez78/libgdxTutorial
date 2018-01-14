package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;

public class ApplicationListenerEjemplo implements ApplicationListener {

	private static final Logger log = new Logger(ApplicationListenerEjemplo.class.getName(), Logger.DEBUG);
    private boolean renderInterrupted = true;

	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		log.debug("create()");
	}

	@Override
	public void resize(int width, int height) {
		log.debug("resize () width =" + width + "height ="+ height);

	}

	@Override
	public void render() {
		log.debug("render()");
		renderInterrupted = false;
	}

	@Override
	public void pause() {
		log.debug("pause()");
		renderInterrupted = true;
	}

	@Override
	public void resume() {
		log.debug("resume()");
		renderInterrupted = true;
	}

	@Override
	public void dispose() {
		log.debug("dispose()");
	}
}
