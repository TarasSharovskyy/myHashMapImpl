import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class myMapTest {
    @Before
    public void setUp() throws Exception{

    }

    @Test
    public void testMyMap(){
        myMap<Integer,String> map = new myMap<>();
        map.put(1, "Lars");
        map.put(2, "Lars");
        map.put(1, "Lars");

        assertEquals( map.get(1), "Lars");

         for (int i=0; i<100; i++){
             map.put(i,String.valueOf(i));

         }

         assertEquals(map.size(), 100);
          assertEquals(Integer.toString(51), map.get(51));
    }
}
