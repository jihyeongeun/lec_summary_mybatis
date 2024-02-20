package com.ohgiraffers.section01.xmlconfig;

import java.util.List;
import java.util.Map;

public class MenuController {           // 이 클래스가 존재하려면 반드시 MenuService가 필요함
    private final MenuService menuService;
    private final PrintResult printResult;     // 결과페이지에 해당하는 (View 개념의) 클래스

    public MenuController() {
        menuService = new MenuService();
        printResult = new PrintResult();
    }

    public void findAllMenus() {
        List<MenuDTO> menuList = menuService.findAllMenus();

        if (!menuList.isEmpty()) {
            printResult.printMenus(menuList);
        } else {
            printResult.printErrorMessage("조회할 메뉴가 없습니다.");
        }
    }

    public void findMenuByMenuCode(Map<String, String> parameter) {
        int menuCode = Integer.valueOf(parameter.get("menuCode"));

        MenuDTO menu = menuService.findMenuByMenuCode(menuCode);

        if (menu != null){
            printResult.printMenu(menu);
        } else {
            printResult.printErrorMessage(menuCode + "번의 메뉴는 없습니다.");
        }
    }

    public void registMenu(Map<String, String> parameter) {
        String menuName = parameter.get("menuName");
        int menuPrice = Integer.valueOf(parameter.get("menuPrice"));
        int categoryCode = Integer.valueOf(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);
        menu.setCategoryCode(categoryCode);

        boolean result = menuService.registMenu(menu);
        System.out.println("result = " + result);
    }
}
