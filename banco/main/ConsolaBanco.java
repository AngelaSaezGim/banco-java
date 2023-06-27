package banco.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import banco.modelos.Cliente;
import banco.modelos.Gestor;
import banco.modelos.Mensaje;
import banco.modelos.Transferencia;
import banco.util.Utiles;

public class ConsolaBanco {
	
	
	//MAIN

	public static void main(String[] args) {
		
		ConsolaBanco banco = new ConsolaBanco();
		
		banco.SelectorMenus();

	}

	
	//Atributos clase
	
	private List<Gestor> gestores;
	private Integer siguienteIdGestor;
	
	private Scanner teclado;
	
	private List<Cliente> clientes;
	private Integer siguienteIdCliente;
	
	private List<Mensaje> mensajes;
	private Integer siguienteIdMensaje;
	
	private List<Transferencia>transferencias;
	private Integer siguienteIdTransferencia;
	
	//Constructor - inicializar atributos
	ConsolaBanco(){
		
		this.gestores = new ArrayList<>();
		this.siguienteIdGestor = 1;
		this.teclado = new Scanner(System.in);
		
		this.clientes = new ArrayList<>();
		this.siguienteIdCliente = 1;
		
		this.mensajes = new ArrayList<>();
		this.siguienteIdMensaje = 1;
		
		this.transferencias = new ArrayList<>();
		this.siguienteIdTransferencia = 1;
		
	}
	
	private void SelectorMenus() {
		
		int opcion = -1;
		
		do {
		System.out.println("\n1. Menu Gestores");
		System.out.println("2. Menu Clientes");
		System.out.println("3. Menu Mensajes");
		System.out.println("4. Menu Transferencias");
		System.out.println("5. Login");
		System.out.println("6. Register");
		System.out.println("0. Cerrar");
		System.out.print("Selecciona una opción: ");
		opcion = teclado.nextInt();
		
		switch (opcion) {
		case 1:
			iniciarMenuGestores();
			break;
		case 2:
			iniciarMenuClientes();
			break;
		case 3:	
			iniciarMenuMensajes();
			break;
		case 4:
			iniciarMenuTransferencias();
			break;
		case 5:
			login();
		case 6:
			register();
			break;
		case 0:
			cerrarGestor();
			break;
		}
		}while (opcion != 0);
		
		
	}
	
	private void iniciarMenuGestores() {
		
		int opcion = -1;

		do {
			
			mostrarMenuGestor();
			
			System.out.print("Selecciona una opción: ");
			opcion = teclado.nextInt();

			switch (opcion) {
			case 1:
				insertarGestor();
				break;
			case 2:
				insertarGestoresDePrueba();
				break;
			case 3:
				consultarGestor();
				break;
			case 4:
				mostrarGestores();
				break;
			case 5:
				actualizarGestor();
				break;
			case 6:
				eliminarGestor();
				break;
			case 0:
				SelectorMenus();
				break;
			default:
				System.out.println("Opción desconocida...");
			}

		} while (opcion != 0);
		
	}
	
	private void iniciarMenuClientes() {
		
		
		int opcion = -1;

		do {
			
			mostrarMenuCliente();
			
			System.out.print("Selecciona una opción: ");
			opcion = teclado.nextInt();

			switch (opcion) {
			case 1:
				insertarCliente();
				break;
			case 2:
				consultarCliente();
				break;
			case 3:
				mostrarClientes();
				break;
			case 4:
				actualizarCliente();
				break;
			case 5:
				eliminarCliente();
				break;
			case 0:
				SelectorMenus();
				break;
			default:
				System.out.println("Opción desconocida...");
			}

		} while (opcion != 0);	
	}

	private void iniciarMenuMensajes(){
		
		int opcion = -1;

		do {
			System.out.println("\n1. Obtener un mensaje");
			System.out.println("2. Obtener todos los mensajes");
			System.out.println("3. Envíar un mensaje");
			System.out.println("0. Atrás");
			System.out.print("Selecciona una opción: ");
			opcion = teclado.nextInt();

			switch (opcion) {
			case 1:
				consultarMensaje();
				break;
			case 2:
				mostrarMensaje();
				break;
			case 3:
				enviarMensaje();
				break;
			case 0:
				SelectorMenus();
				break;
			default:
				System.out.println("Opción desconocida...");
			}

		} while (opcion != 0);	
		
	}
	
	private void iniciarMenuTransferencias() {
		
		int opcion = -1;

		do {
			System.out.println("\n1. Obtener transferencia");
			System.out.println("2. Obtener todas las transferencias");
			System.out.println("3. Envíar transferencias");
			System.out.println("0. Atrás");
			System.out.print("Selecciona una opción: ");
			opcion = teclado.nextInt();

			switch (opcion) {
			case 1:
				consultarTransferencia();
				break;
			case 2:
				mostrarTransferencias();
				break;
			case 3:
				enviarTransferencia();
				break;
			case 0:
				SelectorMenus();
				break;
			default:
				System.out.println("Opción desconocida...");
			}

		} while (opcion != 0);	
		
		
	}
	
	private void cerrarGestor() {
		
		teclado.close();
		System.out.println("¡Hasta pronto!");
		
	}
	
	private void register() {
		
		System.out.println("Registrado");
	}
	
	private void login() {
		
		System.out.print("id gestor: ");
		int idGestor = teclado.nextInt();
		System.out.print("Contraseña: ");
		String pass = teclado.nextLine();
		Gestor gestor = buscarGestorPorId(idGestor);
		if(gestor != null) {
			if(gestor.getPassword().equals(pass)) {
				System.out.println("Sesión Inciada");
				
			}else {
				System.out.println("Login Incorrecto");
			}
		}
		else {
			System.out.println("Usuario no existe");
		}
	}
	
	//Aqui empiezan las funciones correspondientes
	
	private void mostrarMenuCliente() {
	
		System.out.println("\n1. Insertar cliente");
		System.out.println("2. Consultar cliente");
		System.out.println("3. Ver todos los clientes");
		System.out.println("4. Actualizar clientes");
		System.out.println("5. Eliminar cliente");
		System.out.println("0. Atrás\n");
		
	}
	
	private void mostrarMenuGestor() {
		
		System.out.println("\n1. Insertar gestor");
		System.out.println("2. Insertar gestores de prueba");
		System.out.println("3. Consultar gestor");
		System.out.println("4. Ver todos los gestores");
		System.out.println("5. Actualizar gestor");
		System.out.println("6. Eliminar un gestor");
		System.out.println("0. Atrás\n");
		
	}
	
	private void insertarGestor() {
		
		System.out.print("Nombre: ");
		String nombre = teclado.next();
		System.out.print("Email: ");
		String email = teclado.next();
		System.out.print("Contraseña: ");
		String pass = teclado.next();
		System.out.print("Oficina: ");
		String oficina = teclado.next();
		Gestor nuevoGestor = new Gestor(siguienteIdGestor, nombre, pass, email, oficina);
		gestores.add(nuevoGestor);
		siguienteIdGestor++;
		System.out.println("Gestor creado con éxito.");	
	}
	
	private void insertarCliente() {
		
		System.out.print("Nombre: ");
		String nombre = teclado.next();
		System.out.print("Email: ");
		String email = teclado.next();
		System.out.print("Contraseña: ");
		String pass = teclado.next();
		System.out.print("Saldo: ");
		double saldo = teclado.nextDouble();
		System.out.print("id del Gestor: ");
		int idGestor = teclado.nextInt();
		Cliente nuevoCliente = new Cliente(siguienteIdCliente, nombre, pass, email, saldo, idGestor);
		clientes.add(nuevoCliente);
		siguienteIdCliente++;
		System.out.println("Cliente creado con éxito.");	
	}
	
	private void enviarMensaje() {
		
		System.out.println("Enviando mensaje");
		System.out.print("id destino: ");
		int idDestino = teclado.nextInt();
		System.out.print("Texto:  ");
		String texto = teclado.next();
		Mensaje nuevoMensaje = new Mensaje(siguienteIdMensaje, siguienteIdMensaje, idDestino, texto);
		mensajes.add(nuevoMensaje);
		siguienteIdMensaje++;
		System.out.println("Mensaje enviado con éxito.");
		
	}
	
	private void enviarTransferencia() {
		
		System.out.println("Enviando Transferencia");
		System.out.print("id destino: ");
		int idDestino = teclado.nextInt();
		System.out.print("Dinero a enviar;  ");
		double saldo = teclado.nextDouble();
		Transferencia nuevoTransferencia = new Transferencia(siguienteIdTransferencia, siguienteIdTransferencia, idDestino, saldo);
		transferencias.add(nuevoTransferencia);
		siguienteIdTransferencia++;
		System.out.println("Transferencia enviada con éxito.");
	}
	
	private void insertarGestoresDePrueba() {
		
		System.out.print("Número de gestores: ");
		int numeroGestores = teclado.nextInt();
		for (int i = 0; i < numeroGestores; i++) {
			String usuario = Utiles.nombreAleatorio();
			String correo = Utiles.correoAleatorio();
			Gestor gestor = new Gestor(siguienteIdGestor, usuario, "", correo, "Valencia");
			gestores.add(gestor);
			siguienteIdGestor++;
		}
		
	}
	
	private void consultarGestor() {
		
		System.out.print("Id del gestor a consultar: ");
		int idGestor = teclado.nextInt();
		Gestor gestorResultado = buscarGestorPorId(idGestor);
		// si se ha encontrado
		if (gestorResultado != null) {
			System.out.println(gestorResultado);
		} else {
			System.out.println("No se pudo encontrar un gestor con el id " + idGestor);
		}
		
	}
		
		private Gestor buscarGestorPorId(int id) {
			Gestor gestorResultado = null;
			for (int i = 0; i < gestores.size(); i++) {
				Gestor gestor = gestores.get(i);
				if (gestor.getId() == id) {
					gestorResultado = gestor;
					// como ya lo hemos encontrado, rompemos el bucle
					return gestorResultado;
				}
			}
			return null;
		
	}
		
	private void consultarCliente() {
		
		System.out.print("Id del cliente a consultar: ");
		int idCliente = teclado.nextInt();
		Cliente clienteResultado = buscarClientePorId(idCliente);
		// si se ha encontrado
		if (clienteResultado != null) {
			System.out.println(clienteResultado);
		} else {
			System.out.println("No se pudo encontrar un cliente con el id " + idCliente);
		}
		
	}
		
		private Cliente buscarClientePorId(int id) {
			Cliente clienteResultado = null;
			for (int i = 0; i < clientes.size(); i++) {
				Cliente cliente = clientes.get(i);
				if (cliente.getId() == id) {
					clienteResultado = cliente;
					// como ya lo hemos encontrado, rompemos el bucle
					return clienteResultado;
				}
			}
			return null;
	}
		
	private void consultarMensaje() {
		
		System.out.print("Id del mensaje a consultar: ");
		int idMensaje = teclado.nextInt();
		Mensaje mensajeResultado = buscarMensajePorId(idMensaje);
		// si se ha encontrado
		if (mensajeResultado != null) {
			System.out.println(mensajeResultado);
		} else {
			System.out.println("No se pudo encontrar un mensaje con el id " + idMensaje);
		}
		
	}
		
		private Mensaje buscarMensajePorId(int id) {
			Mensaje mensajeResultado = null;
			for (int i = 0; i < mensajes.size(); i++) {
				Mensaje mensaje = mensajes.get(i);
				if (mensaje.getId() == id) {
					mensajeResultado = mensaje;
					// como ya lo hemos encontrado, rompemos el bucle
					return mensajeResultado;
				}
			}
			return null;
		
	}
		
	private void consultarTransferencia() {
		
		System.out.print("Id de la transferencia a consultar: ");
		int idTransferencia = teclado.nextInt();
		Transferencia transferenciaResultado = buscarTransferenciaPorId(idTransferencia);
		// si se ha encontrado
		if (transferenciaResultado != null) {
			System.out.println(transferenciaResultado);
		} else {
			System.out.println("No se pudo encontrar un mensaje con el id " + idTransferencia);
		}
		
	}
		
		private Transferencia buscarTransferenciaPorId(int id) {
			Transferencia transferenciaResultado = null;
			for (int i = 0; i < transferencias.size(); i++) {
				Transferencia transferencia = transferencias.get(i);
				if (transferencia.getId() == id) {
					transferenciaResultado = transferencia;
					// como ya lo hemos encontrado, rompemos el bucle
					return transferenciaResultado;
				}
			}
			return null;
		
		
		
		
		
	}
		
	private void mostrarGestores() {
		
		if (gestores.isEmpty()) {
			System.out.println("Todavía no hay gestores.");
		}
		gestores.forEach(gestor -> {
			System.out.println(gestor);
		});	
	}
	
	private void mostrarClientes() {
		
		if (clientes.isEmpty()) {
			System.out.println("Todavía no hay clientes.");
		}
		clientes.forEach(cliente -> {
			System.out.println(cliente);
		});	
		
	}
	
	private void mostrarMensaje() {
		
		if (mensajes.isEmpty()) {
			System.out.println("Todavía no hay mensajes.");
		}
		mensajes.forEach(mensaje -> {
			System.out.println(mensaje);
		});
		
		
	}
	
	private void mostrarTransferencias() {
		
		if (transferencias.isEmpty()) {
			System.out.println("Todavía no hay transferencias.");
		}
		transferencias.forEach(transferencia -> {
			System.out.println(transferencia);
		});
		
	}
	
	private void actualizarGestor() {
		
		System.out.print("Id del gestor a actualizar: ");
		int idGestor = teclado.nextInt();
		Gestor gestorResultado = buscarGestorPorId(idGestor);
		// si se ha encontrado
		if (gestorResultado != null) {
			System.out.println(gestorResultado);
			System.out.println("[n] Nombre");
			System.out.println("[e] Email");
			System.out.println("[c] Contraseña");
			System.out.println("[o] Oficina");
			System.out.println("[x] Cancelar");
			System.out.print("Campo a actualizar: ");
			char opcionActualizar = teclado.next().charAt(0);
			switch (opcionActualizar) {
			case 'n':
				System.out.print("Nombre: ");
				String nombre = teclado.next();
				gestorResultado.setUsuario(nombre);
				break;
			case 'e':
				System.out.print("Email: ");
				String email = teclado.next();
				gestorResultado.setCorreo(email);
				break;
			case 'c':
				System.out.print("Contraseña: ");
				String pass = teclado.next();
				gestorResultado.setPassword(pass);
				break;
			case 'o':
				System.out.print("Oficina: ");
				String oficina = teclado.next();
				gestorResultado.setOficina(oficina);
				break;
			case 'x':
				System.out.print("Cancelando actualización...");
				break;
			default:
				System.out.println("Opción no válida.");
			}
			if (opcionActualizar != 'x') {
				System.out.println("Se actualizó el gestor con el id " + idGestor);
			}
		} else {
			System.out.println("No se pudo encontrar un gestor con el id " + idGestor);
		}
		
	}
	
	private void actualizarCliente() {
		
		System.out.print("Id del cliente a actualizar: ");
		int idCliente = teclado.nextInt();
		Cliente clienteResultado = buscarClientePorId(idCliente);
		// si se ha encontrado
		if (clienteResultado != null) {
			System.out.println(clienteResultado);
			System.out.println("[n] Nombre");
			System.out.println("[e] Email");
			System.out.println("[c] Contraseña");
			System.out.println("[o] Saldo");
			System.out.println("[x] Cancelar");
			System.out.print("Campo a actualizar: ");
			char opcionActualizar = teclado.next().charAt(0);
			switch (opcionActualizar) {
			case 'n':
				System.out.print("Nombre: ");
				String nombre = teclado.next();
				clienteResultado.setUsuario(nombre);
				break;
			case 'e':
				System.out.print("Email: ");
				String email = teclado.next();
				clienteResultado.setCorreo(email);
				break;
			case 'c':
				System.out.print("Contraseña: ");
				String pass = teclado.next();
				clienteResultado.setPassword(pass);
				break;
			case 'o':
				System.out.print("Saldo: ");
				Double saldo = teclado.nextDouble();
				clienteResultado.setSaldo(saldo);
				break;
			case 'x':
				System.out.print("Cancelando actualización...");
				break;
			default:
				System.out.println("Opción no válida.");
			}
			if (opcionActualizar != 'x') {
				System.out.println("Se actualizó el cliente con el id " + idCliente);
			}
		} else {
			System.out.println("No se pudo encontrar un cliente con el id " + idCliente);
		}
	}
	
	private void eliminarGestor() {
		
		System.out.print("Id del gestor a eliminar: ");
		int idGestor = teclado.nextInt();
		Gestor gestorResultado = null;
		int posicionGestor = -1;
		for (int i = 0; i < gestores.size(); i++) {
			Gestor gestor = gestores.get(i);
			if (gestor.getId() == idGestor) {
				gestorResultado = gestor;
				posicionGestor = i;
				// como ya lo hemos encontrado, rompemos el bucle
				break;
			}
		}
		// si se ha encontrado
		if (gestorResultado != null) {
			gestores.remove(posicionGestor);
			System.out.println("Se eliminó el gestor con el id " + idGestor);
		} else {
			System.out.println("No se pudo encontrar un gestor con el id " + idGestor);
		}
	}
	
	
	private void eliminarCliente() {
		
		System.out.print("Id del cliente a eliminar: ");
		int idCliente = teclado.nextInt();
		Cliente clienteResultado = null;
		int posicionCliente = -1;
		for (int i = 0; i < clientes.size(); i++) {
			Cliente cliente = clientes.get(i);
			if (cliente.getId() == idCliente) {
				clienteResultado = cliente;
				posicionCliente = i;
				// como ya lo hemos encontrado, rompemos el bucle
				break;
			}
		}
		// si se ha encontrado
		if (clienteResultado != null) {
			clientes.remove(posicionCliente);
			System.out.println("Se eliminó el cliente con el id " + idCliente);
		} else {
			System.out.println("No se pudo encontrar un cliente con el id " + idCliente);
		}	
		
		
	}
}
