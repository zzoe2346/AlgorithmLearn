package algorithm;

import java.util.Arrays;

public class TwoPointer {

    //https://www.acmicpc.net/problem/2470
    //https://www.acmicpc.net/problem/2473 위 문제의 업그레이드 버전
    void 투_포인터의_시작_지점은_지정되어_있지_않다() {
        int N = 10; // 배열 크기
        int[] nums = new int[N + 1];

        // 정렬
        Arrays.sort(nums);

        // 투 포인터 초기화
        int left = 0;
        int right = N - 1;

        // 정답 변수 초기화
        int ans1 = nums[left]; // 첫 번째 수
        int ans2 = nums[right]; // 두 번째 수
        int minSum = Math.abs(nums[left] + nums[right]); // 초기 절대값 합

        // 투 포인터 탐색
        while (left < right) { // 포인터가 서로 교차하면 종료
            int currentSum = nums[left] + nums[right]; // 현재 두 수의 합

            // 현재 합의 절대값이 최소값보다 작다면 업데이트
            if (Math.abs(currentSum) < minSum) {
                minSum = Math.abs(currentSum);
                ans1 = nums[left];
                ans2 = nums[right];
            }

            // 합이 0보다 크면 오른쪽 포인터 감소 (합을 줄임)
            if (currentSum > 0) {
                right--;
            }
            // 합이 0보다 작으면 왼쪽 포인터 증가 (합을 키움)
            else if (currentSum < 0) {
                left++;
            }
            // 합이 정확히 0이면 종료 (더 이상 최적값 없음)
            else {
                break;
            }
        }

        // 결과 출력
        System.out.println(ans1 + " " + ans2);
    }

}
