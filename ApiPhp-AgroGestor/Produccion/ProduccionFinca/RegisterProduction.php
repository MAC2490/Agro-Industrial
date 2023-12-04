<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");

include 'Conexion.php';

if (!empty($_POST['id']) and !empty($_POST['date']) and !empty($_POST['total']) and !empty($_POST['price']) and !empty($_POST['crop'])) {

    $id = $_POST['id'];
    $date = $_POST['date'];
    $total = $_POST['total'];
    $price = $_POST['price'];

    try {
        if ($_POST['crop'] >= $total) {
            $newCant = $_POST['crop'] - $total;
            $update = $data_base->prepare("UPDATE produccion_cultivos SET cantidad=:new, fecha=:dat, total=:tot, precio_venta=:pri WHERE id_produccion = :id ");
            $update->bindParam(':new', $newCant);
            $update->bindParam(':dat', $date);
            $update->bindParam(':tot', $total);
            $update->bindParam(':pri', $price);
            $update->bindParam(':id', $id);
            $proccess = $update->execute();
            
            if ($proccess) {
                $response = [
                    'status' => true,
                    'mesagge' => "OK##CLIENT##UPDATE"
                ];
                echo "1";
            } else {
                $response = [
                    'status' => false,
                    'mesagge' => "ERROR##CLIENT##UPDATE"
                ];
                echo "2";
            }
        }else {
            echo "303";   
        }
    } catch (Exception $e) {
        $response = [
            'status' => false,
            'mesagge' => "ERROR##SQL",
            'exception' => $e
        ];
        echo "2";
    }
} else {
    $response = [
        'status' => false,
        'mesagge' => "ERROR##DATOS##POST",
        '$_GET' => $_GET,
        '$_POST' => $_POST
    ];
    echo "2";
}
?>
