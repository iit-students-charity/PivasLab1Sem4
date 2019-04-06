package lab2.view;

import java.util.Vector;

public class PageModel {
    private Vector<Vector<Object>> pages;
    private Integer currentPage;
    private Integer pagesTotal;
    private Integer entriesPerPage;
    private Integer entriesTotal;

    public Vector<Vector<Object>> getPage() {
        Vector<Vector<Object>> page = new Vector<>();
        int startIndex = currentPage * entriesPerPage;
        int endIndex = (currentPage + 1) * entriesPerPage;
        for (int i = startIndex; i < endIndex; i++) {
            page.add(pages.get(i));
        }
        return page;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer getEntriesPerPage() {
        return entriesPerPage;
    }

    public Integer getPagesTotal() {
        return pagesTotal;
    }

    void setPages(Vector<Vector<Object>> data){
        this.pages=data;
        calculateEntriesTotal();
        calculatePagesTotal();
    }

    public Vector<Vector<Object>> getLastPage() {
        Vector<Vector<Object>> lastPage = new Vector<>();
        int startIndex = pagesTotal * entriesPerPage;
        int endIndex = entriesTotal % entriesPerPage + (pagesTotal * entriesPerPage);
        for (int i = startIndex; i < endIndex; i++) {
            lastPage.add(pages.get(i));
        }
        return lastPage;
    }

    public void setCurrentPage(Integer pageNumber) {
        this.currentPage = pageNumber;
    }

    public void setEntriesPerPage(int number) {
        this.currentPage=0;
        this.entriesPerPage = number;
        calculatePagesTotal();
    }

    private void calculateEntriesTotal() {
        entriesTotal = pages.size();
    }

    private void calculatePagesTotal() {
        pagesTotal = entriesTotal / entriesPerPage;
    }

    public PageModel() {
        this.entriesPerPage = 10;
        this.currentPage = 0;
        this.pagesTotal = 0;
        this.entriesTotal = 0;
    }

    public Vector<Vector<Object>> getRequestedPage() {
        if (currentPage.equals(pagesTotal)) {
            return getLastPage();
        } else {
            return getPage();
        }
    }

    public void incrementPage() {
        if (currentPage < pagesTotal) {
            currentPage++;
        }
    }

    public void decrementPage(){
        if(currentPage>0){
            currentPage--;
        }
    }
}
