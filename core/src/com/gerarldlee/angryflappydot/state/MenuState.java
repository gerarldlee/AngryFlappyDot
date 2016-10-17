package com.gerarldlee.angryflappydot.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.gerarldlee.angryflappydot.AngryFlappyDot;

/**
 * Created by datawiz on 16/10/2016.
 */

public class MenuState extends State {
    private Texture background;
    private Texture playBtn;
    private Texture gameOver;
    private BitmapFont font;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, AngryFlappyDot.SCREEN_WIDTH / 2, AngryFlappyDot.SCREEN_HEIGHT / 2);
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
        gameOver = new Texture("gameover.png");
        //font = new BitmapFont(Gdx.files.external("flappy.ttf"), false);
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("flappy.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 16;
        font = generator.generateFont(parameter);
        generator.dispose();
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.resetScore();
            gsm.set(new com.gerarldlee.angryflappydot.state.PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0,0);

        if (gsm.getScore() > 0) {
            sb.draw(gameOver, cam.position.x - gameOver.getWidth() / 2, cam.position.y + gameOver.getHeight());

            String text = "Score: " + gsm.getScore();
            final GlyphLayout layout = new GlyphLayout(font, text);

            font.draw(sb, layout, cam.position.x - layout.width / 2, cam.position.y + 150);
        }

        sb.draw(playBtn, cam.position.x - playBtn.getWidth() / 2, cam.position.y - playBtn.getHeight());
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        font.dispose();
        System.out.println("Menu State Disposed");
    }
}