package br.com.mercadolivre.mutant.repository;

import br.com.mercadolivre.mutant.request.DNARequest;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;

import java.util.Date;

public class MutantRepository {

    private static final String TABLE = "mutante-mercado-livre";

    private DynamoDB dynamoDb;
    private Regions REGION = Regions.US_EAST_1;

    public PutItemOutcome save(DNARequest dna) throws ConditionalCheckFailedException {
        initDynamoDbClient();
        return this.dynamoDb.getTable(TABLE).putItem(new PutItemSpec()
                .withItem(new Item().with("id", new Date().getTime()).with("isMutant", dna.getIstMutant()).with("dna", dna.getDna())));
    }

    @SuppressWarnings("deprecation")
    public void initDynamoDbClient() {
        AmazonDynamoDBClient client = new AmazonDynamoDBClient().withRegion(REGION);
        this.dynamoDb = new DynamoDB(client);
    }
}
