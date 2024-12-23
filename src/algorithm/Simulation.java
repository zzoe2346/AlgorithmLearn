package algorithm;

public class Simulation {
    int[] di = {1, -1, 0, 0};
    int[] dj = {0, 0, 1, -1};
    int nowI = 0;
    int nowJ = 0;

    /**
     * Adjusts the position and direction of movement within an array when encountering boundaries.
     * This method accounts for scenarios where a moving object exceeds the boundary multiple times
     * and modifies its direction to simulate bouncing against the boundary while continuing its movement.
     * <p>
     * The following rules are applied:
     * 1. The starting index in the array is assumed to be 1.
     * 2. For specific directions, the method calculates the new position based on speed, ensuring
     * that the object does not exceed the defined range.
     * 3. If the object exceeds the boundary (e.g., index limits), it "bounces" back by reversing its
     * direction and adjusting the position accordingly.
     * 4. The calculation accounts for repeated boundary crossings using a loop for continuous adjustments.
     * <p>
     * This implementation is particularly applicable in grid simulation problems, where boundaries
     * dictate the direction of movement after hitting the edges.
     */
    //https://www.acmicpc.net/problem/17143
    void 배열에서_이동시_벽에_부딪힌_경우에_방향을_바꾸고_계속_진행하는_경우() {
        // 이 로직의 경우 시작 인덱스가 1인 것 유의
        int speed = 10; // 이동 속도 (한 번에 이동하는 칸 수)
        int direction = 0; // 현재 이동 방향 (0: 위, 1: 아래, 2: 오른쪽, 3: 왼쪽)
        int R = 5; // 배열의 경계값 (우측 마지막 인덱스)

        // 이동할 새로운 위치 계산
        int ni = nowI + (di[direction] * speed); // 가로 방향 이동 계산
        int nj = nowJ + (dj[direction] * speed); // 세로 방향 이동 계산

        // 특정 방향(1: 아래, 2: 오른쪽)에서 경계를 초과하는지 확인
        if (direction == 1 || direction == 2) {
            // 경계를 여러 번 초과할 수 있으니 while로 반복 처리
            while (ni > R || ni < 1) { // 경계 초과 여부 확인
                if (ni > R) {
                    ni = R - (ni - R); // 경계를 초과한 만큼 위치를 반전
                    speed = -speed; // 방향 반전
                } else if (ni < 1) {
                    ni = -ni; // 경계를 초과한 값을 반전
                    ni = 1 + (ni + 1); // 넘친 값을 보정하여 경계 안으로 이동
                    speed = -speed; // 방향 반전
                }
            }
        }
    }
}
