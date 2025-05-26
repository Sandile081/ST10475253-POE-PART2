/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package register;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonStorage {
    private static final File JSON_FILE = new File("messages.json");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Type MESSAGE_LIST_TYPE = new TypeToken<List<Message>>(){}.getType();

    /** 
     * Appends the given message to messages.json, creating the file if necessary.
     */
    public static void saveMessage(Message msg) {
        List<Message> messages;
        if (JSON_FILE.exists()) {
            try (Reader reader = new FileReader(JSON_FILE)) {
                messages = GSON.fromJson(reader, MESSAGE_LIST_TYPE);
                if (messages == null) messages = new ArrayList<>();
            } catch (IOException e) {
                e.printStackTrace();
                messages = new ArrayList<>();
            }
        } else {
            messages = new ArrayList<>();
        }

        messages.add(msg);

        try (Writer writer = new FileWriter(JSON_FILE)) {
            GSON.toJson(messages, MESSAGE_LIST_TYPE, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

