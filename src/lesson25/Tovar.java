package lesson25;

public class Tovar implements Comparable<Tovar> {
    private String Name;
    private int price;
    private int salePrice;
    private int buyingCount;

    public Tovar() {
    }

    public Tovar(String name, int price, int salePrice, int buyingCount) {
        Name = name;
        this.price = price;
        this.salePrice = salePrice;
        this.buyingCount = buyingCount;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public int getBuyingCount() {
        return buyingCount;
    }

    public void setBuyingCount(int buyingCount) {
        this.buyingCount = buyingCount;
    }

    @Override
    public String toString() {
        return "Tovar{" +
                "Name='" + Name + '\'' +
                ", price=" + price +
                ", salePrice=" + salePrice +
                ", buyingCount=" + buyingCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tovar tovar = (Tovar) o;

        if (price != tovar.price) return false;
        if (salePrice != tovar.salePrice) return false;
        if (buyingCount != tovar.buyingCount) return false;
        return Name != null ? Name.equals(tovar.Name) : tovar.Name == null;
    }

    @Override
    public int hashCode() {
        int result = Name != null ? Name.hashCode() : 0;
        result = 31 * result + price;
        result = 31 * result + salePrice;
        result = 31 * result + buyingCount;
        return result;
    }


    @Override
    public int compareTo(Tovar o) {
        // от самого дешевого до самого дорогого
        // this - первый товар
        // o - второй товар
        if (this.getPrice() != o.getPrice()) {
            return this.getPrice() - o.getPrice();
        }

        if (this.getSalePrice() != o.getSalePrice()) {
            return this.getSalePrice() - o.getSalePrice();
        }

        if (this.getBuyingCount() != o.getBuyingCount()) {
            return this.getBuyingCount() - o.getBuyingCount();
        }

        if (!this.getName().equals(o.getName())) {
            return this.getName().compareTo(o.getName());
        }

        return 0;
    }
}
