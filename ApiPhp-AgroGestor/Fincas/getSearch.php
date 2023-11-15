<?php 
	header("Access-Control-Allow-Origin: * "); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
	header("Access-Control-Allow-Methods: GET, POST");
	header("Access-Control-Allow-Headers: Content-Type");

    include 'Conexion.php';

    if (!empty($_POST['farmName'])) {
        $farmName = $_POST['farmName'];
        $list = $data_base->query("SELECT fincas.*, usuarios.nombre AS user_name, usuarios.cedula AS document FROM fincas LEFT JOIN usuarios ON fincas.id_usuario = usuarios.id_usuario WHERE fincas.nombre LIKE '%$farmName%'");
        $data = $list->fetchAll();

        $response['list_farm'] = $data;
        echo json_encode($response);   
    }else{
        echo json_encode($_POST);
    }
    
?>