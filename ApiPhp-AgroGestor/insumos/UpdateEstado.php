<?php
header("Access-Control-Allow-Origin: *"); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");


include_once("../usuarios/Conexion.php");

if (!empty($_POST['id_insumo']) && !empty($_POST['estado'])) {
    $id = $_POST['id_insumo'];
    $estado = $_POST['estado'];

    try {
        $respuesta = $base_de_datos->prepare("UPDATE insumos SET estado=:es WHERE insumos_id = :id");
        $respuesta->bindParam(':es', $estado);
        $respuesta->bindParam(':id', $id);

        $proceso = $respuesta->execute();

        if ($proceso) {
            $respuesta = [
                'status' => true,
                'mesagge' => "OK##INSUMO##UPDATE"
            ];
            echo json_encode($respuesta);
        } else {
            $respuesta = [
                'status' => false,
                'mesagge' => "ERROR##INSUMO##UPDATE"
            ];
            echo json_encode($respuesta);
        }
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
