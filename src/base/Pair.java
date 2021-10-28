package base;

import java.util.Objects;

public final class Pair<A, B> {
    private final A first;
    private final B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair[" +
                "first=" + first + ", " +
                "second=" + second + ']';
    }

    public A first() {
        return first;
    }

    public B second() {
        return second;
    }

    public boolean equals(Pair<A, B> obj) {
        if (obj == this) return true;
        return Objects.equals(this.first, obj.first) &&
                Objects.equals(this.second, obj.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }


}
