import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * A utility class that copies the contents of a source file to a destination file.
 * It provides prompt based input and validates file existence prior to execution.
 */
public class FileCopier {

    public static void main(String[] args) {
        FileCopier fileCopier = new FileCopier();
        fileCopier.executeCopyProcess();
    }

    public void executeCopyProcess() {
        try (Scanner userInputScanner = new Scanner(System.in)) {
            String sourceFileName = getSourceFileName(userInputScanner);
            String destinationFileName = getDestinationFileName(userInputScanner);

            performFileCopy(sourceFileName, destinationFileName);
        }
    }

    public String getSourceFileName(Scanner userInputScanner) {
        System.out.print("Please enter the name of the source file: ");
        String fileName = userInputScanner.nextLine();
        File sourceFile = new File(fileName);

        while (!sourceFile.exists() || sourceFile.isDirectory()) {
            System.out.print("Error: Source file does not exist. Please enter a valid source file name: ");
            fileName = userInputScanner.nextLine();
            sourceFile = new File(fileName);
        }

        return fileName;
    }

    public String getDestinationFileName(Scanner userInputScanner) {
        System.out.print("Please enter the name of the destination file: ");
        return userInputScanner.nextLine();
    }

    public void performFileCopy(String sourceFileName, String destinationFileName) {
        try (
            FileInputStream fileInputStream = new FileInputStream(sourceFileName);
            FileOutputStream fileOutputStream = new FileOutputStream(destinationFileName)
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fileInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("\nFile copied successfully!");
        } catch (IOException exception) {
            System.err.println("\nAn input/output error occurred during the file copy process.");
            exception.printStackTrace();
        }
    }
}