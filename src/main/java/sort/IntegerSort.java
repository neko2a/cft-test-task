package sort;


public class IntegerSort extends SortType<Integer> {

    @Override
    protected boolean compareByKey(Integer i1, Integer i2) {
        if (sortKey.equals("-d")) {
            return i1.compareTo(i2) >= 0;
        }
        return i1.compareTo(i2) <= 0;
    }

    @Override
    protected Integer takeElement(int index) {
        if (inputFiles.get(index).hasNextInt()) {
            int element = inputFiles.get(index).nextInt();

            if (lastWritten != null) {
                while (!compareByKey(lastWritten, element)) {
                    if (inputFiles.get(index).hasNextInt()) {
                        element = inputFiles.get(index).nextInt();
                    } else {
                        return null;
                    }
                }
            }
            return element;
        }
        return null;
    }
}
