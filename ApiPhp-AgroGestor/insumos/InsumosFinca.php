<?php
header("Access-Control-Allow-Origin: * ");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");
include_once("../usuarios/Conexion.php");

if (!empty($_GET['id'])) {
    try {
        $id_finca = $_GET['id'];
        $consulta = $base_de_datos->prepare("SELECT insumos.*,insumos_x_cultivos.*,cultivos.* FROM insumos
        INNER JOIN insumos_x_cultivos ON insumos.insumos_id=insumos_x_cultivos.id_insumo
        INNER JOIN cultivos ON insumos_x_cultivos.id_cultivo=cultivos.id_cultivo
        WHERE insumos_x_cultivos.id_finca=:id");

        // Ejecutar la consulta
        $consulta->bindParam(':id', $id_finca);
        $consulta->execute();

        $datos = $consulta->fetchAll();

        if ($datos) {
            $respuesta['datos'] = $datos;
            echo json_encode($respuesta);
        } else {
            $respuesta = [
                'status' => false,
                'message' => "No se encontraron datos para el ID proporcionado",
                '$_GET' => $_GET,
                '$_POST' => $_POST
            ];
            echo json_encode($respuesta);
        }
    } catch (Exception $e) {
        $respuesta = [
            'status' => false,
            'mesagge' => "ERROR##SQL",
            'exception' => $e->getMessage()
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
