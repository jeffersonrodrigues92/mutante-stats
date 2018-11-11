package br.com.mercadolivre.mutantstas.service;

import br.com.mercadolivre.mutantstas.entity.DNAEntity;
import br.com.mercadolivre.mutantstas.repository.MutantStatsRepository;
import br.com.mercadolivre.mutantstas.response.MutantStatsResponse;

import java.text.DecimalFormat;
import java.util.List;

public class MutantStatsService {

    public MutantStatsResponse findAll(){

        Double mutants = 0.0;
        Double humans = 0.0;

        MutantStatsResponse mutantStatsResponse = new MutantStatsResponse();
        DecimalFormat df = new DecimalFormat("#.##");


        List<DNAEntity> response = new MutantStatsRepository().findAll();

        for(DNAEntity dna : response){
            if(dna.getIsMutant()){
                mutants += 1;
            }else
                humans +=1;
        }

        mutantStatsResponse.setCountHumanDna(humans);
        mutantStatsResponse.setCountMutantDna(mutants);

        String ratioFormatted =  df.format(mutants / humans);
        mutantStatsResponse.setRatio(Double.parseDouble(ratioFormatted));

        return mutantStatsResponse;
    }
}
