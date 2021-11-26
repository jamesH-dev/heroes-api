package com.dio.james.heroesapi.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@Getter
@Setter

@DynamoDBTable(tableName = "tab_heroes")
public class HeroesModel {

    @Id
    @DynamoDBHashKey(attributeName = "hero_id")
    private String heroId;

    @DynamoDBAttribute(attributeName = "hero_name")
    private String heroName;

    @DynamoDBAttribute(attributeName = "hero_universe")
    private String heroUniverse;

    @DynamoDBAttribute(attributeName = "hero_films")
    private Integer heroFilms;

    public HeroesModel(String heroId, String heroName, String heroUniverse, Integer heroFilms) {
        this.heroId = heroId;
        this.heroName = heroName;
        this.heroUniverse = heroUniverse;
        this.heroFilms = heroFilms;
    }
}
