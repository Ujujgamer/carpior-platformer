package com.carpior.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.carpior.platformer.model.Player;

public class PlayerController {
    public static Player player;

    public static String movementAction;
    public static String specialAction;

    private static final float VELOCITY = 1f;
    private static final float MAX_VELOCITY = 5f;
    private static final float JUMP_VELOCITY = 7f;

    private enum State {
        Idle, Walk, Run, Swim, Duck, Stand, Jump, Climb, Hurt
    }

    private static State playerState;

    public static void initializeController() {
        player = new Player(new Vector2(2, 5), 70, 100, "img/aliens.png");
        movementAction = "";
        specialAction = "";
    }

    public static void update(float deltaTime) {
        handleInput();
        player.update(deltaTime);
    }

    private static void handleInput() {
        Vector2 velocity = player.physicsBody.getLinearVelocity();
        Vector2 position = player.physicsBody.getPosition();

        if(Math.abs(velocity.x) > MAX_VELOCITY) {
            velocity.x = Math.signum(velocity.x) * MAX_VELOCITY;
            player.physicsBody.setLinearVelocity(velocity.x, velocity.y);
        }

        if(Math.abs(velocity.y) > JUMP_VELOCITY) {
            velocity.y = Math.signum(velocity.y) * JUMP_VELOCITY;
            player.physicsBody.setLinearVelocity(velocity.x, velocity.y);
        }

        if(movementAction.equalsIgnoreCase("right")) {
            player.physicsBody.applyLinearImpulse(VELOCITY, 0f, position.x, position.y, true);
            player.direction = "right";
        }

        if(movementAction.equalsIgnoreCase("left")) {
            player.physicsBody.applyLinearImpulse(-VELOCITY, 0f, position.x, position.y, true);
            player.direction = "left";
        }

        if(specialAction.equalsIgnoreCase("jump")) {
            player.physicsBody.applyLinearImpulse(0, 0.5f, position.x, position.y, true);
        }

        if(Math.abs(velocity.x) > 0) {
            playerState = State.Walk;
        }
        else {
            playerState = State.Idle;
        }

        setCurrentAnimation();
    }

    private static void setCurrentAnimation() {
        if(player.direction.equals("right")) {
            setRightAnimation();
        }
        if(player.direction.equals("left")) {
            setLeftAnimation();
        }
        if (player.direction.equals("jump")) {
            setJumpAnimation();
        }
    }

    private static void setRightAnimation() {
        if(playerState == State.Walk) {
            player.currentAnimation = "walkRight";
        }
        else if(playerState == State.Idle) {
            player.currentAnimation = "idleRight";
        }

    }

    private static void setLeftAnimation() {
        if(playerState == State.Walk) {
            player.currentAnimation = "walkLeft";
        }
        else if(playerState == State.Idle) {
            player.currentAnimation = "idleLeft";
        }
    }
    private static void setJumpAnimation() {
        if(playerState == State.Jump) {
            player.currentAnimation = "jumpRight";
        }
        else if(playerState == State.Idle) {
            player.currentAnimation = "jumpLeft";
        }
    }
}