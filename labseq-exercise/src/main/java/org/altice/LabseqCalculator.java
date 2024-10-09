package org.altice;

import jakarta.inject.Singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Calcula valores da sequência labseq utilizando uma cache para armazenar
 * valores previamente calculados e melhorar a eficiência.
 */
@Singleton
public class LabseqCalculator {

    // Cache para armazenar valores previamente calculados da sequência
    private final Map<Integer, Long> cache;

    // Valores iniciais da sequência
    private static final long INITIAL_VALUE_L0 = 0L;
    private static final long INITIAL_VALUE_L1 = 1L;
    private static final long INITIAL_VALUE_L2 = 0L;
    private static final long INITIAL_VALUE_L3 = 1L;

    public LabseqCalculator() {
        cache = new ConcurrentHashMap<>();
        // Valores iniciais da sequência
        cache.put(0, INITIAL_VALUE_L0);
        cache.put(1, INITIAL_VALUE_L1);
        cache.put(2, INITIAL_VALUE_L2);
        cache.put(3, INITIAL_VALUE_L3);
    }

    /**
     * Calcula o valor da sequência labseq para o índice especificado.
     *
     * @param n índice da sequência
     * @return valor da sequência no índice n
     */
    public long calculateLabseq(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("O índice não pode ser negativo.");
        }

        // Retorna o valor do cache se já estiver calculado
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        // Calcula recursivamente e armazena no cache
        long result = calculateLabseq(n - 4) + calculateLabseq(n - 3);
        cache.put(n, result);
        return result;
    }
}
