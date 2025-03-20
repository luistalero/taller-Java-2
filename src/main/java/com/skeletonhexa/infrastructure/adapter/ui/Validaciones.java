package com.skeletonhexa.infrastructure.adapter.ui;

public class Validaciones {
    public static boolean esEmailValido(String input) {
        return input.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
}
