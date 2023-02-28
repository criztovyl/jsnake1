package de.ciis0.experiements.jsnake1.jsnake1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static de.ciis0.experiements.jsnake1.jsnake1.model.Direction2D.*;

@Getter
@AllArgsConstructor
@Slf4j
public class BodyPart {
    int x, y;

    void moveAfter(Direction2D dir){
      log.debug("Moving {} {}", this, dir);
        switch (dir){
            case UP:
                y += 1;
                break;
            case DOWN:
                y -= 1;
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

    public Direction2D moveAfter(Direction2D dir, BodyPart after) throws InvalidLocationException {

        //          UP      DOWN    LEFT    RIGHT
        // ABOVE    x       DOWN    DOWN    DOWN
        // BELOW    UP      x       UP      UP
        // LEFT     RIGHT   RIGHT   x       RIGHT
        // RIGHT    LEFT    LEFT    LEFT    x

        log.debug("Moving {} after {} {}", this, dir, after);
        if (y > after.y && dir != UP){
            // ABOVE --> DOWN
            log.debug("above     , moving down");
            y -= 1;
            return DOWN;
        } else if (y < after.y && dir != DOWN) {
            log.debug("below     , moving up");
            y += 1;
            return UP;
        } else if (x < after.x && dir != LEFT) {
            log.debug("left-hand,  moving right");
            x += 1;
            return RIGHT;
        } else if(x > after.x && dir != RIGHT) {
            log.debug("right-hand, moving left");
            x -= 1;
            return LEFT;
        } else throw new InvalidLocationException(this, dir, after);
    }

    @Override
    public String toString() {
        return String.format("%d,%d", x, y);
    }

    public BodyPart copy(){
        return new BodyPart(x, y);
    }

    public static class InvalidLocationException extends Exception {
        InvalidLocationException(BodyPart part, Direction2D dir, BodyPart after){
            super(String.format("%s cannot move %s after %s!", part, dir, after));
        }
    }
}
