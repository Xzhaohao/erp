package org.kuro.erp.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class EmpPermission {

    private List<String> menus;

    private List<String> points;
}
