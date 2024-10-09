package org.altice;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.math.BigInteger;
import java.util.regex.Pattern;

/**
 * Recurso REST para fornecer valores da sequência labseq através de um endpoint.
 */
@Path("/labseq")
public class LabseqResource {

    @Inject
    private LabseqCalculator calculator;

    // Expressão para verificar se o parâmetro é um inteiro não negativo
    private static final Pattern INTEGER_PATTERN = Pattern.compile("^\\d+$");

    /**
     * Retorna o valor da sequência labseq para um índice específico.
     *
     * @param nStr índice da sequência como String para validação de formato
     * @return valor da sequência no índice especificado ou erro 400 se o índice for inválido
     */
    @GET
    @Path("/{n}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getLabseq(@PathParam("n") String nStr) {
        // Verifica se a entrada é um número inteiro não negativo
        if (!isNonNegativeInteger(nStr)) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("O índice deve ser um número inteiro não negativo.")
                    .build();
        }

        int n = Integer.parseInt(nStr);
        BigInteger result = calculator.calculateLabseq(n);
        return Response.ok(String.valueOf(result)).build();
    }

    /**
     * Verifica se uma string representa um número inteiro não negativo.
     *
     * @param value a string a ser verificada
     * @return true se a string representa um inteiro não negativo, false caso contrário
     */
    private boolean isNonNegativeInteger(String value) {
        return INTEGER_PATTERN.matcher(value).matches();
    }
}
