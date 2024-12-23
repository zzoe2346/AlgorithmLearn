package algorithm;

public class BitMasking {

    //n & (-n)이 가장 오른쪽 켜진 비트의 위치에 해당하는 2의 거듭제곱 값을 반환
    //https://www.acmicpc.net/problem/1052
    void bitMaskingSkill01() {
        int N = 13;
        int K = 3;
        int addCount = 0;
        while (true) {
            if (Integer.bitCount(N) <= K) break;
            addCount += N & (-N);
            N = N + (N & (-N)); //(N & (-N))을 하면 N의 비트중 가장 우측에 켜진(1) 비트 위치만 켜져 나온다.
            // -N 을 하면 N 을 모두 뒤집고 +1 을 하는데 이 현상을 귀납적으로 보면 위 같은 규칙이 나옴.
            // 이 문제에서는 계속 끝에꺼 올리면서 최소의 값으로 1의 개수 줄여주는 것!!!
        }
        System.out.println(addCount);
    }
}
