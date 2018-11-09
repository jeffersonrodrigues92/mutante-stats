package br.com.mercadolivre.mutant.request;

public class MutantRequest {

	private Long id;
	private Integer humans;
	private Integer mutants;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getHumans() {
		return humans;
	}

	public void setHumans(Integer humans) {
		this.humans = humans;
	}

	public Integer getMutants() {
		return mutants;
	}

	public void setMutants(Integer mutants) {
		this.mutants = mutants;
	}

}
