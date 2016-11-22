package com.globant.android101.utils;


import com.globant.android101.services.ItemService;

public final class ServiceUtils {
    private static ItemService itemService;

    private ServiceUtils() {
    }

    public static final ItemService getItemService() {
        if (itemService == null) {
            itemService = new ItemService(BusProvider.getInstance());
        }
        return itemService;
    }
}
