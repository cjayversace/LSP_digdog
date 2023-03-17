package org.howard.edu.lsp.midterm.problem51;

public class IntegerRange implements Range {
    private final int lower;
    private final int upper;

    public IntegerRange(int lower, int upper) {
        this.lower = lower; // set the lower bound of the range
        this.upper = upper; // set the upper bound of the range
    }

    @Override
    public int get_lower() {
        return lower; // return the lower bound of the range
    }

    @Override
    public int get_upper() {
        return upper; // return the upper bound of the range
    }

    @Override
    public boolean contains(int value) {
        return value >= lower && value <= upper; // checks if the value is within the range
    }

    @Override
    public boolean overlaps(Range other) throws EmptyRangeException {
        if (other == null) {
            throw new EmptyRangeException("The range is empty"); // throw an exception if the other range is null
        }

        int otherLower = other.get_lower(); // get the lower bound of the other range
        int otherUpper = other.get_upper(); // get the upper bound of the other range

        if (lower >= otherLower && upper <= otherUpper) { // check if the range is completely within the other range
            return true;
        } else if (lower <= otherLower && upper > otherLower) { // check if the range partially overlaps with the other range
            return true;
        } else {
            return false; // otherwise, the ranges don't overlap
        }
    }

    @Override
    public int size() {
        return upper - lower; // calculate the size of the range
    }
}
