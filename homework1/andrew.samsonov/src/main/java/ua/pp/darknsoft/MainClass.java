package ua.pp.darknsoft;

public class MainClass {

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem("root");
        FileSystem dir1 = new FileSystem("dir1");
        fileSystem.addFileOrDir(dir1);
        FileSystem file1 = new File("file1");
        FileSystem file2 = new File("file2");
        dir1.addFileOrDir(file2);
        fileSystem.addFileOrDir(file1);
        System.out.println(dir1);

        FileSystem.printCurrent(dir1);
        //FileSystem.printCurrent(file1);
    }
}
