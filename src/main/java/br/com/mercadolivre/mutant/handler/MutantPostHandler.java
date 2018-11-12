package br.com.mercadolivre.mutant.handler;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import br.com.mercadolivre.mutant.exception.MutantException;
import br.com.mercadolivre.mutant.response.MutantResponse;
import br.com.mercadolivre.mutant.service.MutantService;;

public class MutantPostHandler implements RequestHandler<Map<String,String[]>, MutantResponse> {

	public MutantResponse handleRequest(Map<String, String[]> dnaRequest, Context context) {

	    String [] dnas = dnaRequest.get("dna");
	    MutantResponse response = new MutantResponse();
	    
	    Boolean isMutant = new MutantService().isMutant(dnas);

	    if(!isMutant){
            throw new MutantException("403-Forbidden");
        }

        response.setMessage("OK");
        response.setStatus(200);

		return response;
	}
}