package task_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import task_3.*;

public class EmployeeManagementSystem {
    private List<Division> divisions = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        EmployeeManagementSystem system = new EmployeeManagementSystem();

        // Создаём три отдела
        Division salesDivision = new Division("Отдел продаж");
        Division marketingDivision = new Division("Отдел маркетинга");
        Division developmentDivision = new Division("Отдел разработки");
        system.divisions.add(salesDivision);
        system.divisions.add(marketingDivision);
        system.divisions.add(developmentDivision);

        // Добавляем сотрудников в отделы
        salesDivision.addEmployer(new Employer("Иванов Иван Иванович", 50000 * PositionType.HEAD.multiplier, PositionType.HEAD, salesDivision));
        salesDivision.addEmployer(new Employer("Петров Петр Петрович", 40000 * PositionType.MANAGER.multiplier, PositionType.MANAGER, salesDivision));
        salesDivision.addEmployer(new Employer("Сидоров Сидор Сидорович", 30000 * PositionType.WORKER.multiplier, PositionType.WORKER, salesDivision));

        marketingDivision.addEmployer(new Employer("Васильев Василий Васильевич", 40000 * PositionType.HEAD.multiplier, PositionType.HEAD, marketingDivision));
        marketingDivision.addEmployer(new Employer("Смирнов Сергей Сергеевич", 30000 * PositionType.MANAGER.multiplier, PositionType.MANAGER, marketingDivision));
        marketingDivision.addEmployer(new Employer("Пупкин Иван Иванович", 20000 * PositionType.WORKER.multiplier, PositionType.WORKER, marketingDivision));

        developmentDivision.addEmployer(new Employer("Андреев Андрей Андреевич", 30000 * PositionType.HEAD.multiplier, PositionType.HEAD, developmentDivision));
        developmentDivision.addEmployer(new Employer("Козлов Константин Константинович", 20000 * PositionType.MANAGER.multiplier, PositionType.MANAGER, developmentDivision));
        developmentDivision.addEmployer(new Employer("Михайлов Михаил Михайлович", 10000 * PositionType.WORKER.multiplier, PositionType.WORKER, developmentDivision));

        // Сохраняем список сотрудников в файл CSV
        PrintWriter writer = new PrintWriter("employees.csv");
        for (Division division : system.divisions) {
            for (Employer employer : division.getEmployerList()) {
                writer.println(employer.getName() + "," + employer.getPosition().name() + "," + employer.getSalary() + "," + division.getName());
            }
        }
        writer.close();

        // Загружаем структуру компании из CSV файла
        Scanner scanner = new Scanner(new BufferedReader(new FileReader("employees.csv")));
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(",");
            Employer employer = new Employer(line[0], Integer.parseInt(line[2]), PositionType.valueOf(line[1]), system.getDivisionByName(line[3]));
            system.getDivisionByName(line[3]).addEmployer(employer);
        }
        scanner.close();

        // Выводим информацию о каждом отделе
        for (Division division : system.divisions) {
            System.out.println("Отдел: " + division.getName());
            System.out.println("Глава отдела: " + division.getHeadOfDivision().getName());
            System.out.println("Количество сотрудников: " + division.getEmployerList().size());
            System.out.println("Средняя зарплата: " + division.getAverageSalary());
        }
    }
    public Division getDivisionByName(String name) {
        for (Division division : divisions) {
            if (division.getName().equals(name)) {
                return division;
            }
        }
        return null;
    }
}
