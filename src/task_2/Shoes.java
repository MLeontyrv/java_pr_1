package task_2;

class Shoes implements Box<Shoes> {
    private Shoes item;
    public Shoes() {
        this.item = null;
    }
    @Override
    public Shoes open() {
        return this.item;
    }
    @Override
    public void put(Shoes item) {
        this.item = item;
    }
    @Override
    public Shoes removeFromBox() {
        Shoes itemToReturn = this.item;
        this.item = null;
        return itemToReturn;
    }
}