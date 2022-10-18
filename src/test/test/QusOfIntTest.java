import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

class QusOfIntTest {
    @Test
    void test()
    {

        boolean flag=false;
        try {
            QusOfFrac qus = new QusOfFrac(3);
        }
        catch (Exception e)
        {
            flag=true;
        }
        assertTrue(flag);

    }
    }


