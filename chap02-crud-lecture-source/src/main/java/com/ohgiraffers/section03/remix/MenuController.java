package com.ohgiraffers.section03.remix;

import java.util.List;
import java.util.Map;

public class MenuController {

    private final MenuService menuService;
    private final PrintResult printResult;

    public MenuController() {
        this.menuService = new MenuService();
        this.printResult = new PrintResult();
    }

    public static void findAllMenu() {
        List<MenuDTO> menus = MenuService.findAllMenu();

        if (!menus.isEmpty()){
            PrintResult.printMenus(menus);
        }else {
            PrintResult.printErrorMessage("전체 메뉴 조회 실피");
        }
    }

    public static void findOneMenu(Map<String, String> parameter) {
        int menuCode = Integer.valueOf(parameter.get("menuCode"));

        MenuDTO menu = MenuService.findOneMenu(menuCode);

        if (menu != null){
            PrintResult.printMenu(menu);
        } else {
            PrintResult.printErrorMessage(menuCode + "번의 메뉴는 없습니다.");
        }
    }

    public static void registMenu(Map<String, String> parameter) {
        String menuName = parameter.get("menuName");
        int menuPrice = Integer.valueOf(parameter.get("menuPrice"));
        int categoryCode = Integer.valueOf(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);
        menu.setCategoryCode(categoryCode);

        if (MenuService.registMenu(menu)){
            PrintResult.printSuccessMessage("regist");
        } else {
            PrintResult.printErrorMessage("메뉴 추가 등록에 실패하였습니다.");
        }

    }

    public static void modifyMenu(Map<String, String> parameter) {
        int menuCode = Integer.valueOf(parameter.get("menuCode"));
        String menuName = parameter.get("menuName");
        int menuPrice = Integer.valueOf(parameter.get("menuPrice"));

        MenuDTO menu = new MenuDTO();
        menu.setMenuCode(menuCode);
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);

        if (MenuService.modifyMenu(menu)){
            PrintResult.printSuccessMessage("modify");
        } else {
            PrintResult.printErrorMessage("메뉴 수정에 실패하였습니다.");
        }
    }

    public static void deleteMenu(Map<String, String> parameter) {
        int menuCode = Integer.valueOf(parameter.get("menuCode"));

        MenuDTO menu = MenuService.findOneMenu(menuCode);

        if (MenuService.deleteMenu(menu)){
            PrintResult.printSuccessMessage("remove");
        } else {
            PrintResult.printErrorMessage(menuCode + "번을 삭제하였습니다.");
        }

    }
}
