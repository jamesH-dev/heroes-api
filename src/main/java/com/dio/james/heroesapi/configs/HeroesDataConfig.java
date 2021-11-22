package com.dio.james.heroesapi.configs;


import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

import static com.dio.james.heroesapi.constants.HeroesConstant.ENDPOINT_DYNAMO;
import static com.dio.james.heroesapi.constants.HeroesConstant.REGION_DYNAMO;

public class HeroesDataConfig {
    public static void main(String[] args) throws Exception{
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("tab_heroes");
        Item hero = new Item()
                .withPrimaryKey("hero_id", "1")
                .withString("hero_name", "Wonder Woman")
                .withString("hero_universe", "DC Comics")
                .withNumber("hero_films", 4);
        PutItemOutcome outcome = table.putItem(hero);

    }
}
