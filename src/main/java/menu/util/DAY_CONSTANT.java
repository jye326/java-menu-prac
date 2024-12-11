package menu.util;

public enum DAY_CONSTANT {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일"),
    ;

    private final String day;

    DAY_CONSTANT(String day) {
        this.day= day;
    }
    public String getDay() {
        return day;
    }
}
