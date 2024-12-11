package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import menu.domain.Category;
import menu.model.RecommendationModel;
import menu.util.NUMBER_CONSTANT;
import menu.util.OUTPUT_MESSAGE;
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
            String[] lines = scanner.nextLine().split(OUTPUT_MESSAGE.COLON.toString());
            Category category = new Category(lines[NUMBER_CONSTANT.ZERO.getInt()].trim());  // 카테고리 명
            for (String menu : lines[NUMBER_CONSTANT.ONE.getInt()].split(OUTPUT_MESSAGE.COMMA.toString())) {
                category.addMenu(menu.trim());
            }
            categories.add(category);
        }
        return categories;
    }

    public void printCategories(RecommendationModel model) {
        String ret = OUTPUT_MESSAGE.CATEGORY_PRE.toString();
        List<String> categoryNameList = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++) {
            categoryNameList.add(model.getCategory(i));
        }
        ret += String.join(OUTPUT_MESSAGE.DELIMITER.toString(), categoryNameList);
        ret += OUTPUT_MESSAGE.CLOSE.toString();
        System.out.println(ret);
    }

    public void startMenuRecommendation() {
        OutputView.openingMessage();
        OutputView.askCoachesName();
        InputView inputView = new InputView();
        RecommendationModel model = new RecommendationModel();
        setCategoriesForDay(model); // model에 카테고리 업데이트
        model.updateCoachesName(inputView.readCoachesName());
        updateHates(model);
        recommend(model);
        OutputView.printResultMessage();
        printCategories(model);
        model.printRecommendationResult();
        OutputView.printEndMessage();
    }

    private void recommend(RecommendationModel model) {
        for (int i = 0; i < 5; i++) {
            model.recommendOneDay(getMenuListWithCategoryName(model.getCategory(i)));
        }
    }

    private List<String> getMenuListWithCategoryName(String categoryName) {
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                return category.getMenu();
            }
        }
        return new ArrayList<>();
    }


    public void updateHates(RecommendationModel model) {
        for (int i = NUMBER_CONSTANT.ZERO.getInt(); i < model.getCoachesNumber(); i++) {
            System.out.println(model.getCoachName(i) + OUTPUT_MESSAGE.ASK_HATES);
            model.updateCoachesHate(i, InputView.readCoachesHate());
        }
    }

    private void setCategoriesForDay(RecommendationModel model) {
        for (int i = NUMBER_CONSTANT.ZERO.getInt(); i < NUMBER_CONSTANT.FIVE.getInt(); i++) {
            model.addCategoryOneDay(categories);
        }
    }
}
