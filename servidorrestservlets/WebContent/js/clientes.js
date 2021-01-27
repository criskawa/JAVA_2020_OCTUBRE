const URL = '/servidorrestservlets/api/clientes/';

window.onload = function() {

	listar();

	$('form')[0].onsubmit = function(e) {
		e.preventDefault();

		$('table')[0].style = 'display: block';
		$('form')[0].style = 'display: none';

		const id = parseInt($('#id').value);
		const nombre = $('#nombre').value;
		const apellidos = $('#apellidos').value;

		const cliente = { id, nombre, apellidos };

		console.log(cliente, typeof cliente);

		if (id) {
			fetch(URL + id, { method: 'PUT', body: JSON.stringify(cliente) }).then(() => listar());
		} else {
			fetch(URL, { method: 'POST', body: JSON.stringify(cliente) }).then(() => listar());
		}
	}

	$('#a-insertar').onclick = function(e) {
		e.preventDefault();

		$('table')[0].style = "display: none";
		$('form')[0].style = "display: block";

		$('#id').value = '';
		$('#nombre').value = '';
		$('#apellidos').value = '';
	}
};

async function listar() {
	const respuesta = await fetch(URL);
	const clientes = await respuesta.json();

	console.log(clientes);

	const tbody = $('tbody')[0];

	tbody.innerHTML = '';

	let fila;

	clientes.forEach(cliente => {
		fila = document.createElement('tr');
		fila.innerHTML = `
				<th>${cliente.id}</th>
				<td>${cliente.nombre}</td>
				<td>${cliente.apellidos}</td>
				<td>
					<a href="javascript:editar(${cliente.id})">Editar</a>
					<a href="javascript:borrar(${cliente.id})">Borrar</a>
				</td>`;

		tbody.appendChild(fila);
	});

	$('form')[0].style = 'display: none';
}

async function editar(id) {
	const respuesta = await fetch(URL + id);
	const cliente = await respuesta.json();

	$('#id').value = cliente.id;
	$('#nombre').value = cliente.nombre;
	$('#apellidos').value = cliente.apellidos;

	$('table')[0].style = 'display: none';
	$('form')[0].style = 'display: block';
}

function borrar(id) {
	fetch(URL + id, { method: 'DELETE' }).then(() => listar());
}

window.$ = function(selector) {
	var selectorType = 'querySelectorAll';

	if (selector.indexOf('#') === 0) {
		selectorType = 'getElementById';
		selector = selector.substr(1, selector.length);
	}

	return document[selectorType](selector);
};