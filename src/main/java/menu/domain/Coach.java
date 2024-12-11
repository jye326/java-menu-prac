package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> hates = new ArrayList<>();
    private List<String> recommendations = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 2개 이하, 이미 있는 거 제외 추가 가능
    public void addHates(String hate) {
        if ((!hates.contains(hate)) && hates.size()<2) {
            hates.add(hate);
        }
    }

    public void printName_hates() {
        System.out.print(name);
        System.out.print("가 싫어하는 음식");
        for (String hate : hates) {
            System.out.print(hate);
        }
        System.out.println();
    }

}
