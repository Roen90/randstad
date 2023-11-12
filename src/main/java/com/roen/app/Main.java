package com.roen.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static List<String> data = new ArrayList<String>(){{
        add("5 3");
        add("1 2 100");
        add("2 5 100");
        add("3 4 100");
    }};

    public static void main(String[] args) {

        int[] info = Arrays.stream(data.get(0).split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = IntStream.generate(() -> 0).limit(info[0]).toArray();

        for (int i = 1; i <= info[1]; i++) {

            int[] infoTmp = Arrays.stream(data.get(i).split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = infoTmp[0]; j <= infoTmp[1]; j++) {
                result[j-1] = result[j-1] + infoTmp[2];
            }

        }

        System.out.println("MaxVal:" + Arrays.stream(result).max().getAsInt());

    }

}
