<?php 
	header("Access-Control-Allow-Origin: * "); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
	header("Access-Control-Allow-Methods: GET, POST");
	header("Access-Control-Allow-Headers: Content-Type");

    include 'Conexion.php';

    $consultation = $data_base->query("SELECT * FROM usuarios WHERE rol LIKE 'ADMIN'");
    $data = $consultation->fetchAll();

    $response['admins'] = $data;
    echo json_encode($response);
    
?>