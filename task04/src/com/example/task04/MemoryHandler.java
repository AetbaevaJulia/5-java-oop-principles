package com.example.task04;

import java.util.ArrayList;
import java.util.Arrays;

public class MemoryHandler {
    private final int Size;
    private final ArrayList<MessageHandler> Handlers = new ArrayList<>();
    private final ArrayList<String> Messages = new ArrayList<>();

    public MemoryHandler(int size, MessageHandler... handlers) {
        Size = size;
        ArrayList<MessageHandler> newHandlers = new ArrayList<>(Arrays.asList(handlers));
        Handlers.addAll(newHandlers);
    }

    public void sendMessageToHandler(String m) {
        Messages.add(m);
        if (Messages.size() > Size) {
            for (MessageHandler handler : Handlers) {
                for (String message : Messages) {
                    handler.log(message);
                }
                Messages.clear();
            }
        }
    }
}
