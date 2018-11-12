package br.com.mercadolivre.mutant;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.mercadolivre.mutant.service.MutantServiceTest;

@RunWith(MockitoJUnitRunner.class)
public class MutantTest {

    private final String[] horizontal = {"GGGGTA", "TTTAAA", "CCAATT", "AGAGCG", "AATTCC", "CTGTCA"};
    private final String[] vertical = {"TGGCGT", "TGGCGA", "TGAATT", "TATACT", "ACCGAT", "TTCCAT"};
    private final String[] diagonal = {"TGGAGT", "TTGCGA", "AGTGTT", "TATCGG", "AGTGTA", "TCCCAT"};
    private final String[] humanDna = {"WWQQQW", "DDFFFD", "LLXXXL", "SSVSVV", "HHJJJH", "PPOPPP"};

    @InjectMocks
    private MutantServiceTest service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void mutantHorizontal() {
        Boolean isMutant =  service.isMutant(horizontal);
        assertEquals(isMutant , true);
    }

    @Test
    public void mutantVertical() {
        Boolean isMutant  = service.isMutant(vertical);
        assertEquals(isMutant , true);
    }

    @Test
    public void mutantDiagonal() {
        Boolean isMutant = service.isMutant(diagonal);
        assertEquals(isMutant , true);
    }

    @Test
    public void verifyIsHuman() {
        Boolean isHuman = service.isMutant(humanDna);
        assertEquals(isHuman , false);
    }
    
}
