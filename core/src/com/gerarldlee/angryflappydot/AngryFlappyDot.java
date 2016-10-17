package com.gerarldlee.angryflappydot;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AngryFlappyDot extends ApplicationAdapter {

	public static final int SCREEN_WIDTH = 480;
	public static final int SCREEN_HEIGHT = 800;

	public static final String TITLE = "Flappy Demo";

	private com.gerarldlee.angryflappydot.state.GameStateManager gsm;
	private Music music;

	private SpriteBatch batch;
	
	@Override
	public void create () {
//		batch = new SpriteBatch();
//		img = new Texture("badlogic.jpg");

		batch = new SpriteBatch();
		gsm = new com.gerarldlee.angryflappydot.state.GameStateManager();
		music = Gdx.audio.newMusic(Gdx.files.internal("song.ogg"));
		music.setLooping(true);
		music.setVolume(0.1f);
		music.play();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new com.gerarldlee.angryflappydot.state.MenuState(gsm));
	}

	@Override
	public void render () {
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
