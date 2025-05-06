package io.github.gdx_text;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.Random;

import io.github.gdx_text.actors.FloppyBirb;
import io.github.gdx_text.input.FloppyBirbInputProcessor;

public class PantallaPrincipal implements Screen {
    private SpriteBatch batch;
    private Texture bg;
    private Texture floppyBirbTexture;
    private Texture pipeDownTexture;
    private TextureRegion pipeUpTexture;
    private Stage stage;
    private FloppyBirb floppyBirb;
    private FloppyBirbInputProcessor floppyBirbInputProcessor; // Instancia del InputProcessor


    // Lógica para los tubos
    float pipeWidth = 150;
    float pipeHeight = 615;
    // Así se obtiene el centro de la imagen para poder rotar entorno a él
    float pipeOriginX = pipeWidth / 2;
    float pipeOriginY = pipeHeight / 2;
    float pipeUpRotation = 180;
    // Logica para randomizar la posición de los tubos
    Random generator = new Random();
    float pipeDownY1 = generator.nextInt(500) + 400;
    float pipeDownY2 = generator.nextInt(500) + 400;
    // La posición Y de pipeUp debe ser siempre 1000 menos que pipeDownY
    int pipeSpacing = 1000;
    float pipeUpY1 = pipeDownY1 - pipeSpacing;
    float pipeUpY2 = pipeDownY2 - pipeSpacing;

    public PantallaPrincipal() {
        batch = new SpriteBatch();
        bg = new Texture("pixelartbg.png");
        floppyBirbTexture = new Texture("floppybirb1.png");
        pipeDownTexture = new Texture("pipe.png");
        pipeUpTexture = new TextureRegion(pipeDownTexture);

        // Inicializar el Stage con un Viewport para manejar diferentes resoluciones
        stage = new Stage(new FitViewport(1280, 720), batch);

        // Crear el pájaro y añadirlo al Stage
        floppyBirb = new FloppyBirb(floppyBirbTexture, 150, 480, 120, 100);
        stage.addActor(floppyBirb);

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
            System.out.println("Arriba: Y = " + floppyBirb.getY() + ", Delta = " + delta); // Imprime la posición Y y el delta time
        }
        if (floppyBirbInputProcessor.moveDown) {
            floppyBirb.moveDown(delta);
            System.out.println("Abajo: Y = " + floppyBirb.getY() + ", Delta = " + delta);
        }
        if (floppyBirbInputProcessor.moveLeft) {
            floppyBirb.moveLeft(delta);
            System.out.println("Izquierda: X = " + floppyBirb.getX() + ", Delta = " + delta);
        }
        if (floppyBirbInputProcessor.moveRight) {
            floppyBirb.moveRight(delta);
            System.out.println("Derecha: X = " + floppyBirb.getX() + ", Delta = " + delta);
        }

        batch.begin();
        batch.draw(bg, 0, 0);

        // Dibujar los tubos
        batch.draw(pipeDownTexture, 500, pipeDownY1, pipeWidth, pipeHeight);
        batch.draw(pipeUpTexture, 500, pipeUpY1, pipeOriginX, pipeOriginY, pipeWidth, pipeHeight, 1, 1, pipeUpRotation);
        batch.draw(pipeDownTexture, 1000, pipeDownY2, pipeWidth, pipeHeight);
        batch.draw(pipeUpTexture, 1000, pipeUpY2, pipeOriginX, pipeOriginY, pipeWidth, pipeHeight, 1, 1, pipeUpRotation);

        batch.end();

        // Dibujar el Stage (dibuja todos los actores que contiene)
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
        pipeDownTexture.dispose();
        stage.dispose();
    }
}
