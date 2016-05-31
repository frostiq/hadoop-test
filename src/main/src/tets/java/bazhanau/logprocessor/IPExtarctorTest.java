package bazhanau.logprocessor;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by a.bazhanau on 31.05.16.
 */
public class IPExtarctorTest {

    @Test
    public void TestExtract(){
        IPExtractor extractor = new IPExtractor();
        String text = "qwfrgdf10.10.10.10 sgfsrgdg";
        String result = extractor.extract(text);
        Assert.assertEquals("10.10.10.10", result);
    }
}
