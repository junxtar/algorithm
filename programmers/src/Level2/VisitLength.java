package Level2;

public class VisitLength {

	// {D, U, R, L}
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    //예시 그림 보면 점이 하나의 칸이라고 생각해서 좌우 길이를 11 
    //지나간 부분을 체크 해야하므로 3차원 배열로 표현
    static boolean[][][]visited = new boolean[11][11][4];
    
    public int solution(String dirs) {
        //주어진 문자열을 인덱스로 변환
        String transdirs = transform(dirs);
        int answer = 0;
        //현재 위치 (5,5)
        int curx = 5;
        int cury = 5;
       
        for(int i = 0; i<transdirs.length(); i++){
            //char이 숫자일경우 - '0' 을 해주면 정수형 숫자로 변환 가능
            int value = transdirs.charAt(i) - '0';
            //현재위치 x, y, 가려고 하는 방향 true
            visited[curx][cury][value] = true;
            //다음 방문 위치를 변수로 표현
            int nx = curx + dx[value];
            int ny = cury + dy[value];
            //현재 위치와 다음 위치의 양쪽 모두 방향을 알아야 하므로 다음 방향을 표시
            //ex) 위쪽으로 갔다면 아래, 왼쪽으로 갔다면 오른쪽
            int nv = value % 2 == 0 ? value+1 : value-1;
            
            //그래프 범위를 벗어났을 경우
            if(nx < 0 | nx > 10 | ny < 0 | ny > 10)
                continue;
            //현재 위치에서 가려고 하는 방향을 방문 안했거나
            //다음 위치에서 현재위치의 방향을 방문 안했을 경우 answer++
            if(!visited[curx][cury][value] || !visited[nx][ny][nv]){
                answer++;
            } 
            //다음 위치에서 현재 위치를 가르키는 방향도 true
            visited[nx][ny][nv] = true;
            
            //현재위치 초기화
            curx = nx;
            cury = ny;
            }
        
        return answer;
    }
    
    static String transform(String dirs){
        String result = "";
        for(int i = 0; i<dirs.length(); i++){
            char ch = dirs.charAt(i);
            switch(ch){
                case 'D':
                    ch = '0';
                    break;
                case 'U':
                    ch = '1';
                    break;
                case 'R':
                    ch = '2';
                    break;
                case 'L':
                    ch = '3';
            }
            result += ch;
        }
        return result;
    }
}