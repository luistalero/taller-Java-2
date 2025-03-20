package com.skeletonhexa;

import java.sql.Connection;

import com.skeletonhexa.infrastructure.database.ConnMySql;

public class Main {
    public static void main(String[] args) {
        String entrada = """
        =========================================================
        |   SE HA ESTABLECIDO LA CONEXION A LA BASE DE DATOS    |
        =========================================================    
        """;
        String salida = """
        ===================================================        
        |    LA CONEXION A LA BASE DE DATOS HA FALLADO    |
        ===================================================
        """;
        ConnMySql conexionDB = new ConnMySql();
        try {
            Connection conexion = conexionDB.getConexion();
            if (conexion != null) {
                System.out.println(entrada);

                System.out.println("Cargando Menú Principal...");                 
                Thread.sleep(3000); // Esperar 5 segundos
                limpiarConsola();  
            }
        } catch (Exception e) {
            System.err.println(salida);
            return;
        }
        System.out.println("Hello world!");
    }

    private static void limpiarConsola() {
        try {
            // Intenta limpiar la consola en sistemas Windows
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
               try {
                // Intenta limpiar la consola en sistemas Unix/Linux/Mac
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            } catch (Exception ex) {
                // Si no se puede limpiar la consola, simplemente imprime varias líneas en blanco
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
            }
        }
    }
}