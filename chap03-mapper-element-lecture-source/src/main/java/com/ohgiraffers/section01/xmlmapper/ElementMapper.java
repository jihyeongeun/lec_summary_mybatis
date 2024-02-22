package com.ohgiraffers.section01.xmlmapper;

import java.util.List;

public interface ElementMapper {
    List<MenuDTO> selectResultMapTest();

    List<MenuAndCategoryDTO> selectResultAssociationTest();

    List<CategoryAndMenuDTO> selectResultMapCollectionTest();
}
