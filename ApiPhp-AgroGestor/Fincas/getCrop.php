<?php 
	header("Access-Control-Allow-Origin: * "); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
	header("Access-Control-Allow-Methods: GET, POST");
	header("Access-Control-Allow-Headers: Content-Type");

    include 'Conexion.php';
    if (!empty($_POST['id'])) {
        $id = $_POST['id'];
        
        $list = $data_base->query("SELECT produccion_cultivos.cantidad, produccion_cultivos.total, cultivos.*  FROM cultivos JOIN cultivos_finca ON (cultivos.id_cultivo = cultivos_finca.id_cultivo) JOIN produccion_cultivos ON (cultivos_finca.id_cultivos_finca = produccion_cultivos.id_cultivos_finca) WHERE cultivos_finca.id_finca = $id");
        $data = $list->fetchAll();
        
        $response['list_crop'] = $data;
        echo json_encode($response);
    }else{
        echo json_encode(404); // Datos vacios
    }

    
?>