package io.github.gdx_text.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class FloppyBirb extends Actor {
    private Texture texture;
    private float velocity = 100; // Pixeles por segundo

    public FloppyBirb(Texture texture, float x, float y, float width, float height) {
        this.texture = texture;
        setBounds(x, y, width, height); // Establece la posición y dimensiones iniciales
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void act(float delta) {
        // Este metodo se llama en cada frame. Aquí actualizaremos la posición basándonos en la entrada del usuario.
        // Por ahora, lo dejaremos vacío. La lógica de movimiento estará en PantallaPrincipal.java.
    }

    public void moveUp(float delta) {
        setY(getY() + velocity * delta);
    }

    public void moveDown(float delta) {
        setY(getY() - velocity * delta);
    }

    public void moveLeft(float delta) {
        setX(getX() - velocity * delta);
    }

    public void moveRight(float delta) {
        setX(getX() + velocity * delta);
    }
}
