package org.phonepe.ritesh.service;

import org.phonepe.ritesh.model.Problem;
import org.phonepe.ritesh.model.User;

import java.util.List;

public class HackathonPlatform {
    private ProblemService problemService;
    private UserService userService;


    public HackathonPlatform(ProblemService problemService, UserService userService) {
        this.problemService = problemService;
        this.userService = userService;
    }

    public void addProblem(Problem problem) {
        problemService.addProblem(problem);
    }

    public void addUser(User user) {
        userService.addUser(user);
    }

    public List<Problem> fetchProblems(String difficultyLevel, String tag) {
        return problemService.fetchProblems(difficultyLevel, tag);
    }

    public void solve(Problem problem, User user,Double timeTaken) {
        problemService.solve(problem, user);
        problem.addToTotalTimeTaken(timeTaken);
    }

    public List<Problem> fetchSolvedProblems(User user) {
        return userService.fetchSolvedProblems(user);
    }

    public User getLeader() {
        return userService.getLeader();
    }

    public List<Problem> getTopNProblems(String tag, int n) {
        return problemService.getTopNProblems(tag, n);
    }

}
