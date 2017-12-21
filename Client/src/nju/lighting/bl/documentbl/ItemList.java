package nju.lighting.bl.documentbl;

import nju.lighting.po.doc.DocPO;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created on 2017/12/18.
 * Description:
 * @author Liao
 */
public class ItemList<Item> {
    private List<Item> items;

    public ItemList() {
        items = new ArrayList<>();
    }

    public  <T> void add(T t, Function<T, Item> function) {
        items.add(function.apply(t));
    }

    public  <PO> List<PO> toPO(String docId, Function<Item, PO> function) {
        return items.stream().map(function).collect(Collectors.toList());
    }

    public <Attribute> boolean containItemWithAttribute(Attribute attribute, Function<Item, Attribute> function) {
        for (Item i : items) {
            if (attribute.equals(function.apply(i)))
                return true;
        }
        return false;
    }
}
