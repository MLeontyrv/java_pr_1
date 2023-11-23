package task_2;

class Beer implements Box<Beer> {
    private Beer item;
    public Beer() {
        this.item = null;
    }
    @Override
    public Beer open() {
        return this.item;
    }
    @Override
    public void put(Beer item) {
        this.item = item;
    }
    @Override
    public Beer removeFromBox() {
        Beer itemToReturn = this.item;
        this.item = null;
        return itemToReturn;
    }
}
