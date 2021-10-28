package base;

public record Pair<A, B>(A first, B second) {
    @Override
    public String toString() {
        return "Pair[" +
                "first=" + first + ", " +
                "second=" + second + ']';
    }

}
