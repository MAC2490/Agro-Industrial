<?php
header("Access-Control-Allow-Origin: * "); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");

include_once("../usuarios/Conexion.php");


if (!empty($_POST['cantidad'])  && !empty($_POST['insumo'])) {
    // guardamos el las variables 

    $cantidad = $_POST['cantidad'];
    $insumo = $_POST['insumo'];


    // lo metemos dentro de un try para futuros errores

    try {
        $respuesta = $base_de_datos->prepare("UPDATE insumos SET cantidad=cantidad - :can WHERE insumos_id=:id");
        $respuesta->bindParam(':can', $cantidad);
        $respuesta->bindParam(':id', $insumo);

        // AQUI VALIDAMOS EL PROCESO O RESPUESTA DEL SERVIDOR
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
        'mesagge' => "ERROR##DATOS##GET",
        '$_GET' => $_GET,
        '$_POST' => $_POST
    ];
    echo json_encode($respuesta);
}
