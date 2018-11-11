package br.com.mercadolivre.mutant.handler;

import java.util.Map;

import br.com.mercadolivre.mutant.exception.MutantException;
import br.com.mercadolivre.mutant.service.MutantService;
import com.amazonaws.services.lambda.runtime.Context;

import br.com.mercadolivre.mutant.response.MutantResponse;
import com.amazonaws.services.lambda.runtime.RequestHandler;;

public class MutantPostHandler implements RequestHandler<Map<String,String[]>, MutantResponse> {


	public MutantResponse handleRequest(Map<String, String[]> dnaRequest, Context context) {

	    String [] dnas = dnaRequest.get("dna");

	    Boolean isMutant = new MutantService().isMutant(dnas);

	    MutantResponse response = new MutantResponse();

	    if(!isMutant){
            throw new MutantException("403-Forbidden");
        }

        response.setMessage("OK");
        response.setStatus(200);

		return response;
	}



}