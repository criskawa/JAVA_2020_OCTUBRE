window.onload = listar;

async function listar() {
	const respuesta = await fetch('/servidorrestservlets/api/clientes');
	const clientes = await respuesta.json();

	console.log(clientes);

	const tbody = document.getElementsByTagName('tbody')[0];

	tbody.innerHTML = '';

	let fila;

	clientes.forEach(cliente => {
		fila = document.createElement('tr');
		fila.innerHTML = `
				<th>${cliente.id}</th>
				<td>${cliente.nombre}</td>
				<td>${cliente.apellidos}</td>
				<td>
					<a href="#">Editar</a>
					<a href="javascript:borrar(${cliente.id})">Borrar</a>
				</td>`;

		tbody.appendChild(fila);
	});
}

function borrar(id) {
	fetch('/servidorrestservlets/api/clientes/' + id, { method: 'DELETE' }).then(() => listar());
}