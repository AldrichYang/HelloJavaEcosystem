package io.files;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by yh on 2018/4/10.
 */
public class PathClass {
    public static void main(String[] args) {

//        createFile(args);
//        retrievingInformationAboutAPath(args);
        convertingPath();
//        joiningPaths();
//        creatingAPathBetweenTwoPaths();

    }

    private static void createFile(String[] args) {
        Path p1 = Paths.get("/tmp/foo");
        Path p2 = Paths.get(args.length > 0 ? args[0] : "");
        Path p3 = Paths.get(URI.create("file:///Users/joe/FileTest.java"));
        Path p4 = FileSystems.getDefault().getPath("/users/sally");
        Path p5 = Paths.get(System.getProperty("user.home"), "logs", "foo.log");
    }

    private static void retrievingInformationAboutAPath(String[] args) {
        // None of these methods requires that the file corresponding to the Path exists.
        // Microsoft Windows syntax
//        Path path = Paths.get("C:\\home\\joe\\foo");
//        Path path = Paths.get("sally\\bar");

        // Solaris syntax
//        Path path = Paths.get("/home/joe/foo");
        Path path = Paths.get("sally/bar");

        System.out.format("toString: %s%n", path.toString());
        System.out.format("getFileName: %s%n", path.getFileName());
        System.out.format("getName(0): %s%n", path.getName(0));
        System.out.format("getNameCount: %d%n", path.getNameCount());
        System.out.format("subpath(0,2): %s%n", path.subpath(0, 2));
        System.out.format("getParent: %s%n", path.getParent());
        System.out.format("getRoot: %s%n", path.getRoot());

    }

    private static void convertingPath() {
        Path p1 = Paths.get("/home/logfile");
// Result is file:///home/logfile
        System.out.format("%s%n", p1.toUri());
        Path inputPath = Paths.get("sally/bar");
        Path fullPath = inputPath.toAbsolutePath();
        System.out.format("toAbsolutePath: %s%n", fullPath.toString());
        Path fp = null;
        try {
            fp = inputPath.toRealPath();
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", fp);
            // Logic for case when file doesn't exist.
        } catch (IOException x) {
            System.err.format("%s%n", x);
            // Logic for other sort of file error.
        }

    }

    private static void joiningPaths() {
        // Solaris
        Path p1 = Paths.get("/home/joe/foo");
// Result is /home/joe/foo/bar
        System.out.format("%s%n", p1.resolve("bar"));


// Microsoft Windows
        Path p2 = Paths.get("C:\\home\\joe\\foo");
// Result is C:\home\joe\foo\bar
        System.out.format("%s%n", p2.resolve("bar"));
//        Passing an absolute path to the resolve method returns the passed - in path:
// Result is /home/joe
        Paths.get("foo").resolve("/home/joe");

    }

    private static void creatingAPathBetweenTwoPaths() {
        Path p1 = Paths.get("joe");
        Path p2 = Paths.get("sally");
        // Result is ../sally
        Path p1_to_p2 = p1.relativize(p2);
// Result is ../joe
        Path p2_to_p1 = p2.relativize(p1);
        Path p0 = Paths.get("home");
        Path p3 = Paths.get("home/sally/bar");
// Result is sally/bar
        Path p0_to_p3 = p0.relativize(p3);
// Result is ../..
        Path p3_to_p1 = p3.relativize(p1);

    }
}
