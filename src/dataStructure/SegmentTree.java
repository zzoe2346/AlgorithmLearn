package dataStructure;

public class SegmentTree {
    private int[] tree;
    private int n;

    public SegmentTree(int[] arr){
        n = arr.length;
        tree = new int[4*n]; // 충분한 크기로 할당
        init(arr,0,n-1,1);// 트리 초기화
    }

    private int init(int[] arr, int left, int right, int node){
        if(left == right){
            return tree[node] = arr[left];
        }
        int mid = (left+right)/2;
        return tree[node] = init(arr, left, mid, node * 2) + init(arr, mid + 1, right, node * 2 + 1);
    }
}
