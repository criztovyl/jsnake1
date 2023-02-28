package de.ciis0.experiements.jsnake1.jsnake1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@Slf4j
public class BodyPart {
    int x, y;

    void move(Direction2D dir){
      log.debug("Moving {},{} {}", x, y, dir);
        switch (dir){
            case UP:
                y -= 1;
                break;
            case DOWN:
                y += 1;
                break;
            case LEFT:
                x -= 1;
                break;
            case RIGHT:
                x += 1;
                break;
        }
        log.debug("Moved {},{}", x, y);
    }
}
