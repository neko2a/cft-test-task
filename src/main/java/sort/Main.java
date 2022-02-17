package sort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        try {
            final SortingArgs sortingArgs = new SortingArgs();
            keyChecker(sortingArgs, args);
            switch (sortingArgs.getTypeKey()) {
                case "-i" -> {
                    IntegerSort integerSort = new IntegerSort();
                    integerSort.mergeSort(sortingArgs.getSortKey(), sortingArgs.getInputFileNames(), sortingArgs.getOutputFileName());
                }
                case "-s" -> {
                    StringSort stringSort = new StringSort();
                    stringSort.mergeSort(sortingArgs.getSortKey(), sortingArgs.getInputFileNames(), sortingArgs.getOutputFileName());
                }
                default -> throw new IllegalArgumentException("Expected -s or -i, but got " + sortingArgs.getTypeKey());
            }
        } catch (IllegalArgumentException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void keyChecker(SortingArgs sortingArgs, String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("Invalid number of arguments.");
        } else {
            int argIndex = 0;

            if (Objects.equals(args[argIndex], "-d") || Objects.equals(args[argIndex], "-a")) {
                sortingArgs.setSortKey(args[argIndex]);
                argIndex++;
            }
            if (Objects.equals(args[argIndex], "-i") || Objects.equals(args[argIndex], "-s")) {
                sortingArgs.setTypeKey(args[argIndex]);
                argIndex++;
            } else {
                throw new IllegalArgumentException("Invalid " + argIndex + " key (" + args[argIndex] + ").");
            }
            sortingArgs.setOutputFileName(args[argIndex]);
            argIndex++;
            sortingArgs.setInputFileNames(new ArrayList<>(Arrays.asList(args).subList(argIndex, args.length)));
        }
    }
}
