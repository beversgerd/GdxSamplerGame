package com.williameversgerd;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.Field;
import com.badlogic.gdx.utils.reflect.Method;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Arrays;

public class GdxReflectionSample implements ApplicationListener {

	private static final Logger log = new Logger(GdxReflectionSample.class.getName(), Logger.DEBUG);

	private boolean renderInterrupted = true;

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

		debugReflection(GdxReflectionSample.class);
	}

	@Override
	public void resize(int i, int i1) {
		viewport.update(i, i1, true);
	}

	@Override
	public void render() {

	}

	private void draw() {
		// mouse / touch x/y
		int mouseX = Gdx.input.getX();
		int mouseY = Gdx.input.getY();

		// buttons
		boolean leftPressed = Gdx.input.isButtonPressed(Input.Buttons.LEFT);
		boolean rightPressed = Gdx.input.isButtonPressed(Input.Buttons.RIGHT);

		font.draw(batch,
				"Mouse/Touch : x= " + mouseX + " y= "+ mouseY,
				20f,
				720 - 20f);

		log.debug("Mouse/Touch : x= " + mouseX + " y= "+ mouseY);



		font.draw(batch,
				leftPressed ? "Left Button Pressed" : "Left Button not Pressed",
				20f,
				720 - 50f);

		log.debug(leftPressed ? "Left Button Pressed" : "Left Button not Pressed");

		font.draw(batch,
				rightPressed ? "Right Button Pressed" : "Right Button not Pressed",
				20f,
				720 - 80f);

		log.debug(rightPressed ? "Right Button Pressed" : "Right Button not Pressed");


		// Keys
		boolean wPressed = Gdx.input.isKeyPressed(Input.Keys.W);
		boolean sPressed = Gdx.input.isKeyPressed(Input.Keys.S);

		font.draw(batch,
				wPressed ? "W Pressed" : "W not Pressed",
				20f,
				720 - 110f);

		log.debug(wPressed ? "W Pressed" : "W not Pressed");

		font.draw(batch,
				sPressed ? "S Pressed" : "S not Pressed",
				20f,
				720 - 140f);

		log.debug(sPressed ? "S Pressed" : "S not Pressed");



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

	private static void debugReflection(Class<?> clazz){
		Field[] fields = ClassReflection.getDeclaredFields(clazz);
		Method[] methods = ClassReflection.getDeclaredMethods(clazz);

		log.debug("== debug reflection class= " + clazz.getName());

		log.debug("fields-count= " + fields.length);

		for(Field field : fields) {
			log.debug("name= " + field.getName() + ", type= " + field.getType());
		}

		log.debug("methods-count= " + methods.length);

		for(Method method : methods) {
			log.debug("name= " + method.getName() + " parameterType= " + Arrays.asList(method.getParameterTypes()));
		}

		log.debug("===========");


	}
}
