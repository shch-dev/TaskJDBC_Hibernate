package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

        //Создание таблицы User(ов)
        userDaoHibernate.createUsersTable();

        //Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
        userDaoHibernate.saveUser("Ivan", "Ivanov", (byte) 5);
        userDaoHibernate.saveUser("Bob", "Marlow", (byte) 5);
        userDaoHibernate.saveUser("Max", "Maslow", (byte) 5);
        userDaoHibernate.saveUser("Vitalik", "Bobrov", (byte) 5);

        //Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
        List<User> userList = userDaoHibernate.getAllUsers();
        userList.forEach(System.out::println);

        //Очистка таблицы User(ов)
        userDaoHibernate.cleanUsersTable();

        //Удаление таблицы
        userDaoHibernate.dropUsersTable();
    }
}
