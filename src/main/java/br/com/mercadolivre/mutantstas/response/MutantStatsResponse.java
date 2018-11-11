package br.com.mercadolivre.mutantstas.response;

public class MutantStatsResponse {

	private Double countMutantDna;
	private Double countHumanDna;
	private Double ratio;

    public Double getCountMutantDna() {
        return countMutantDna;
    }

    public void setCountMutantDna(Double countMutantDna) {
        this.countMutantDna = countMutantDna;
    }

    public Double getCountHumanDna() {
        return countHumanDna;
    }

    public void setCountHumanDna(Double countHumanDna) {
        this.countHumanDna = countHumanDna;
    }

    public Double getRatio() {
		return ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}
}
