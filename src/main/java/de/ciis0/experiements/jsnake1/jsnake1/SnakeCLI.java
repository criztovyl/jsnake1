package de.ciis0.experiements.jsnake1.jsnake1;

import de.ciis0.experiements.jsnake1.jsnake1.model.Field;
import de.ciis0.experiements.jsnake1.jsnake1.model.Point;
import de.ciis0.experiements.jsnake1.jsnake1.model.Snake;
import de.ciis0.experiements.jsnake1.jsnake1.viz.Visualizer;
import de.ciis0.experiements.jsnake1.jsnake1.viz.cli.CliVisualizer;

import java.util.List;

public class SnakeCLI {

    public static void main(String[] args) {
        Snake snake = new Snake();

        snake.setPoints(List.of(
                new Point(6,6)
        ));

        Visualizer viz = new CliVisualizer(new Field(8,12));
        viz.drawSnake(snake);
    }
}
