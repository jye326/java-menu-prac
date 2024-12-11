package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<String> menu = new ArrayList<String>();

    public Category(String name) {
        this.name = name;
    }

    public void addMenu(String menu) {
        this.menu.add(menu);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String ret ="name : " + name + " menu : ";
        for (String menu : menu) {
            ret += menu + " ";
        }
        return ret;
    }
}
