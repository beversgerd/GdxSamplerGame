package com.williameversgerd;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class InputListeningSample implements ApplicationListener, InputProcessor {

    private static final Logger log = new Logger(InputListeningSample.class.getName(), Logger.DEBUG);

    private boolean renderInterrupted = true;

    private static final int MAX_MESSAGE_COUNT = 15;

    private final Array messages = new Array<String>();

    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private BitmapFont font;


    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        log.debug("in create()");

        camera = new OrthographicCamera();
        viewport = new FitViewport(1080, 720, camera);
        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("C:\\Bill\\projects\\GdxSamplerGame\\core\\assets\\assets\\fonts\\oswald-32.fnt"));

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void resize(int i, int i1) {
        viewport.update(i, i1, true);
    }

    @Override
    public void render() {

        // Clear screen
        Gdx.gl.glClearColor(0, 0, 0, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        draw();

        batch.end();
    }

    private void addMessage(String message) {
        messages.add(message);

        if (messages.size > MAX_MESSAGE_COUNT) {
            messages.removeIndex(0);
        }
    }

    private void draw() {
        for (int i = 0; i < messages.size; i++) {
            font.draw(batch, (CharSequence) messages.get(i),
                    20.0f,
                    720 - 40.0f * (i + 1)
            );
        }

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public boolean keyDown(int i) {
        String message = "keyDown keycode= " + i;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean keyUp(int i) {
        String message = "keyUp keycode= " + i;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean keyTyped(char c) {
        String message = "keyTyped keycode= " + c;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        String message = "touchDown screenX= " + i + " screenY= " + i1;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        String message = "touchUp screenX= " + i + " screenY= " + i1;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        String message = "touchDragged screenX= " + i + " screenY= " + i1;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        String message = "mouseMoved screenX= " + i + " screenY= " + i1;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean scrolled(int i) {
        String message = "scrolled keycode= " + i;
        log.debug(message);
        addMessage(message);
        return true;
    }
}
