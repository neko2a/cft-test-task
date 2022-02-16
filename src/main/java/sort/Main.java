package sort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    private static String sortKey = "-a";
    private static String typeKey;
    private static String outputFileName;
    private static final ArrayList<String> inputFileNames = new ArrayList<>();

    public static void main(String[] args) {
        try {
            keyChecker(args);
            switch (typeKey) {
                case "-i" -> {
                    IntegerSort integerSort = new IntegerSort();
                    integerSort.mergeSort(sortKey, inputFileNames, outputFileName);
                }
                case "-s" -> {
                    StringSort stringSort = new StringSort();
                    stringSort.mergeSort(sortKey, inputFileNames, outputFileName);
                }
                default -> throw new IllegalArgumentException("Expected -s or -i, but got " + typeKey);
            }
        } catch (IllegalArgumentException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void keyChecker(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("Invalid number of arguments.");
        } else {
            int argIndex = 0;

            if (Objects.equals(args[argIndex], "-d") || Objects.equals(args[argIndex], "-a")) {
                sortKey = args[argIndex];
                argIndex++;
            }
            if (Objects.equals(args[argIndex], "-i") || Objects.equals(args[argIndex], "-s")) {
                typeKey = args[argIndex];
                argIndex++;
            } else {
                throw new IllegalArgumentException("Invalid " + argIndex + " key (" + args[argIndex] + ").");
            }
            outputFileName = args[argIndex];
            argIndex++;
            inputFileNames.addAll(Arrays.asList(args).subList(argIndex, args.length));
        }
    }
}
