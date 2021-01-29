const URL = '/servidorrestservlets/api/v2/clientes/';

$(function() {

	listar();

	$('form').on('submit', function(e) {
		e.preventDefault();

		enviarFormulario();
	});

	$('#a-insertar').on('click', function(e) {
		e.preventDefault();

		mostrarFormulario();
	});
});

function mostrarFormulario() {
	$('table').hide();
	$('form').show();

	$('#id').val('');
	$('#nombre').val('');
	$('#apellidos').val('');
}

function enviarFormulario() {

	var id = parseInt($('#id').val());
	var nombre = $('#nombre').val();
	var apellidos = $('#apellidos').val();

	var cliente = { id, nombre, apellidos };

	console.log(cliente, typeof cliente);

	if (id) {
		// Editar
		$.ajax(URL + id, { method: 'PUT', data: JSON.stringify(cliente), contentType: 'application/json' }).then(
			listar, mostrarErrores);
	} else {
		// Añadir
		$.ajax(URL, { method: 'POST', data: JSON.stringify(cliente), contentType: 'application/json' }).then(
			listar, mostrarErrores);
	}
}

function mostrarErrores(peticion) {//( jqXHR, textStatus, errorThrown ) {
	//console.log( jqXHR, textStatus, errorThrown );

	var errores = peticion.responseJSON;

	//$('#nombre ~ span').remove();
	//$('#apellidos ~ span').remove();
	$('span.error').remove();

	if (errores.nombre) {
		$('#nombre').after($('<span class="error">' + errores.nombre + '</span>'));
	}

	if (errores.apellidos) {
		$('#apellidos').after($('<span class="error">' + errores.apellidos + '</span>'));
	}
}

function listar(data, textStatus, jqXHR) {
	console.log(data, textStatus, jqXHR);

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
