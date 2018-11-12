package br.com.mercadolivre.mutant.utils;

import br.com.mercadolivre.mutant.request.DNARequest;

import java.util.List;

public class Utils {

    private static final String DNA_AAAA = "AAAA";
    private static final String DNA_CCCC = "CCCC";
    private static final String DNA_GGGG = "GGGG";
    private static final String DNA_TTTT = "TTTT";

    public static DNARequest verifyDNA(List<String> dna){

        DNARequest dnaBean = null;

        for(String dnaUnique : dna){
            if (dnaUnique.contains(DNA_AAAA) || dnaUnique.contains(DNA_CCCC) || dnaUnique.contains(DNA_GGGG) || dnaUnique.contains(DNA_TTTT) )
                return new DNARequest(true, dnaUnique);
            dnaBean = new DNARequest(false, dnaUnique);
        }

        return dnaBean;
    }
}
