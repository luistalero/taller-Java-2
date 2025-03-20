package com.skeletonhexa.infrastructure.database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum AppSingleton {
    INSTANCIA;

    private final Properties propiedades = new Properties();

    AppSingleton() {
        cargarConfiguraciones("configmysql.properties");
    }

    private void cargarConfiguraciones(String rutaArchivo) {
    try (InputStream imputStream = getClass().getClassLoader().getResourceAsStream(rutaArchivo)) {
        if (imputStream == null) {
            throw new IOException("Archivo no encontrado: " + rutaArchivo);
        }
        propiedades.load(imputStream);
        } catch (IOException e) {
            System.err.println("❌ Error cargando configuración: " + e.getMessage());
        }
    }

    public String get(String clave) {
        return propiedades.getProperty(clave, "No encontrado");
    }
}
