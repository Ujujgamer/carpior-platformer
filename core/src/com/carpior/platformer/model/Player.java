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

        animations.put("walkRight", spriteSheet.createAnimation(53, 54, 0.1f));
        animations.put("walkLeft", spriteSheet.flipAnimation(animations.get("walkRight"), true, false));
        animations.put("stand", spriteSheet.createAnimation(50, 50, 0.1f));
        animations.put("climb", spriteSheet.createAnimation(45, 46, 0.2f));
        animations.put("duck", spriteSheet.createAnimation(47, 47, 0.1f));
        animations.put("duckFlip", spriteSheet.flipAnimation(animations.get("duck"), true, false));
        animations.put("hurt", spriteSheet.createAnimation(48, 48, 0.1f));
        animations.put("hurtFlip", spriteSheet.flipAnimation(animations.get("hurt"), true, false));
        animations.put("jumpRight", spriteSheet.createAnimation(49, 49, 0.1f));
        animations.put("jumpLeft", spriteSheet.flipAnimation(animations.get("jumpRight"), true, false));
        animations.put("idle", spriteSheet.createAnimation(44, 44, 0.1f));
        animations.put("idleFlip", spriteSheet.flipAnimation(animations.get("idle"), true, false));
        animations.put("swim", spriteSheet.createAnimation(51, 52, 0.2f));
        animations.put("swimFlip", spriteSheet.flipAnimation(animations.get("swim"), true, false));

        currentAnimation = "idle";

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
