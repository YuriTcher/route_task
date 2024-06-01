import java.util.*;

public class Main {

    private static final String ROUTE = "Москва Рязань Самара Краснодар Брянск Калининград Пермь Хабаровск Владивосток";

    public static void main(String[] args) {
        Map<String, String> first = new HashMap<>(); // мапа для поиска первого города в маршруте
        Map<String, String> second = new HashMap<>(); // мапа для получения следующего города по ключу
        StringBuilder sb = new StringBuilder(); // результирующая строка
        String current = null; // текущий город

        Path[] paths = init(); // инициализируем массив данных, содержащий маршруты между двумя городами

        // перебираем список и создаем мапы
        // (линейная O(n))
        for (Path path : paths) {
            first.put(path.getTo(), path.getFrom());
            second.put(path.getFrom(), path.getTo());
        }

        // 1 ищем первый город в маршруте
        // (линейная O(n))
        for (Map.Entry<String, String> entry : first.entrySet()) {
            String value = entry.getValue();
            if (!first.containsKey(value)) {
                current = value;
                sb.append(current);
                break;
            }
        }

        // пока мапа содержит ключ равный текущему городу, продолжаем искать следующий город
        // (постоянная O(1))
        while(second.containsKey(current)) {
            current = second.get(current);
            sb.append(" ").append(current);
        }

        String result = sb.toString();
        System.out.printf("Результат ==> %s", result);
        System.out.println();
        System.out.printf("Результат и входная строка равны? %b", result.equals(ROUTE));
    }

    /**
     * @return перемешанный массив объектов класса Path, на основе строки ROUTE
     */
    private static Path[] init() {
        String[] cities = ROUTE.split(" ");
        List<Path> paths = new ArrayList<>();

        for (int i = 0; i < cities.length - 1; i++) {
            Path path = new Path(cities[i], cities[i + 1]);
            paths.add(path);
        }

        Collections.shuffle(paths);
        Path[] array = new Path[paths.size()];
        return paths.toArray(array);
    }
}