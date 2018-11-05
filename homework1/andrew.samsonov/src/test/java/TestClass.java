import org.junit.Test;
import ua.pp.darknsoft.File;
import ua.pp.darknsoft.FileSystem;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class TestClass {

    @Test
    public void fileAddTest() {
        FileSystem fileSystem = new FileSystem("root");
        FileSystem dir1 = new FileSystem("dir1");
        fileSystem.addFileOrDir(dir1);
        FileSystem file1 = new File("file1");
        FileSystem file2 = new File("file2");
        dir1.addFileOrDir(file2);
        fileSystem.addFileOrDir(file1);

        assertEquals(dir1.getNextElement().get(0).getClass(), File.class);
    }

    @Test
    public void dirAddTest() {
        FileSystem fileSystem = new FileSystem("root");
        FileSystem dir1 = new FileSystem("dir1");
        fileSystem.addFileOrDir(dir1);
        FileSystem file1 = new File("file1");
        FileSystem file2 = new File("file2");
        dir1.addFileOrDir(file2);
        fileSystem.addFileOrDir(file1);

        assertEquals(fileSystem.getNextElement().get(0).getClass(), FileSystem.class);
    }
    @Test
    public void dirSizeTest() {
        FileSystem fileSystem = new FileSystem("root");
        FileSystem dir1 = new FileSystem("dir1");
        fileSystem.addFileOrDir(dir1);
        FileSystem file1 = new File("file1");
        FileSystem file2 = new File("file2");
        dir1.addFileOrDir(file2);
        fileSystem.addFileOrDir(file1);

        assertEquals(fileSystem.getNextElement().size(), 2);
        assertEquals(dir1.getNextElement().size(), 1);
    }

    @Test
    public void testAddFileOrDirMethod() {
        FileSystem dir1 = new FileSystem("dir1");
        FileSystem dir2 = new FileSystem("dir2");
        FileSystem file1 = new File("file1");
        FileSystem file2 = new File("file2");

        assertEquals(dir1.addFileOrDir(dir2), true);
        assertEquals(dir1.addFileOrDir(file2), true);
        assertEquals(file1.addFileOrDir(file2), false);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUnsupportedOperationException() {
        FileSystem file1 = new File("file1");
        file1.setNextElement(new LinkedList<FileSystem>());
    }


}
