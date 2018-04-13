package tdd;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.CombinableMatcher.both;
import static org.hamcrest.core.Is.is;

public class RangeTest {

    @Test
    public void beforeAndNotAfter() {
        Range range1 = new Range(2, 5);
        Range range2 = new Range(6, 7);
        assertThat(range1.isBefore(range2), is(true));
        assertThat(range1.isAfter(range2), is(false));
    }


    @Test
    public void notBeforeButAfter() {
        Range range1 = new Range(5, 8);
        Range range2 = new Range(1, 4);
        assertThat(range1.isBefore(range2), is(false));
        assertThat(range1.isAfter(range2), is(true));
    }


    @Test
    public void isConcurrentNotBeforeNotAfter() {
        Range range1 = new Range(5, 8);
        Range range2 = new Range(1, 5);
        Range range3 = new Range(8, 9);
        Range range4 = new Range(1, 10);
        Range range5 = new Range(6, 7);

        assertThat(range1.isConcurrent(range2), is(true));
        assertThat(range1.isBefore(range2), is(false));
        assertThat(range1.isAfter(range2), is(false));

        assertThat(range1.isConcurrent(range3), is(true));
        assertThat(range1.isBefore(range3), is(false));
        assertThat(range1.isAfter(range3), is(false));

        assertThat(range1.isConcurrent(range4), is(true));
        assertThat(range1.isBefore(range4), is(false));
        assertThat(range1.isAfter(range4), is(false));

        assertThat(range1.isConcurrent(range5), is(true));
        assertThat(range1.isBefore(range5), is(false));
        assertThat(range1.isAfter(range5), is(false));



    }

    @Test
    public void isNotConcurrent() {
        Range range1 = new Range(5, 8);
        Range range2 = new Range(1, 4);
        Range range3 = new Range(9, 9);

        assertThat(range1.isConcurrent(range2), is(false));
        assertThat(range1.isConcurrent(range3), is(false));


    }


    @Test
    public void constructionShouldWorkProperly() {
        Range range = new Range(5, 9);
        assertThat(range.getLowerBound(), is(equalTo(5L)));
        assertThat(range.getUpperBound(), is(equalTo(9L)));
    }


    @Test
    public void containsValues() {
        Range range1 = new Range(5, 8);

        assertThat(range1.contains(4), is(false));
        assertThat(range1.contains(5), is(true));
        assertThat(range1.contains(7), is(true));
        assertThat(range1.contains(8), is(true));
        assertThat(range1.contains(9), is(false));
    }


    @Test
    public void asListShouldContainAllNumbers() {
        List<Long> rangelist = new Range(5, 10).asList();
        assertThat(rangelist, both(hasItems(5L, 6L, 7L, 8L, 9L, 10L)).and(not(hasItems(3L, 4L, 11L, 12L))));
    }

    @Test
    public void asIteratorShouldIterateOverAllNumbers() {
        Range range = new Range(5, 10);
        Iterator<Long> longIterator = range.asIterator();
        while (longIterator.hasNext()) {
            assertThat(range.contains(longIterator.next()), is(true));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void startGreaterThanEndShouldThrowException() {
        new Range(7, 3);
    }
}