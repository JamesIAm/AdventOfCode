package y2023.Day7.Types;

public abstract class Type implements Comparable<Type> {
    public abstract int getOrdinal();

//    public abstract String getCardValuesAsString();

    @Override
    public int compareTo(Type other) {
//        int ordinalComparison = getOrdinal() - other.getOrdinal();
//        if (ordinalComparison != 0) {
//            return ordinalComparison;
//        } else {
//            return getCardValuesAsString().compareTo(other.getCardValuesAsString());
//        }
        return getOrdinal() - other.getOrdinal();
    }

}
