package io.github.gdx_text;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.Random;

import io.github.gdx_text.actors.FloppyBirb;
import io.github.gdx_text.actors.Pipes;
import io.github.gdx_text.input.FloppyBirbInputProcessor;

public class PantallaPrincipal implements Screen {
    private SpriteBatch batch;
    private Texture bg;
    private Texture floppyBirbTexture;
    private Texture pipeTexture;
    private Stage stage;
    private FloppyBirb floppyBirb;
    private FloppyBirbInputProcessor floppyBirbInputProcessor; // Instancia del InputProcessor

    private int screenHeight = 720;
    private int screenWidth = 1280;
    private Random generator = new Random();

    public PantallaPrincipal() {
        batch = new SpriteBatch();
        bg = new Texture("pixelartbg.png");
        floppyBirbTexture = new Texture("floppybirb1.png");
        pipeTexture = new Texture("pipe.png");

        // Inicializar el Stage con un Viewport para manejar diferentes resoluciones
        stage = new Stage(new FitViewport(screenWidth, screenHeight), batch);

        // Crear el pájaro y añadirlo al Stage
        floppyBirb = new FloppyBirb(floppyBirbTexture, 150, 480, 120, 100);
        stage.addActor(floppyBirb);

        // Crear las tuberías y añadirlas al Stage
        // Determinar el punto Y de la tubería inferior aleatoriamente
        int maxY = 670; // El punto Y máximo será 50 px menos que la altura de la pantalla (para que nunca quede escondida)
        int minY = 430; // Si la altura de la pantalla es 720px, el punto Y mínimo debe ser 430
        int rangeY = maxY - minY; // El punto Y podrá variar en 240 px de la altura máxima
        float lowerPipeY = generator.nextInt(rangeY) + minY;
        Pipes pipes1 = new Pipes(pipeTexture, 500, lowerPipeY);
        stage.addActor(pipes1);

        lowerPipeY = generator.nextInt(rangeY) + minY;
        Pipes pipes2 = new Pipes(pipeTexture, 1000, lowerPipeY);
        stage.addActor(pipes2);

        // Establecer el InputProcessor dedicado
        floppyBirbInputProcessor = new FloppyBirbInputProcessor(floppyBirb);
        Gdx.input.setInputProcessor(floppyBirbInputProcessor);

    }

    @Override
    public void show() {
        // Se llama cuando esta pantalla se convierte en la pantalla actual del juego.
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        // Llamar al metodo act de todos los actores
        stage.act(delta);

        // Procesar la entrada para el movimiento continuo
        if (floppyBirbInputProcessor.moveUp) {
            floppyBirb.moveUp(delta);
        }
        if (floppyBirbInputProcessor.moveDown) {
            floppyBirb.moveDown(delta);
        }
        if (floppyBirbInputProcessor.moveLeft) {
            floppyBirb.moveLeft(delta);
        }
        if (floppyBirbInputProcessor.moveRight) {
            floppyBirb.moveRight(delta);
        }

        batch.begin();
        batch.draw(bg, 0, 0);
        batch.end();

        // Dibujar el Stage (dibuja todos los actores que contiene: pájaro y tuberías)
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {
        // Se llama cuando la aplicación se pausa.
    }

    @Override
    public void resume() {
        // Se llama cuando la aplicación se reanuda después de una pausa.
    }

    @Override
    public void hide() {
        // Se llama cuando esta pantalla deja de ser la pantalla actual del juego.
    }

    @Override
    public void dispose() {
        batch.dispose();
        bg.dispose();
        floppyBirbTexture.dispose();
        pipeTexture.dispose();
        stage.dispose();
    }
}
