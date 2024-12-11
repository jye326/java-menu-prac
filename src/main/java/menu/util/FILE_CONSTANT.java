package menu.util;

public enum FILE_CONSTANT {
    menuFilePath("src/main/java/menu/menu.md"),

    fileDelimiter("\n"),
    dateFormat_yyyyMMdd("yyyy-MM-dd");

    private final String path;

    FILE_CONSTANT(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return path;
    }
}