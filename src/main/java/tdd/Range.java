package tdd;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Range implements IRange {
    private long l;
    private long r;

    public Range(long a, long b) {
        if (a > b) throw new IllegalArgumentException("start is greater than end");
        l = a;
        r = b;
    }

    @Override
    public boolean isBefore(IRange otherRange) {
        return r < otherRange.getLowerBound();
    }

    @Override
    public boolean isAfter(IRange otherRange) {
        return l > otherRange.getUpperBound();
    }

    @Override
    public boolean isConcurrent(IRange otherRange) {
        return l <= otherRange.getUpperBound() && otherRange.getLowerBound() <= r;
    }

    @Override
    public long getLowerBound() {
        return l;
    }

    @Override
    public long getUpperBound() {
        return r;
    }

    @Override
    public boolean contains(long value) {
        return l <= value && value <= r;
    }

    @Override
    public List<Long> asList() {
        return LongStream.rangeClosed(l, r).boxed().collect(Collectors.toList());
    }

    @Override
    public Iterator<Long> asIterator() {
        return LongStream.rangeClosed(l, r).boxed().iterator();
    }
}
