package com.toadordragon.kata.SpinWords;

import java.io.*;

public class SpinFile {

    String m_filename;

    public SpinFile(String filename) {
        m_filename = filename;
    }

    public String read() {
        String contents = "";
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(m_filename));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            contents = sb.toString();
        } catch (Exception e) {

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return contents;
    }

    public void write(String contents) {
        try (PrintWriter writer = new PrintWriter(m_filename)) {
            writer.write(contents);
        } catch (FileNotFoundException e) {
        }
    }
}
