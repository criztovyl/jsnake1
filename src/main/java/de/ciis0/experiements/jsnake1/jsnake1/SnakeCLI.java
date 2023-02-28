package de.ciis0.experiements.jsnake1.jsnake1;

import de.ciis0.experiements.jsnake1.jsnake1.model.Direction2D;
import de.ciis0.experiements.jsnake1.jsnake1.model.Field;
import de.ciis0.experiements.jsnake1.jsnake1.model.BodyPart;
import de.ciis0.experiements.jsnake1.jsnake1.model.Snake;
import de.ciis0.experiements.jsnake1.jsnake1.viz.Visualizer;
import de.ciis0.experiements.jsnake1.jsnake1.viz.cli.CliVisualizer;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class SnakeCLI {

    public static void main(String[] args) {
        Snake snake = new Snake();

        snake.setPoints(List.of(
                new BodyPart(5,5),
                new BodyPart(4, 5),
                new BodyPart(3, 5),
                new BodyPart(3,6),
                new BodyPart(3,7),
                new BodyPart(3,8)
        ));

        Visualizer viz = new CliVisualizer(new Field(9,9));

        viz.drawSnake(snake);

        try {
            snake.move(Direction2D.UP);
            viz.drawSnake(snake);

            snake.move(Direction2D.UP);
            viz.drawSnake(snake);

            snake.move(Direction2D.UP);
            viz.drawSnake(snake);
        } catch(BodyPart.InvalidLocationException e){
            log.error("Failure!", e);
        }

    }
}
