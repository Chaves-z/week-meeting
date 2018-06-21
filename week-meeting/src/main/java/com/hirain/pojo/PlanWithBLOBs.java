package com.hirain.pojo;

public class PlanWithBLOBs extends Plan {
    private String lastweek;

    private String currentweek;

    private String problem;

    public String getLastweek() {
        return lastweek;
    }

    public void setLastweek(String lastweek) {
        this.lastweek = lastweek == null ? null : lastweek.trim();
    }

    public String getCurrentweek() {
        return currentweek;
    }

    public void setCurrentweek(String currentweek) {
        this.currentweek = currentweek == null ? null : currentweek.trim();
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem == null ? null : problem.trim();
    }
}