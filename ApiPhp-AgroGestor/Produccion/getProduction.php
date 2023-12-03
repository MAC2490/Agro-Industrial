<?php 
	header("Access-Control-Allow-Origin: * "); // Permite el acceso desde cualquier origen, o usa "http://localhost" si solo quieres permitirlo desde localhost.
	header("Access-Control-Allow-Methods: GET, POST");
	header("Access-Control-Allow-Headers: Content-Type");

    include 'Conexion.php';
    $list = $data_base->query("SELECT cultivos.nombre AS nombre_cultivo, fincas.nombre AS nombre_finca, insumos.name AS nombre_insumo, insumos_x_cultivos.valor_aprox, insumos_x_cultivos.cantidad_pro, insumos_x_cultivos.unidad_medida, produccion_cultivos.cantidad, produccion_cultivos.fecha, produccion_cultivos.total, produccion_cultivos.precio_venta
    FROM produccion_cultivos JOIN cultivos_finca ON (produccion_cultivos.id_cultivos_finca = cultivos_finca.id_cultivos_finca)
    JOIN fincas ON (cultivos_finca.id_finca = fincas.id_finca)
    JOIN cultivos ON (cultivos_finca.id_cultivo = cultivos.id_cultivo)
    JOIN insumos_x_cultivos ON (fincas.id_finca = insumos_x_cultivos.id_finca)
    JOIN insumos ON (insumos_x_cultivos.id_insumo = insumos.insumos_id)
    WHERE insumos_x_cultivos.id_finca = cultivos_finca.id_finca");
    $data = $list->fetchAll();
    
    $response['list_crop'] = $data;
    echo json_encode($response);
?>
