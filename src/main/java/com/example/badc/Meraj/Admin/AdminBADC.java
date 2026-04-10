package com.example.badc.Meraj.Admin;

public class AdminBADC {
    private String menuName;
    private String fxmlPath;

    public AdminBADC(String menuName, String fxmlPath) {
        this.menuName = menuName;
        this.fxmlPath = fxmlPath;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getFxmlPath() {
        return fxmlPath;
    }

    public void setFxmlPath(String fxmlPath) {
        this.fxmlPath = fxmlPath;
    }

    @Override
    public String toString() {
        return "AdminBADC{" +
                "menuName='" + menuName + '\'' +
                ", fxmlPath='" + fxmlPath + '\'' +
                '}';
    }
}
