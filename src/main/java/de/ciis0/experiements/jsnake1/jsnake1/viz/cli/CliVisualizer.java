package de.ciis0.experiements.jsnake1.jsnake1.viz.cli;

import de.ciis0.experiements.jsnake1.jsnake1.model.Field;
import de.ciis0.experiements.jsnake1.jsnake1.model.Snake;
import de.ciis0.experiements.jsnake1.jsnake1.viz.Visualizer;

public class CliVisualizer implements Visualizer {

    Field field;

    public CliVisualizer(Field field) {
        this.field = field;
    }

    @Override
    public void drawSnake(Snake snake) {

        boolean[][] points = new boolean[field.getMaxX()][field.getMaxY()];

        snake.getPoints().forEach(p ->
                points[p.getX()][p.getY()] = true
        );

        StringBuffer sb = new StringBuffer();
        for (int x = 0; x < field.getMaxX(); x++) {
            for (int y = 0; y < field.getMaxY(); y++) {
                sb.append(points[x][y] ? "·" : "-");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
