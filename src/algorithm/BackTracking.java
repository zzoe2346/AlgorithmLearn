package algorithm;

public class BackTracking {

    //https://www.acmicpc.net/problem/2239
    //스도쿠를 백트래킹 기법으로 해결
    void boj_2239(int[][] sudokuMap, int i, int j) {
        // 행이 9가 되면 스도쿠 판을 완성한 것이므로 출력 후 종료
        if (i == 9) {
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < 9; k++) {
                for (int l = 0; l < 9; l++) {
                    sb.append(sudokuMap[k][l]);
                }
                sb.append("\n");
            }
            System.out.printf(sb.toString());
            System.exit(0);
        }

        // 열이 9 이상이면 다음 행의 첫 번째 열로 이동
        if (j >= 9) {
            boj_2239(sudokuMap, i + 1, 0);
            return;
        }

        // 현재 위치가 이미 채워져 있는 경우 다음 열로 이동
        if (sudokuMap[i][j] != 0) {
            boj_2239(sudokuMap, i, j + 1);
            return;
        }

        // 현재 위치가 0이라면 1부터 9까지 숫자를 시도
        for (int k = 1; k <= 9; k++) {
            boolean isFail = false;

            // 같은 행에 같은 숫자가 있는지 확인
            for (int l = 0; l < 9; l++) {
                if (l == j) continue; // 현재 열 제외
                if (sudokuMap[i][l] == k) {
                    isFail = true;
                    break;
                }
            }
            if (isFail) continue;

            // 같은 열에 같은 숫자가 있는지 확인
            for (int l = 0; l < 9; l++) {
                if (l == i) continue; // 현재 행 제외
                if (sudokuMap[l][j] == k) {
                    isFail = true;
                    break;
                }
            }
            if (isFail) continue;

            // 3x3 박스 안에 같은 숫자가 있는지 확인
            int si = (i / 3) * 3; // 현재 위치의 3x3 박스 시작 행 계산
            int sj = (j / 3) * 3; // 현재 위치의 3x3 박스 시작 열 계산
            for (int l = si; l < si + 3; l++) {
                for (int m = sj; m < sj + 3; m++) {
                    if (sudokuMap[l][m] == k) {
                        isFail = true;
                        break;
                    }
                }
            }
            if (isFail) continue;

            // 조건을 모두 만족하면 현재 위치에 숫자를 채우고 재귀 호출
            sudokuMap[i][j] = k;
            boj_2239(sudokuMap, i, j + 1);

            // 백트래킹: 다음 시도를 위해 현재 위치를 다시 0으로 초기화
            sudokuMap[i][j] = 0;
        }
    }
}
