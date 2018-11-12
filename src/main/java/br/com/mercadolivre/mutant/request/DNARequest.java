package br.com.mercadolivre.mutant.request;

public class DNARequest {

	private Long id;
	private String dna;
    private Boolean isMutant;


    public DNARequest(Boolean isMutant, String dna){
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

    public Boolean getIstMutant() {
        return isMutant;
    }

    public void setMutant(Boolean mutant) {
        isMutant = mutant;
    }
}
