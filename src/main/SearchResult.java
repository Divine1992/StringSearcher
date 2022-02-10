package main;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {
    private final String value;
    private final List<Offset> offsets = new ArrayList<>();

    public SearchResult(String value) {
        this.value = value;
    }

    public void addOffset(Offset offset) {
        this.offsets.add(offset);
    }

    public String getValue() {
        return value;
    }

    static class Offset {
        private final int lineOffset;
        private final int charOffset;

        public Offset(int lineOffset, int charOffset) {
            this.lineOffset = lineOffset;
            this.charOffset = charOffset;
        }

        @Override
        public String toString() {
            return "[lineOffset=" + lineOffset + ", charOffset=" + charOffset + "]";
        }
    }

    @Override
    public String toString() {
        return value + " --> " + offsets;
    }
}
