package sort;

import java.util.ArrayList;

public class SortingArgs {
    private String sortKey = "-a";
    private String typeKey;
    private String outputFileName;
    private ArrayList<String> inputFileNames = new ArrayList<>();

    public String getSortKey() {
        return sortKey;
    }

    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    public String getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(String typeKey) {
        this.typeKey = typeKey;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public ArrayList<String> getInputFileNames() {
        return inputFileNames;
    }

    public void setInputFileNames(ArrayList<String> inputFileNames) {
        this.inputFileNames = inputFileNames;
    }
}
