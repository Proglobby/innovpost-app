package com.proglobby.innovpost;

public class Feedback {
    private String content;
    private String gichetNum;
    private int zip;

    public Feedback(String content, String gichetNum, int zip) {
        this.content = content;
        this.gichetNum = gichetNum;
        this.zip = zip;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGichetNum() {
        return gichetNum;
    }

    public void setGichetNum(String gichetNum) {
        this.gichetNum = gichetNum;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "content='" + content + '\'' +
                ", gichetNum='" + gichetNum + '\'' +
                ", zip=" + zip +
                '}';
    }
}
