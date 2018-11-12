package br.com.mercadolivre.mutant;

import br.com.mercadolivre.mutant.service.MutantStatsServiceTest;
import br.com.mercadolivre.mutantstas.entity.DNAEntity;
import br.com.mercadolivre.mutantstas.repository.MutantStatsRepository;
import br.com.mercadolivre.mutantstas.response.MutantStatsResponse;
import br.com.mercadolivre.mutantstas.service.MutantStatsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class MutantStatsTest {

	@InjectMocks
	private MutantStatsService service;

	@InjectMocks
	private MutantStatsServiceTest serviceTest;

	@InjectMocks
	private MutantStatsRepository repositoryTest;

	private List<DNAEntity> mutantRepositoryResponse;

	private MutantStatsResponse mutantStatsResponse;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mutantRepositoryResponse = repositoryTest.findAll();
		this.mutantStatsResponse = serviceTest.findAll(mutantRepositoryResponse);
	}

	@Test
	public void testStatsMutant() {
		MutantStatsResponse  mutantResponse = service.findAll();
		assertThat(mutantResponse.getCountHumanDna(), equalTo(mutantStatsResponse.getCountHumanDna()));
		assertThat(mutantResponse.getCountMutantDna(), equalTo(mutantStatsResponse.getCountMutantDna()));
		assertThat(mutantResponse.getRatio(), equalTo(mutantStatsResponse.getRatio()));
	}
}
