package main;

import java.util.List;

public class Main {

    private static final String DEFAULT_PATH = "src/resources/big.txt";
    private static final String DEFAULT_INPUT = "James,John,Robert,Michael,William,David,Richard,Charles,Joseph," +
            "Thomas,Christopher,Daniel,Paul,Mark,Donald,George,Kenneth,Steven,Edward,Brian,Ronald,Anthony,Kevin," +
            "Jason,Matthew,Gary,Timothy,Jose,Larry,Jeffrey,Frank,Scott,Eric,Stephen,Andrew,Raymond,Gregory,Joshua," +
            "Jerry,Dennis,Walter,Patrick,Peter,Harold,Douglas,Henry,Carl,Arthur,Ryan,Roger";

    public static void main(String[] args) {
        Aggregator aggregator = new Aggregator(DEFAULT_INPUT, DEFAULT_PATH);
        List<SearchResult> results = aggregator.search();
        System.out.println(results);
    }
}
