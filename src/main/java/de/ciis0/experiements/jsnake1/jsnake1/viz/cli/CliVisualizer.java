package de.ciis0.experiements.jsnake1.jsnake1.viz.cli;

import de.ciis0.experiements.jsnake1.jsnake1.model.Field;
import de.ciis0.experiements.jsnake1.jsnake1.model.Snake;
import de.ciis0.experiements.jsnake1.jsnake1.viz.Visualizer;

public class CliVisualizer implements Visualizer {

    private static final char NEW_LINE = '\n';
    Field field;

    public CliVisualizer(Field field) {
        this.field = field;
    }

    @Override
    public void drawSnake(Snake snake) {

        boolean[][] points = new boolean[field.getMaxX()][field.getMaxY()];

        int headX, headY;

        headX = snake.getPoints().get(0).getX();
        headY = snake.getPoints().get(0).getY();

        snake.getPoints().forEach(p ->
                points[p.getX()][p.getY()] = true
        );

        StringBuffer sb = new StringBuffer();

        // y = rows
        // x = cols

        sb.append("  ");

        for(int x=0; x < field.getMaxX(); x++){
            sb.append(x);
        }

        sb.append(NEW_LINE);

        for(int x=0; x < field.getMaxX(); x++){
            sb.append(x == headX ? "^" : " ");
        }

        sb.append(NEW_LINE);

        for(int y=0; y < field.getMaxY(); y++){
            sb.append(y);
            sb.append(y == headY ? "<" : " ");
            for(int x=0; x < field.getMaxX(); x++){
                sb.append(points[x][y] ? "_" : " ");
            }
            sb.append(NEW_LINE);
        }

        System.out.println(sb);

    }
}
