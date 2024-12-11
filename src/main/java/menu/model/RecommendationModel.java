package menu.model;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;

public class RecommendationModel {
    private List<Coach> coachList = new ArrayList<Coach>();
    private List<String> categoryList = new ArrayList<>();

    public void updateCoachesName(List<String> coachesNameList) {
        for (String coachName : coachesNameList) {
            coachList.add(new Coach(coachName));
        }
    }

    public void printCoachesList() {
        for (Coach coach : coachList) {
            System.out.println(coach.getName());
        }
    }

    public void printCoachesHateList() {
        for (Coach coach : coachList) {
            coach.printName_hates();
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

}
