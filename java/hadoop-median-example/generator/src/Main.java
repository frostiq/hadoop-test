import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Created by a.bazhanau on 30.05.16.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        List<String> lines = new ArrayList<>();
        Random random = new Random();
        for (int y = 1950; y <= 2016; ++y){
            for (int m = 1; m <= 12; ++m){
                int v = random.nextInt(20) + 10;
                String s = String.format("%d %d", y, v);
                lines.add(s);
            }
        }
        Path file = Paths.get("input/sample-median.txt");
        Files.createDirectories(Paths.get("input"));
        Files.write(file, lines, Charset.forName("UTF-8"));
    }
}
