package handlers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by riziq.habiballah on 17 Dec, 2021
 */
public class TxtFileHandler {
    private File file;
    private FileWriter writer;
    private TxtFileHandler(File f){
        file=f;
        try {
            writer=new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static class TxtFile{
        File f;
        public TxtFile(String name){
            f=new File(name+".txt");
        }
        public TxtFileHandler Init(){
            return new TxtFileHandler(f);
        }
    }


    public TxtFileHandler append(String text) throws IOException {
        writer.write(text);
        return this;
    }
    public TxtFileHandler appendln(String text) throws IOException {
        return append(text).append("\n");
    }
    public File save() throws IOException {
        writer.close();
        return file;
    }
}
