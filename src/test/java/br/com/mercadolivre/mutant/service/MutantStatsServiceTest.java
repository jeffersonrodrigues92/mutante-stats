package br.com.mercadolivre.mutant.service;

import br.com.mercadolivre.mutantstas.entity.DNAEntity;
import br.com.mercadolivre.mutantstas.response.MutantStatsResponse;

import java.text.DecimalFormat;
import java.util.List;

public class MutantStatsServiceTest {

    public MutantStatsResponse findAll(List<DNAEntity> response){

        Integer mutants = 0;
        Integer humans = 0;

        MutantStatsResponse mutantStatsResponse = new MutantStatsResponse();
        DecimalFormat df = new DecimalFormat("#.##");

        for(DNAEntity dna : response){
            if(dna.getIsMutant()){
                mutants += 1;
            }else
                humans +=1;
        }

        mutantStatsResponse.setCountHumanDna(humans);
        mutantStatsResponse.setCountMutantDna(mutants);

        if(humans != 0 && mutants != 0) {
            String ratio = df.format(new Double(mutants.doubleValue() / humans.doubleValue()));
            mutantStatsResponse.setRatio(Double.parseDouble(ratio.replace(",",".")));
        }else{
            mutantStatsResponse.setRatio(0.0);
        }

        return mutantStatsResponse;
    }
}
