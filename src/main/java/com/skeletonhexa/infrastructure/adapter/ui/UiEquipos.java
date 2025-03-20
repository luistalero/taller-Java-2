package com.skeletonhexa.infrastructure.adapter.ui;

import java.util.List;
import java.util.Scanner;

import com.skeletonhexa.infrastructure.database.ConnMySql;
import com.skeletonhexa.infrastructure.database.ConnectionDb;
import com.skeletonhexa.application.usecase.Equipo.EquipoUseCase;
import com.skeletonhexa.domain.entities.Equipo;
import com.skeletonhexa.domain.repository.EquipoRepository;
import com.skeletonhexa.infrastructure.persistence.equipo.EquipoRepositoryImpl;

public class UiEquipos implements Gestionable {
    private final EquipoUseCase EquipoUseCase;

    public UiEquipos(Object object) {
        ConnectionDb connectionDb = new ConnMySql();
        EquipoRepository repositorio = new EquipoRepositoryImpl(connectionDb);
        this.EquipoUseCase = new EquipoUseCase(repositorio);
    }

    @Override
    public void gestionar(Scanner sc) {
        int opcion;
        do {
            String menu = """
            ====================================
            |       GESTION DE EQUIPOS         |
            ====================================
            |    1. Agregar Equipo             |
            |    2. Modificar Equipo           |
            |    3. Eliminar Equipo            |   
            |    4. Listar Equipos             |
            |    5. Volver al menú principal   |
            ====================================
            """;
            System.out.println(menu);
            System.out.print("Seleccione una opción: ");
            while (!sc.hasNextInt()) {
                System.err.println("Error: El valor Ingresado no es valido.");
                sc.next();
                System.out.print("Seleccione una opción: ");
            }
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer
            System.out.println("Cargando...");                 
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } 
                limpiarConsola(); 

            switch (opcion) {
                case 1:
                    agregarEquipo(sc);
                    break;
                case 2:
                    actualizarEquipo(sc);
                    break;
                case 3:
                    eliminarEquipo(sc);
                    break;
                case 4:
                    listarEquipos();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private void agregarEquipo(Scanner sc) {
        while (true) {
            System.out.println("Si desea cancelar esta operacion escriba la palabra 'Cancelar' ");
            int id;
            System.out.print("Ingrese ID del Equipo: ");
            while (!sc.hasNextInt()) {
                System.err.println("Error: El valor Ingresado no es valido.");
                sc.next();
                System.out.print("Ingrese ID del Equipo: ");
            }
            id = sc.nextInt();
            sc.nextLine(); // Consumir la nueva línea
        
        String name;
        while (true) {
            System.out.print("Ingrese Nombre: ");
            name = sc.nextLine().trim();
            if (name.equalsIgnoreCase("cancelar")) return;
            if (name.isEmpty() || !name.matches("^[a-zA-Z ]+$")) {
            System.err.println("Error: El nombre no puede estar vacío y solo debe contener letras.");
        } else {
            break;
        }      
    }
        
        String yearfoundation;
        while (true) {
            System.out.print("Ingrese Año de fundacion: ");
            yearfoundation = sc.nextLine();
            if (yearfoundation.equalsIgnoreCase("cancelar")) return;
            if (name.isEmpty() || !name.matches("^[a-zA-Z ]+$")) {
                System.err.println("Error: Ingrese una fecha valida");
            } else {
                break;
            }
        }

        String coach;
        while (true) {
            System.out.print("Ingrese el nombre de Coach: ");
            coach = sc.nextLine();
            if (coach.equalsIgnoreCase("cancelar")) return;
            if (name.isEmpty() || !name.matches("^[a-zA-Z ]+$")) {
                System.err.println("Error: Ingrese un Nombre Valido.");
        } else {
            break;
        }
    }
            
            EquipoUseCase.registrarEquipo(id, name, yearfoundation, coach);
            System.out.println("✅ Equipo registrado exitosamente.");
            break;
        } 
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 

    } 

    private void actualizarEquipo(Scanner sc) {
        while (true) {
            System.out.println("Si desea cancelar esta operacion escriba la palabra 'Cancelar' ");
            int id;
            System.out.print("Ingrese el ID del equipo a modificar: ");
            while (!sc.hasNextInt()) {
                System.err.println("Error: El valor Ingresado no es valido.");
                sc.next();
                System.out.print("Ingrese el ID del equipo a modificar: ");
            }
            id = sc.nextInt();
            sc.nextLine();

        String name;
        while (true) {
            System.out.print("Ingrese el nuevo nombre: ");
            name = sc.nextLine().trim();
            if (name.equalsIgnoreCase("cancelar")) return;
            if (name.isEmpty() || !name.matches("^[a-zA-Z ]+$")) {
            System.err.println("Error: El nombre no puede estar vacío y solo debe contener letras.");
        } else {
            break;
        }      
    }
        String yearfoundation;
        while (true) {
            System.out.print("Ingrese El Año de fundación: ");
            yearfoundation = sc.nextLine();
            if (yearfoundation.equalsIgnoreCase("cancelar")) return;
            if (name.isEmpty() || !name.matches("^[a-zA-Z ]+$")) {
                System.err.println("Error: Ingrese una fecha valida.");
        } else {
            break;
        }
    }

    String coach;
        while (true) {
            System.out.print("Ingrese el nombre de Coach: ");
            coach = sc.nextLine();
            if (coach.equalsIgnoreCase("cancelar")) return;
            if (name.isEmpty() || !name.matches("^[a-zA-Z ]+$")) {
                System.err.println("Error: Ingrese un Nombre Valido.");
        } else {
            break;
        }
    }

        EquipoUseCase.actualizarEquipo(id, name, yearfoundation, coach);
        limpiarConsola();
        System.out.println("✅ Equipo modificado exitosamente.");
    }
}
    private void eliminarEquipo(Scanner sc) {
        while (true) {
            System.out.println("Si desea cancelar esta operacion escriba la palabra 'Cancelar' ");
            int id;
            System.out.print("Ingrese el ID del equipo a eliminar: ");
            while (!sc.hasNextInt()) {
                System.err.println("Error: El valor Ingresado no es valido.");
                sc.next();
                System.out.print("Ingrese ID del Equipo: ");
            }
            id = sc.nextInt();
            sc.nextLine();
        EquipoUseCase.eliminarEquipo(id);
        limpiarConsola();
        System.out.println("✅ Equipo eliminado exitosamente.");
    }
}
    private void listarEquipos() {
        List<Equipo> equipos = EquipoUseCase.listarEquipos();
        
        if (equipos.isEmpty()) {
            System.out.println("No hay equipo registrados.");
            System.out.println("Debe ingresar Equipos para poder visusalizarlos");

        } else {
            String mensage = """
            +------+----------------------+-----------------------------------------------+
            |  ID  |        Nombre        |     Yearfoundation      |       coach         |
            +------+----------------------+-------------------------+---------------------+
            """;
            System.out.println(mensage);

            for (Equipo equipo : equipos) {
                System.out.println(equipo);
            }

            System.out.println("+------+----------------------+-------------------------+---------------------+");
        }
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
