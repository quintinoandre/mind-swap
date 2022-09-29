package academy.mindswap;

import java.util.*;

public final class DupeFinder<T> {
    private List<T> tList;

    public DupeFinder(List<T> tList) {
        this.tList = tList;
    }

    public int checkDupes() {
        Set<T> set = new HashSet<>(tList);

        return tList.size() - set.size();
    }

    public List<T> getDupes() {
        Set<T> set = new HashSet<>();
        List<T> listToBeReturned = new ArrayList<>(0);

        for (T t : tList) {
            boolean duplicated = !set.add(t);

            if (duplicated) {
                listToBeReturned.add(t);
            }
        }

        return listToBeReturned;
    }

    public Collection<T> sortedDupes() {
        return new TreeSet<>(getDupes());
    }
}
