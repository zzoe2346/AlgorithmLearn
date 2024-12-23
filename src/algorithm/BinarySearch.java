package algorithm;

public class BinarySearch {

    public int binarySearchFindOnlyEqual(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            //int mid = left + (right - left) / 2; // 오버플로우 방지
            int mid = (left + right) / 2;

            if (array[mid] == target) {
                return mid;
            }
            //target 값이 중간 값보다 큰 경우 오른쪽 절반 탐색
            if (array[mid] < target) {
                left = mid + 1;
            }
            //target 값이 중간 값보다 작을 경우 왼쪽 절반 탐색
            if (array[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int binarySearchFindFirstGreaterOrEqual(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int result = -1; // target 이상의 값이 없을 경우

        while (left <= right) {
            //int mid = left + (right - left) / 2;
            int mid = (left + right) / 2;

            //target 값과 같거나 큰 경우에 왼쪽 절반 탐색
            //왼쪽을 탐색하는 이유는 인덱스가 작지만 같은 값을 찾기 위함
            if (array[mid] >= target) {
                result = mid; // target 이상의 값을 찾음. result 를 갱신
                right = mid - 1;
            }
            //target 값보다 작은 경우에 오른쪽 절반 탐색
            if (array[mid] < target) {
                left = mid + 1;
            }
        }
        return result;
    }

}
