package com.example.todolist;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileReader {
    public static final String FILENAME = "listinfo.dat";

    public static void writeData(ArrayList<String> list, Context context) {
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream oas = new ObjectOutputStream(fos);
            oas.writeObject(list);
            oas.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> readData(Context context) {
        ArrayList<String> itemList = null;

        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            ObjectInputStream ois = null;
            ois = new ObjectInputStream(fis);
            itemList = (ArrayList<String>) ois.readObject();

        }catch (FileNotFoundException e){
            itemList = new ArrayList<>();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return itemList;
    }
}
