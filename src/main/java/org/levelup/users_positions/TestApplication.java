package org.levelup.users_positions;


import org.levelup.users_positions.domain.Position;
import org.levelup.users_positions.jdbc.PositionJdbcService;
import org.levelup.users_positions.jdbc.UsersJdbcService;


import java.sql.SQLException;
import java.util.Collection;

public class TestApplication {

    public static void main(String[] args) throws SQLException {

        // test Position Service
        PositionJdbcService positionService = new PositionJdbcService();

        System.out.println(positionService.createPosition("Test_Position"));

        positionService.deletePositionById(25);

        positionService.deletePositionByName("Test_Position");

        Collection<Position> likePositions = positionService.findAllPositionWhichNameLike("Dev%");
        for (Position position : likePositions) {
            System.out.println(position.getId() + " " + position.getName());
        }

        System.out.println(positionService.findPositionById(1));

        Collection<Position> allPositions = positionService.findAllPositions();
        for (Position position : allPositions) {
            System.out.println(position.getId() + " " + position.getName());
        }

        System.out.println(positionService.findPositionByName("prog"));


        // test User Service
        UsersJdbcService userService = new UsersJdbcService();

        System.out.println(userService.createUser("7895 097654","Kolya","Nikolaev"));

        System.out.println(userService.findByPassport("6785 383624"));

        System.out.println(userService.findByLastName("Kozlova"));
        System.out.println(userService.findByNameAndLastName("Oleg","Olegov"));

        System.out.println(userService.updateUser("0972 445672", "Ivan", "Ivanov"));

        userService.deleteUserByPassport("7895 097654");


    }
}
