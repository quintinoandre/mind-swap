package academy.mindswap;

import java.io.File;
import java.io.FilenameFilter;

public final class DirectoryAnalyser {
    private DirectoryAnalyser() {
    }

    public static void listAllFilesStartWith(String directoryPath, String combinationOfLetters) {
        File path = new File(directoryPath);

        if (!path.isDirectory()) {
            System.out.println("The given path is not a directory path");

            return;
        }

        File[] files = path.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith(combinationOfLetters);
            }
        });

        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
