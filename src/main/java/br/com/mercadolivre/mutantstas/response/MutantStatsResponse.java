package br.com.mercadolivre.mutantstas.response;

public class MutantStatsResponse {

	private Integer countMutantDna;
	private Integer countHumanDna;
	private Double ratio;


	public MutantStatsResponse(){

    }

    public MutantStatsResponse(Integer countHumanDna, Integer countMutantDna, Double ratio){
	    this.countHumanDna = countHumanDna;
	    this.countMutantDna = countMutantDna;
	    this.ratio = ratio;
    }

    public Integer getCountMutantDna() {
        return countMutantDna;
    }

    public void setCountMutantDna(Integer countMutantDna) {
        this.countMutantDna = countMutantDna;
    }

    public Integer getCountHumanDna() {
        return countHumanDna;
    }

    public void setCountHumanDna(Integer countHumanDna) {
        this.countHumanDna = countHumanDna;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }
}
