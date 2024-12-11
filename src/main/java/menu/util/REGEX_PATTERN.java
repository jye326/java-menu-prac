package menu.util;

public enum REGEX_PATTERN {

    // 정규식 테스트 사이트 링크 : https://regex101.com/
    // 정규식 참고 사이트 링크 : https://adjh54.tistory.com/104#google_vignette

    SPACE(" "),
    COMMA(","),

    NAME_LIST_PATTERN("^([a-zA-Z가-힣]{2,4},){0,4}[a-zA-Z가-힣]{2,4}$"), // 한글영문 2~4자 세트가 ,로 구분되어 총 1~5명세트
    HATE_LIST_PATTERN("^([a-zA-Z가-힣]*,){0,1}[a-zA-Z가-힣]*$"),


    PURCHASE_VALIDATE_PATTERN("\\[[\\w가-힣]+-\\d+](,\\[[\\w가-힣]+-\\d+])*"),
    YN_VALIDATE_PATTERN("[YN]");    // Y또는N, YN은 아님

    private final String regexPattern;

    REGEX_PATTERN(String regexPattern) {
        this.regexPattern = regexPattern;
    }
    public String getRegexPattern() {
        return regexPattern;
    }

}
