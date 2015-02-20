package com.carpior.platformer.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.carpior.platformer.controller.LevelController;

public class Enemy extends Sprite {
    public Enemy(Vector2 position, int width, int height, String sheetPath) {
        super(position, width, height, sheetPath);

        animations.put("attack", spriteSheet.createAnimation(0, 1, 0.1f));
        animations.put("dead", spriteSheet.createAnimation(2, 3, 0.1f));

        currentAnimation = "dead";

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
