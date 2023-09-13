public class DivideNConquer {
    public static int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public static int majorityElement(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }
        int mid = lo + (hi - lo) / 2;
        int left = majorityElement(nums, lo, mid);
        int right = majorityElement(nums, mid + 1, hi);
        if (left == right) {
            return left;
        }
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);
        return leftCount > rightCount ? left : right;
    }

    static String[] merge(String[] arr1, String[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        String[] arr3 = new String[n + m];
        int idx = 0, i = 0, j = 0;
        while (i < n && j < m) {
            if (isAlphabeticallySmaller(arr1[i], arr2[j])) {
                arr3[idx++] = arr1[i++];
            } else {
                arr3[idx++] = arr2[j++];
            }
        }
        while (i < n) {
            arr3[idx++] = arr1[i++];
        }
        while (j < m) {
            arr3[idx++] = arr2[j++];
        }
        return arr3;
    }

    static boolean isAlphabeticallySmaller(String str1, String str2) {
        if (str1.compareTo(str2) < 0) {
            return true;
        }
        return false;
    }

    public static String[] mergeSort(String[] arr, int lo, int hi) {
        if (lo == hi) {
            String[] ans = { arr[lo] };
            return ans;
        }
        int mid = lo + (hi - lo) / 2;
        String[] arr1 = mergeSort(arr, lo, mid);
        String[] arr2 = mergeSort(arr, mid + 1, hi);
        return merge(arr1, arr2);
    }

    static int countInversion(int[] arr, int left, int mid, int right) {
        int i = left, j = mid, k = 0, invCount = 0;
        int[] temp = new int[(right - left + 1)];
        while (i < mid && j <= right) {
            if (arr[i] <= arr[j++]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i);
            }
        }
        while (i < mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }
        return invCount;
    }

    public static int getInversions(int[] arr, int left, int right) {
        int invCount = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            invCount = getInversions(arr, left, mid);
            invCount += getInversions(arr, mid + 1, right);
            invCount += countInversion(arr, left, mid + 1, right);
        }
        return invCount;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(nums, 0, nums.length - 1));
        String[] arr = { "sun", "earth", "mars", "mercury" };
        String[] a = mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }
}