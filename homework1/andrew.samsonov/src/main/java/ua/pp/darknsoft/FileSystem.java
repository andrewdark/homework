package ua.pp.darknsoft;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class FileSystem {
    private String name;
    private List<FileSystem> nextElement = new LinkedList<>();

    public FileSystem() {
    }

    public FileSystem(String name) {
        this.name = name;
    }

    public Boolean addFileOrDir(FileSystem fileOrDir) {
        this.nextElement.add(fileOrDir);
        return true;
    }

    public Boolean isDir() {
        return true;
    }

    public static void printCurrent(FileSystem dir) {
        if (!dir.isDir()) {
            System.out.println("FILE: " + dir.getName());
            return;
        }
        for (FileSystem fs : dir.getNextElement()
                ) {
            if (fs.getClass() == FileSystem.class) {
                System.out.println("DIR: " + fs.getName());
            }
            if (fs.getClass() == File.class) {
                System.out.println("FILE: " + fs.getName());
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FileSystem> getNextElement() {
        return nextElement;
    }

    public void setNextElement(List<FileSystem> nextElement) {
        this.nextElement = nextElement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileSystem)) return false;
        FileSystem that = (FileSystem) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(nextElement, that.nextElement);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, nextElement);
    }

    @Override
    public String toString() {
        return "FileSystem{" +
                "name='" + name + '\'' +
                '}';
    }
}
