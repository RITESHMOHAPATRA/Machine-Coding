package org.phonepe.ritesh.model;

import java.util.Objects;

public class Problem {
    private String description;
    private String tag;
    private String difficultyLevel;
    private int score;
    private int numOfSolvers;
    private double totalTimeTaken;

    public Problem(String description, String tag, String difficultyLevel, int score) {
        this.description = description;
        this.tag = tag;
        this.difficultyLevel = difficultyLevel;
        this.score = score;
        this.numOfSolvers = 0;
        this.totalTimeTaken = 0;
    }

    public String getDescription() {
        return description;
    }

    public String getTag() {
        return tag;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public int getScore() {
        return score;
    }

    public int getNumOfSolvers() {
        return numOfSolvers;
    }

    public void incrementNumOfSolvers() {
        numOfSolvers++;
    }

    public double getTotalTimeTaken() {
        return totalTimeTaken;
    }

    public void addToTotalTimeTaken(double timeTaken) {
        totalTimeTaken += timeTaken;
    }

    public double getAverageTimeTaken() {
        return numOfSolvers == 0 ? 0 : totalTimeTaken / numOfSolvers;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Problem problem = (Problem) obj;
        return score == problem.score &&
                Objects.equals(description, problem.description) &&
                Objects.equals(tag, problem.tag) &&
                Objects.equals(difficultyLevel, problem.difficultyLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, tag, difficultyLevel, score);
    }
}
