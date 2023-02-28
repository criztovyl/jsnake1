package de.ciis0.experiements.jsnake1.jsnake1;

import de.ciis0.experiements.jsnake1.jsnake1.model.Direction2D;
import de.ciis0.experiements.jsnake1.jsnake1.model.Field;
import de.ciis0.experiements.jsnake1.jsnake1.model.BodyPart;
import de.ciis0.experiements.jsnake1.jsnake1.model.Snake;
import de.ciis0.experiements.jsnake1.jsnake1.viz.Visualizer;
import de.ciis0.experiements.jsnake1.jsnake1.viz.cli.CliVisualizer;

import java.util.List;

public class SnakeCLI {

    public static void main(String[] args) {
        Snake snake = new Snake();

        snake.setPoints(List.of(
                new BodyPart(5,5)
        ));

        Visualizer viz = new CliVisualizer(new Field(9,9));

        viz.drawSnake(snake);

        snake.move(Direction2D.UP);
        viz.drawSnake(snake);

        snake.move(Direction2D.LEFT);
        viz.drawSnake(snake);

        snake.move(Direction2D.DOWN);
        viz.drawSnake(snake);

        snake.move(Direction2D.RIGHT);
        viz.drawSnake(snake);

    }
}
