import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.awt.Desktop;
import java.net.URI;

public class MyFileWriter {
    public static void main(String[] args) {
        makeNewFolder();
    }

    public static void fileTest() {
        String data = "Hello, World!";
        String fileName1 = "example.txt";
        String fileName2 = "example2.txt";
        String fileName3 = "example3.txt";
        String fileName4 = "example4.txt";
        String fileName5 = "example5.txt";

        // 1. Using FileWriter
        try (FileWriter writer = new FileWriter(fileName1)) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Using BufferedWriter
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. Using FileOutputStream
        try (FileOutputStream outputStream = new FileOutputStream(fileName3)) {
            outputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4. Using BufferedOutputStream
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName4))) {
            bufferedOutputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 5. Using Files (java.nio.file)
        try {
            Files.write(Paths.get(fileName5), data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateHiddenFile() {
        String data = "super secret file";
        try {
            Files.write(Paths.get(".wow.txt"), data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void hiddenFolderRegularFile() {
        String dir = ".spoopy6";
        String file = "mystery1.txt";
        Path insideSpoopy = Paths.get(dir + "/mystery1.txt");
        try {
            Files.createDirectory(Paths.get(dir));
            Files.createFile(Paths.get(file));
            Files.move(Paths.get(file), insideSpoopy, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeNewFolder() {
        File dir = new File("mydirectory");
        if (!dir.exists()) {
            dir.mkdir();
        }
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
            } else {
                System.out.println(
                        "https://www.youtube.com/watch?v=dQw4w9WgXcQ");
            }
        } catch (Exception e) {
            System.out.println("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
            e.printStackTrace();
        }
    }

}
