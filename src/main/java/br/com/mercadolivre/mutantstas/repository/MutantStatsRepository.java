package br.com.mercadolivre.mutantstas.repository;

import br.com.mercadolivre.mutantstas.entity.DNAEntity;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;

import java.util.ArrayList;
import java.util.List;

public class MutantStatsRepository {

    private AmazonDynamoDB amazonDynamoDb;
    private Regions REGION = Regions.US_EAST_1;

    public List<DNAEntity> findAll() throws ConditionalCheckFailedException {

        initDynamoDbClient();

        DynamoDBMapper mapper = new DynamoDBMapper(amazonDynamoDb);
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();

        List<DNAEntity> dnaEntities = new ArrayList<>();

        List<DNAEntity> dnaResponse = mapper.scan(DNAEntity.class, scanExpression);

        for(DNAEntity dna : dnaResponse){
            dnaEntities.add(dna);
        }

        return dnaEntities;
    }

    @SuppressWarnings("deprecation")
    public void initDynamoDbClient() {
        this.amazonDynamoDb = AmazonDynamoDBClientBuilder.standard().withRegion(REGION).build();

    }
}
