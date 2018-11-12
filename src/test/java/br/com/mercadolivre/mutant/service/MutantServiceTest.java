package br.com.mercadolivre.mutant.service;

import java.util.ArrayList;

import br.com.mercadolivre.mutant.request.DNARequest;
import br.com.mercadolivre.mutant.utils.Utils;

public class MutantServiceTest {

    public Boolean isMutant(String[] dna) {

        ArrayList<String> dnaToValidate = new ArrayList<>();

        String horizontal = null;
        String vertical = null;
        String diagonal = null;

            for (int j = 0; j < dna.length; j++) {

                 horizontal = "";
                 vertical = "";
                 diagonal = "";

                for (int i = 0; i < dna.length; i++) {
                    horizontal = horizontal + dna[j].charAt(i);
                    vertical = vertical + dna[i].charAt(j);

                    if(i+j < dna.length) {
                        diagonal = diagonal + dna[i].charAt(i + j);
                    }
                }
                
                dnaToValidate.add(horizontal);
                dnaToValidate.add(vertical);
                dnaToValidate.add(diagonal);
            }

        DNARequest dnaBean = Utils.verifyDNA(dnaToValidate);

        if(dnaBean.getIstMutant()) {
            return true;
        }
        return false;
    }
}

