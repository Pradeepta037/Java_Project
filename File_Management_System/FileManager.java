import java.io.File;
import java.io.IOException;

public class FileManager {
    private File currentDirectory;

    public FileManager(String path) {
        this.currentDirectory = new File(path);
        if (!currentDirectory.exists()) {
            currentDirectory.mkdirs();
        }
    }

    public void createFile(String fileName) throws IOException {
        File file = new File(currentDirectory, fileName);
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getName());
        } else {
            System.out.println("File already exists.");
        }
    }

    public void deleteFile(String fileName) {
        File file = new File(currentDirectory, fileName);
        if (file.delete()) {
            System.out.println("File deleted: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    public void renameFile(String oldName, String newName) {
        File oldFile = new File(currentDirectory, oldName);
        File newFile = new File(currentDirectory, newName);
        if (oldFile.renameTo(newFile)) {
            System.out.println("File renamed to: " + newFile.getName());
        } else {
            System.out.println("Failed to rename the file.");
        }
    }

    public void searchFiles(String keyword) {
        File[] files = currentDirectory.listFiles();
        if (files != null) {
            boolean found = false;
            for (File file : files) {
                if (file.getName().contains(keyword)) {
                    System.out.println("Found file: " + file.getName());
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No files found with keyword: " + keyword);
            }
        } else {
            System.out.println("No files in the directory.");
        }
    }
}
