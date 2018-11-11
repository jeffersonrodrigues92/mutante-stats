package br.com.mercadolivre.mutantstas.handler;

import br.com.mercadolivre.mutantstas.response.MutantStatsResponse;
import br.com.mercadolivre.mutantstas.service.MutantStatsService;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;

public class MutantStatsHandler implements RequestHandler<Map<String,Object>,MutantStatsResponse> {

    public MutantStatsResponse handleRequest(Map<String, Object> input, Context context) {

        MutantStatsResponse mutantResponse = new MutantStatsService().findAll();

        return mutantResponse;
    }
}
