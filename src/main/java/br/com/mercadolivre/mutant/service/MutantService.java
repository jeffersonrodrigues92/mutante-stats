package br.com.mercadolivre.mutant.service;

import br.com.mercadolivre.mutant.repository.MutantRepository;
import br.com.mercadolivre.mutant.request.DNABean;
import br.com.mercadolivre.mutant.utils.Utils;

import java.util.ArrayList;

public class MutantService {


    public static void main (String[] args){
        String[] dna= {"AAAAGT", "CCCCGA", "GGGATT", "AATTCC", "AGAGCG", "TCACTG"};
        Boolean flag =  new MutantService().isMutant(dna);
        System.out.println(flag);
    }

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

            DNABean dnaBean = Utils.verifyDNA(dnaToValidate);

        if(dnaBean.getIstMutant()) {
            new MutantRepository().save(dnaBean);
            return true;
        }

        new MutantRepository().save(dnaBean);
        return false;
    }
}

