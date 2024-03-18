package org.phonepe.ritesh.service;

import org.phonepe.ritesh.model.Problem;
import org.phonepe.ritesh.model.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProblemServiceImpl implements ProblemService {
    private List<Problem> problemList;
    private UserService userService;

    public ProblemServiceImpl(UserService userService) {
        this.problemList = new ArrayList<>();
        this.userService = userService;
    }

    @Override
    public void addProblem(Problem problem) {
        problemList.add(problem);
    }

    @Override
    public List<Problem> fetchProblems(String difficultyLevel, String tag) {
        List<Problem> filteredProblems = new ArrayList<>();
        for (Problem problem : problemList) {
            if ((difficultyLevel == null || problem.getDifficultyLevel().equalsIgnoreCase(difficultyLevel)) &&
                    (tag == null || problem.getTag().equalsIgnoreCase(tag))) {
                filteredProblems.add(problem);
            }
        }
        filteredProblems.sort(Comparator.comparingInt(Problem::getScore).reversed());
        return filteredProblems;
    }

    @Override
    public void solve(Problem problem, User user) {
        problem.incrementNumOfSolvers();
        userService.addSolvedProblem(user, problem);
    }

    @Override
    public List<Problem> getTopNProblems(String tag, int n) {
        List<Problem> filteredProblems = new ArrayList<>();
        for (Problem problem : problemList) {
            if (problem.getTag().equalsIgnoreCase(tag)) {
                filteredProblems.add(problem);
            }
        }
        filteredProblems.sort(Comparator.comparingInt(Problem::getNumOfSolvers).reversed());
        return filteredProblems.subList(0, Math.min(n, filteredProblems.size()));
    }
}
