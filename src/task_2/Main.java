package task_2;

public class Main {

    public static void main(String[] args) {
        // Создаём коробки
        Box <Shoes> shoesBox = new ShoesBox();
        Box <Book> bookBox = new BookBox();
        Box <Beer> beerBox = new BeerBox();

        // Кладём вещи в коробки
        shoesBox.put(new Shoes());
        bookBox.put(new Book());
        beerBox.put(new Beer());

        // Открываем коробки
        Shoes shoes = shoesBox.open();
        Book book = bookBox.open();
        Beer beer = beerBox.open();

        // Выводим содержимое коробок
        System.out.println("В обувной коробке находится: " + shoes);
        System.out.println("В книжной коробке находится: " + book);
        System.out.println("В пивной коробке находится: " + beer);

        // Забираем вещи из коробок
        shoesBox.removeFromBox();
        bookBox.removeFromBox();
        beerBox.removeFromBox();

        // Проверяем, что коробки пусты
        if (shoesBox.open() == null) {
            System.out.println("Обувная коробка пуста");
        }
        if (bookBox.open() == null) {
            System.out.println("Книжная коробка пуста");
        }
        if (beerBox.open() == null) {
            System.out.println("Пивная коробка пуста");
        }
    }
}
