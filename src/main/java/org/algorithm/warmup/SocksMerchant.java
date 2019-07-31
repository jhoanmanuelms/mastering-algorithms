package org.algorithm.warmup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SocksMerchant {
    public static void main(String[] args) {
        System.out.println(sockMerchant(7, new int[] {1, 2, 1, 2, 1, 3, 2}));
        System.out.println(sockMerchant(9, new int[] {10, 20, 20, 10, 10, 30, 50, 10, 20}));
    }

    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> classifier = new HashMap<>();

        Arrays.stream(ar).forEach(sock -> {
            classifier.putIfAbsent(sock, 0);
            classifier.put(sock, classifier.get(sock) + 1);
        });

        return classifier
            .values()
            .stream()
            .reduce(0, (pairs, socks) -> pairs + (socks / 2));
    }
}
