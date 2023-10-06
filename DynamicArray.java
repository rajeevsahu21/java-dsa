import java.util.ArrayList;

class DynamicArray {
    static int storeWater(ArrayList<Integer> height) {
        long maxWater = 0;
        // for (int i = 0; i < height.size(); i++) {
        // for (int j = i + 1; j < height.size(); j++) {
        // int hi = Math.min(height.get(j), height.get(i));
        // int width = j - i;
        // maxWater = Math.max(maxWater, width * hi);
        // }
        // }

        int left = 0, right = height.size() - 1;
        while (left < right) {
            int width = right - left;
            int ht = Math.min(height.get(left), height.get(right));
            maxWater = Math.max(maxWater, ht * width);
            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        return (int) maxWater;
    }

    static boolean pairSum1(ArrayList<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            if (list.get(left) + list.get(right) == target) {
                return true;
            }
            if (list.get(left) + list.get(right) < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    static boolean pairSum2(ArrayList<Integer> list, int target) {
        int bp = -1, n = list.size();
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }
        int left = bp + 1, right = bp;
        while (left != right) {
            if (list.get(left) + list.get(right) == target) {
                return true;
            }
            if (list.get(left) + list.get(right) < target) {
                left = (left + 1) % n;
            } else {
                right = (n + right - 1) % n;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<Integer>();
        height.add(11);
        height.add(15);
        height.add(6);
        height.add(8);
        height.add(9);
        height.add(10);
        // height.add(8);
        // height.add(3);
        // height.add(7);
        System.out.println(pairSum2(height, 122));
    }
}