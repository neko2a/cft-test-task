package sort;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class IntegerSortTest extends TestCase {
    private static final String FILE_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\integer_test_cases\\";

    public void baseForTest(String path, String key) throws IOException {
        ArrayList<String> inputFileNames = new ArrayList<>();
        String actualOutputFileName = path + "actual_output.txt";
        String expectedOutputFileName = path + "expected_output.txt";
        File actualOutputFile = new File(actualOutputFileName);

        for (int i = 1; i <= 3; ++i) {
            inputFileNames.add(path + "in" + i + ".txt");
        }

        Scanner expectedOutput = new Scanner(new FileReader(expectedOutputFileName));

        IntegerSort integerSort = new IntegerSort();
        integerSort.mergeSort(key, inputFileNames, actualOutputFileName);

        Scanner actualOutput = new Scanner(new FileReader(actualOutputFile));

        while (expectedOutput.hasNextLine()) {
            Assertions.assertEquals(expectedOutput.nextLine(), actualOutput.nextLine());
        }

        actualOutput.close();
        expectedOutput.close();
        actualOutputFile.deleteOnExit();
    }

    @Test
    public void integerDecreaseTest() throws IOException {
        baseForTest(FILE_PATH + "decrease\\", "-d");
    }

    @Test
    public void integerIncreaseTest() throws IOException {
        baseForTest(FILE_PATH + "increase\\", "-a");
    }

    @Test
    public void integerNotSortedTest() throws IOException {
        baseForTest(FILE_PATH + "not_sorted\\", "-a");
    }


}
