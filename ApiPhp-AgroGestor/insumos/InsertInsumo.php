<?php
header("Access-Control-Allow-Origin: *"); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");

include_once("../usuarios/Conexion.php");

if (!empty($_POST['nombre']) and !empty($_POST['serial']) and !empty($_POST['tipo']) and !empty($_POST['unidad']) and !empty($_POST['cantidad']) and !empty($_POST['fecha']) and !empty($_POST['costo']) and !empty($_POST['provedor'])) {

    $nombre = $_POST['nombre'];
    $serial = $_POST['serial'];
    $tipo = $_POST['tipo'];
    $unidad = $_POST['unidad'];
    $cantidad = $_POST['cantidad'];
    $fecha = $_POST['fecha'];
    $costo = $_POST['costo'];
    $provedor = $_POST['provedor'];

    // manejo de errores con try 

    try {
        $respuesta = $base_de_datos->prepare("INSERT INTO insumos(name,serial,tipo_insumo,unidada_medida,cantidad,fecha_compra,costo_compra,proveedor) VALUES(:no,:se,:ti,:un,:ca,:fe,:co,:pr)");

        $respuesta->bindParam(':no', $nombre);
        $respuesta->bindParam(':se', $serial);
        $respuesta->bindParam(':ti', $tipo);
        $respuesta->bindParam(':un', $unidad);
        $respuesta->bindParam(':ca', $cantidad);
        $respuesta->bindParam(':fe', $fecha);
        $respuesta->bindParam(':co', $costo);
        $respuesta->bindParam(':pr', $provedor);

        $proceso = $respuesta->execute();
        if ($proceso) {
            $respuesta = [
                'status' => true,
                'mesagge' => "OK##INSUMO##INSERT"
            ];
            echo json_encode($respuesta);
        } else {
            $respuesta = [
                'status' => false,
                'mesagge' => "ERROR##INSUMO##INSERT"
            ];
            echo json_encode($respuesta);
        }
    } catch (Exception $e) {
        $respuesta = [
            'status' => false,
            'mesagge' => "ERROR##DATOS##POST",
            '$_GET' => $_GET,
            '$_POST' => $_POST
        ];
        echo json_encode($respuesta);
    }
}
