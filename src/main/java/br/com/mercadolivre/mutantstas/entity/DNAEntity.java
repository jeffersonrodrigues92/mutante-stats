package br.com.mercadolivre.mutantstas.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "mutante-mercado-livre")
public class DNAEntity {

    @DynamoDBHashKey(attributeName = "id")
	private Long id;
	private String dna;
    private Boolean isMutant;


    public DNAEntity(){

    }

    public DNAEntity(Boolean isMutant, String dna){
        this.isMutant = isMutant;
        this.dna = dna;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getDna() {
        return dna;
    }

    public void setDna(String dna) {
        this.dna = dna;
    }

    public Boolean getIsMutant() {
        return isMutant;
    }

    public void setIsMutant(Boolean mutant) {
        isMutant = mutant;
    }
}
