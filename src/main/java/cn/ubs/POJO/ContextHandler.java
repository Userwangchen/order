package cn.ubs.POJO;

public final class ContextHandler {

    private static volatile ContextHandler handler;

    private String name;

    private ContextHandler() {
    }

    public static ContextHandler getInstance() {
        if (handler == null) {
            Class aClass = ContextHandler.class;
            synchronized (aClass) {
                if (handler == null) {
                    handler = new ContextHandler();
                }
            }
        }

        return handler;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
