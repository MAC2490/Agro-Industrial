<?php
header("Access-Control-Allow-Origin: *"); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");


include_once("../usuarios/Conexion.php");

if (!empty($_POST['id_insumo']) and !empty($_POST['nombre']) and !empty($_POST['serial']) and !empty($_POST['tipo']) and !empty($_POST['unidad']) and !empty($_POST['cantidad']) and !empty($_POST['fecha']) and !empty($_POST['costo']) and !empty($_POST['provedor'])) {


    $id = $_POST['id_insumo'];
    $nombre = $_POST['nombre'];
    $serial = $_POST['serial'];
    $tipo = $_POST['tipo'];
    $unidad = $_POST['unidad'];
    $cantidad = $_POST['cantidad'];
    $fecha = $_POST['fecha'];
    $costo = $_POST['costo'];
    $provedor = $_POST['provedor'];

    try {
        $respuesta = $base_de_datos->prepare("UPDATE insumos SET name=:no, serial=:se, tipo_insumo=:ti, unidada_medida=:un, cantidad=:ca, fecha_compra=:fe, costo_compra=:co, proveedor=:pr WHERE insumos_id = $id");
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
