package task_2;

class Book implements Box<Book> {
    private Book item;
    public Book() {
        this.item = null;
    }
    @Override
    public Book open() {
        return this.item;
    }
    @Override
    public void put(Book item) {
        this.item = item;
    }
    @Override
    public Book removeFromBox() {
        Book itemToReturn = this.item;
        this.item = null;
        return itemToReturn;
    }
}
