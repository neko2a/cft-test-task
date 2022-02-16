package sort;

public class StringSort extends SortType<String> {

    @Override
    protected boolean compareByKey(String i1, String i2) {
        if (sortKey.equals("-d")) {
            return i1.compareTo(i2) >= 0;
        }
        return i1.compareTo(i2) <= 0;
    }

    @Override
    protected String takeElement(int index) {
        if (inputFiles.get(index).hasNextLine()) {
            String line = inputFiles.get(index).nextLine();

            line = checkSpace(line);

            while (lastWritten != null && !compareByKey(lastWritten, line)) {
                if (inputFiles.get(index).hasNextLine()) {
                    line = checkSpace(inputFiles.get(index).nextLine());
                } else {
                    return null;
                }
            }
            return line;
        }
        return null;
    }

    String checkSpace(String line) {
        try {
            if (line.contains(" ")) {
                throw new IllegalArgumentException("The string '" + line + "' must not contain a space.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            String[] wrongString = line.split(" ");

            for (String s : wrongString) {
                if (s.length() > 0) {
                    return s;
                }
            }
        }
        return line;
    }
}
