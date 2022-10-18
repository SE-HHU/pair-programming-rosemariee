import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ConstructedTools.Frac;
import org.junit.jupiter.api.Test;

class FileOperateTest {
    /**
     * Method under test: {@link FileOperate#fileWriter(List, String)}
     */
    @Test

    void testFile_writer() throws Exception {
        List<String> list=new ArrayList<>();
        list.add("1");
        FileOperate.fileWriter(list, "test");
    }

    /**
     * Method under test: {@link FileOperate#fileWriterFrac(List, String)}
     */
    @Test

    void testFile_writerFrac() throws Exception {

        List<Frac> list=new ArrayList<>();
        Frac f1=new Frac(1);
        list.add(f1);
        FileOperate.fileWriterFrac(list, "test2");
    }

    /**
     * Method under test: {@link FileOperate#fileReader(File)}
     */
    @Test

    void testFile_reader() throws Exception {
        File fe=new File("test.txt");
        FileOperate.fileReader(fe);
    }
}

