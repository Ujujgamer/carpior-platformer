package com.carpior.platformer.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.carpior.platformer.controller.LevelController;

public class Player extends Sprite{

    public Player(Vector2 position, int width, int height, String sheetPath) {
        super(position, width, height, sheetPath);

        animations.put("walkRight", spriteSheet.createAnimation(9, 10, 0.1f));
        animations.put("walkLeft", spriteSheet.flipAnimation(animations.get("walkRight"), true, false));
        animations.put("stand", spriteSheet.createAnimation(0, 0, 0.1f));
        animations.put("climb", spriteSheet.createAnimation(1, 2, 0.2f));
        animations.put("duck", spriteSheet.createAnimation(2, 2, 0.1f));
        animations.put("duckFlip", spriteSheet.flipAnimation(animations.get("duck"), true, false));
        animations.put("hurt", spriteSheet.createAnimation(4, 4, 0.1f));
        animations.put("hurtFlip", spriteSheet.flipAnimation(animations.get("hurt"), true, false));
        animations.put("jumpRight", spriteSheet.createAnimation(5, 5, 0.1f));
        animations.put("jumpLeft", spriteSheet.flipAnimation(animations.get("jumpRight"), true, false));
        animations.put("idleRight", spriteSheet.createAnimation(6, 6, 0.1f));
        animations.put("idleLeft", spriteSheet.flipAnimation(animations.get("idleRight"), true, false));
        animations.put("swim", spriteSheet.createAnimation(7, 8, 0.2f));
        animations.put("swimFlip", spriteSheet.flipAnimation(animations.get("swim"), true, false));

        currentAnimation = "walkRight";

        //creating the properties for a rigid body
        BodyDef bodyDefinition = new BodyDef();
        bodyDefinition.type = BodyDef.BodyType.DynamicBody;
        bodyDefinition.position.set(position);

        physicsBody = LevelController.gameWorld.createBody(bodyDefinition);
        physicsBody.setUserData(this);

        //creates the body of the character
        PolygonShape rectangleShape = new PolygonShape();
        rectangleShape.setAsBox(this.width / 2, this.height / 2, new Vector2(this.width / 2, this.height / 2), 0f);

        PolygonShape sensorShape = new PolygonShape();
        sensorShape.setAsBox(this.width / 2.5f, this.height / 32, new Vector2(this.width / 2, 0), 0f);

        //attached it to the body
        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;

        fixtureDefinition.density = 0.7f;

        FixtureDef fixtureDefinitionSensor = new FixtureDef();
        fixtureDefinitionSensor.shape = sensorShape;
        fixtureDefinitionSensor.isSensor = true;

        //disposes the body
        physicsBody.createFixture(fixtureDefinition);
        physicsBody.createFixture(fixtureDefinitionSensor);
        physicsBody.setFixedRotation(true);
        rectangleShape.dispose();
        sensorShape.dispose();
    }

    public void draw(Batch spriteBatch) {
        super.draw(spriteBatch);
    }

    public void update(float deltaTime) {
        super.update(deltaTime);
    }
}
