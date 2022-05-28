package model;

public class State {
    private int stepOneX, stepOneY, stepTwoX, stepTwoY;
    private Boolean result;
    private int imageStep1, imageStep2;
    private int index;
    private int step = 0;
    private int targetScore;
    private int currentScore;

    public State() {
    }

    public int getStepOneX() {
        return stepOneX;
    }

    public void setStepOneX(int stepOneX) {
        this.stepOneX = stepOneX;
    }

    public int getStepOneY() {
        return stepOneY;
    }

    public void setStepOneY(int stepOneY) {
        this.stepOneY = stepOneY;
    }

    public int getStepTwoX() {
        return stepTwoX;
    }

    public void setStepTwoX(int stepTwoX) {
        this.stepTwoX = stepTwoX;
    }

    public int getStepTwoY() {
        return stepTwoY;
    }

    public void setStepTwoY(int stepTwoY) {
        this.stepTwoY = stepTwoY;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getImageStep1() {
        return imageStep1;
    }

    public void setImageStep1(int imageStep1) {
        this.imageStep1 = imageStep1;
    }

    public int getImageStep2() {
        return imageStep2;
    }

    public void setImageStep2(int imageStep2) {
        this.imageStep2 = imageStep2;
    }

    public int getTargetScore() {
        return targetScore;
    }

    public void setTargetScore(int targetScore) {
        this.targetScore = targetScore;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public void clear() {
        this.step = 0;
        this.stepOneX = 0;
        this.stepOneY = 0;
        this.stepTwoX = 0;
        this.stepTwoY = 0;
        this.imageStep1 = 0;
        this.imageStep2 = 0;
        this.result = null;
    }
}
