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

    public void move(Direction2D headDirection) throws BodyPart.InvalidLocationException {
        log.debug("Moving {}", headDirection);
        Direction2D direction = headDirection;
        BodyPart last = null;
        for (BodyPart bp : points) {
            BodyPart copy = bp.copy();
            if (last != null) {
                direction = bp.moveAfter(direction, last);
            } else {
                bp.moveAfter(headDirection);
            }
            last = copy;
        }
    }
}
