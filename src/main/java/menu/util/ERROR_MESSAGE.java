package menu.util;

public enum ERROR_MESSAGE {
    FILE_NOT_FOUND("파일이 경로에 존재하지 않습니다."),
    INPUT_FORMAT_ERROR("입력 형식이 올바르지 않습니다. 다시 입력해 주세요.")
    ;

    private static final String ERROR_PREFIX = "[ERROR] ";
    private String message;

    // Prefix 붙어서 저장
    ERROR_MESSAGE(String message) {
        this.message = ERROR_PREFIX + message;
    }

    // toString 오버라이드
    @Override
    public String toString() {
        return this.message;
    }
}
