package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

import menu.domain.Category;
import menu.domain.Coach;
import menu.util.NUMBER_CONSTANT;
import menu.util.OUTPUT_MESSAGE;


public class RecommendationModel {
    private List<Coach> coachList = new ArrayList<Coach>();
    private List<String> categoryForDay = new ArrayList<>();    // 요일별 카테고리

    public void updateCoachesName(List<String> coachesNameList) {
        for (String coachName : coachesNameList) {
            coachList.add(new Coach(coachName));
        }
    }

    public String getCategory(int i) {
        return categoryForDay.get(i);
    }

    public void printCoachesList() {
        for (Coach coach : coachList) {
            System.out.println(coach.getName());
        }
    }

    public void printCoachesRecommendList() {
        for (Coach coach : coachList) {
            System.out.println(coach.getName());
            coach.printRecommendation();
        }
    }


    public String getCoachName(int index) {
        return coachList.get(index).getName();
    }

    public int getCoachesNumber() {
        return coachList.size();
    }

    public void updateCoachesHate(int coachIndex, List<String> hateList) {
        // coachIndex번째 코치의 싫어하는 목록 업데이트
        for (String hate : hateList) {
            coachList.get(coachIndex).addHates(hate);
        }
    }

    // 0~4 : 월 ~ 목요일
    // 하루의 카테고리 추천
    // 나중에 리팩토링 // 지금은 걍 indexof로 찾자.
    public void addCategoryOneDay(List<Category> categories) {
        int index = Randoms.pickNumberInRange(NUMBER_CONSTANT.ONE.getInt(), NUMBER_CONSTANT.FIVE.getInt()) - NUMBER_CONSTANT.ONE.getInt();
        String todayCategory = categories.get(index).getName();
        while (true) {
            if (underTwoCategory(todayCategory)) {
                categoryForDay.add(todayCategory);
                return;
            }
            index = Randoms.pickNumberInRange(NUMBER_CONSTANT.ONE.getInt(), NUMBER_CONSTANT.FIVE.getInt()) - NUMBER_CONSTANT.ONE.getInt();
            todayCategory = categories.get(index).getName();
        }
    }


    public void printDays() {
        for (String category : categoryForDay) {
            System.out.println(category);
        }
    }

    private boolean underTwoCategory(String category) {
        int count = 0;
        for (String c : categoryForDay) {
            if (c.equals(category)) {
                count++;
            }
        }
        return count < 2;
    }

    // 오늘의 메뉴 리스트임.
    public void recommendOneDay(List<String> todayMenuList) {
        for (Coach coach : coachList) {
            recommendToOneCoach(todayMenuList, coach);  // 각 코치별로 다 추천
        }
    }

    private static void recommendToOneCoach(List<String> todayMenuList, Coach coach) {
        while (true) {
            String menu = Randoms.shuffle(todayMenuList).get(0);    // 이녀석을 추가할 수 있으면 추가함
            if (coach.addPossible(menu)) {
                coach.addRecommendation(menu);
                return;// 추가 성공하면 나가
            }
        }
    }

    public void printRecommendationResult() {
        for (Coach coach : coachList) {
            String ret = OUTPUT_MESSAGE.OPEN.toString() + coach.getName() + OUTPUT_MESSAGE.DELIMITER.toString();
            ret += String.join(OUTPUT_MESSAGE.DELIMITER.toString(), coach.getRecommendations());
            ret += OUTPUT_MESSAGE.CLOSE.toString();
            System.out.println(ret);
        }
    }

}
