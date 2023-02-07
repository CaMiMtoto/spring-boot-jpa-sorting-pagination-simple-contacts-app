package com.codewithjeanpaul.contacts_app.helpers;

public class CustomHelper {

    public static String formatPrice(double price) {
        return String.format("$%.2f", price);
    }

    public static String currentSortClass(String sortField, String sortDir) {
        if (sortField.equals(sortDir)) {
            return sortDir.equals("asc") ? "sort-asc" : "sort-desc";
        }
        return "";
    }


}
