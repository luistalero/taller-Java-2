package com.skeletonhexa.infrastructure.adapter.ui;

public class UiPrincipal {
    public static Gestionable getMenu(int option) {
        switch (option) {
            case 1: return new UiEquipos(null);
            //// case 2: return new UiEstadisticas(null);
            //// case 3: return new UiPlayers(null);
            default: return null;
        }
    }
}
