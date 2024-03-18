package org.phonepe.ritesh.service;

import org.phonepe.ritesh.model.Problem;
import org.phonepe.ritesh.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<Problem> fetchSolvedProblems(User user);
    User getLeader();
    void addSolvedProblem(User user, Problem problem);
}
