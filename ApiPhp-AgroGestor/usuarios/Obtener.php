<?php 
	header("Access-Control-Allow-Origin: * "); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
	header("Access-Control-Allow-Methods: GET, POST");
	header("Access-Control-Allow-Headers: Content-Type");

    include 'Conexion.php';

<<<<<<< HEAD
<<<<<<< HEAD
    $consulta = $base_de_datos->query("SELECT * FROM usuarios");
=======
    $consulta = $base_de_datos->query("SELECT * FROM personas");
>>>>>>> origin/dev03
=======
    $consulta = $base_de_datos->query("SELECT * FROM personas");
>>>>>>> origin/dev04
    $datos = $consulta->fetchAll();

    $respuesta['registros'] = $datos;
    echo json_encode($respuesta);
    
?>

