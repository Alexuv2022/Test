package lesson25;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TypesOfSortTovar {

    public static void printTovarByPriceFromTo(SortedSet<Tovar> tovars) {
        TreeSet<Tovar> sorted = new TreeSet<>(new SortedByPriceFromTo());
        sorted.addAll(tovars);
        System.out.println("--- сортировка по цене от большего к меньшему ---");
        for (Tovar t : sorted) {
            System.out.println(t);
        }
    }

    public static void printTovarByPopular(SortedSet<Tovar> tovars) {
        TreeSet<Tovar> sorted = new TreeSet<>(new Comparator<Tovar>() {
            @Override
            public int compare(Tovar o1, Tovar o2) {

                if (o1.getBuyingCount() != o2.getBuyingCount()) {
                    return o2.getBuyingCount() - o1.getBuyingCount();
                }

                if (o1.getPrice() != o2.getPrice()) {
                    return o2.getPrice() - o1.getPrice();
                }

                if (o1.getSalePrice() != o2.getSalePrice()) {
                    return o2.getSalePrice() - o1.getSalePrice();
                }

                if (!o1.getName().equals(o2.getName())) {
                    return o2.getName().compareTo(o1.getName());
                }
                return 0;
            }
        });
        sorted.addAll(tovars);
        System.out.println("--- сортировка по популярности от большего к меньшему ---");
        for (Tovar t : sorted) {
            System.out.println(t);
        }
    }


    public static void printTovarBySales(SortedSet<Tovar> tovars) {
        TreeSet<Tovar> sorted = new TreeSet<>(new Comparator<Tovar>() {
            @Override
            public int compare(Tovar o1, Tovar o2) {

                if ((o1.getPrice() - o1.getSalePrice()) != (o2.getPrice() - o2.getSalePrice())) {
                    return (o2.getPrice() - o2.getSalePrice()) - (o1.getPrice() - o1.getSalePrice());
                }

                if (o1.getPrice() != o2.getPrice()) {
                    return o2.getPrice() - o1.getPrice();
                }

                if (o1.getBuyingCount() != o2.getBuyingCount()) {
                    return o2.getBuyingCount() - o1.getBuyingCount();
                }



                if (!o1.getName().equals(o2.getName())) {
                    return o2.getName().compareTo(o1.getName());
                }
                return 0;
            }
        });
        sorted.addAll(tovars);
        System.out.println("--- сортировка по размеру скидки от большего к меньшему ---");
        for (Tovar t: sorted) {
            System.out.println(t);
        }
    }
}
