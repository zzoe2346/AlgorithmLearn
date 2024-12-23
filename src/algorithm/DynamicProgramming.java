package algorithm;

public class DynamicProgramming {

    //https://www.acmicpc.net/problem/1562
    public void dpWithBitMasking() {
        int N = 20; // N은 i의 크기
        int[][][] dp = new int[N + 1][10][1 << 10]; // 3번째 배열은 어떤 수를 썻는지 확인하기 위함

        // 초기 세팅. [1<<j]는 1, 10, 100 등 이런걸 표시하기 위함!
        // 이 문제에서 첫 수로 0이 불가능하기 때문에 j는 1부터 시작함
        for (int j = 1; j <= 9; j++) {
            dp[1][j][1 << j] = 1;
        }

        for (int i = 2; i <= N; i++) { // i는 계단수 위치
            for (int j = 0; j <= 9; j++) { // j 는 계단수
                for (int k = 0; k < (1 << 10); k++) { // k 는 비트마스킹 경우의 수 모두 탐색하는 인덱스. 이걸로 어떤수를 썻는지 파익한다. 위치파악은 아니다.
                    //계단수 규칙을 분석해보면
                    //0이 나오려면, 이전 수가 1 이 나와야 함
                    //9이 나오려면, 이전 수가 8 이 나와야 함
                    //1~8은 해당 수의 -1, +1 이 나와야 함
                    //각 dp에서 or을 이용해서 현재 위치(i)까지 j수가 포함되기까지를 bitmasking으로 사용해온 계단수까지 누적해가며 경우의 수 알려줄 수 있다.
                    if (j == 0) {
                        dp[i][j][k | (1 << j)] += dp[i - 1][j + 1][k] % 1000000000;
                    } else if (j == 9) {
                        dp[i][j][k | (1 << j)] += dp[i - 1][j - 1][k] % 1000000000;
                    } else {
                        dp[i][j][k | (1 << j)] += (dp[i - 1][j + 1][k] % 1000000000 + dp[i - 1][j - 1][k] % 1000000000) % 1000000000;
                    }
                }
            }
        }

        int ans = 0;
        for (int j = 0; j <= 9; j++) {
            ans = (ans % 1000000000 + dp[N][j][0b1111111111] % 1000000000) % 1000000000;
        }
        System.out.println(ans);
    }
}
