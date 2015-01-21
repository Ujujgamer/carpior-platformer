package com.carpior.platformer.model;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.carpior.platformer.controller.LevelController;

public class Bodies {
    public static void createBody(MapObject mapObject) {
        String bodyType = mapObject.getProperties().get("type").toString();

        if(bodyType.equalsIgnoreCase("solid")) {
            RectangleMapObject rectangleObject = (RectangleMapObject)mapObject;
            BodyDef bodyDefinition = new BodyDef();
            bodyDefinition.type = BodyDef.BodyType.StaticBody;
            bodyDefinition.position.set(rectangleObject.getRectangle().x * LevelController.UNIT_SCALE,
                    rectangleObject.getRectangle().y * LevelController.UNIT_SCALE);

            Body physicsBody = LevelController.gameWorld.createBody(bodyDefinition);
            PolygonShape rectangleShape = new PolygonShape();
            rectangleShape.setAsBox(rectangleObject.getRectangle().width * LevelController.UNIT_SCALE / 2f,
                    rectangleObject.getRectangle().height * LevelController.UNIT_SCALE / 2f,
                    new Vector2(rectangleObject.getRectangle().width * LevelController.UNIT_SCALE / 2f, rectangleObject.getRectangle().height * LevelController.UNIT_SCALE / 2f),
                    0f);

            FixtureDef fixtureDefinition = new FixtureDef();
            fixtureDefinition.shape = rectangleShape;

            physicsBody.createFixture(fixtureDefinition);
            rectangleShape.dispose();
        }

        if(bodyType.equalsIgnoreCase("slope")) {
            PolygonMapObject polygonObject = (PolygonMapObject)mapObject;
            BodyDef bodyDefinition = new BodyDef();
            bodyDefinition.type = BodyDef.BodyType.StaticBody;
            bodyDefinition.position.set(polygonObject.getPolygon().getX() * LevelController.UNIT_SCALE,
                    polygonObject.getPolygon().getY() * LevelController.UNIT_SCALE);

            Body physicsBody = LevelController.gameWorld.createBody(bodyDefinition);
            PolygonShape polygonShape = new PolygonShape();
            polygonShape.set(polygonObject.getPolygon().getVertices());
            float[] transformedVertices = new float[polygonObject.getPolygon().getVertices().length];

            for(int index = 0; index < transformedVertices.length; index++) {
                transformedVertices[index] = polygonObject.getPolygon().getVertices()[index] * LevelController.UNIT_SCALE;
            }

            polygonShape.set(transformedVertices);

            FixtureDef fixtureDefinition = new FixtureDef();
            fixtureDefinition.shape = polygonShape;

            physicsBody.createFixture(fixtureDefinition);
            polygonShape.dispose();
        }

    }
}
