package br.com.mercadolivre.mutant.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.lambda.runtime.Context;


import br.com.mercadolivre.mutant.request.MutantRequest;
import br.com.mercadolivre.mutant.response.MutantResponse;
import com.amazonaws.services.lambda.runtime.RequestHandler;;

public class MutantPostHandler implements RequestHandler<Map<String,List<String>>, MutantResponse> {

	private DynamoDB dynamoDb;
	private Regions REGION = Regions.US_EAST_1;


	public MutantResponse handleRequest(Map<String, List<String>> mutant, Context context) {

		initDynamoDbClient();
		MutantRequest mutantRequest = new MutantRequest();

		persistData(mutantRequest);
		
		
		mutantRequest.setId(new Date().getTime());
		mutantRequest.setMutants(3);
		mutantRequest.setHumans(10);

		MutantResponse response = new MutantResponse();

		response.setMessage("SUCCESS");
		response.setStatus(200);

		return response;
	}

	private PutItemOutcome persistData(MutantRequest personRequest) throws ConditionalCheckFailedException {
		return this.dynamoDb.getTable("mutante-mercado-livre").putItem(new PutItemSpec()
				.withItem(new Item().with("id", new Date().getTime()).with("mutants", 10).with("humans", 5)));
	}

	@SuppressWarnings("deprecation")
	private void initDynamoDbClient() {
		AmazonDynamoDBClient client = new AmazonDynamoDBClient().withRegion(REGION);
		this.dynamoDb = new DynamoDB(client);
	}

}