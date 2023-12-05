<?php
header("Access-Control-Allow-Origin: *"); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");

include_once("../usuarios/Conexion.php");

if (!empty($_POST['cultivo'])and !empty($_POST['finca']) and !empty($_POST['insumo']) and !empty($_POST['valor']) and !empty($_POST['fecha']) and !empty($_POST['unidad']) and !empty($_POST['cantidad'])) {

    $cultivo = $_POST['cultivo'];
    $finca = $_POST['finca'];
    $insumo = $_POST['insumo'];
    $valor = $_POST['valor'];
    $fecha = $_POST['fecha'];
    $unidad = $_POST['unidad'];
    $cantidad = $_POST['cantidad'];
    // manejo de errores con try 

    try {
        $respuesta = $base_de_datos->prepare("INSERT INTO insumos_x_cultivos(id_cultivo,id_finca,id_insumo,valor_aprox,cantidad_pro,unidad_medida,fecha) VALUES(:cu, :fi, :ins, :va, :ca, :un, :fe)");

        $respuesta->bindParam(':cu', $cultivo);
        $respuesta->bindParam(':fi', $finca);
        $respuesta->bindParam(':ins', $insumo);
        $respuesta->bindParam(':va', $valor);
        $respuesta->bindParam(':ca', $cantidad);
        $respuesta->bindParam(':un', $unidad);
        $respuesta->bindParam(':fe', $fecha);

        $proceso = $respuesta->execute();
        if ($proceso) {
            $respuesta = [
                'status' => true,
                'mesagge' => "OK##INSUMO-X-CULTIVO##INSERT"
            ];
            echo json_encode($respuesta);
        } else {
            $respuesta = [
                'status' => false,
                'mesagge' => "ERROR##INSUMO-X-CULTIVO##INSERT"
            ];
            echo json_encode($respuesta);
        }
    } catch (Exception $e) {
        $respuesta = [
            'status' => false,
            'mesagge' => "ERROR##DATOS##POST: " . $e->getMessage(),
            '$_GET' => $_GET,
            '$_POST' => $_POST
        ];
        echo json_encode($respuesta);
    }
}
