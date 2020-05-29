package io.files;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.Set;

/**
 * Created by yh on 2018/4/18.
 */
public class FileMetadata {
    public static void main(String[] args) throws Exception {
//        readBasicAttribute();
//        setTimeStamp();
//        posixFile();
//        createFromOldFile();
        fileStoreAttribute();
    }

    private static void readBasicAttribute() throws IOException {
        Path file = Paths.get("./src/main/java/io/files/PathClass.java");
        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);

        System.out.println("creationTime: " + attr.creationTime());
        System.out.println("lastAccessTime: " + attr.lastAccessTime());
        System.out.println("lastModifiedTime: " + attr.lastModifiedTime());

        System.out.println("isDirectory: " + attr.isDirectory());
        System.out.println("isOther: " + attr.isOther());
        System.out.println("isRegularFile: " + attr.isRegularFile());
        System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
        System.out.println("size: " + attr.size());
    }

    private static void setTimeStamp() throws IOException {
        Path file = Paths.get("./src/main/java/io/files/PathClass.java");
        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
        long currentTime = System.currentTimeMillis();
        FileTime ft = FileTime.fromMillis(currentTime);
        Files.setLastModifiedTime(file, ft);
    }

    private static void posixFile() throws IOException {
        Path file = Paths.get("./src/main/java/io/files/PathClass.java");
        PosixFileAttributes attr =
                Files.readAttributes(file, PosixFileAttributes.class);
        System.out.format("%s %s %s%n",
                attr.owner().getName(),
                attr.group().getName(),
                PosixFilePermissions.toString(attr.permissions()));
    }

    private static void createFromOldFile() throws IOException {
        Path sourceFile = Paths.get("./src/main/java/io/files/PathClass.java");
        Path newFile = Paths.get("./src/main/java/io/files/PathClass1.java");
        PosixFileAttributes attrs =
                Files.readAttributes(sourceFile, PosixFileAttributes.class);
        FileAttribute<Set<PosixFilePermission>> attr =
                PosixFilePermissions.asFileAttribute(attrs.permissions());
        Files.createFile(newFile, attr);
    }

    private static void changeFileAttribute() throws IOException {
        Path file = Paths.get("");
        Set<PosixFilePermission> perms =
                PosixFilePermissions.fromString("rw-------");
        FileAttribute<Set<PosixFilePermission>> attr =
                PosixFilePermissions.asFileAttribute(perms);
        Files.setPosixFilePermissions(file, perms);
    }

    private static void setFileOrGroupOwner() throws IOException {
        Path file = Paths.get("");
        UserPrincipal owner = file.getFileSystem().getUserPrincipalLookupService()
                .lookupPrincipalByName("sally");
        Files.setOwner(file, owner);

        GroupPrincipal group =
                file.getFileSystem().getUserPrincipalLookupService()
                        .lookupPrincipalByGroupName("green");
        Files.getFileAttributeView(file, PosixFileAttributeView.class)
                .setGroup(group);
    }

    private static void userDefinedAttribute() throws IOException {
        Path file = Paths.get("");
        //write user.mime
        UserDefinedFileAttributeView view = Files
                .getFileAttributeView(file, UserDefinedFileAttributeView.class);
        view.write("user.mimetype",
                Charset.defaultCharset().encode("text/html"));

        // read user.mime
        UserDefinedFileAttributeView view1 = Files
                .getFileAttributeView(file, UserDefinedFileAttributeView.class);
        String name = "user.mimetype";
        ByteBuffer buf = ByteBuffer.allocate(view1.size(name));
        view.read(name, buf);
        buf.flip();
        String value = Charset.defaultCharset().decode(buf).toString();
    }

    private static void fileStoreAttribute() throws IOException {
        Path file = Paths.get("./src/main/java/io/files/PathClass.java");
        FileStore store = Files.getFileStore(file);
        long g = 1024*1024*1024;
        long total = store.getTotalSpace() / g;
        long used = (store.getTotalSpace() -
                store.getUnallocatedSpace()) / g;
        long avail = store.getUsableSpace() / g;

        System.out.format("total:%d,used:%d,avail:%d", total, used, avail);

    }
}

