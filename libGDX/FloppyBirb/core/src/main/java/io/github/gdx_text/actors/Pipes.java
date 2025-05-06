package io.github.gdx_text.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Pipes extends Actor {
    private Texture pipeDownTexture;
    private TextureRegion pipeUpTexture;
    private final float pipeWidth = 150;
    private final float pipeHeight = 615;

    // Con pipeOriginX y pipeOriginY se obtiene el centro de la imagen para poder rotar entorno a él
    private final float pipeOriginX = pipeWidth / 2;
    private final float pipeOriginY = pipeHeight / 2;
    private final float pipeUpRotation = 180;

    private float spacing = 1000; // Espacio entre las tuberías
    private float lowerPipeY;
    private float upperPipeY;

    // Constructor: recibe la imagen de la tubería, la posición X y la posición Y de la tubería inferior
    public Pipes(Texture texture, float x, float lowerY) {
        this.pipeDownTexture = texture;
        this.pipeUpTexture = new TextureRegion(texture);
        this.lowerPipeY = lowerY;
        this.upperPipeY = lowerY - spacing; // La posición Y de la tubería superior debe ser siempre 1000 menos que la inferior
        setBounds(x, lowerPipeY, pipeWidth, pipeHeight); // Establecemos el bounds de la tubería inferior
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        // Se dibujan las dos tuberías: la inferior y la superior (rotada 180º)
        batch.draw(pipeDownTexture, getX(), lowerPipeY, pipeWidth, pipeHeight);
        batch.draw(pipeUpTexture, getX(), upperPipeY, pipeOriginX, pipeOriginY, pipeWidth, pipeHeight, 1, 1, pipeUpRotation);
    }

    @Override
    public void act(float delta) {
        // Aquí irá la lógica cuando las tuberías se desplacen de derecha a izquierda
    }

    public float getWidth() {
        return pipeWidth;
    }
}
