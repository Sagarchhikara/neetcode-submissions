class Solution {
    public int[][] kClosest(int[][] points, int k) {
     PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
     for(int[] point :points){
        int x=point[0];
        int y=point[1];
        int distance=x*x+y*y;
        pq.offer(new int[]{distance,x,y});
        if(pq.size()>k) pq.poll();
     }
     int[][] answer=new int[k][2];
     for(int i=0;i<k;i++){
        int[] current=pq.poll();
        answer[i][0]=current[1];
        answer[i][1]=current[2];
     }
     return answer;

    }
}