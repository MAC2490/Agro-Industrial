<?php 
	header("Access-Control-Allow-Origin: * "); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
	header("Access-Control-Allow-Methods: GET, POST");
	header("Access-Control-Allow-Headers: Content-Type");

    include 'Conexion.php';

    
    $consulta = $base_de_datos->query("SELECT fincas.id_finca, cultivos.* FROM cultivos JOIN cultivos_finca ON (cultivos.id_cultivo=cultivos_finca.id_cultivo) JOIN fincas ON (cultivos_finca.id_finca=fincas.id_finca) WHERE fincas.id_usuario = ".$_GET['id_usuario']);
    $datos = $consulta->fetchAll();

    $respuesta['registros'] = $datos;
    echo json_encode($respuesta);
    
?>

