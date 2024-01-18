import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

public class Provafile {

    public static void main(String[] args) {
        String frase = "\nprima riga file\n";

        File file = new File("filepath/file.txt");

        try {
            //scrittura stringa all'interno di un file
            FileUtils.writeStringToFile(file, frase, Charset.defaultCharset(), true);

            //String s = FileUtils.readFileToString(file, Charset.defaultCharset());
            //System.out.println(s);

            //FileUtils.deleteQuietly(file);

            //FileUtils.deleteDirectory(new File("filepath"));

            //creazione di una directory
            FileUtils.createParentDirectories(file);

            File file2 = new File("filepath");

            //lunghezza di un file in byte, se è un file
            System.out.println(file2.length());

            //path assoluto di un file
            System.out.println(file2.getAbsolutePath());

            //stampa di una lista di file presenti in una directory
            Arrays.stream(file2.list()).forEach(s -> System.out.println(s));

            //numero di file dentro una directory
            System.out.println(file2.list().length);

            //Lettura delle righe all'interno dei file salvate all'interno di una list
            List<String> lista = FileUtils.readLines(file, Charset.defaultCharset());

            System.out.println(lista);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}