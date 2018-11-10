package temp;

import java.util.concurrent.Callable;

public class ThreadCall implements Callable<Integer> {

    public Integer call()
    {
        Integer a= Integer.valueOf(1);
        return a;
    }
}
