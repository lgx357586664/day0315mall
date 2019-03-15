package com.zr.webmall.framework;

import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019-03-15 下午 7:13
 */
public class PageBean<T> {
    private int count;
    private int pageCount;
    private int pageIndex;
    private List<T> list;
    /**
     * 获取总页数
     * @return
     */
    public int getPages(){
        return (count+pageCount-1)/pageCount;
    }

    /**
     * 获取数据页面索引
     * @return
     */
    public int getIndex(){
        return (pageIndex-1)*pageCount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
