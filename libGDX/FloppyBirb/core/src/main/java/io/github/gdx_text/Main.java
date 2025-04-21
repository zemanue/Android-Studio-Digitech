package io.github.gdx_text;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture bg;
    private Texture floppyBirb;
    private Texture pipeDown;
    private TextureRegion pipeUp;

    // Lógica para poder rotar la imagen del tubo
    float pipeWidth = 150;
    float pipeHeight = 615;
    // Así se obtiene el centro de la imagen para poder rotar entorno a él
    float pipeOriginX = pipeWidth / 2;
    float pipeOriginY = pipeHeight / 2;
    float pipeUpRotation = 180;

    // Lógica para randomizar la posición de los tubos
    Random generator = new Random();
    // La posición Y de pipeDown debe ser mínimo de 500 y máximo de 800
    float pipeDownY1 = generator.nextInt(500) + 400;
    float pipeDownY2 = generator.nextInt(500) + 400;
    // La posición Y de pipeUp debe ser siempre 1000 menos que pipeDownY
    float pipeUpY1 = pipeDownY1 - 1000;
    float pipeUpY2 = pipeDownY2 - 1000;


    @Override
    public void create() {
        batch = new SpriteBatch();
        bg = new Texture("pixelartbg.png");
        floppyBirb = new Texture("floppybirb1.png");
        pipeDown = new Texture("pipe.png");
        pipeUp = new TextureRegion(pipeDown);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f); // Clear screen with a blue color
        batch.begin();
        batch.draw(bg, 0, 0);
        batch.draw(floppyBirb, 150, 480, 120, 100);

        batch.draw(pipeDown, 500, pipeDownY1, 150, 615);
        batch.draw(pipeUp, 500, pipeUpY1, pipeOriginX, pipeOriginY, pipeWidth, pipeHeight, 1, 1, pipeUpRotation);

        batch.draw(pipeDown, 1000, pipeDownY2, 150, 615);
        batch.draw(pipeUp, 1000, pipeUpY2, pipeOriginX, pipeOriginY, pipeWidth, pipeHeight, 1, 1, pipeUpRotation);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose(); // Este metodo se llama cuando la aplicación se cierra para liberar recursos
        floppyBirb.dispose();
        bg.dispose();
        pipeDown.dispose();
    }
}
