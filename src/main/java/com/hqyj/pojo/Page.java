package com.hqyj.pojo;

public class Page {
    private int currentPage=1;//当前页
    private int pageNumSize=5;//每页显示条数

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageNumSize() {
        return pageNumSize;
    }

    public void setPageNumSize(int pageNumSize) {
        this.pageNumSize = pageNumSize;
    }


}
