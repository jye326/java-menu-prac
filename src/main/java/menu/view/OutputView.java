package menu.view;

import java.text.NumberFormat;
import menu.util.OUTPUT_MESSAGE;


public class OutputView {
    // 일반 출력
    public static void openingMessage() {
        System.out.println(OUTPUT_MESSAGE.openingComment);
    }
    public static void askCoachesName() {
        System.out.println(OUTPUT_MESSAGE.ASK_COACHES_NAME);
    }

    // 숫자를 세 자리마다 쉼표 찍어서 String 으로 반환
    private String formatNumber(Long number) {
        return NumberFormat.getInstance().format(number);
    }
}
