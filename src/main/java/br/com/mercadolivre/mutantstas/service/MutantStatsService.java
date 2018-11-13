package br.com.mercadolivre.mutantstas.service;

import br.com.mercadolivre.mutantstas.entity.DNAEntity;
import br.com.mercadolivre.mutantstas.repository.MutantStatsRepository;
import br.com.mercadolivre.mutantstas.response.MutantStatsResponse;

import java.util.List;
import java.util.Objects;

public class MutantStatsService {

    public MutantStatsResponse findAll(){

        Integer mutants = 0;
        Integer humans = 0;

        MutantStatsResponse mutantStatsResponse = new MutantStatsResponse();

        List<DNAEntity> response = new MutantStatsRepository().findAll();

        for(DNAEntity dna : response){
            if(dna.getIsMutant()){
                mutants += 1;
            }else
                humans +=1;
        }

        mutantStatsResponse.setCountHumanDna(humans);
        mutantStatsResponse.setCountMutantDna(mutants);

        if(humans != 0 && mutants != 0) {
            mutantStatsResponse.setRatio(new Double(mutants.doubleValue() / humans.doubleValue()));
        }

        return mutantStatsResponse;
    }
}
