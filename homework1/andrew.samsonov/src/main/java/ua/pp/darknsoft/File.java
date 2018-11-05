package ua.pp.darknsoft;

import java.util.List;

public class File extends FileSystem {
    private List<FileSystem> nextElement = null;

    public File(String name) {
        super(name);
    }

    public List<FileSystem> getNextElement() {
        if (true) throw new UnsupportedOperationException();
        return nextElement;
    }

    public void setNextElement(List<FileSystem> nextElement) {
        throw new UnsupportedOperationException();
    }

    public Boolean addFileOrDir(FileSystem fileOrDir) {

        return false;
    }

    public Boolean isDir() {
        return false;
    }
}
