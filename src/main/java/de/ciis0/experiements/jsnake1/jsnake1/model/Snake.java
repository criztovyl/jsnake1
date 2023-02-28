package de.ciis0.experiements.jsnake1.jsnake1.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Getter
@Setter
@Slf4j
public class Snake {
    List<BodyPart> points;

    public void move(Direction2D direction) {
        log.debug("Moving {}", direction);
        points.forEach(bp ->
                bp.move(direction)
        );
    }
}
