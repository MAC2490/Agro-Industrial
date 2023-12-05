<?php
header("Access-Control-Allow-Origin: * "); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");

include_once("../usuarios/Conexion.php");

if (!empty($_GET['id_finca'])) {
    try {
        $consulta = $base_de_datos->prepare("SELECT insumos_x_cultivos.*, insumos.*, cultivos.*
        
        ");

        $datos = $consulta->fetchAll();
        $respuesta->bindParam(':id', $id);


        $respuesta['datos'] = $datos;
        echo json_encode($respuesta);
    } catch (Exception $e) {
        $respuesta = [
            'status' => false,
            'mesagge' => "ERROR##SQL",
            'exception' => $e
        ];
        echo json_encode($respuesta);
    }
} else {
    $respuesta = [
        'status' => false,
        'mesagge' => "ERROR##DATOS##POST",
        '$_GET' => $_GET,
        '$_POST' => $_POST
    ];
    echo json_encode($respuesta);
}
