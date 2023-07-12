import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void networkDelayTimeTest1(){
        int[][] items = {
                {2,1,1},
                {2,3,1},
                {3,4,1}
        };
        int n = 4;
        int k = 2;

        int expected = 2;
        int actual = new Solution().networkDelayTime(items, n, k);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void networkDelayTimeTest2(){
        int[][] items = {
                {1,2,1},
        };
        int n = 2;
        int k = 1;

        int expected = 1;
        int actual = new Solution().networkDelayTime(items, n, k);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void networkDelayTimeTest3(){
        int[][] items = {
                {1,2,1},
        };
        int n = 2;
        int k = 2;

        int expected = -1;
        int actual = new Solution().networkDelayTime(items, n, k);

        Assertions.assertEquals(expected, actual);
    }
}
