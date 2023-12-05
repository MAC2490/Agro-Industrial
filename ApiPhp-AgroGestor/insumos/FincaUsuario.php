<?php
header("Access-Control-Allow-Origin: * ");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");


include_once("../usuarios/Conexion.php");

if (!empty($_GET['id'])) {
    // este es el id que se le manda desde java 
    $id_finca = $_GET['id'];
    $consulta = $base_de_datos->prepare("SELECT * FROM fincas WHERE id_usuario = :id ");
    $consulta->bindParam(":id", $id_finca);
    
    
    // Ejecutar la consulta
    $consulta->execute();
    // Obtener los datos
    $datos = $consulta->fetchObject();

    if ($datos) {
        echo json_encode($datos);
    } else {
        $respuesta = [
            'status' => false,
            'message' => "No se encontraron datos para el ID proporcionado",
            '$_GET' => $_GET,
            '$_POST' => $_POST
        ];
        echo json_encode($respuesta);
    }
} else {
    $respuesta = [
        'status' => false,
        'message' => "ERROR##DATOS##GET",
        '$_GET' => $_GET,
        '$_POST' => $_POST
    ];
    echo json_encode($respuesta);
}
