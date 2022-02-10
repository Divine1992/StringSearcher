package main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Aggregator {
    private final String input;
    private final String path;

    private static final String SEPARATOR = ",";

    public Aggregator(String input, String path) {
        this.input = input;
        this.path = path;
    }

    public List<SearchResult> search() {
        return makeTasks().stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    private List<CompletableFuture<SearchResult>> makeTasks() {
        String[] searchValues = input.split(SEPARATOR);
        List<CompletableFuture<SearchResult>> tasks = new ArrayList<>(searchValues.length);
        for (String val: searchValues) {
            CompletableFuture<SearchResult> task = CompletableFuture.supplyAsync(() ->
                    new Matcher(val, path).get());
            tasks.add(task);
        }
        return tasks;
    }
}
