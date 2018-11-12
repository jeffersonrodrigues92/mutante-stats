package br.com.mercadolivre.mutant;

import br.com.mercadolivre.mutantstas.entity.DNAEntity;
import br.com.mercadolivre.mutantstas.response.MutantStatsResponse;
import br.com.mercadolivre.mutantstas.service.MutantStatsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class MutantStatsTest {

	private List<DNAEntity> list = new ArrayList<>();

	@InjectMocks
	private MutantStatsService service;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testStatsMutant() {

		MutantStatsResponse  mutantResponse = service.findAll();
		assertThat(mutantResponse.getCountHumanDna(), equalTo(1));
		assertThat(mutantResponse.getCountMutantDna(), equalTo(1));
		assertThat(mutantResponse.getRatio(), equalTo(1.0));
	}
}
