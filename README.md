# proyectosemana1
Grupo conformado por:

Lulio Arturo Herrera Mestanza

Joffre Hermosilla Salas

SOLUCION AL ENUNCIADO 





![ScreenShot](https://github.com/joffrehermosilla/proyectosemana1/blob/master/proyectosemana1/CUN%20proyecto%20semana%201.drawio.png) 



APIS
POST
localhost:8090/api/cuentas/crear-cuenta-pasiva

{
    "accountname": "Plazo Fijo",
    "maintenancefee": 0,
    "monthlymovement": 100

}

localhost:8090/api/cuentas/crear-cuenta-activa

{
    "creditname": "Tarjeta de Credito",
    "creditaccountcounter": 0,
    "authorizedsigner": 0

}


GET
localhost:8090/api/cuentas/pasivo-all
localhost:8090/api/cuentas/activo-all

