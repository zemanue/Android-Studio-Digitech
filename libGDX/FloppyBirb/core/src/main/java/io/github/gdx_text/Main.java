package io.github.gdx_text;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture bg;
    private Texture floppyBirb;


    @Override
    public void create() {
        batch = new SpriteBatch();
        bg = new Texture("pixelartbg.png");
        floppyBirb = new Texture("floppybirb1.png");
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f); // Clear screen with a blue color
        batch.begin();
        batch.draw(bg, 0, 0);
        batch.draw(floppyBirb, 150, 480, 100, 100);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose(); // Este metodo se llama cuando la aplicación se cierra para liberar recursos
        floppyBirb.dispose();
        bg.dispose();
    }
}
