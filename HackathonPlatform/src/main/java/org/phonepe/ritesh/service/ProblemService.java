package org.phonepe.ritesh.service;

import org.phonepe.ritesh.model.Problem;
import org.phonepe.ritesh.model.User;

import java.util.List;

public interface ProblemService {
    void addProblem(Problem problem);
    List<Problem> fetchProblems(String difficultyLevel, String tag);
    void solve(Problem problem, User user);

    List<Problem> getTopNProblems(String tag, int n);
}
