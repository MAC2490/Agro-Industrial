<?php
header("Access-Control-Allow-Origin: *"); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");

include 'Conexion.php';

if (!empty($_POST['nombre']) and !empty($_POST['descripcion'] and !empty($_POST['tiempoCosecha']) and !empty($_POST['estado']) and !empty($_POST['id_cultivo']))) {

    $nombre = $_POST['nombre'];
    $descripcion = $_POST['descripcion'];
    $tiempoCosecha = $_POST['tiempoCosecha'];
    $estado = $_POST['estado'];
    $id_cultivo = $_POST['id_cultivo'];

    try {
        $consulta = $base_de_datos->prepare("UPDATE cultivos SET nombres=:nom, descripcion=:descri, tiempoCosecha=:tiemp, estado=:esta WHERE id_cultivo = :id ");

        $consulta->bindParam(':nom', $nombre);
        $consulta->bindParam(':descri', $descripcion);
        $consulta->bindParam(':tiemp', $tiempoCosecha);
        $consulta->bindParam(':esta', $estado);
        $consulta->bindParam(':id', $id_cultivo);

        $proceso = $consulta->execute();

        if ($proceso) {
            $respuesta = [
                'status' => true,
                'mesagge' => "OK##CLIENT##UPDATE"
            ];
            echo json_encode($respuesta);
        } else {
            $respuesta = [
                'status' => false,
                'mesagge' => "ERROR##CLIENT##UPDATE"
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
?>