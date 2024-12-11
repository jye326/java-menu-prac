package menu.util;

public enum NUMBER_CONSTANT {
    ZERO(0L),
    ONE(1L),
    TWO(2L),
    THREE(3L),
    FOUR(4L),
    FIVE(5L),
    SIX(6L),
    SEVEN(7L),
    EIGHT(8L),
    NINE(9L),
    TEN(10L);

    private final Long value;

    NUMBER_CONSTANT(Long value) {
        this.value = value;
    }

    // Long 타입 반환
    public Long getLong() {
        return value;
    }
    // Int 타입으로 반환
    public int getInt(){
        return value.intValue();
    }
}
