package ru.elizarov.network;

public class Resource {
    private boolean isClosed = false;

    public void use() {
        if (isClosed) {
            throw new ResourceAlreadyClosedException();
        }
        System.out.println("Ресурс используется.");
    }

    public void close() {
        isClosed = true;
        System.out.println("Ресурс закрыт.");
    }
}
