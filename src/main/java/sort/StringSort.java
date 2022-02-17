package sort;

import java.util.Scanner;

public class StringSort extends SortType<String> {

    @Override
    protected boolean hasNext(Scanner file) {
        return file.hasNextLine();
    }

    @Override
    protected String takeNext(Scanner file) {
        String line = file.nextLine();
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
