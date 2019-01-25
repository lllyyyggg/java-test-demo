package pattern.structure;

import java.util.ArrayList;
import java.util.List;

public class CompositeTest {

    static class Menu {
        private String name;
        private List<Menu> subMenus;

        public Menu(String name) {
            this.name = name;
            this.subMenus = new ArrayList<>();
        }

        public Menu add(Menu subMenu) {
            subMenus.add(subMenu);
            return this;
        }

        @Override
        public String toString() {
            return "Menu{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Menu menu1 = new Menu("一级菜单");
        Menu menu2 = new Menu("二级菜单");
        Menu menu3 = new Menu("三级菜单");
        menu1.add(menu2);
        menu2.add(menu3);
        System.out.println(menu1);
        for (Menu menu : menu1.subMenus) {
            System.out.println(menu);
            for (Menu menu4: menu.subMenus) {
                System.out.println(menu4);
            }
        }
    }
}
