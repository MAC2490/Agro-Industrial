<?php 
	header("Access-Control-Allow-Origin: * "); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
	header("Access-Control-Allow-Methods: GET, POST");
	header("Access-Control-Allow-Headers: Content-Type");

    include_once("../usuarios/Conexion.php");

    $consulta = $base_de_datos->query("SELECT * FROM insumos ORDER BY fecha_compra DESC");

    $datos = $consulta->fetchAll();

    $respuesta['datos'] = $datos;
    echo json_encode($respuesta);
    