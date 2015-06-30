package org.inno.control;

import javafx.collections.ObservableList;

import org.inno.model.Node;

import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;


/**
 * @author spindizzy
 */
final class ListLookupListener<T extends Node> implements LookupListener {
    private final ObservableList<T> list;

    private final Lookup.Result<T> result;

    public ListLookupListener(final ObservableList<T> list, final Lookup.Result<T> result) {
        this.list = list;
        this.result = result;
        result.addLookupListener(this);
    }

    @Override
    public void resultChanged(final LookupEvent le) {
        list.clear();
        list.addAll(result.allInstances());
    }
}
