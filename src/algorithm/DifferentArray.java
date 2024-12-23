package algorithm;

import java.util.Arrays;

public class DifferentArray {

    public static void updateRange(int[] diff, int start, int end, int value) {
        diff[start] += value;
        // 범위를 넘어가면 그냥 업데이트를 안해도 된다!
        if (end + 1 < diff.length) {
            diff[end + 1] -= value;
        }
    }

    public static int[] generatePrefixSumArray(int[] diff) {
        int[] updatedArr = new int[diff.length];
        updatedArr[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            updatedArr[i] = updatedArr[i - 1] + diff[i];
        }
        return updatedArr;
    }

    public static void main(String[] args) {
        int[] originalArray = {1, 3, 5, 2, 7};
        System.out.println("Original Array: " + Arrays.toString(originalArray));

        int[] differenceArray = new int[originalArray.length];
        System.out.println("Difference Array: " + Arrays.toString(differenceArray));

        // 범위 업데이트 예시: 인덱스 1부터 3까지 2씩 더하기
        updateRange(differenceArray, 1, 3, 2);
        System.out.println("Difference Array after update: " + Arrays.toString(differenceArray));

        int[] updatedArray = generatePrefixSumArray(differenceArray);
        System.out.println("Updated Array: " + Arrays.toString(updatedArray));

        // 범위 업데이트 예시 2: 인덱스 0부터 4까지 5씩 더하기
        updateRange(differenceArray, 0, 4, 5);
        System.out.println("Difference Array after second update: " + Arrays.toString(differenceArray));

        int[] updatedArray2 = generatePrefixSumArray(differenceArray);
        System.out.println("Updated Array after second update: " + Arrays.toString(updatedArray2));


    }
}
