package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import menu.util.REGEX_PATTERN;

public class inputView {
    public List<String> readCoachesName() {
        List<String> coachesName = new ArrayList<String>();
        String nameList = Console.readLine();
        if (nameListValidation(nameList)) {
            coachesName.addAll(List.of(nameList.split(",")));
            return coachesName;
        }
        throw new IllegalArgumentException("nameList input error");
    }

    private boolean nameListValidation(String nameList) {
        Pattern pattern = Pattern.compile(REGEX_PATTERN.NAME_LIST_PATTERN.getRegexPattern());
        Matcher matcher = pattern.matcher(nameList);
        return matcher.matches();
    }

    public List<String> readCoachesHate() {
        List<String> coachesHate = new ArrayList<>();
        String hateList = Console.readLine();
        if (hateListValidation(hateList)) {
            coachesHate.addAll(List.of(hateList.split(",")));
            return coachesHate;
        }
        throw new IllegalArgumentException("hateList input error");
    }

    private boolean hateListValidation(String nameList) {
        Pattern pattern = Pattern.compile(REGEX_PATTERN.HATE_LIST_PATTERN.getRegexPattern());
        Matcher matcher = pattern.matcher(nameList);
        return matcher.matches();
    }

}
