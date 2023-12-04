<?php 
	header("Access-Control-Allow-Origin: * "); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
	header("Access-Control-Allow-Methods: GET, POST");
	header("Access-Control-Allow-Headers: Content-Type");

    include 'Conexion.php';
    $list = $data_base->query("");
    $data = $list->fetchAll();
    
    $response['list_crop'] = $data;
    echo json_encode($response);
?>
