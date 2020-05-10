
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;

import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.text.*;
import javafx.scene.Group;
import javafx.scene.shape.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.*;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

import javafx.stage.DirectoryChooser;

public class Main extends Application {
    static String cd;
    public static String getExtension(String filename) {
        for (int i = 0; i < filename.length(); i++) {
            if (filename.charAt(i) == '.')
                return filename.substring(i + 1);
        }
        return filename;
    }

    public static void sort() {

        String[] s = { "Music", "Videos", "Documents", "Images", "Compressed" };
        Scanner ob = new Scanner(System.in);
        // System.getProperty("user.dir");
        File dir = new File(cd);
        String fileNames[] = dir.list();
        File[] files = dir.listFiles();

        HashMap<String, Integer> ext = new HashMap<>();
        String mext[] = { "aif", "cda", "mid", "midi", "mp3", "mpa", "ogg", "wav", "wma", "wpl", };
        String vext[] = { "3g2", "3gp", "avi", "flv", "h264", "m4v", "mkv", "mov", "mp4", "mpg", "mpeg", "rm",
                "swf", "vob", "wmv" };
        String dext[] = { "doc", "docx", "odt", "pdf", "rtf", "tex", "txt", "wpd", "ods", "xls", "xlsm", "xlsx",
                "c", "cpp", "java", "py", "html", "css", "sh", "class", "sh", "swift", "pl", "cs", "ppt", "pptx",
                "pps", "key", "odp", "php", "jsp", "asp", "aspx", "xhtml", "html", "csv", "db", "dbf", "sav", "sql",
                "tar", "xml", "dat" };
        String iext[] = { "ai", "bmp", "gif", "ico", "jpeg", "jpg", "png", "ps", "psd", "svg", "tif", "tiff",
                "rgb" };
        String cext[] = { "7z", "arj", "deb", "pkg", "rar", "rpm", "tar", "tar.gz", "z", "zip" };

        for (int i = 0; i < mext.length; i++) {
            ext.put(mext[i], 0);
        }
        for (int i = 0; i < vext.length; i++) {
            ext.put(vext[i], 1);
        }
        for (int i = 0; i < dext.length; i++) {
            ext.put(dext[i], 2);
        }
        for (int i = 0; i < iext.length; i++) {
            ext.put(iext[i], 3);
        }
        for (int i = 0; i < cext.length; i++) {
            ext.put(cext[i], 4);
        }
        //////////////

        //////////////
        int index;
        for (int i = 0; i < files.length; i++) {
            if (!files[i].isDirectory()) {
                if (ext.containsKey(getExtension("" + fileNames[i]))) {
                    index = ext.get(getExtension("" + fileNames[i]));
                    File di = new File(cd + "\\" + s[index]);
                    boolean diExists = di.exists();
                    if (!diExists)
                        di.mkdir();
                    boolean flag = files[i].renameTo(new File(cd + "\\" + s[index] + "\\" + fileNames[i]));

                }

            }

        }

    }
    // launch the application
    public void start(Stage stage) {

        try {

            // set title for the stage
            stage.setTitle("FileSorter");

            // create a Directory chooser
            DirectoryChooser dir_chooser = new DirectoryChooser();
            Label label1 = new Label("Select folder to Manage the files");
            // create a Label
            Label label = new Label("Designed and Developed by : Devesh Gupta(DJ) ");

            // create a Button
            Button button = new Button("Select Folder");

            // create an Event Handler
            EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

                public void handle(ActionEvent e) {

                    // get the file selected
                    File filen = dir_chooser.showDialog(stage);

                    if (filen != null) {
                        cd = filen.getAbsolutePath();
                        label.setText("\t\tFile Soted Successfully \nThanks for using our service : Devesh Gupta(DJ)");
                        sort();
                    }
                }
            };

            button.setOnAction(event);

            // create a VBox
            VBox vbox = new VBox(30, label1, button, label);

            // set Alignment
            vbox.setAlignment(Pos.CENTER);

            // create a scene

            Scene scene = new Scene(vbox, 500, 250);

            // set the scene
            stage.setScene(scene);

            stage.show();
        }

        catch (

                Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public static void main(String args[]) {
        launch(args);
    }
}
