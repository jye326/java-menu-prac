package menu.util;

public enum OUTPUT_MESSAGE {
    // 일반 정적 출력 문구 예시
    openingComment("점심 메뉴 추천을 시작합니다.\n"),
    ASK_COACHES_NAME("코치의 이름을 입력해 주세요. (, 로 구분)"),

    divider("===================================="),
    doubleTab("\t\t"),
    // format 사용한 가변 출력 문구 예시
    PAY_AMOUNT("내실돈\t\t\t %s")

    ;
    private final String message;

    OUTPUT_MESSAGE(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    // 주어진 인자를 순서대로 해당 포멧에 채워 넣음
    public String format(Object... args) {
        return String.format(message, args);
    }
}