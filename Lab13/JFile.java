import java.io.*;
import javax.swing.*;

public class JFile {
    public static void main(String[] args) {
    JFileChooser fileChooser = new JFileChooser();
    File file , directory;
    int status;
    status = fileChooser.showOpenDialog(null);
    if(status == JFileChooser.APPROVE_OPTION){
        file = fileChooser.getSelectedFile();
        directory = fileChooser.getCurrentDirectory();
        System.out.println("Directory: " + directory.getAbsolutePath());
        System.out.println("File: " + file.getName());
    }
}
}