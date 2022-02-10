package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.function.Supplier;

public class Matcher implements Supplier<SearchResult> {
    private final String path;
    private final SearchResult searchResult;

    private int lineOffset = 0;
    private int charOffset = 0;

    public Matcher(String searchVal, String path) {
        this.path = path;
        searchResult = new SearchResult(searchVal);
    }

    @Override
    public SearchResult get() {
        try(FileInputStream fis = new FileInputStream(path);
            Scanner sc = new Scanner(fis, StandardCharsets.UTF_8)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                findOffsets(line);
                lineOffset += 1;
                charOffset += line.length();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searchResult;
    }

    private void findOffsets(String line) {
        int index = line.indexOf(searchResult.getValue());
        while (index > -1) {
            searchResult.addOffset(new SearchResult.Offset(lineOffset, charOffset + index));
            index = line.indexOf(searchResult.getValue(), index + 1);
        }
    }


}
