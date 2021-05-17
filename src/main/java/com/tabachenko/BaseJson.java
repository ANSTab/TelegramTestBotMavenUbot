package com.tabachenko;

import java.io.*;

public class BaseJson {
    public  StringBuilder deserializatior(String path) throws InvalidObjectException {
        File file = new File(path);
        String InfoTask = null;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            FileInputStream fis = new FileInputStream(file);
            if (fis != null) {
                int b = 0;
                while ((b = fis.read()) != -1) {
                    InfoTask = Character.toString(b);
                    stringBuilder.append(InfoTask);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return stringBuilder;
    }
}
