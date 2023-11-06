<?php 
	header("Access-Control-Allow-Origin: * "); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
	header("Access-Control-Allow-Methods: GET, POST");
	header("Access-Control-Allow-Headers: Content-Type");

    include 'Conexion.php';

    $list = $data_base->query("SELECT fincas.*, usuarios.nombre AS user_name, usuarios.cedula AS document FROM fincas JOIN usuarios ON fincas.id_usuario = usuarios.id_usuario");
    $data = $list->fetchAll();

    $response['list_farm'] = $data;
    echo json_encode($response);
    
?>