package br.com.mercadolivre.mutant.service;

import br.com.mercadolivre.mutantstas.entity.DNAEntity;
import br.com.mercadolivre.mutantstas.repository.MutantStatsRepository;
import br.com.mercadolivre.mutantstas.response.MutantStatsResponse;

import java.util.List;

public class MutantStatsServiceTest {

    public MutantStatsResponse findAll(List<DNAEntity> response){

        Integer mutants = 0;
        Integer humans = 0;

        MutantStatsResponse mutantStatsResponse = new MutantStatsResponse();

        for(DNAEntity dna : response){
            if(dna.getIsMutant()){
                mutants += 1;
            }else
                humans +=1;
        }

        mutantStatsResponse.setCountHumanDna(humans);
        mutantStatsResponse.setCountMutantDna(mutants);
        mutantStatsResponse.setRatio(new Double(mutants.doubleValue() / humans.doubleValue()));

        return mutantStatsResponse;
    }
}
