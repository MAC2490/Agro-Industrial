<?php
header("Access-Control-Allow-Origin: *"); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");

include_once("../usuarios/Conexion.php");

if (!empty($_POST['id_finca']) and !empty($_POST['id_insumo']) ) {

    $id_finca = $_POST['id_finca'];
    $id_insumo = $_POST['id_insumo'];
    // manejo de errores con try 

    try {
        $respuesta = $base_de_datos->prepare("INSERT INTO insumo_x_finca(id_finca,id_insumo) VALUES(:fi,:ins)");

        $respuesta->bindParam(':fi', $id_finca);
        $respuesta->bindParam(':ins', $id_insumo);
        $proceso = $respuesta->execute();
        if ($proceso) {
            $respuesta = [
                'status' => true,
                'mesagge' => "OK##INSUMO-FINCA##INSERT"
            ];
            echo json_encode($respuesta);
        } else {
            $respuesta = [
                'status' => false,
                'mesagge' => "ERROR##INSUMO-FINCA##INSERT"
            ];
            echo json_encode($respuesta);
        }
    } catch (Exception $e) {
        $respuesta = [
            'status' => false,
            'mesagge' => "ERROR##DATOS##POST".$e->getMessage(),
            '$_GET' => $_GET,
            '$_POST' => $_POST
        ];
        echo json_encode($respuesta);
    }
}
