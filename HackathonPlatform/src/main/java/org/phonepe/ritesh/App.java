package org.phonepe.ritesh;

import org.phonepe.ritesh.enums.DifficultyLevel;
import org.phonepe.ritesh.model.Problem;
import org.phonepe.ritesh.model.User;
import org.phonepe.ritesh.service.*;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserService userService = new UserServiceImpl();
        ProblemService problemService = new ProblemServiceImpl(userService);



        HackathonPlatform platform = new HackathonPlatform(problemService, userService);

        // Sample usage
        platform.addProblem(new Problem("Description 1", "Tag 1", DifficultyLevel.EASY.name(), 10));
        platform.addProblem(new Problem("Description 2", "Tag 2", DifficultyLevel.MEDIUM.name(), 20));
        platform.addProblem(new Problem("Description 3", "Tag 1", DifficultyLevel.HARD.name(), 30));
        platform.addUser(new User("User 1", "Dept 1"));
        platform.addUser(new User("User 2", "Dept 2"));

        // Solving problems by users
        platform.solve(platform.fetchProblems(DifficultyLevel.EASY.name(), "Tag 1").get(0), new User("User 1", "Dept 1"),3.0);
        platform.solve(platform.fetchProblems( DifficultyLevel.MEDIUM.name(), "Tag 2").get(0), new User("User 1", "Dept 1"),5.0);
        platform.solve(platform.fetchProblems( DifficultyLevel.HARD.name(), "Tag 1").get(0), new User("User 2", "Dept 2"),6.0);

        // Fetch solved problems for a user
        System.out.println("Solved problems for User 1:");
        List<Problem> solvedProblems = platform.fetchSolvedProblems(new User("User 1", "Dept 1"));
        for (Problem problem : solvedProblems) {
            System.out.println(problem.getDescription());
        }

        //Get leader
        System.out.println("Leader: " + platform.getLeader().getName());

        // Get top N problems for a specific tag
        System.out.println("Top 2 problems for Tag 1:");
        List<Problem> topProblems = platform.getTopNProblems("Tag 1", 2);
        for (Problem problem : topProblems) {
            System.out.println(problem.getDescription());
        }
    }
}
