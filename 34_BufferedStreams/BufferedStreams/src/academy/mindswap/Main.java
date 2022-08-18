package academy.mindswap;

import academy.mindswap.utils.Logger;

import java.io.*;

import static academy.mindswap.utils.LoggerType.ERROR;
import static academy.mindswap.utils.LoggerType.SUCCESS;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = "";

        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. List files from a directory");
            System.out.println("2. Write the name of the files present in the given directory in a new text file");
            System.out.println("3. Check if file exists");
            System.out.println("4. Create a new file in the directory and name specified");

            try {
                if ((line = reader.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (line.equalsIgnoreCase("exit")) {
                return;
            }

            if (line.equals("1")) {
                System.out.println("Please input a directory to list the files:");

                try {
                    line = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                listFilesFromDirectory(line);

                return;
            }

            if (line.equals("2")) {
                System.out.println("Please input a directory to list the files:");

                try {
                    line = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                writeFilesName(line);

                return;
            }

            if (line.equals("3")) {
                System.out.println("Please input the file path:");

                try {
                    line = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                checkExistingFile(line);

                return;
            }

            if (line.equals("4")) {
                System.out.println("Please input the path:");

                try {
                    line = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                createNewFile(line);

                return;
            }

            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void listFilesFromDirectory(String directoryPath) {
        File path = new File(directoryPath);

        if (!path.isDirectory()) {
            Logger.log(ERROR, "The given folder does not exist!");
        } else {
            String[] files = path.list();

            Logger.log(SUCCESS, "Files present in the given folder:");

            for (String file : files) {
                System.out.println(file);
            }
        }
    }

    private static void writeFilesName(String directoryPath) {
        File path = new File(directoryPath);

        if (!path.isDirectory()) {
            Logger.log(ERROR, "The given folder does not exist!");
        } else {
            String[] files = path.list();

            BufferedWriter writer = null;

            try {
                writer = new BufferedWriter(new FileWriter("resources/file_list.txt"));

                for (String file : files) {
                    writer.write(file.concat("\n"));
                }

                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void checkExistingFile(String filePath) {
        if (!filePath.matches("(.+)[.](.+)")) {
            Logger.log(ERROR, "The path provided is not a file path!");

            return;
        }

        File path = new File(filePath);

        if (!path.isFile()) {
            Logger.log(ERROR, "The given file name does not exist!");

        } else {
            Logger.log(SUCCESS, "The given file name exist!");
        }
    }

    private static void createNewFile(String path) {
        if (!path.matches("(.+)[.](.+)")) {
            Logger.log(ERROR, "The path provided is not a file path!");

            return;
        }

        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(path));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
