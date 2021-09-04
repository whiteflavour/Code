import com.google.Solution;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        System.out.println(solution.permute(new int[]{1,2,3}));
    }
}
