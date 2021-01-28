const URL = '/servidorrestservlets/api/clientes/';

$(function() {

	listar();

	$('form').on('submit', function(e) {
		e.preventDefault();

		$('table').show();
		$('form').hide();

		var id = parseInt($('#id').val());
		var nombre = $('#nombre').val();
		var apellidos = $('#apellidos').val();

		var cliente = { id, nombre, apellidos };

		console.log(cliente, typeof cliente);

		if (id) {
			$.ajax(URL + id, { method: 'PUT', data: JSON.stringify(cliente), contentType: 'application/json' }).then(listar);
		} else {
			$.ajax(URL, { method: 'POST', data: JSON.stringify(cliente), contentType: 'application/json' }).then(listar);
		}
	});

	$('#a-insertar').on('click', function(e) {
		e.preventDefault();

		$('table').hide();
		$('form').show();

		$('#id').val('');
		$('#nombre').val('');
		$('#apellidos').val('');
	});
});

function listar() {
	$.getJSON(URL, function(clientes) {
		console.log(clientes);

		var tbody = $('tbody');

		tbody.empty();

		$(clientes).each(function() {
			$('<tr>'
				+ '<th>' + this.id + '</th>'
				+ '<td>' + this.nombre + '</td>'
				+ '<td>' + this.apellidos + '</td>'
				+ '<td><a href="javascript:editar(' + this.id + ')">Editar</a><a href="javascript:borrar(' + this.id + ')">Borrar</a></td>')
				.appendTo(tbody);
		});

		$('table').show();
		$('form').hide();
	});


}

function editar(id) {
	$.getJSON(URL + id, function(cliente) {
		$('#id').val(cliente.id);
		$('#nombre').val(cliente.nombre);
		$('#apellidos').val(cliente.apellidos);

		$('table').hide();
		$('form').show();
	});
}

function borrar(id) {
	$.ajax(URL + id, { method: 'DELETE' }).then(listar);
}
