INSERT INTO examenLinea.administrador(estado) VALUES ('ACTIVO'), ('INACTIVO');

INSERT INTO examenLinea.profesor (apellido, nombre, estado) VALUES ('Garcia', 'Carlos', 'ACTIVO');
INSERT INTO examenLinea.profesor  (apellido, nombre, estado) VALUES ('Lopez', 'María', 'ACTIVO');

INSERT INTO examenLinea.horario (dia, hora, lugar, estado) VALUES ('2023-11-17', STR_TO_DATE('08:00:00', '%H:%i:%s'), 'Aula 101', 'ACTIVO');

INSERT INTO examenLinea.plan_estudio (contenido, unidades, estado) VALUES ('Matemáticas', 10, 'ACTIVO');

INSERT INTO examenLinea.grupo (nombre, horario_id, plan_estudio_id, profesor_id, estado) VALUES ('Matemáticas 101', 1, 1, 1, 'ACTIVO');

INSERT INTO examenLinea.estudiante (apellido, nombre, grupo_id, estado) VALUES ('Perez', 'Juan', 1, 'ACTIVO');
INSERT INTO examenLinea.estudiante (apellido, nombre, grupo_id, estado) VALUES ('Martinez', 'Ana', 1, 'ACTIVO');

INSERT INTO examenLinea.tema (nombre, estado) VALUES ('Álgebra', 'ACTIVO');
INSERT INTO examenLinea.tema (nombre, estado) VALUES ('Geometría', 'ACTIVO');

INSERT INTO examenLinea.banco_pregunta (estado, tema_id) VALUES ('ACTIVO', 1);
INSERT INTO examenLinea.banco_pregunta (estado, tema_id) VALUES ('ACTIVO', 2);

INSERT INTO examenLinea.pregunta (estado, porcentaje, pregunta, tiempo, tipo_pregunta) VALUES ('ACTIVO', 10.0, '¿Cuál es la fórmula cuadrática?', '2023-11-17 10:00:00', 'SELECCION_MULTIPLE_UNICA_RESPUESTA');

INSERT INTO examenLinea.pregunta (estado, porcentaje, pregunta, tiempo, tipo_pregunta) VALUES ('ACTIVO', 10.0, '¿Cuál es la fórmula cuadrática?', '2023-11-17 10:00:00', 'SELECCION_MULTIPLE_UNICA_RESPUESTA');
INSERT INTO examenLinea.pregunta (estado, porcentaje, pregunta, tiempo, tipo_pregunta) VALUES ('ACTIVO', 15.0, 'Nombre dos teoremas de geometría', '2023-11-17 10:15:00', 'FALSO_VERDADERO');

INSERT INTO examenLinea.configuracion (estado, fecha, hora, numero_preguntas, porcentaje, tiempo, umbral) VALUES ('ACTIVO', '2023-11-17 00:00:00', '2023-11-17 09:00:00', 10, 70.0, '2023-11-17 02:00:00', 50.0);

INSERT INTO examenLinea.dia_evaluacion (dia, estado, fecha, hora) VALUES ('2023-11-18', 'ACTIVO', '2023-11-17', STR_TO_DATE('09:00:00', '%H:%i:%s'));

INSERT INTO examenLinea.examen (cantidad_preguntas_banco, cantidad_preguntas_estudiante, categoria, descripcion, estado, estado_examen, nombre, tiempo_limite, tiempo_transcurrido, configuracion_id, dia_evaluacion_id, profesor_id) VALUES (5, 5, 'Matemáticas', 'Examen de matemáticas básicas', 'ACTIVO', 'PENDIENTE', 'Matemáticas Básicas', '2023-11-17 11:00:00', NULL, 1, 1, 1);

INSERT INTO examenLinea.respuesta (estado, respuesta, tipo_respuesta, pregunta_id) VALUES ('ACTIVO', 'x = [-b ± sqrt(b^2 - 4ac)] / 2a', 'SELECCION_MULTIPLE_UNICA_RESPUESTA', 1);
INSERT INTO examenLinea.respuesta (estado, respuesta, tipo_respuesta, pregunta_id) VALUES ('ACTIVO', 'Teorema de Pitágoras, Teorema de Thales', 'FALSO_VERDADERO', 2);

INSERT INTO examenLinea.sub_pregunta (estado, porcentaje, pregunta_id) VALUES ('ACTIVO', 5.0, 1);
INSERT INTO examenLinea.sub_pregunta (estado, porcentaje, pregunta_id) VALUES ('ACTIVO', 5.0, 2);

INSERT INTO examenLinea.pregunta_examen (pregunta_id, examen_id) VALUES (1, 1);

INSERT INTO examenLinea.calificacion (estado, nota, estudiante_id, examen_id) VALUES ('ACTIVO', 85.0, 1, 1);

INSERT INTO examenLinea.estadistica_examen (estado, fecha, puntaje, tiempo_transcurrido, estudiante_id, examen_id) VALUES ('ACTIVO', '2023-11-17', 85.0, '2023-11-17 01:00:00', 1, 1);

INSERT INTO examenLinea.estadistica_pregunta (contestadas, correctas, estado, incorrectas, porcentaje_correcto, pregunta_id ) VALUES (10, 8, 'ACTIVO', 2, 80.0, 1);
INSERT INTO examenLinea.estadistica_pregunta (contestadas, correctas, estado, incorrectas, porcentaje_correcto, pregunta_id ) VALUES (5, 2, 'ACTIVO', 3, 40.0, 2);

INSERT INTO examenLinea.notificacion (estado, notificacion, calificacion_id, estudiante_id) VALUES ('ACTIVO', 'Su calificación en el examen de Matemáticas es 85', 1, 1);

INSERT INTO examenLinea.estudiante_examenes (estudiante_id, examenes_id) VALUES (1, 1);
