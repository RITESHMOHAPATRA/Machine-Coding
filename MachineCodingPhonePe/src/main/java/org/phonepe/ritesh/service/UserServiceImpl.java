package org.phonepe.ritesh.service;

import org.phonepe.ritesh.model.Problem;
import org.phonepe.ritesh.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService{
    private Map<User, List<Problem>> userSolvedProblems;
    private User leader;

    public UserServiceImpl() {
        this.userSolvedProblems = new HashMap<>();
        this.leader = null;
    }

    @Override
    public void addUser(User user) {
        userSolvedProblems.put(user, new ArrayList<>());
    }

    @Override
    public List<Problem> fetchSolvedProblems(User user) {
        return userSolvedProblems.getOrDefault(user, new ArrayList<>());
    }

    @Override
    public User getLeader() {
        if (leader != null) {
            return leader;
        }
        int maxSolved = -1;
        for (Map.Entry<User, List<Problem>> entry : userSolvedProblems.entrySet()) {
            int solvedCount = entry.getValue().size();
            if (solvedCount > maxSolved) {
                maxSolved = solvedCount;
                leader = entry.getKey();
            }
        }
        return leader;
    }

    @Override
    public void addSolvedProblem(User user, Problem problem) {
        List<Problem> solvedProblems = userSolvedProblems.get(user);
        if (solvedProblems != null) {
            solvedProblems.add(problem);
        }
    }

    public void setLeader(User leader) {
        this.leader = leader;
    }

    public void setUserSolvedProblems(Map<User, List<Problem>> userSolvedProblems) {
        this.userSolvedProblems = userSolvedProblems;
    }
}
