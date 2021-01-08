package com.company;

public class Case {
    private int row;
    private int column;
    private boolean isEaten;


    /**
     * Constructor
     * @param row
     * @param column
     */
    public Case(int row, int column){
        this.row = row;
        this.column = column;
        this.isEaten = false;
    }

    /**
     * Render the aspect of the case if she's eaten or not
     * @return
     */
    public String getRender()
    {
        return this.isEaten ? "\uD83D\uDD73\uFE0F" : "\uD83E\uDDC0";
    }

    public boolean getIsEaten() {
        return isEaten;
    }

    public void setIsEaten(boolean eaten) {
        isEaten = eaten;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}


