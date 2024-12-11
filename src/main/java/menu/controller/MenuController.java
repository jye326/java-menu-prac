package menu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import menu.domain.Category;
import menu.model.RecommendationModel;
import menu.view.FileInputView;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private static List<Category> categories;

    public MenuController() {
        categories = updateCategories(FileInputView.readFileToString());
    }

    private List<Category> updateCategories(String fileString) {
        List<Category> categories = new ArrayList<>();
        Scanner scanner = new Scanner(fileString);
        while (scanner.hasNextLine()) {
            String[] lines = scanner.nextLine().split(":");
            Category category = new Category(lines[0].trim());  // 카테고리 명
            for(String menu : lines[1].split(",")) {
                category.addMenu(menu.trim());
            }
            categories.add(category);
        }
        return categories;
    }

    public void printCategories() {
        for (Category category : categories) {
            System.out.println(category);
        }
    }

    public void startMenuRecommendation() {
        OutputView.openingMessage();
        OutputView.askCoachesName();
        printCategories();
        InputView inputView = new InputView();
        RecommendationModel model = new RecommendationModel();
        model.updateCoachesName(inputView.readCoachesName());
        model.printCoachesList();
        updateHates(model);
        model.printCoachesHateList();
    }

    public void updateHates(RecommendationModel model) {
        for (int i = 0; i < model.getCoachesNumber(); i++) {
            System.out.println(model.getCoachName(i) +"(이)가 못 먹는 메뉴를 입력해 주세요.");
            model.updateCoachesHate(i, InputView.readCoachesHate());
        }
    }
}
