package homework1;

public class BinarySearch {
    public static int[] search(Entry[] entries, String searchableName) {
        int left = 0;
        int right = entries.length - 1;
        int[] result = {-1, -1};

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = entries[mid].getName().compareTo(searchableName);

            if (cmp == 0) {
                result[0] = findStart(entries, searchableName, left, mid);
                result[1] = findEnd(entries, searchableName, mid, right);
                return result;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[0];
    }

    private static int findStart(Entry[] entries, String searchableName, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (entries[mid].getName().equals(searchableName)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int findEnd(Entry[] entries, String searchableName, int left, int right) {
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (entries[mid].getName().equals(searchableName)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
