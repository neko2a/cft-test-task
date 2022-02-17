package sort;

import java.util.Scanner;

public class IntegerSort extends SortType<Integer> {

    @Override
    protected boolean hasNext(Scanner file) {
        return file.hasNextInt();
    }

    @Override
    protected Integer takeNext(Scanner file) {
        return file.nextInt();
    }
}
